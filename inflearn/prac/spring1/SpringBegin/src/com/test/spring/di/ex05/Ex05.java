package com.test.spring.di.ex05;

import java.util.ArrayList;

public class Ex05 {
	
	public static void main(String[] args) {
		
		//ex04 vs ex05
		// - File객체에서 DB객체로 전환 시
		// - 그걸 제어하는 주체가 다르다!!!
		// - ex04 > 주체(Service)
		// - ex05 > 주체(Ex05)
		
		
		//회원 명단 관리
		//1. 데이터 저장소 > 텍스트 파일 사용(member.txt)
		//-> 저장소 전환
		//2. 데이터 저장소 > 데이터베이스 사용(Oracle)
		
		
		//Ex05 -> (의존) -> Service -> (의존) -> File or DB
		
		//DI 구현
		//Service -> (의존) -> File or DB 
		
		
		//IData data = new File(); //Service가 필요로 하는 의존 객체
		IData data = new DB();
		
		Service service = new Service(data); //의존 주입 실행
		
		ArrayList<String> list = service.list();
		
		for (String name : list) {
			
			System.out.println(name);
		}
				
	}

}








