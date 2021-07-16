package com.one.boot.core.service;

import com.one.boot.core.domain.BaseDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by jonn
 * Date: 2021/4/19 6:06 下午
 * Description: TODO 缓存实现
 */

public abstract class CacheDomainService<T extends BaseDomain> extends AbstractDomainService<T> {

    @Resource
    protected ApplicationContext context;

    protected Cache cache;

    @Autowired(required = false)
    protected RedisTemplate redisTemplate;


    @Override
    public void proxyCreate(T domain) {
        domain.setCreateTime(new Date());
        getBaseMapper().insert(domain);
    }

    @Override
    public void proxyUpdate(T domain) {
        domain.setCreateTime(new Date());
        getBaseMapper().updateById(domain);
    }

    @Override
    public List<T> findAll() {
        return super.findAll();
    }

    @Override
    public void proxyDelete(T domain) {
        getBaseMapper().deleteById(domain.getId());
    }


}
