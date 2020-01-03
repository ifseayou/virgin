package com.isea.virgin.web.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ifseayou@gmail.com
 * @date 2020/1/2 23:57
 * @target:
 */
@Configuration
//@MapperScan 注解，扫描 Mapper 文件夹，此处@MapperScan + @Configuration 就相当于在启动类加上 @MapperScan 注解
@MapperScan(basePackages = {"com.isea.virgin.web.company.mapper"})
public class MybatisPlusConfig {

    /**
     * 分页
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        /*
         设置请求的页面大于最大页后操作， true调回到首页，false 继续请求  默认false
         paginationInterceptor.setOverflow(false);
         设置最大单页限制数量，默认 500 条，-1 不受限制
         paginationInterceptor.setLimit(500);
         */
        return new PaginationInterceptor();
    }
}
