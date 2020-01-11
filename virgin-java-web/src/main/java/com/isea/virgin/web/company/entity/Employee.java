package com.isea.virgin.web.company.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.Date;


/**
 * @author ifseayou@gmail.com
 * @date 2020/1/3 14:59
 * @target:
 */

@Data
@Accessors(chain = true)
@ToString
public class Employee extends Model<Employee> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "emp_no",type = IdType.AUTO)
    private String empNo;

    /**
     * 姓
     */
    @TableField(value = "first_name")
    private String firstName;

    /**
     * 名字
     */
    @TableField(value = "last_name")
    private String lastName;

    /**
     * 性别
     */
    @TableField("gender")
    private String gender;

    /**
     * 员工电话
     */
    @TableField("mobile")
    private String mobile;

    /***
     * 出生日期
     */
    @TableField("birth_date")
    private Date birthDate;

    /**
     * 雇用日期
     */
    @TableField("hire_date")
    private Date hireDate;

    /**
     * 是否删除，表示是否离职
     */
    @TableField("is_deleted")
    @TableLogic
    private boolean deleted;
    /**
     * POJO类中布尔类型变量都不要加is前缀，否则部分框架解析会引起序列化错误。 说明：在本文 MySQL 规约中的建表约定第一条，
     * 表达是与否的值采用 is_xxx 的命名方式，所以，需要在 <resultMap>设置从 is_xxx到 xxx的映射关系
     */
}
