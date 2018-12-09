package com.cxjg.mes;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication()
@EnableDubboConfiguration
public class CxjgMesSystemWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(CxjgMesSystemWebApplication.class, args);
	}
}
