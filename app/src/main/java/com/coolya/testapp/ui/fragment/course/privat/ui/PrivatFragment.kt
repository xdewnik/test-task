package com.coolya.testapp.ui.fragment.course.privat.ui

import androidx.lifecycle.Observer
import com.coolya.testapp.core.ext.gone
import com.coolya.testapp.core.ext.toast
import com.coolya.testapp.core.ext.visible
import com.coolya.testapp.core.response.Result
import com.coolya.testapp.ui.fragment.course.CombinedRecycler
import com.coolya.testapp.ui.fragment.course.CourseFragment
import com.coolya.testapp.ui.fragment.course.privat.vm.PrivatViewModel
import kotlinx.android.synthetic.main.fragment_course.*
import org.koin.android.viewmodel.ext.android.viewModel


class PrivatFragment: CourseFragment() {


    private val viewModel by viewModel<PrivatViewModel>()


    override fun initData(inputAdapter: CombinedRecycler) {
        viewModel.privatCourse.observe(viewLifecycleOwner, Observer {
            progress_bar.gone()
            when(it){
                is Result.Loading -> progress_bar.visible()
                is Result.Success -> inputAdapter.submitList(it.data)
                is Result.Failure -> context?.toast(it.throwable.message?:"Error")
            }

        })
    }
}