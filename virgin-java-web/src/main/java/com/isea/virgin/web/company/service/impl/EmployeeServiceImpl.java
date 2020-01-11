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
import com.isea.virgin.web.company.vo.PageInfoVO;
import com.isea.virgin.web.utils.ListUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
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

    @Autowired
    EmployeeServiceImpl employeeService;

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
    public PageInfoVO<EmployeeVO> getEmployeePage(EmployeePageDTO employeePageDTO) {

        // 传入第几页，当前页的行数大小
        PageHelper.startPage(employeePageDTO.getPageNum(), employeePageDTO.getPageSize());

        QueryWrapper<Employee> query = new QueryWrapper();
        if (StringUtils.hasText(employeePageDTO.getEmpNo())) {
            query.eq("emp_no", employeePageDTO.getEmpNo());
        }
        // 将满足query条件的都选择出来
        List<Employee> employees = employeeMapper.selectList(query);

        // 将employees 进行分页
        PageInfo<Employee> pageInfo = new PageInfo<>(employees);

        // 将employee 数据变为 employeeVO数据
        List<EmployeeVO> employeeVOs = ListUtils.entityListToModelList(employees, EmployeeVO.class);
        PageInfoVO<EmployeeVO> pageInfoVO = new PageInfoVO<>();
        // 将原有的分页改装成间洁的分页模式
        BeanUtils.copyProperties(pageInfo,pageInfoVO);
        // 设置一页中值
        pageInfoVO.setList(employeeVOs);
        return pageInfoVO;
    }

    @Override
    public boolean insertTbEmployeeBatch(List<EmployeeDTO> employeeDTOS) {

        ArrayList<Employee> employeeList = new ArrayList<>();
        for (EmployeeDTO employeeDTO : employeeDTOS) {
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeDTO,employee);
            employee.setDeleted(false);
            employeeList.add(employee);
        }

        return employeeService.saveBatch(employeeList);
    }
}
