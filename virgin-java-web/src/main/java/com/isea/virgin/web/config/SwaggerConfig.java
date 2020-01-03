package com.isea.virgin.web.config;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ifseayou@gmail.com
 * @date 2020/1/2 23:57
 * @target:
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    // 定义分隔符号
    private static final String  DELIMITER  = ";";

    @Bean
    public Docket createRestApi(){
        ParameterBuilder ticketPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<>();
        ticketPar.name("Authorization").description("user ticket")
                .modelRef(new ModelRef("string")).parameterType("header")
                .required(false).build(); //header中的ticket参数非必填，传空也可以
        pars.add(ticketPar.build());

        return new Docket(DocumentationType.SWAGGER_2)  //对Swagger规范2.0进行初始化
                //
                .apiInfo(apiInfo())
                /**
                 * select（）返回ApiSelectorBuilder的实例，以对通过swagger公开的端点进行精细控制。
                 */
                .select()
                //为当前包路径
                .apis(basePackage("com.isea.virgin.web.company.controller"))
                .paths(PathSelectors.any())
                .build()
                /*
                 *  为path-/request-/header 设置全局参数，这里的参数将会对每个restApi生效，此处添加的参数，将成为swagger规范中每个API
                 *  operation的一部分，关于如何设置安全性，每个header的名称可能不同
                 */
                .globalOperationParameters(pars);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //页面标题
                .title("Spring Boot 使用 Swagger2 构建RESTFul API")
                //创建人
                .contact(new Contact("ifseayou", "", "ifseayou@gmail.com"))
                //版本号
                .version("1.0")
                //描述
                .description("API 描述")
                .build();
    }


    public static Predicate<RequestHandler> basePackage(final String basePackage) {
        return input -> declaringClass(input).transform(handlerPackage(basePackage)).or(true);
    }

    private static Function<Class<?>, Boolean> handlerPackage(final String basePackage)     {
        return input -> {
            // 循环判断匹配
            for (String strPackage : basePackage.split(DELIMITER)) {
                boolean isMatch = input.getPackage().getName().startsWith(strPackage);
                if (isMatch) {
                    return true;
                }
            }
            return false;
        };
    }

    private static Optional<? extends Class<?>> declaringClass(RequestHandler input) {
        return Optional.fromNullable(input.declaringClass());
    }
}
