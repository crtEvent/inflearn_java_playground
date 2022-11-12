package com.calendar;

public class Calendar {
	
	// [과제4]
	// ## 요구사항
	// * 3단계와 같지만 년도와 월만 입력받는다.
	// * 진짜 캘린더에서 나오는 달력과 똑같은 모양의 달력을 출력한다.
	// * 추가적으로 입력받아야 하는 내용이 있는지 생각해 보자.
	
	private static final int[] MAX_DAYS = {31,28,31,30,31,30,31,31,30,31,30,31};
	private static final int[] LEAP_MAX_DAYS = {31,29,31,30,31,30,31,31,30,31,30,31};
	
	public boolean isLeapYear(int year) {
		if(year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
			return true;
		}
		
		return false;
	}
	
	public int getMaxDaysOfMonth(int year, int month) {
		if(isLeapYear(year)) {
			return LEAP_MAX_DAYS[month-1];
		} else {
			return MAX_DAYS[month-1];
		}
		
	}
	
	public int getWeekDay(int year, int month) {
		
		// ##달력 알고리즘(그레고리력)
		// * 1년 1월 1일은 월요일이다.
		// * 1년 1월 1일부터 지금까지의 모든 일 수를 구하여 7로 나눈 나머지를 요일로 한다.
		
		// ## 1년 1월 1일 부터 작년 12월 31일 까지의 일 수 구하기
		// * (year-1)*365 : 작년도 x 365일
		// * (year-1)/4 : 윤년으로 늘어난 일수를 더해준다
		// * (year-1)/100 : (year-1)/4 중 윤년이 아닌 날을 빼준다
		// * (year-1)/400 : (year-1)/100에서 윤년인 날을 더해준다
		
		int allDay = 0;
		
		// 1년 1월 1일 부터 작년 12월 31일 까지의 일 수
		allDay += (year-1)*365 + (year-1)/4 - (year-1)/100 + (year-1)/400;
		
		// 올해 지난 달 까지의 일수
		for(int i=1; i < month; i++) {
			allDay += getMaxDaysOfMonth(year, i);
		}
		
		// 이번 달의 1일
		allDay += 1;
		
		return allDay%7;
	}
	
	public void printCalendar(int year, int month) {
		
		System.out.printf("   <<%4d년 %3d월>>\n", year,  month);
		System.out.println(" SU MO TU WE TH FR SA");
		System.out.println("---------------------");
		
		//get weekday automatically
		int weekday = getWeekDay(year, month);
		
		// print blank space
		for(int i=0; i < weekday; i++) {
			System.out.print("   ");
		}
		
		int maxDay = getMaxDaysOfMonth(year, month);
		int count = 7 - weekday;
		int delim = (count < 7) ? count : 0;
		
		// print frist line
		for(int i=1; i <= count; i++) {
			System.out.printf("%3d", i);
		}
		System.out.println();
		
		// print from second line to last
		count++;
		for(int i=count; i<=maxDay; i++) {
			System.out.printf("%3d", i);
			if(i%7 == delim) {
				System.out.println();
			}
		}
		
		System.out.println();
		System.out.println();
	}


}
