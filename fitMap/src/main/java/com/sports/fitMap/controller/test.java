package com.sports.fitMap.controller;

public class test {
	public static void main(String[] args) {
	    String phoneNumber = "20010130";
	    
	    // StringBuilder를 이용하여 문자열 조합
	    StringBuilder sb = new StringBuilder(phoneNumber);
	    sb.insert(4, "-");
	    sb.insert(7, "-");

	    System.out.println(sb.toString());  // 출력: 010-1234-5678
	}

}
