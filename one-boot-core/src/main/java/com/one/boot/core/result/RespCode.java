package com.one.boot.core.result;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.builder.EqualsBuilder;

/**
 * Created by jonn
 * Date: 2021/5/7 4:13 下午
 * Description:
 */
@Getter
@AllArgsConstructor
public class RespCode {
    /**
     * SUCCESS.
     */
    public static final RespCode SUCCESS = new RespCode(1, "调用成功");
    /**
     * WARNING.
     */
    public static final RespCode WARNING = new RespCode(2, "警告信息");
    /**
     * NOT_FOUND.
     */
    public static final RespCode NOT_FOUND = new RespCode(-1, "数据未找到");
    /**
     * VALIDATION_ERROR.
     */
    public static final RespCode VALIDATION_ERROR = new RespCode(-2, "校验错误");
    /**
     * FAILURE.
     */
    public static final RespCode FAILURE = new RespCode(9, "系统异常");

    private final int code;
    private final String description;

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        RespCode rhs = (RespCode) obj;
        return new EqualsBuilder().append(this.code, rhs.getCode()).isEquals();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

}
