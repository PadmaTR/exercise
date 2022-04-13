import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TestCompareVersion {

	@Test
    public void testversionCompare() throws Exception {
        assertEquals(1, CompareVersion.versionCompare("1.1", "1.0"));
        assertEquals(-1, CompareVersion.versionCompare("1.1", "1.2"));
        assertEquals(1, CompareVersion.versionCompare("10.8", "9.9"));
        assertEquals(1, CompareVersion.versionCompare("1.3", "1.2.9.9.9.9"));
        assertEquals(-1, CompareVersion.versionCompare("1.3.4", "1.10"));
        assertEquals(1, CompareVersion.versionCompare("2.0.1", "2"));
        assertEquals(-1, CompareVersion.versionCompare("0.9.11", "0.9.12"));
        assertEquals(1, CompareVersion.versionCompare("0.9.12", "0.9.11"));
        assertEquals(1, CompareVersion.versionCompare("0.10", "0.9"));
        assertEquals(0, CompareVersion.versionCompare("0.10", "0.10"));
        assertEquals(1, CompareVersion.versionCompare("2.13", "2.10.1"));
        assertEquals(-1, CompareVersion.versionCompare("0.0.0.2", "0.1"));
        assertEquals(1, CompareVersion.versionCompare("1.0", "0.9.2"));
        assertEquals(1, CompareVersion.versionCompare("1.10", "1.8"));
        assertEquals(0, CompareVersion.versionCompare("1.10", "1.10.0.0"));
        assertEquals(1, CompareVersion.versionCompare("1.10.0.0.1", "1.10.0.0.0.0"));
        assertEquals(0, CompareVersion.versionCompare("1.10.0.0", "1.10"));
    }

}
