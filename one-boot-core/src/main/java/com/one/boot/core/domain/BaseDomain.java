package com.one.boot.core.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @version 1.0
 * @Author jonn
 * @Date: 2021/7/14
 * @Description:
 */
public class BaseDomain extends Domain {
    protected Date createTime;

    protected Date lastModifyTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    public Date getCreateDate() {
        if (this.createTime == null) {
            this.createTime = new Date();
        }
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    public Date getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(Date lastModifyDate) {
        this.lastModifyTime = lastModifyDate;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
