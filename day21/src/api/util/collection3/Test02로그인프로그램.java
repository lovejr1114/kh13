package api.util.collection3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test02로그인프로그램 {
	public static void main(String[] args) {
//		Map을 만들고 다음 아이디와 비밀번호를 저장해둔 뒤
//		사용자에게 아이디와 비밀번호를 입력받아 로그인을 판정하는 프로그램을 구현하세요
//
//		(아이디) khadmin , (비밀번호) admin1234
//		(아이디) khstudent, (비밀번호) student1234
//		(아이디) khteacher, (비밀번호) teacher1234
//		(아이디) khmanager, (비밀번호) manager1234
//
//		사용자가 입력한 아이디와 비밀번호를 검사하여 통과 시 '로그인 성공' 출력
//		통과하지 못할 경우 '입력하신 정보가 일치하지 않습니다' 출력
		Scanner sc = new Scanner(System.in);
		Map<String,String> users = new HashMap<>();		
		users.put("khadmin", "admin1234");
		users.put("khstudent", "student1234");
		users.put("khteacher", "teacher1234");
		users.put("khmanager", "manager1234");
		
		//사용자 입력
		System.out.print("ID : ");
		String id = sc.nextLine();
		System.out.print("PW : ");
		String pw = sc.nextLine();
		sc.close();
		
		
		boolean login = users.containsKey(id) && users.get(id).equals(pw);		
		
		if(login) { //아이디가 존재하고 해당하는 비밀번호가 일치하면
			System.out.println("로그인 성공");
		}
		else {
			System.out.println("입력하신 정보가 일치하지 않습니다.");
		}
	}
}
