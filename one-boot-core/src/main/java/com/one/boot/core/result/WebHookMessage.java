package com.one.boot.core.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

/**
 * @version 1.0
 * @Author jonn
 * @Date: 2021/7/8
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WebHookMessage {

    private Integer status;

    private String msg;

    public WebHookMessage success(String msg) {
        this.status = HttpStatus.OK.value();
        this.msg = msg;
        return this;
    }

    public WebHookMessage fail(String msg) {
        this.status = HttpStatus.NOT_ACCEPTABLE.value();
        this.msg = msg;
        return this;
    }


}
