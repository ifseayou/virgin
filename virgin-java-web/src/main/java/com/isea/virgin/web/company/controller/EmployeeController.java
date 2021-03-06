package com.isea.virgin.web.company.controller;

import com.isea.virgin.web.company.dto.EmployeeDTO;
import com.isea.virgin.web.company.dto.EmployeePageDTO;
import com.isea.virgin.web.company.entity.Employee;
import com.isea.virgin.web.company.service.EmployeeService;
import com.isea.virgin.web.company.vo.EmployeeVO;
import com.isea.virgin.web.company.vo.PageInfoVO;
import com.isea.virgin.web.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

/**
 * @author ifseayou@gmail.com
 * @date 2020/1/3 12:25
 * @target:
 */
@Api(tags = "企业员工信息操作")
@RestController  // 声明Bean对象，为一个控制器组件
@RequestMapping(value = {"/company"})
@Slf4j
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @ApiOperation(value = "添加员工",httpMethod = "POST",response = String.class,
            notes = "添加员工")
    @ApiParam(name = "传入的值",value = "传入Json",required = true)
    @PostMapping(value = {"/employee/add","/i/sea/you"})
    public Result<Boolean> add(@Valid @RequestBody EmployeeDTO employeeDTO){
        return Result.success(employeeService.insertTbEmployee(employeeDTO));
    }

    @ApiOperation(value = "获取员工信息",notes = "根据员工编号，获取员工信息")
    @ApiParam(name = "传入的值",value = "String",required = true)
    @GetMapping("/employee/{empNo}") // 在Get请求中不能使用@RequestBody，但是可以使用@RequestParam
    public Result<Employee> getEmployeeByEmpNo(@PathVariable(value = "empNo") String empNo){
        return Result.success(employeeService.selectEmployeeByEmpNo(empNo));
    }

    @ApiOperation(value = "删除员工",notes = "根据员工号删除员工")
    @ApiParam(name = "传入的值",value = "String",required = true)
    @PutMapping("/employee/delete")
    public Result<Integer> deleteEmployeeByEmpNo(
            @RequestParam(value = "empNo", defaultValue = "没有传入值的时候，使用的value") String empNo/*,
            @RequestParam(name = "") String test*/){
        return Result.success(employeeService.deleteEmployeeByEmpNo(empNo));
    }


    @ApiOperation(value = "获取员工列表",notes = "查询所有员工")
    @ApiParam(name = "传入的值",value = "Json",required = true)
    @PostMapping("/employee/list")
    public Result<PageInfoVO<EmployeeVO>> getEmployeePage(@RequestBody EmployeePageDTO employeePageDTO){
        return Result.success(employeeService.getEmployeePage(employeePageDTO));
    }

    @ApiOperation(value = "批量添加员工",notes = "批量添加员工")
    @ApiParam(name = "传入的值",value = "JSON",required = true)
    @PostMapping("/employee/batch")
    public Result<Boolean> insertTbEmployeeBatch(@RequestBody List<EmployeeDTO> employeeDTOS){
        return Result.success(employeeService.insertTbEmployeeBatch(employeeDTOS));
    }

    @ApiOperation(value = "使用Servlet原生API作为目标方法的参数",notes = "测试")
    @ApiParam(value = "String",required = true)
    @GetMapping(value = "/servlet/test")
    public void servletTest(HttpServletRequest request, HttpServletResponse response, Writer out) throws IOException {
        log.error("Request:" + request + ",Response:" + response);
        out.write("this is a servlet api for test....");
    }

}
