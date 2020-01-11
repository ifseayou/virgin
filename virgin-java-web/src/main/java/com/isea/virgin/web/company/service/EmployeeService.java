package com.isea.virgin.web.company.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.isea.virgin.web.company.dto.EmployeeDTO;
import com.isea.virgin.web.company.dto.EmployeePageDTO;
import com.isea.virgin.web.company.entity.Employee;
import com.isea.virgin.web.company.vo.EmployeeVO;
import com.isea.virgin.web.company.vo.PageInfoVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ifseayou@gmail.com
 * @date 2020/1/3 14:46
 * @target:
 */
@Service
public interface EmployeeService extends IService<Employee> {
    /**
     * 保存
     * @param employeeDTO
     * @return
     */
    boolean insertTbEmployee(EmployeeDTO employeeDTO);


    /**
     * 根据员工Id获取员工信息
     * @param empNo
     * @return
     */
    Employee selectEmployeeByEmpNo(String empNo);


    /**
     * 删除员工
     * @param empNo
     * @return
     */
    int deleteEmployeeByEmpNo(String empNo);


    /**
     * 分页查询
     * @param employeePageDTO
     * @return
     */
    PageInfoVO<EmployeeVO> getEmployeePage(EmployeePageDTO employeePageDTO);

    /**
     * 批量插入employee
     * @param employeeDTOS
     * @return
     */
    boolean insertTbEmployeeBatch(List<EmployeeDTO> employeeDTOS);
}
