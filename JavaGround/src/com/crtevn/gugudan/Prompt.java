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
		Gugudan gugudan = new Gugudan();
		Scanner scanner = new Scanner(System.in);
		
		boolean isLoop = true;
		while(isLoop) {
			
			System.out.println("하나의 정수(n) 또는 쉼표로 구분되는 두 정수(n, m)을 입력하세요.");
			System.out.println("(단, 1 < n < 101, 0 < m < 101.)");
			System.out.println("예) '8' or '8,7', 종료: q");
			String inputValue = scanner.nextLine();
			
			if(inputValue.equals("q")){
				System.out.println("종료합니다.");
				isLoop = false;
				break;
			}
			
			String[] splitedValue = inputValue.split(",");
			if(!validationInputValue(splitedValue)){
				continue;
			}
			
			if (splitedValue.length == 1) {
				int firstInt = Integer.parseInt(splitedValue[0]);
				System.out.printf("%d*%d 까지 계산합니다.\n", firstInt, firstInt);
				// -> nn단 계산
				gugudan.caculate(firstInt, firstInt);
			}
			
			if (splitedValue.length == 2) {
				int firstInt = Integer.parseInt(splitedValue[0]);
				int secondInt = Integer.parseInt(splitedValue[1]);
				System.out.printf("%d*%d 까지 계산합니다.\n", firstInt, secondInt);
				// -> nm단 계산
				gugudan.caculate(firstInt, secondInt);
			}
			
			System.out.println();
		}
		
		scanner.close();
	}
	
	/**
	 * 사용자로 부터 입력받은 값이 유효한지 검사하는 메서드
	 * @param strArr
	 * @return 유효성검사에 통과하면 true 반환, 실패하면 false 반환
	 */
	public boolean validationInputValue(String[] strArr) {
		
		int firstInt, secondInt = 1;
		
		try {
			firstInt = Integer.parseInt(strArr[0]);
			
			if(strArr.length > 1){
				secondInt = Integer.parseInt(strArr[1]);
			}
			
			if(firstInt < 2 || firstInt > 100 || secondInt < 1 || secondInt > 100) {
				throw new Exception();
			}
			
			return true;
			
		} catch (Exception e) {
			System.out.println("잘못된 값이 들어왔습니다.\n");
			return false;
		}
		
	}
	
	public static void main(String[] args) {
		Prompt p = new Prompt();
		p.runPrompt();
	}
	
}
