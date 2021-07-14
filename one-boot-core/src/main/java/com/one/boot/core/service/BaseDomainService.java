package com.one.boot.core.service;

import com.one.boot.core.domain.BaseDomain;
import org.springframework.context.ApplicationContext;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by jonn
 * Date: 2021/4/19 6:06 下午
 * Description:
 */

public abstract class BaseDomainService<T extends BaseDomain> extends AbstractDomainService<T> {

    @Resource
    protected ApplicationContext context;


    @Override
    public void proxyCreate(T domain) {
        domain.setCreateTime(new Date());
        domain.setLastModifyTime(new Date());
        getBaseMapper().insert(domain);
    }

    @Override
    public void proxyUpdate(T domain) {
        domain.setLastModifyTime(new Date());
        getBaseMapper().updateById(domain);
    }

    @Override
    public void proxyDelete(T domain) {
        getBaseMapper().deleteById(domain.getId());
    }


}
