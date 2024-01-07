package com.example.library_ui.tab.common;

import android.view.ViewGroup;

import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * 项目名称 mukePro
 * 创建人 xiaojinli
 * 创建时间 2023/12/31 19:50
 **/
public interface IHiTabLayout<Tab extends ViewGroup, D> {
    Tab findTab(@NotNull D data);

    void addTabSelectedChangeLisntener(OnTabSelectedListener<D> listener);

    void defaultSelected(@NotNull D defaultInfo);

    void inflateInfo(@NotNull List<D> infoList);

    interface OnTabSelectedListener<D> {
        void onTabSelectedChange(int index,  D preInfo,  D nextInfo);
    }
}
