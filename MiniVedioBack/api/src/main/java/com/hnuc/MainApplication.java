package com.hnuc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan("com.hnuc.pojo")
@ComponentScan({"com.hnuc.api"})
@ComponentScan({"com.hnuc.interceptor"})
@ComponentScan({"com.hnuc.service"})
@MapperScan({"com.hnuc.dao"})
public class MainApplication {

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}

}

