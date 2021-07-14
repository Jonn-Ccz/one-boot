package com.one.boot.web.controller;

import com.one.boot.web.domain.TestDomain;
import com.one.boot.web.service.TestService;
import com.one.boot.core.result.Resp;
import com.one.boot.core.result.RespCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 1.0
 * @Author jonn
 * @Date: 2021/7/14
 * @Description:
 */
@RequestMapping("/test")
@RestController
@RequiredArgsConstructor
public class TestController {

    private final TestService testService;

    @RequestMapping("/createDomain")
    public Resp<String> createDomain() {
        TestDomain domain = new TestDomain();
        domain.setName("zcc");
        this.testService.proxyCreate(domain);
        return new Resp<>(RespCode.SUCCESS);
    }
}
