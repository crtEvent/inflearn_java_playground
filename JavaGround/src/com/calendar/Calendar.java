package com.calendar;

import java.util.Scanner;

public class Calendar {
	
	private static final int[] MAX_DAYS = {31,28,31,30,31,30,31,31,30,31,30,31};
	
	public int getMaxDaysOfMonth(int month) {
		return MAX_DAYS[month-1];
	}
	
	public void printSampleCalendar() {
		System.out.println("일   월   화   수   목   금   토");
		System.out.println("--------------------");
		System.out.println(" 1  2  3  4  5  6  7");
		System.out.println(" 8  9 10 11 12 13 14");
		System.out.println("15 16 17 18 19 20 21");
		System.out.println("22 23 24 25 26 27 28");
	}

	public static void main(String[] args) {
		
		// [과제3]
		// 반복 입력하도록 프로그램 변경하기
		// ## 학습목표
		// * 반복문을 사용해 본다.
		// * for 문과 while 문의 차이점에 대해 생각해 본다.
		// ## 요구사항
		// * 월을 입력하면 그 달이 몇일로 구성되어 있는지 출력하는 프로그램 작성하기
		// * 원하는 입력횟수를 먼저 입력받는다.

		Scanner scanner = new Scanner(System.in);
		Calendar cal = new Calendar();
		
		// 반복 횟수 입력
		System.out.println("반복횟수를 입력하세요.");
		int repeatCount = scanner.nextInt();
		int[] months = new int[repeatCount];
		
		// 월 입력
		System.out.println("월을 입력하세요.");
		for(int i=0; i < repeatCount; i++) {
			months[i] = scanner.nextInt();
		}
		
		// 출력
		for(int i=0; i < repeatCount; i++) {
			System.out.printf("%d월은 %d까지 있습니다.\n", months[i], cal.getMaxDaysOfMonth(months[i]));
		}
		
		scanner.close();
		
	}

}
