package com.one.boot.core.condition;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.google.common.collect.Lists;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * @version 1.0
 * @Author jonn
 * @Date: 2021/5/12
 * @Description:
 */
@Getter
@Setter
public class PageVo<T> {

    private Integer pageSize;

    private Integer pageNumer;

    private List<FieldCondition> conditions = Lists.newArrayList();


    public Wrapper queryCondition() {
        QueryWrapper<T> wrapper = new QueryWrapper<T>();
        conditions.stream().forEach(condition -> {
            Operation operator = condition.getOperator();
            String fieldName = condition.getFieldName();
            Object fieldValue = condition.getFieldValue();
            if (StringUtils.isAnyBlank(fieldName) || fieldValue == null) {
                return;
            }
            if (operator == Operation.GE) {
                wrapper.ge(fieldName, fieldValue);
            } else if (operator == Operation.GT) {
                wrapper.gt(fieldName, fieldValue);
            } else if (operator == Operation.IN) {
                if (fieldValue instanceof List) {
                    wrapper.in(fieldName, (List) fieldValue);
                } else {
                    wrapper.in(fieldName, fieldValue);
                }
            } else if (operator == Operation.LE) {
                wrapper.le(fieldName, fieldValue);
            } else if (operator == Operation.LIKE) {
                wrapper.like(fieldName, fieldValue);
            } else if (operator == Operation.LT) {
                wrapper.lt(fieldName, fieldValue);
            } else if (operator == Operation.NE) {
                wrapper.ne(fieldName, fieldValue);
            } else if (operator == Operation.NOT_IN) {
                wrapper.notIn(fieldName, fieldValue);
            } else if (operator == Operation.NOT_LIKE) {
                wrapper.notLike(fieldName, fieldValue);
            } else {
                wrapper.eq(fieldName, fieldValue);
            }
        });
        return wrapper;
    }


}
