package com.isea.virgin.web.company.dto;

import com.isea.virgin.web.annotation.Mobile;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import java.util.Date;


/**
 * @author ifseayou@gmail.com
 * @date 2020/1/3 13:40
 * @target:
 */
@Data
@Accessors(chain = true)
// 需要有get/set方法，swagger才能进行对象的设置
public class EmployeeDTO {

    /**
     * @ApiModelProperty()用于方法，字段； 表示对model属性的说明 或者 数据操作更改
     * value 字段说明
     * name 重写属性名
     * required 是否必填
     * example 举个例子
     * hidden 是否隐藏
     */
    @ApiModelProperty(value = "姓")
    @NotBlank(message = "FirstName can not null or empty")
    private String firstName;

    @ApiModelProperty(value = "名字")
    @NotBlank(message = "LastName can not null or empty")
    private String lastName;

    /**
     * 数据库中的char就是字符串，在MySQL中只有变长和定长字符串两种
     */
    @ApiModelProperty(value = "性别，1: 男 0: 女")
    @NotBlank(message = "Gender can not null or empty")
    private String gender;

    @ApiModelProperty(value = "手机号")
    @Mobile(message = "invalid mobile number")
    private String mobile;

    @ApiModelProperty(value = "出生日期 如1997-09-07 'YYYY-mm-dd'")
    @Past(message = "BirthDate must be a past time") //该注解仅仅为util.Date类型的日期类型生效
    private Date birthDate;

    /**
     * 对于数据库中的Date，在Java中使用util.Date类型
     */
    @ApiModelProperty(value = "雇用日期")
    private Date hireDate;
}
