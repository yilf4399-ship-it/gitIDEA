package com.itheima.springboot_train;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.itheima.springboot_train.mapper") //MyBatis自动为这些接口生成代理实现类,无需mapper接口
public class SpringbootTrainApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootTrainApplication.class, args);
    }

}
