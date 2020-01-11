package com.isea.virgin.web.company.vo;

import com.github.pagehelper.PageSerializable;
import lombok.Data;
import lombok.ToString;

/**
 * @author ifseayou@gmail.com
 * @date 2020/1/10 22:26
 * @target: 定制分页，作为PageInfo的拷贝类
 */

@Data
@ToString
public class PageInfoVO<T> extends PageSerializable<T> {
    private int pageNum;
    private int pageSize;
    private int size;
    private int pages;
    private int prePage;
    private int nextPage;
}
