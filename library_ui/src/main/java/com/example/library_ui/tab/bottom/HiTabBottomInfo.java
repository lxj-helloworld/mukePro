package com.example.library_ui.tab.bottom;

import android.graphics.Bitmap;
import android.widget.FrameLayout;

/**
 * 项目名称 mukePro
 * 创建人 xiaojinli
 * 创建时间 2023/12/31 19:58
 **/
public class HiTabBottomInfo<Color> {
    public enum TabType {
        BITMAP, ICON
    }

    public Class<? extends FrameLayout> fragment;

    public String name;
    public Bitmap defaultBitmap;
    public Bitmap selectedBitmap;
    public String iconFont;
    public String detaultIconName;
    public String selectedIconName;
    public String defaultColor;
    public String tintColor;
    public TabType tabType;

    public HiTabBottomInfo(String name, Bitmap defaultBitmap, Bitmap selectedBitmap, String defaultColor, String tintColor, TabType tabType) {
        this.name = name;
        this.defaultBitmap = defaultBitmap;
        this.selectedBitmap = selectedBitmap;
        this.defaultColor = defaultColor;
        this.tintColor = tintColor;
        this.tabType = tabType;
    }

    public HiTabBottomInfo(String name, String iconFont, String detaultIconName, String selectedIconName, String defaultColor, String tintColor, TabType tabType) {
        this.name = name;
        this.iconFont = iconFont;
        this.detaultIconName = detaultIconName;
        this.selectedIconName = selectedIconName;
        this.defaultColor = defaultColor;
        this.tintColor = tintColor;
        this.tabType = tabType;
    }
}
