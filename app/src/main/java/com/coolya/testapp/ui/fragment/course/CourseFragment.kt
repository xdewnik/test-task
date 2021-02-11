package com.coolya.testapp.ui.fragment.course

import android.os.Bundle
import android.view.View
import com.coolya.testapp.R
import com.coolya.testapp.core.fragment.BaseFragment
import kotlinx.android.synthetic.main.fragment_course.*

abstract class CourseFragment: BaseFragment() {

    override fun layout(): Int = R.layout.fragment_course

    private val inputAdapter =
        CombinedRecycler()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recycler_course.adapter = inputAdapter
        initData(inputAdapter)
    }

    abstract fun initData(inputAdapter: CombinedRecycler)
}
