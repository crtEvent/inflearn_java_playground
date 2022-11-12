package com.calendar;

import java.util.Scanner;

public class Prompt {
	
	private final static String PROMPT = "cal>";
	
	public void runPrompt() {
		Scanner scanner = new Scanner(System.in);
		Calendar cal = new Calendar();
		
		int month = -1;
		int year = -1;

		// 월 입력/마지막 날 출력
		while(true) {
			System.out.println("년도를 입력하세요.");
			System.out.print("YEAR> ");
			year = scanner.nextInt();
			System.out.println("월을 입력하세요.");
			System.out.print("MONTH> ");
			month = scanner.nextInt();
			
			if(month == -1) {
				break;
			}
			
			if(month > 12 || month < -1) {
				continue;
			}
			
			cal.printCalendar(year, month);
		}
		
		System.out.println("Bye~");
		scanner.close();
	}

	public static void main(String[] args) {
		
		// 셀  실행
		Prompt p = new Prompt();
		p.runPrompt();

	}

}
