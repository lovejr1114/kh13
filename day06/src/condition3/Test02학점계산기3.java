package condition3;

import java.util.Scanner;

public class Test02학점계산기3 {
	public static void main(String[] args) {
		//KH대학교에서는 다음 기준에 따라 학점을 계산합니다.
		//(시험은 100점이 만접입니다.)
		//90점 이상 100점 이하 A+
		//80점 이상 90점 미만 A
		//70점 이상 80점 미만 B
		//60점 이상 70점 미만 C
		//나머지 F
		//if 구문이 아닌 switch구문으로 풀어보세요
		
		Scanner sc = new Scanner(System.in);
				System.out.println("학점을 입력하세요");
		int score = sc.nextInt();
		
		score = score / 10 * 10;
		
		String grade;
		switch(score) {
		case 90: case 100: //if문일 때는 if(score >= 90 && score <= 100)
			grade = "A+";
			break;
		case 80:
			grade = "A";
			break;
		case 70:
			grade = "B";
			break;
		case 60:
			grade = "C";
			break;
		default:
			grade = "F";
			break;
		}
		
		System.out.println("당신의 학점은? " + grade);
		
	}

}
