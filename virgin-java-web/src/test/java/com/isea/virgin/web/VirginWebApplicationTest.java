package com.isea.virgin.web;

import com.alibaba.fastjson.JSON;
import com.isea.virgin.web.company.dto.EmployeeDTO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Date;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author ifseayou@gmail.com
 * @date 2020/1/6 9:47
 * @target: MockMvc就是模拟的MVC环境。
 * MockMvc是一套用于测试WEB应用的框架工具，它可以模拟HTTP请求来完成spring mvc的流程测试。有了它，我们不用再通过客户端访问服务端的方式来进行测试了，
 * 直接通过MockMvc模拟客户端即可，这样整个测试只需要在服务端就可以完成了。
 * <p>
 * perform：执行一个RequestBuilder请求，会自动执行SpringMVC的流程并映射到相应的控制器执行处理；
 * get:声明发送一个get请求的方法。MockHttpServletRequestBuilder get(String urlTemplate, Object... urlVariables)：根据uri模板和uri变量值得到一个GET请求方式的。另外提供了其他的请求的方法，如：post、put、delete等。
 * andExpect：添加ResultMatcher验证规则，验证控制器执行完成后结果是否正确（对返回的数据进行的判断）；
 * andDo：添加ResultHandler结果处理器，比如调试时打印结果到控制台（对返回的数据进行的判断）；
 * andReturn：最后返回相应的MvcResult；然后进行自定义验证/进行下一步的异步处理（对返回的数据进行的判断）；
 */
@RunWith(SpringRunner.class)
// @RunWith是一个JUnit4的注解，表明测试运行器,表明获取spring上下文支持；如果使用JUnit5可以不用添加此注解，因为@SpringBootTest中集成了@RunWith
@SpringBootTest
// 加载Web ApplicationContext并提供模拟Web环境，其的搜索算法从包含测试包开始工作，直到找到用@SpringBootApplicationor 或者@SpringBootConfiguration注释的类
public class VirginWebApplicationTest {

    @Test
    public void contextLoads() {
    }

    private MockMvc mockMvc; // 模拟MVC对象，通过MockMvcBuilders.webAppContextSetup(this.wac).build()初始化。

    @Autowired
    private WebApplicationContext wac; // 注入WebApplicationContext

    /**
     * 定义一个before方法，在执行测试方法之前准备测试环境，如果没有这个，test中，mockMvc产生空指针
     */
    @Before // 在测试开始前初始化工作
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    /**
     * 测试Get请求
     *
     * @throws Exception
     */
    @Test
    public void testGetEmployeeByEmpNo() throws Exception {
        mockMvc.perform(get("/company/employee/{empNo}", 1)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()) // // 返回执行请求的结果
                .andDo(print());
    }

    /**
     * 测试Post请求
     *
     * @throws Exception
     */
    @Test
    public void testAdd() throws Exception {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setFirstName("关").setLastName("羽").setGender("1").
                setBirthDate(new Date()).setHireDate(new Date());
        mockMvc.perform(
                post("/company/employee/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JSON.toJSONString(employeeDTO)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andReturn().getResponse().getContentAsString();
    }
}
