package com.exercise.codetest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

class MathAPIServiceTest {
	InputRequest input;

	@BeforeEach
	void setUp() throws Exception {
		input = new InputRequest();
	}

	@AfterEach
	void tearDown() throws Exception {
		input = null;
	}

	@Test
	void testMinAPI() {
		List<Integer> list = new ArrayList() {{
	        add(3);
	        add(4);
	        add(5);
	        add(9);
	        add(1);
	        add(8);
	    }};
	    input.setNumbers(list);
	    input.setQuantifier(1);
	    ResponseEntity<Result> result = MathAPIService.minAPI(input);
		assertEquals(1,result.getBody().getNumbers().get(0).intValue());
	}

	@Test
	void testMaxAPI() {
		List<Integer> list = new ArrayList() {{
	        add(3);
	        add(4);
	        add(5);
	        add(9);
	        add(1);
	        add(8);
	    }};
	    input.setNumbers(list);
	    input.setQuantifier(1);
	    ResponseEntity<Result> result = MathAPIService.maxAPI(input);
		assertEquals(9,result.getBody().getNumbers().get(0).intValue());
	}

	@Test
	void testAvgAPI() {
		List<Integer> list = new ArrayList() {{
	        add(3);
	        add(4);
	        add(5);
	        add(6);
	    }};
	    input.setNumbers(list);
	    ResponseEntity<Double> result = MathAPIService.avgAPI(input);
		assertEquals(4.5,result.getBody().doubleValue());
	}

	@Test
	void testMedianAPI() {
		List<Integer> list = new ArrayList() {{
	        add(7);
	        add(8);
	        add(5);
	        add(3);
	        add(2);
	    }};
	    input.setNumbers(list);
	    ResponseEntity<Integer> result = MathAPIService.medianAPI(input);
		assertEquals(5,result.getBody().intValue());
	}

	@Test
	void testPercentileAPI() {
		List<Integer> list = new ArrayList() {{
	        add(3);
	        add(6);
	        add(7);
	        add(8);
	        add(8);
	        add(10);
	        add(13);
	        add(15);
	        add(16);
	        add(20);
	    }};
	    input.setNumbers(list);input.setQuantifier(25);
	    ResponseEntity<Integer> result = MathAPIService.percentileAPI(input);
		assertEquals(7,result.getBody().intValue());
	}

}
