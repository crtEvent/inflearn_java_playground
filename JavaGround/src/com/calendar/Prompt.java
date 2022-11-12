package com.calendar;

import java.util.Scanner;

public class Prompt {
	
	private static Scheduler scheduler = new Scheduler();
	
	// [과제5]
	// ##학습 목표
	// * 리스트, 딕셔너리를 사용해 본다.
	// ##요구 사항
	// * 간단한 콘솔 기반 사용자 UI를 만든다. (일정 검색용)
	// * 오늘 날짜를 인식해서 해당 월의 달력을 출력한다.
	// * 달력에서 일정이 있는 날 아래에는 . 을 찍어서 보여준다.
	// * 일정을 등록, 검색, 변경이 가능하게 해 준다.
	// * 오늘의 일정을 표시해 준다.

	/**
	 * 
	 * @param week
	 *            요일명
	 * @return 0~6 (0=Sunday, 6=Saturday)
	 */
	public int parseDay(String week) {

		switch (week) {
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

	public void printMenu() {
		System.out.println("+----------------------+");
		System.out.println("| 1. 일정 등록                       ");
		System.out.println("| 2. 일정 검색                       ");
		System.out.println("| 3. 달력 보기                       ");
		System.out.println("| h. 도움말 q. 종료               ");
		System.out.println("+----------------------+");
	}
	
	public void getCalendar(Scanner scanner) {
		//Scanner scanner = new Scanner(System.in);
		Calendar cal = new Calendar();

		int month = -1;
		int year = -1;

		// 월 입력/마지막 날 출력
		while (true) {

			System.out.println("년도를 입력하세요.(exit: -1)");
			System.out.print("YEAR> ");
			year = scanner.nextInt();

			if (year == -1) {
				break;
			}

			System.out.println("월을 입력하세요.(exit: -1)");
			System.out.print("MONTH> ");
			month = scanner.nextInt();

			if (month == -1) {
				break;
			}

			if (month > 12 || month < -1) {
				System.out.println("잘못된 값을 입력하였습니다.");
				continue;
			}
			
			cal.printCalendar(year, month);
			break;
		}
	}

	public void runPrompt() {
		printMenu();
		
		boolean isContinue = true;
		while(isContinue) {
			System.out.println("명령 (1, 2, 3, h, q)");
			System.out.print("> ");
			Scanner scanner = new Scanner(System.in);
			
			switch(scanner.nextLine()) {
			case "1":
				scheduler.addSchedule(scanner);
				break;
			case "2":
				scheduler.showSchedule(scanner);
				break;
			case "3":
				getCalendar(scanner);
				break;
			case "h":
				printMenu();
				break;
			case "q":
				System.out.println("Bye~");
				isContinue = false;
				scanner.close();
				break;
			} // end switch()
		}// end while()
	}

	public static void main(String[] args) {

		// 셀 실행
		Prompt p = new Prompt();
		p.runPrompt();

	}

}
