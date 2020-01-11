package com.isea.virgin.web;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.isea.virgin.web.company.entity.Employee;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author ifseayou@gmail.com
 * @date 2020/1/10 13:45
 * @target:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class MybatisPlusCURDTest {

    @Test
    public void contextLoads() {
    }

    @Test
    public void testSelectById(){
        Employee employee = new Employee();
        employee.setEmpNo("1");
        //根据ID查询一条数据
        Employee emp = employee.selectById();
        log.error(emp.toString());
    }

    @Test
    public void testSelectAll(){
        Employee employee = new Employee();
        // 查询所有数据
        List<Employee> employees = employee.selectAll();
        employees.forEach(t->log.error(t.toString()));
    }

    @Test
    public void testSelectList(){
        Employee employee = new Employee();
        // 根据条件查询
        QueryWrapper<Employee> query = new QueryWrapper<>();
        List<Employee> employeeList = employee.selectList(query.like("gender", "1"));
        // 这里实例query实例已经包含了之前的like，所以下面的查询语句将会获取不到数据
        // 所以实例类是可以复用的，但是Wrapper不能复用
        List<Employee> employeeList1 = employee.selectList(query.like("gender", "0"));
        employeeList.forEach(t->log.error(t.toString()));
        employeeList1.forEach(t->log.error(t.toString()));
    }

    @Test
    public void testSelectCount(){

        Employee employee = new Employee();
        QueryWrapper<Employee> query = new QueryWrapper<>();
        Integer boyCount = employee.selectCount(query.like("gender", "1"));
        log.error(boyCount.toString());
    }

    @Test
    public void testGe(){
        Employee employee = new Employee();
        QueryWrapper<Employee> query = new QueryWrapper<Employee>().ge("mobile", "13126505729");
        List<Employee> employeeList = employee.selectList(query);
        employeeList.forEach(t-> log.info(t.toString()));
    }

    @Test
    public void testInsert(){
        SimpleDateFormat sf = new SimpleDateFormat("YYYY-mm-dd");
        Employee employee = new Employee();
        employee.setDeleted(false).setBirthDate(new Date()).
                setFirstName("李").setLastName("白").setGender("1").
                setHireDate(new Date()).setMobile("13126505729");
        boolean insert = employee.insert();
        Assert.assertTrue(insert);

        List<Employee> employees = employee.selectList(new QueryWrapper<Employee>()
                .eq("first_name", "李")
                .eq("last_name", "白"));
        ArrayList<Employee> emps = new ArrayList<>();
        employees.forEach(t->{
            Employee emp = new Employee();
            BeanUtils.copyProperties(t,emp);
            Date birthDate = t.getBirthDate();
            String format = sf.format(birthDate);

        });


    }
}
