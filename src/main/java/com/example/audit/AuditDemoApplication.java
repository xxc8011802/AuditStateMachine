package com.example.audit;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@MapperScan(basePackages = {"com.example.audit.mapper"})
public class AuditDemoApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(AuditDemoApplication.class, args);
    }

}
