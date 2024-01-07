package com.example.log_library.log;

import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

/**
 * 项目名称 mukeDemo
 * 创建人 xiaojinli
 * 创建时间 2023/12/23 22:32
 **/
public class HiViewPrinterProvider {
    private FrameLayout rootView;
    private View floatingView;
    private boolean isOpen;
    private FrameLayout logView;
    private RecyclerView recyclerView;

    public HiViewPrinterProvider(FrameLayout rootView, RecyclerView recyclerView) {
        this.rootView = rootView;
        this.recyclerView = recyclerView;
    }

    private static final String TAG_FLOATING_VIEW = "TAG_FLOATING_VIEW";
    private static final String TAG_LOG_VIEW = "TAG_LOG_VIEW";

    public void showFloatingView() {
        if (rootView.findViewWithTag(TAG_FLOATING_VIEW) != null) {
            return;
        }
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);

        params.gravity = Gravity.BOTTOM | Gravity.END;
        View floatingView = genFloatingView();

        floatingView.setTag(TAG_FLOATING_VIEW);
        floatingView.setBackgroundColor(Color.BLACK);
        floatingView.setAlpha(0.8f);
        params.bottomMargin = HiDislayUtil.dp2px(100, recyclerView.getResources());

        rootView.addView(genFloatingView(), params);
    }

    public void closefloatingView() {
        rootView.removeView(genFloatingView());
    }


    private View genFloatingView() {
        if (floatingView != null) {
            return floatingView;
        }

        TextView textView = new TextView(rootView.getContext());
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isOpen) {
                    showLogView();
                }
            }
        });
        textView.setText("HiLog");
        textView.setTextColor(Color.WHITE);
        return floatingView = textView;
    }

    private void showLogView() {
        if ((rootView.findViewWithTag(TAG_LOG_VIEW) != null)) {
            return;
        }
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                HiDislayUtil.dp2px(160, rootView.getResources()));//

        params.gravity = Gravity.BOTTOM;
        View logView = genLogView();
        logView.setTag(TAG_LOG_VIEW);
        rootView.addView(logView,params);
        isOpen = true;
    }

    private View genLogView() {
        if (logView != null) {
            return logView;
        }
        FrameLayout logView = new FrameLayout(rootView.getContext());
        logView.setBackgroundColor(Color.BLACK);
        logView.addView(recyclerView);

        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        params.gravity = Gravity.END;

        TextView closeView = new TextView(logView.getContext());
        FrameLayout.LayoutParams closeParams = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        closeParams.gravity = Gravity.TOP | Gravity.LEFT;

        closeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("TAG", "onClick: closeLogView");
                closeLogiew();
            }
        });
        closeView.setText("Clsoe");
        logView.addView(closeView,closeParams);
        return this.logView = logView;
    }

    public void closeLogiew() {
        isOpen = false;
        rootView.removeView(genLogView());
    }
}
