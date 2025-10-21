package com.kh.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication이 있는 파일의 위치와 동일하거나 그 아래에 존재하는 파일/패키지 등을 찾는다.
@SpringBootApplication
public class Application {

	public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
	}

}
