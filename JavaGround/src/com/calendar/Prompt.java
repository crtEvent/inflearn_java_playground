package com.calendar;

import java.text.ParseException;
import java.util.Scanner;

public class Prompt {
	
	public void printMenu() {
		System.out.println("+----------------------+");
		System.out.println("| 1. 일정 등록                       ");
		System.out.println("| 2. 일정 검색                       ");
		System.out.println("| 3. 달력 보기                       ");
		System.out.println("| h. 도움말 q. 종료               ");
		System.out.println("+----------------------+");
	}
	
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
	
	public void runPrompt() throws ParseException {
		printMenu();
		
		Scanner scanner = new Scanner(System.in);
		Calendar cal = new Calendar();
		
		boolean isLoop = true;
		while(isLoop) {
			System.out.println("명령 (1, 2, 3, h, q)");
			String cmd = scanner.next();
			
			switch(cmd) {
			case "1":
				cmdRegister(scanner, cal);
				break;
			case "2":
				cmdSearch(scanner, cal);
				break;
			case "3":
				cmdCal(scanner, cal);
				break;
			case "h":
				printMenu();
				break;
			case "q":
				isLoop = false;
				break;
			} // end switch()
		}// end while()
		
		System.out.println("Bye~!");
	}

	private void cmdSearch(Scanner scanner, Calendar cal) {
		System.out.println("[일정 검색]");
		System.out.println("날짜를 입력해 주세요 (yyyy-MM-dd).");
		String date = scanner.next();
		PlanItem plan;
		plan = cal.searchPlan(date);
		if (plan != null) {
			System.out.println(plan.detail);
		} else {
			System.out.println("일정이 없습니다.");
		}
	}

	private void cmdRegister(Scanner scanner, Calendar cal) throws ParseException {
		System.out.println("[새 일정 등록]");
		System.out.println("날짜를 입력해 주세요 (yyyy-MM-dd).");
		String date = scanner.next();
		String text = "";
		System.out.println("일정을 입력해 주세요.(끝문자=;)");
		String word;
		while(!(word = scanner.next()).endsWith(";")) {
			text += word +" ";
		}
		word = word.replace(";", "");
		text += word;
		cal.registerPlan(date, text);
	}

	private void cmdCal(Scanner scanner, Calendar cal) {

		int month = 1;
		int year = 2017;

		System.out.println("년도를 입력하세요.");
		System.out.print("YEAR> ");
		year = scanner.nextInt();

		System.out.println("달을 입력하세요.");
		System.out.print("MONTH> ");
		month = scanner.nextInt();

		if (month > 12 || month < 1) {
			System.out.println("잘못된 입력입니다.");
			return;
		}

		cal.printCalendar(year, month);
	}

	public static void main(String[] args) throws ParseException {

		// 셀 실행
		Prompt p = new Prompt();
		p.runPrompt();

	}

}
