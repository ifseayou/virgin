package com.isea.virgin.web.company.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.isea.virgin.web.company.dto.EmployeeDTO;
import com.isea.virgin.web.company.dto.EmployeePageDTO;
import com.isea.virgin.web.company.entity.Employee;
import com.isea.virgin.web.company.mapper.EmployeeMapper;
import com.isea.virgin.web.company.service.EmployeeService;
import com.isea.virgin.web.company.vo.EmployeeVO;
import com.isea.virgin.web.utils.ListUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author ifseayou@gmail.com
 * @date 2020/1/3 14:47
 * @target:
 */
@Service
// ServiceImpl<操作表对应的Mapper,被操作表对应的实体类>
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    @Override
    public boolean insertTbEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDTO, employee);
        employee.setDeleted(false);
        return this.save(employee);
    }

    @Override
    public Employee selectEmployeeByEmpNo(String empNo) {
        return employeeMapper.selectById(empNo);
    }

    @Override
    public int deleteEmployeeByEmpNo(String empNo) {
        return employeeMapper.deleteById(empNo);
    }

    @Override
    public PageInfo<EmployeeVO> getEmployeePage(EmployeePageDTO employeePageDTO) {
        PageHelper.startPage(employeePageDTO.getPageNum(), employeePageDTO.getPageSize());
        QueryWrapper<Employee> queryWrapper = new QueryWrapper();
        if (StringUtils.hasText(employeePageDTO.getEmpNo())) {
            queryWrapper.eq("emp_no", employeePageDTO.getEmpNo());
        }
        List<Employee> employees = employeeMapper.selectList(queryWrapper);
        PageInfo<Employee> pageInfo = new PageInfo<>(employees);
        List<EmployeeVO> employeeVOs = ListUtils.entityListToModelList(employees, EmployeeVO.class);
        PageInfo<EmployeeVO> pageInfoVO = new PageInfo<>();
        BeanUtils.copyProperties(pageInfo,pageInfoVO);
        pageInfoVO.setList(employeeVOs);
        return pageInfoVO;
    }
}
