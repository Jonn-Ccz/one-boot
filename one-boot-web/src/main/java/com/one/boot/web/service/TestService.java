package com.one.boot.web.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.one.boot.web.domain.TestDomain;
import com.one.boot.web.mapper.TestDomainMapper;
import com.one.boot.core.service.BaseDomainService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @version 1.0
 * @Author jonn
 * @Date: 2021/7/14
 * @Description:
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class TestService extends BaseDomainService<TestDomain> {

    private final TestDomainMapper mapper;

    @Override
    protected BaseMapper<TestDomain> getBaseMapper() {
        return mapper;
    }
}
