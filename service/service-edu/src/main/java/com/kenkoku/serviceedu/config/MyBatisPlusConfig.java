package com.kenkoku.serviceedu.comfig;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.kenkoku.serviceedu.mapper")
public class MyBatisPlusConfig {
}
