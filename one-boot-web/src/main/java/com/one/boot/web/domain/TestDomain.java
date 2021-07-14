package com.one.boot.web.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.one.boot.core.domain.BaseDomain;
import lombok.Data;

/**
 * @version 1.0
 * @Author jonn
 * @Date: 2021/7/14
 * @Description:
 */
@Data
@TableName("test_domain")
public class TestDomain extends BaseDomain {
    private String name;
}
