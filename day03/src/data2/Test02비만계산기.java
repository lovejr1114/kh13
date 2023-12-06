package data2;

public class Test02비만계산기 {
	public static void main(String[] args) {
		//BMI(체질량지수) 계산 공식은 다음과 같습니다.
		//키가 180cm, 몸무게가 80kg인 사람의 BMI 지수를 구하여 출력하세요
		// BMI = 체중(kg) / 키 (m²)
		
		//입력
		double kg = 80; //int 입력도 가능 (cm)도
		double cm = 180;
		
		//계산
		double m = cm / 100;
		double bmi = kg / (m * m); 
		//double bmi = kg / m / m; 도 가능 **kg / m * m 으로 적으면 틀림. 
		
		//출력
		System.out.println(bmi);
		
	}

}
