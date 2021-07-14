package com.one.boot.core.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @version 1.0
 * @Author jonn
 * @Date: 2021/7/14
 * @Description:
 */
public class Domain implements Serializable, Cloneable {

    private static final long serialVersionUID = -1194431813899876492L;

    @TableId(type = IdType.AUTO)
    protected Long id;



}
