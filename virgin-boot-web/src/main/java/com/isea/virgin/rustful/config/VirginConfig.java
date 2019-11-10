package com.isea.virgin.rustful.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author isea_you
 * @date 2019/11/9
 * @time 8:23
 * @target:
 */
@Configuration
public class VirginConfig extends WebMvcConfigurerAdapter {

    // 所有的WebMvcConfigurerAdapter组件都会一起起作用，前提是springboot知道我们的组件，添加@Bean注解
    @Bean // 将组件注册到容器中
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
            }
        };
        return adapter;
    }
}
