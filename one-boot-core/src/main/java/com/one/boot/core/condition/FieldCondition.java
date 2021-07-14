package com.one.boot.core.condition;

import lombok.Data;

/**
 * @version 1.0
 * @Author jonn
 * @Date: 2021/6/8
 * @Description: 条件
 */
@Data
public class FieldCondition {

    private String fieldName;

    private Object fieldValue;

    private Operation operator = Operation.EQ;

}
