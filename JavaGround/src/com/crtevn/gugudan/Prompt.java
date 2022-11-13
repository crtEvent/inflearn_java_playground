package com.crtevn.gugudan;

import java.util.Scanner;

public class Prompt {
	
	// [계획]
	// 1. 값을 입력 받음
	// 2. 값 분류 - 한 자리 정수 or 쉼표로 구분되는 두 자리 정수
	// 3-1 값이 한 자리 정수 n일 경우 -> 4-1
	// 3-2 값이 쉼표로 구분되는 두 자리 정수 n, m일 경우 -> 4-2
	// 4-1. 2*1 부터 n*n 까지 계산(nn단)
	// 4-2. 2*1 부터 n*m 까지 계산(nm단)
	// 4. 사용자가 종료할 때 까지 반복
	
	public void runPrompt() {
		System.out.println("2 이상의 하나의 정수 혹은 쉼표로 구분되는 두 자리 정수를 입력하세요.");
		System.out.println("예) '8' or '8,7', 종료: q");
		Scanner scanner = new Scanner(System.in);
		
		boolean isLoop = true;
		while(isLoop) {
			String inputValue = scanner.nextLine();
			
			if(inputValue.equals("q")){
				System.out.println("종료합니다.");
				isLoop = false;
				break;
			}
			
			String[] splitedValue = inputValue.split(",");
			
			if (splitedValue.length == 1) {
				int firstInt = Integer.parseInt(splitedValue[0]);
				System.out.printf("%d*%d 까지 계산합니다.\n", firstInt, firstInt);
				// -> nn단 계산
			}
			
			if (splitedValue.length == 2) {
				int firstInt = Integer.parseInt(splitedValue[0]);
				int secondInt = Integer.parseInt(splitedValue[1]);
				System.out.printf("%d*%d 까지 계산합니다.\n", firstInt, secondInt);
				// -> nm단 계산
			}
			
		}
		
		scanner.close();
	}
	
	
	
	public static void main(String[] args) {
		Prompt p = new Prompt();
		p.runPrompt();
	}
	
}
