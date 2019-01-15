package com.aidilude.moochat;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages={"com.aidilude.moochat.mapper"})
public class MooChatApplication {

	public static void main(String[] args) {
		SpringApplication.run(MooChatApplication.class, args);
	}

}