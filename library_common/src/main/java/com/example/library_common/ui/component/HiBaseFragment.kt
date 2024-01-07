package com.example.library_common.ui.component

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * Author ： lxj
 * Time ： 2024/1/7 17:45
 * Describe：
 **/
abstract class HiBaseFragment : Fragment() {
    protected lateinit var layoutView: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        layoutView = inflater.inflate(getLayoutId(), container, false)
        return layoutView
    }


    /**
     * Author ： lxj
     * Time ： 2024/1/7 17:49
     * Describe： 判断宿主是否还存活
     **/
    fun isAlive(): Boolean {
        return !(isRemoving || isDetached || activity == null)
    }


    @LayoutRes
    abstract fun getLayoutId(): Int
}