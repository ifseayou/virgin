package com.isea.virgin.web.company.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author ifseayou@gmail.com
 * @date 2020/1/3 18:41
 * @target:
 */
@Data
@ApiModel(value = "查询VO",description = "查询列表返回的VO")
public class EmployeeVO {

    @ApiModelProperty(notes = "员工编号")
    private String empNo;

    @ApiModelProperty(notes = "姓")
    private String firstName;

    @ApiModelProperty(notes = "名字")
    private String lastName;

}
