package com.example.library_ui.tab.common;

import androidx.annotation.Px;

import org.jetbrains.annotations.NotNull;

/**
 * 项目名称 mukePro
 * 创建人 xiaojinli
 * 创建时间 2023/12/31 19:56
 **/
public interface IHiTab<D> extends IHiTabLayout.OnTabSelectedListener<D> {
    void setHiTabInfo(@NotNull D data);

    void resetHeight(@Px int height);
}
