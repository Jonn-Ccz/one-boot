package com.one.boot.core.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.one.boot.core.condition.PageVo;
import com.one.boot.core.util.PageUtils;
import com.one.boot.core.domain.Domain;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Created by jonn
 * Date: 2021/7/14 4:25 下午
 * Description:
 */
public abstract class AbstractDomainService<T extends Domain> implements DomainService<T> {

    protected abstract void proxyCreate(T domain);

    protected abstract void proxyUpdate(T domain);

    protected abstract void proxyDelete(T domain);

    protected abstract BaseMapper<T> getBaseMapper();

    public void create(T domain) {
        proxyCreate(domain);
    }

    @Override
    public void update(T domain) {
        proxyUpdate(domain);
    }

    @Override
    public List<T> findAll() {
        return getBaseMapper().selectList(null);
    }

    @Override
    public void delete(T domain) {
        proxyDelete(domain);
    }

    @Override
    public Optional<T> getOne(Integer id) {
        final T entity = getBaseMapper().selectById(id);
        return Optional.ofNullable(entity);
    }

    @Override
    public T selectOne(Wrapper<T> wrapper) {
        List<T> result = selectAll(wrapper);
        return result.isEmpty() ? null : result.get(0);
    }

    @Override
    public Map<String, Object> selectOne(QueryWrapper<T> wrapper, String... fields) {
        List<Map<String, Object>> maps = selectMaps(wrapper, fields);
        return maps.isEmpty() ? null : maps.get(0);
    }

    @Override
    public List<Map<String, Object>> selectMaps(LambdaQueryWrapper<T> wrapper, SFunction<T, ?>... columns) {
        if (wrapper == null) {
            wrapper = new LambdaQueryWrapper<T>();
        }
        wrapper.select(columns);
        return getBaseMapper().selectMaps(wrapper);
    }

    @Override
    public List<Map<String, Object>> selectMaps(QueryWrapper<T> wrapper, String... fields) {
        if (wrapper == null) {
            wrapper = new QueryWrapper<T>();
        }
        wrapper.select(fields);
        return getBaseMapper().selectMaps(wrapper);
    }


    @Override
    public List<T> selectAll(Wrapper<T> wrapper) {
        return getBaseMapper().selectList(wrapper);
    }

    @Override
    public void update(T domain, Wrapper<T> updateWrapper) {
        getBaseMapper().update(domain, updateWrapper);
    }

    @Override
    public IPage<T> search(IPage<T> page, Wrapper<T> queryWrapper) {
        final IPage<T> resultPage = getBaseMapper().selectPage(page, queryWrapper);
        return resultPage;
    }

    @Override
    public Integer count(Wrapper<T> wrapper) {
        return getBaseMapper().selectCount(wrapper);
    }

    @Override
    public Boolean exist(Wrapper<T> wrapper) {
        return this.selectOne(wrapper) == null ? false : true;
    }

    public IPage<T> searchPage(PageVo<T> pageVo) {
        IPage page = PageUtils.convertPageVo(pageVo);
        Wrapper queryCondition = pageVo.queryCondition();
        return search(page, queryCondition);
    }
}
