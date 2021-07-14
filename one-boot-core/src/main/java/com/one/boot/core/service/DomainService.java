package com.one.boot.core.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.one.boot.core.domain.Domain;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @version 1.0
 * @Author jonn
 * @Date: 2021/7/14
 * @Description:
 */
public interface DomainService<T extends Domain> {

    void create(T domain);

    void update(T domain);

    void update(T domain, Wrapper<T> updateWrapper);

    void delete(T domain);

    Optional<T> getOne(Integer id);

    Integer count(Wrapper<T> wrapper);

    Boolean exist(Wrapper<T> wrapper);

    T selectOne(Wrapper<T> wrapper);

    Map<String, Object> selectOne(QueryWrapper<T> wrapper, String... fields);

    List<Map<String, Object>> selectMaps(LambdaQueryWrapper<T> wrapper, SFunction<T, ?>... columns);

    List<Map<String, Object>> selectMaps(QueryWrapper<T> wrapper, String... fields);

    List<T> selectAll(Wrapper<T> wrapper);

    List<T> findAll();

    IPage<T> search(IPage<T> page, Wrapper<T> wrapper);

    default LambdaQueryWrapper<T> getQueryWrapper() {
        return new QueryWrapper<T>().lambda();
    };

    default LambdaUpdateWrapper getUpdateWrapper() {
        return new UpdateWrapper<T>().lambda();
    }
}
