package com.isea.virgin.web.company.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author ifseayou@gmail.com
 * @date 2020/1/3 18:48
 * @target:
 */
@Data
@ApiModel(value = "查询之后分页的DTO", description = "请求参数")
public class EmployeePageDTO {

    @ApiModelProperty(notes = "页码")
    private Integer pageNum = 1;

    @ApiModelProperty(notes = "行数")
    private Integer pageSize = 10;

    @ApiModelProperty(notes = "员工编号")
    private String empNo;
}
