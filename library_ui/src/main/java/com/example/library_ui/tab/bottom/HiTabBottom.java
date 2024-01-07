package com.example.library_ui.tab.bottom;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;

import com.example.library_ui.R;
import com.example.library_ui.tab.common.IHiTab;

/**
 * 项目名称 mukePro
 * 创建人 xiaojinli
 * 创建时间 2024/1/1 10:56
 **/
public class HiTabBottom extends RelativeLayout implements IHiTab<HiTabBottomInfo<?>> {

    private HiTabBottomInfo<?> tabBottomInfo;
    private ImageView tabImageView;
    private TextView tabIconView;
    private TextView tabNameView;

    public HiTabBottom(Context context) {
        this(context, null);
    }

    public HiTabBottom(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public HiTabBottom(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.hi_tab_bottom, this);
        tabImageView = findViewById(R.id.iv_image);
        tabIconView = findViewById(R.id.tv_icon);
        tabNameView = findViewById(R.id.tv_name);
    }


    @Override
    public void setHiTabInfo(@NonNull HiTabBottomInfo<?> data) {
        this.tabBottomInfo = data;
        inflateInfo(false, true);
    }

    public HiTabBottomInfo getHiTabInfo() {
        return tabBottomInfo;
    }

    public ImageView getTabImageView() {
        return tabImageView;
    }

    public TextView getTabIconView() {
        return tabIconView;
    }

    public TextView getTabNameView() {
        return tabNameView;
    }

    @Override
    public void resetHeight(int height) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = height;
        setLayoutParams(layoutParams);
        getTabNameView().setVisibility(View.GONE);
    }

    private void inflateInfo(boolean selected, boolean init) {
        if (tabBottomInfo.tabType == HiTabBottomInfo.TabType.ICON) {
            if (init) {
                tabImageView.setVisibility(GONE);
                tabIconView.setVisibility(VISIBLE);
                Typeface typeface = Typeface.createFromAsset(getContext().getAssets(), tabBottomInfo.iconFont);
                tabIconView.setTypeface(typeface);
                if (!TextUtils.isEmpty(tabBottomInfo.name)) {
                    tabNameView.setText(tabBottomInfo.name);
                }
            }
            if (selected) {
                tabIconView.setText(TextUtils.isEmpty(tabBottomInfo.selectedIconName) ? tabBottomInfo.detaultIconName : tabBottomInfo.selectedIconName);
                tabIconView.setTextColor(getTextColor(tabBottomInfo.tintColor));
                tabNameView.setTextColor(getTextColor(tabBottomInfo.tintColor));
            } else {
                tabIconView.setText(tabBottomInfo.detaultIconName);
                tabIconView.setTextColor(getTextColor(tabBottomInfo.defaultColor));
                tabNameView.setTextColor(getTextColor(tabBottomInfo.defaultColor));
            }
        } else if (tabBottomInfo.tabType == HiTabBottomInfo.TabType.BITMAP) {
            if (init) {
                tabImageView.setVisibility(VISIBLE);
                tabIconView.setVisibility(GONE);
                if (!TextUtils.isEmpty(tabBottomInfo.name)) {
                    tabNameView.setText(tabBottomInfo.name);
                }
            }
            if (selected) {
                tabImageView.setImageBitmap(tabBottomInfo.selectedBitmap);
                tabNameView.setTextColor(getTextColor(tabBottomInfo.tintColor));
            } else {
                tabImageView.setImageBitmap(tabBottomInfo.defaultBitmap);
                tabNameView.setTextColor(getTextColor(tabBottomInfo.defaultColor));
            }
        }

    }


    @Override
    public void onTabSelectedChange(int index,  HiTabBottomInfo<?> preInfo,  HiTabBottomInfo<?> nextInfo) {
        Log.i("TAG", "onTabSelectedChange: index = " + index + " , preInfo = " + preInfo + " nextInfo = " + nextInfo);

        if (preInfo != tabBottomInfo && nextInfo != tabBottomInfo || preInfo == nextInfo) {
            return;
        }
        if (preInfo == tabBottomInfo) {
            inflateInfo(false, false);
        } else {
            inflateInfo(true, false);
        }
    }

    @ColorInt
    private int getTextColor(Object color) {
        if (color instanceof String) {
            return Color.parseColor((String) color);
        } else {
            return (int) color;
        }
    }
}
