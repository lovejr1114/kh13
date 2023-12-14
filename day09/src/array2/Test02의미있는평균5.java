package array2;

import java.util.Scanner;

public class Test02의미있는평균5 {
	public static void main(String[] args) {
//		사용자에게 5개의 실수를 입력받아 평균을 구하려고 합니다. 
		
//		좀 더 의미있는 데이터를 만들기 위해서
//		가장 작은 값과 가장 큰 값을 뺀 나머지 데이터로 평균을 구하는 프로그램을 구현하세요.
//		최소나 최대값이 2개 이상이라면 둘 중 아무거나 한 개를 정해서 하면 된다.
		
		//배열 준비
		double[] data = new double[5];
		
		data[0] = 1.2;
		data[1] = 2.3;
		data[2] = 3.4;
		data[3] = 4.5;
		data[4] = 5.6;
		
		//최대값 위치 구하기
		int max = 0; //맨 앞이 제일 클 것이라고 예상
		for(int i=1; i<=4; i++) {//1번 위치부터 마지막까지
			if(data[max] < data[i]) { //현재 값이 내가 아는 최대값보다 더 크다면
				max = i;
			}
		}
		System.out.println("최대값 위치 : " +max);
		
		//합계 구하기
		double total = 0.0;
		for(int i=0; i<=4; i++) {
			total += data[i];	
		}
		
		total -= data[0]; //제일 작은 거
		total -= data[max]; //제일 큰 거

		double avg = total / 3;
		System.out.println("평균 : " + avg);

	}
	

}
