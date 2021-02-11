package com.coolya.testapp.ui.main.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.coolya.testapp.R
import com.coolya.testapp.core.ext.gone
import com.coolya.testapp.core.ext.toast
import com.coolya.testapp.core.ext.visible
import com.coolya.testapp.core.response.Result
import com.coolya.testapp.ui.fragment.course.CombinedRecycler
import com.coolya.testapp.ui.main.adapter.MainActivityCourseAdapter
import com.coolya.testapp.ui.main.vm.MainActivityViewModel
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {

    private val viewModel by viewModel<MainActivityViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.isViewPager.observe(this, Observer {
            if (it) {
                initViewpager()
            } else {
                initCombinedRecycler()
            }
        })

    }

    private fun initViewpager() {
        if (view_pager.adapter == null) {
            viewModel.combinedCourse.removeObservers(this)
            recycler_combined.adapter = null
            recycler_combined.gone()
            progress.gone()
            view_pager.adapter = MainActivityCourseAdapter(this)

            TabLayoutMediator(tab_layout, view_pager) { tab, position ->
                when (position) {
                    0 -> tab.text = getString(R.string.privat)
                    1 -> tab.text = getString(R.string.crypto)
                }
            }.attach()
            view_pager.visible()
            tab_layout.visible()
        }
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        R.id.action_change_type -> {
            viewModel.toggleMode()
            true
        }
        else -> super.onOptionsItemSelected(item)
    }

    private fun initCombinedRecycler() {
        if (recycler_combined.adapter == null) {
            view_pager.adapter = null
            view_pager.gone()
            tab_layout.gone()
            val inputAdapter =
                CombinedRecycler()
            viewModel.combinedCourse.observe(this, Observer {
                progress.gone()
                when (it) {
                    is Result.Success -> inputAdapter.submitList(it.data)
                    is Result.Failure -> this.toast(it.throwable.message?:"Error")
                    is Result.Loading -> progress.visible()
                }
            })
            recycler_combined.visible()
            recycler_combined.adapter = inputAdapter
        }
    }
}