package com.maomao2.databasesharding;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@MapperScan(basePackages = "com.maomao2.databasesharding.mapper")
@SpringBootApplication
public class DatabaseShardingApplication {

	public static void main(String[] args) {
		SpringApplication.run(DatabaseShardingApplication.class, args);
	}
}
