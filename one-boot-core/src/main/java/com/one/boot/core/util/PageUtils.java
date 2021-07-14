package com.one.boot.core.util;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.one.boot.core.condition.PageVo;

/**
 * @version 1.0
 * @Author jonn
 * @Date: 2021/6/8
 * @Description:
 */

public class PageUtils {

    private PageUtils() { }

    public static IPage convertPageVo(PageVo pageVo) {
        IPage page = new Page(pageVo.getPageNumer(), pageVo.getPageSize());
        return page;
    }
}
