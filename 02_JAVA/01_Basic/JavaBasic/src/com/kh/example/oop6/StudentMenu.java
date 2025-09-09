package com.kh.example.oop6;

public class StudentMenu {
	private StudentController ssm = new StudentController();

	public StudentMenu() {
		Student[] stArr = ssm.printStudent();
		System.out.println("=========학생 정보 출력=========");
		for(Student st : stArr) {
			if(st == null) break;
			System.out.println(st.inform());
		}
		
		System.out.println();
		System.out.println("=========학생 성적 출력=========");
		double[] scArr = ssm.avgScore();
		System.out.println("학생 점수 합계 : " +scArr[0]);
		System.out.println("학생 점수 평균 : " +scArr[1]);
		
		System.out.println();
		System.out.println("=========성적 결과 출력=========");
		for(Student st : stArr) {
			if(st.getScore() < ssm.CUT_LINE) {
				System.out.printf("%s학생은 재시험 대상입니다.\n",st.getName());
			} else {
				System.out.printf("%s학생은 통과입니다.\n",st.getName());
			}
		}
	}
	
	
}
