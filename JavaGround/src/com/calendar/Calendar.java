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
		// ## 요구사항
		// * 월을 입력하면 해당월의 달력을 출력한다.
		// * 달력은 모양은 1단계에서 작성한 모양으로 만든다.
		// * 1일은 일요일로 정해도 무방하다.
		// * -1을 입력받기 전까지 반복 입력받는다.
		// * 프롬프트를 출력한다.
		
		String PROMPT = "cal> ";
		
		Scanner scanner = new Scanner(System.in);
		Calendar cal = new Calendar();
		
		int month = 1;

		// 월 입력/마지막 날 출력
		while(true) {
			System.out.println("월을 입력하세요.");
			System.out.print(PROMPT);
			
			month = scanner.nextInt();
			if(month == -1) {
				break;
			}
			
			if(month > 12 || month < -1) {
				continue;
			}
			
			int day = 0;
			System.out.println("일   월   화   수   목   금   토");
			System.out.println("--------------------");
			for(int i=1; i <= cal.getMaxDaysOfMonth(month); i++) {
				
				if(i/10 == 0) {
					System.out.print(" "+i+" ");
				} else {
					System.out.print(i+" ");
				}
				
				day++;
				
				if(day==7) {
					System.out.println("");
					day=0;
				}
				
				if(i==cal.getMaxDaysOfMonth(month)) {
					System.out.println("");
				}
			}
		}
		
		System.out.println("Bye~");
		scanner.close();
		
	}

}
