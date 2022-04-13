package com.exercise.codetest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class MathAPIService {
	
	public static ResponseEntity<Result> minAPI(InputRequest input){
		List<Integer> minnumbers  = new ArrayList<>();
		if(input.getQuantifier()<=1) {
			minnumbers.add(input.getNumbers().stream().mapToInt(Integer::intValue).min().orElse(0));
		}
		else {
			List<Integer> sortedList = input.getNumbers().stream().sorted().collect(Collectors.toList());
			for(int i = 0; i<input.getQuantifier();i++) {
				minnumbers.add(sortedList.get(i));
			}
		}
		Result result = new Result();
		result.setNumbers(minnumbers);
		return new ResponseEntity<Result>(result , HttpStatus.OK);
	}
	
	
	public static ResponseEntity<Result> maxAPI(InputRequest input){
		List<Integer> maxnumbers  = new ArrayList<>();
		if(input.getQuantifier()<=1) {
			maxnumbers.add(input.getNumbers().stream().mapToInt(Integer::intValue).max().orElse(0));
		}
		else {
			List<Integer> sortedList = input.getNumbers().stream().sorted().collect(Collectors.toList());
			for(int i = sortedList.size()-1 , j=0; j<input.getQuantifier();i--,j++) {
				maxnumbers.add(sortedList.get(i));
			}
		}
		Result result = new Result();
		result.setNumbers(maxnumbers);
		return new ResponseEntity<Result>(result , HttpStatus.OK);
		
	}
	
	public static ResponseEntity<Double> avgAPI(InputRequest input){
		double avg = input.getNumbers().stream().mapToInt(Integer::intValue).average().orElse(0);
		return new ResponseEntity<Double>(avg , HttpStatus.OK);
	}
	
	public static ResponseEntity<Integer> medianAPI(InputRequest input){
		int median = 0;
		List<Integer> sortedList = input.getNumbers().stream().sorted().collect(Collectors.toList());
		if(sortedList.size()%2==1) {
			median = sortedList.get((sortedList.size()/2));
		}
		else {
			int i = (sortedList.size()/2);
			median = Math.abs((sortedList.get(i)+sortedList.get(i-1))/2);
			}
		return new ResponseEntity<Integer>(median , HttpStatus.OK);
	}
	
	public static ResponseEntity<Integer> percentileAPI(InputRequest input){
		int n = input.getNumbers().size();
		int q = input.getQuantifier();
		int index = (int) Math.round(((n*q)+99)/100);
		List<Integer> sortedList = input.getNumbers().stream().sorted().collect(Collectors.toList());
		return new ResponseEntity<Integer>(sortedList.get(index-1) , HttpStatus.OK);
	}

}
