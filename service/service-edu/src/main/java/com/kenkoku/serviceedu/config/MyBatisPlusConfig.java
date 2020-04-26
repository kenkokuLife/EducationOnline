package com.kenkoku.serviceedu.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.kenkoku.serviceedu.mapper")
public class MyBatisPlusConfig {

    /*
    *ページングプラグイン
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() { return new PaginationInterceptor(); }


}
