package com.manage.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * MyBatis相关配置
 * @author 吴政杰
 */
@Configuration
@EnableTransactionManagement
@MapperScan("com.manage.mapper")
public class MyBatisConfig {
}
