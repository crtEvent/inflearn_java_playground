package com.crtevn.gugudan;

public class Gugudan {

	// nm단 계산
	public void caculate(int firstNum, int secondNum) {
		int lastNumber = 0;
		for (int i = 2; i <= firstNum; i++) {
			if (i < firstNum)
				lastNumber = 9;
			if (i == firstNum)
				lastNumber = secondNum;

			for (int j = 1; j <= lastNumber; j++) {
				System.out.printf("%d * %d = %d\n", i, j, i * j);
			}
		}
	}

}
