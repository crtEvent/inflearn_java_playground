package com.calendar;

import java.util.Scanner;

public class Prompt {
	
	/**
	 * 
	 * @param week 요일명
	 * @return 0~6 (0=Sunday, 6=Saturday)
	 */
	public int parseDay(String week) {
		
		switch(week) {
		case "su": 
			return 0;
		case "mo":
			return 1;
		case "tu":
			return 2;
		case "we":
			return 3;
		case "th":
			return 4;
		case "fr":
			return 5;
		case "sa":
			return 6;
		default:
			return 0;
		}
		
	}
	
	public void runPrompt() {
		Scanner scanner = new Scanner(System.in);
		Calendar cal = new Calendar();
		
		int month = -1;
		int year = -1;
		int weekday = 0;

		// 월 입력/마지막 날 출력
		while(true) {
			System.out.println("년도를 입력하세요.(exit: -1)");
			System.out.print("YEAR> ");
			year = scanner.nextInt();
			
			if(year == -1) {
				break;
			}
			
			System.out.println("월을 입력하세요.(exit: -1)");
			System.out.print("MONTH> ");
			month = scanner.nextInt();
			
			if(month == -1) {
				break;
			}
			
			if(month > 12 || month < -1) {
				System.out.println("잘못된 값을 입력하였습니다.");
				continue;
			}
			
			System.out.println("첫째 날의 요일을 입력하세요.(su mo tu we th fr sa)");
			System.out.print("WEEKDAY> ");
			String str_weekday = scanner.next();
			weekday = parseDay(str_weekday);
			
			cal.printCalendar(year, month, weekday);
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
