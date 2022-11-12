package com.calendar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Scheduler {
	
	private static HashMap<String, ArrayList<String>> scheduleMap = new HashMap<>();

	public void addSchedule(Scanner scanner) {
		
		//Scanner scanner = new Scanner(System.in);
		System.out.println("[일정 등록] 날짜를 입력하세요. 형식: yyyy-MM-dd");
		String date = scanner.nextLine();
		System.out.println("일정을 입력하세요.");
		String detail = scanner.nextLine();
		
		ArrayList<String> detailList;
		
		if(scheduleMap.get(date) == null) {
			detailList = new ArrayList<>();
		} else {
			detailList = scheduleMap.get(date);
		}
		
		detailList.add(detail);
		
		scheduleMap.put(date, detailList);
	}

	public void showSchedule(Scanner scanner) {
		
		//Scanner scanner = new Scanner(System.in);
		System.out.println("[일정 검색] 날짜를 입력하세요.");
		String date = scanner.nextLine();
		
		if(scheduleMap.get(date) == null) {
			System.out.println("일정이 없습니다.");
			return;
		}
		
		ArrayList<String> scheduleList = scheduleMap.get(date);
		
		System.out.printf("%s에 %d개의 일정이 있습니다.\n", date, scheduleList.size());
		for(int i = 0; i < scheduleList.size(); i++) {
			System.out.printf("%d. %s\n", i, scheduleMap.get(date).get(i));
		}
	}

}
