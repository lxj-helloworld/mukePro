package com.example.library_common.tab

import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.library_ui.tab.bottom.HiTabBottomInfo

/**
 * 项目名称 mukePro
 * 创建人 xiaojinli
 * 创建时间 2024/1/7 17:54
 *
 **/
class HiTabViewAdapter(fragmentManager: FragmentManager, infoList: List<HiTabBottomInfo<*>>) {
    private var mInfoList: List<HiTabBottomInfo<*>> = infoList
    private var mCurFragment: Fragment? = null
    private var mFragmentManager: FragmentManager = fragmentManager


    fun instantiateItem(container: View, position: Int) {
        val mCurTransaction = mFragmentManager.beginTransaction()
        if (mCurFragment != null) {
            mCurTransaction.hide(mCurFragment!!)
        }
        val name = container.id.toString() + ":" + position
        var fragment = mFragmentManager.findFragmentByTag(name)
        if (fragment != null) {
            mCurTransaction.show(fragment)
        } else {
            fragment = getItem(position)
            if (!fragment!!.isAdded) {
                mCurTransaction.add(container.id, fragment, name)
            }
        }
        mCurFragment = fragment
        mCurTransaction.commitNowAllowingStateLoss()
    }

    fun getCurrentFragment(): Fragment? {
        return mCurFragment
    }

    fun getItem(position: Int): Fragment? {
        try {
            return mInfoList[position].fragment.newInstance() as Fragment
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null
    }

    fun getCount(): Int {
        return mInfoList.size
    }
}