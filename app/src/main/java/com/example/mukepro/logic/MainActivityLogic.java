package com.example.mukepro.logic;

/**
 * 项目名称 mukePro
 * 创建人 xiaojinli
 * 创建时间 2024/1/7 18:40
 **/

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.FragmentManager;

import com.example.library_common.tab.HiFragmentTabView;
import com.example.library_common.tab.HiTabViewAdapter;
import com.example.library_ui.tab.bottom.HiTabBottomInfo;
import com.example.library_ui.tab.bottom.HiTabBottomLayout;
import com.example.library_ui.tab.common.IHiTabLayout;
import com.example.mukepro.R;
import com.example.mukepro.fragment.category.CategoryFragment;
import com.example.mukepro.fragment.favorite.FavoriteFragment;
import com.example.mukepro.fragment.home.HomePageFragment;
import com.example.mukepro.fragment.profile.ProfileFragment;
import com.example.mukepro.fragment.recommend.RecommendFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * 将MainActivity的一些逻辑内聚在这，让MainActivity更加清爽
 */
public class MainActivityLogic {
    private HiFragmentTabView fragmentTabView;
    private HiTabBottomLayout hiTabBottomLayout;
    private List<HiTabBottomInfo<?>> infoList;
    private ActivityProvider activityProvider;
    private final static String SAVED_CURRENT_ID = "SAVED_CURRENT_ID";
    private int currentItemIndex;

    public MainActivityLogic(ActivityProvider activityProvider, @Nullable Bundle savedInstanceState) {
        this.activityProvider = activityProvider;
        //fix 不保留活动导致的Fragment重叠问题
        if (savedInstanceState != null) {
            currentItemIndex = savedInstanceState.getInt(SAVED_CURRENT_ID);
        }
        initTabBottom();
    }

    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt(SAVED_CURRENT_ID, currentItemIndex);
    }

    public HiFragmentTabView getFragmentTabView() {
        return fragmentTabView;
    }

    public List<HiTabBottomInfo<?>> getInfoList() {
        return infoList;
    }

    public HiTabBottomLayout getHiTabBottomLayout() {
        return hiTabBottomLayout;
    }

    private void initTabBottom() {
        hiTabBottomLayout = activityProvider.findViewById(R.id.tab_bottom_layout);
        hiTabBottomLayout.setTabAlpha(0.85f);
        infoList = new ArrayList<>();
        String defaultColor = "#ff656667";
        String tintColor = "#ffd44949";
        HiTabBottomInfo homeInfo = new HiTabBottomInfo<Integer>(
                "首页",
                "fonts/iconfont.ttf",
                activityProvider.getString(R.string.if_home),
                null,
                defaultColor,
                tintColor,
                HiTabBottomInfo.TabType.ICON
        );
        homeInfo.fragment = HomePageFragment.class;
        HiTabBottomInfo infoFavorite = new HiTabBottomInfo<Integer>(
                "收藏",
                "fonts/iconfont.ttf",
                activityProvider.getString(R.string.if_favorite),
                null,
                defaultColor,
                tintColor,
                HiTabBottomInfo.TabType.ICON
        );
        infoFavorite.fragment = FavoriteFragment.class;
        HiTabBottomInfo infoCategory = new HiTabBottomInfo<Integer>(
                "分类",
                "fonts/iconfont.ttf",
                activityProvider.getString(R.string.if_category),
                null,
                defaultColor,
                tintColor,
                HiTabBottomInfo.TabType.ICON
        );
        infoCategory.fragment = CategoryFragment.class;
        HiTabBottomInfo infoRecommend = new HiTabBottomInfo<Integer>(
                "推荐",
                "fonts/iconfont.ttf",
                activityProvider.getString(R.string.if_recommend),
                null,
                defaultColor,
                tintColor,
                HiTabBottomInfo.TabType.ICON
        );
        infoRecommend.fragment = RecommendFragment.class;
        HiTabBottomInfo infoProfile = new HiTabBottomInfo<Integer>(
                "我的",
                "fonts/iconfont.ttf",
                activityProvider.getString(R.string.if_profile),
                null,
                defaultColor,
                tintColor,
                HiTabBottomInfo.TabType.ICON
        );
        infoProfile.fragment = ProfileFragment.class;
        infoList.add(homeInfo);
        infoList.add(infoFavorite);
        infoList.add(infoCategory);
        infoList.add(infoRecommend);
        infoList.add(infoProfile);
        hiTabBottomLayout.inflateInfo(infoList);
        initFragmentTabView();
        hiTabBottomLayout.addTabSelectedChangeLisntener(new IHiTabLayout.OnTabSelectedListener<HiTabBottomInfo<?>>() {
            @Override
            public void onTabSelectedChange(int index, @Nullable HiTabBottomInfo<?> prevInfo, @NonNull HiTabBottomInfo<?> nextInfo) {
                fragmentTabView.setCurrentItem(index);
                MainActivityLogic.this.currentItemIndex = index;
            }
        });
        hiTabBottomLayout.defaultSelected(infoList.get(currentItemIndex));
    }

    private void initFragmentTabView() {
        HiTabViewAdapter tabViewAdapter = new HiTabViewAdapter(activityProvider.getSupportFragmentManager(), infoList);
        fragmentTabView = activityProvider.findViewById(R.id.fragment_tab_view);
        fragmentTabView.setAdapter(tabViewAdapter);
    }

    public interface ActivityProvider {
        <T extends View> T findViewById(@IdRes int id);

        Resources getResources();

        FragmentManager getSupportFragmentManager();

        String getString(@StringRes int resId);
    }

}

