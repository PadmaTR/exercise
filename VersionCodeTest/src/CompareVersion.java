
public class CompareVersion {
	
	public static int versionCompare(String v1 , String v2) {
		if(!v1.equals(v2)) {
			String[] v1values = v1.split("\\.");
			String[] v2values = v2.split("\\.");
			int minLength = v1values.length > v2values.length ?v2values.length:v1values.length;
			for(int i=0;i<minLength ;i++) {
				if(v1values[i].equals(v2values[i])) {
					continue;
				}
				else if( Integer.parseInt(v1values[i]) > Integer.parseInt(v2values[i]) ) {
					return 1;
				}
				else {
					return -1;
				}
			}
			int v1zero =0,v2zero =0;
			if(v1values.length > v2values.length  ) {
				v1zero =  checkZeros(minLength , v1values);
			}
			else {
				v2zero = checkZeros(minLength , v2values);
			}
			if(v1zero == 0 && v2zero==0) {
				return 0;
			}
			return v1zero > v2zero ? v1zero : -1;			
		}
		return 0 ;
	}

	private static int checkZeros(int minLength, String[] values) {
		for(int i = minLength ;i<values.length;i++) {
			if(Integer.parseInt(values[i]) ==0) {
				continue;
			}
			return 1;
		}
		return 0;
	}

}

