package com.rac.interview;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class InterviewApplicationTests {
	
	private static InterviewApplication interviewApplication;
	
	@BeforeAll
	public static void init() {
		interviewApplication = new InterviewApplication();
		interviewApplication.put("aaa", "111");
		interviewApplication.put("bbb", "222");
		interviewApplication.put("ccc", "1333");
	}
	
	@Test
	void testPut() {
		interviewApplication.put("aaa", "444");
		assertEquals(interviewApplication.get("aaa"), "444");
	}
	
	@Test
	void testGet() {
		assertEquals(interviewApplication.get("aaa"), "111");
	}
	
	@Test
	void testGetInvalidKey() {
		assertEquals(interviewApplication.get("ddd"), "key not found.");
	}
	
	@Test
	void testRemoveKey() {
		assertEquals(interviewApplication.remove("aaa"), "key deleted");
		assertEquals(interviewApplication.get("aaa"), "key not found.");
	}
	
	@Test
	void testRemoveNonExistentKey() {
		assertEquals(interviewApplication.remove("qqq"), "Key does not exist.");
	}

}
