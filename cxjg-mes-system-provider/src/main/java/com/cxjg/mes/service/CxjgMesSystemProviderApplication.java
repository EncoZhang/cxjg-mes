package com.cxjg.mes.service;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubboConfiguration
@MapperScan("com.cxjg.mes.mapper.*")
public class CxjgMesSystemProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(CxjgMesSystemProviderApplication.class, args);
	}
}
