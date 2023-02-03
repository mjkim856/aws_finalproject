package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

// @ComponentScan(basePackages = "com.example.demo")
// 만약 아무것도 입력 안 하면 해당 패키지의 annotation을 모두 읽는다.
// 아래처럼 기본패키지를 upload하면 현재 패키지가 기본 대상이 되지 않기에 따로 적어줘야 한다.
// @ComponentScan만 하면 알아서 현재 패키지 스캔해 준다.
@SpringBootApplication		// 설정클래스파일 + spring 시작 / 톰캣 시작
@ComponentScan
@ComponentScan(basePackages = {"upload", "board.spring.mybatis"})
@ComponentScan(basePackages = "spring.mybatis")
@ComponentScan(basePackages = "websocket")
@ComponentScan(basePackages = "dbsecure")
@MapperScan(basePackages = {"spring.mybatis", "board.spring.mybatis"})
public class SecondApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecondApplication.class, args);
	}

}
