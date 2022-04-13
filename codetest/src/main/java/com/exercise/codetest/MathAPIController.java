package com.exercise.codetest;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/mathapi")
public class MathAPIController {
	private static final String HEADER = "Accept=application/json";
	
	@RequestMapping(value = "/min", method = RequestMethod.POST , headers = HEADER)
	public ResponseEntity<Result> minAPI(@RequestBody InputRequest input){
		return MathAPIService.minAPI(input);
	}
	
	
	@RequestMapping(value = "/max", method = RequestMethod.POST, headers = HEADER)
	public ResponseEntity<Result> maxAPI(@RequestBody InputRequest input){
		return MathAPIService.maxAPI(input);
		
	}
	
	@RequestMapping(value = "/avg", method = RequestMethod.POST, headers = HEADER)
	public ResponseEntity<Double> avgAPI(@RequestBody InputRequest input){
		return MathAPIService.avgAPI(input);		
	}
	
	@RequestMapping(value = "/median", method = RequestMethod.POST, headers = HEADER)
	public ResponseEntity<Integer> medianAPI(@RequestBody InputRequest input){
		return MathAPIService.medianAPI(input);
		
	}
	
	@RequestMapping(value = "/percentile", method = RequestMethod.POST, headers = HEADER)
	public ResponseEntity<Integer> percentileAPI(@RequestBody InputRequest input){
		return MathAPIService.percentileAPI(input);
		
	}
	
	

}
