package com.coolya.testapp.ui.fragment.course

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.coolya.testapp.R
import com.coolya.testapp.data.dto.CourseItem
import com.coolya.testapp.data.dto.CryptoCourse
import com.coolya.testapp.data.dto.Header
import com.coolya.testapp.data.dto.PrivatCourse
import kotlinx.android.synthetic.main.item_course.view.*
import kotlinx.android.synthetic.main.item_header.view.*

class CombinedRecycler : ListAdapter<CourseItem, RecyclerView.ViewHolder>(ASYNC) {
    private val HEADER = 0
    private val PRIVAT = 1
    private val CRYPTO = 2

    private companion object ASYNC : DiffUtil.ItemCallback<CourseItem>() {
        override fun areItemsTheSame(oldItem: CourseItem, newItem: CourseItem): Boolean =
            (oldItem is Header && newItem is Header) || (oldItem is PrivatCourse && newItem is PrivatCourse) || (oldItem is CryptoCourse && newItem is CryptoCourse)


        override fun areContentsTheSame(oldItem: CourseItem, newItem: CourseItem): Boolean =
            if (oldItem is Header && newItem is Header) {
                oldItem.title == newItem.title
            } else if (oldItem is PrivatCourse && newItem is PrivatCourse) {
                oldItem.ccy == newItem.ccy || oldItem.buy == newItem.buy
            } else if (oldItem is CryptoCourse && newItem is CryptoCourse) {
                oldItem.id == newItem.id || oldItem.priceUsd == newItem.priceUsd
            } else {
                false
            }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        LayoutInflater.from(parent.context).run {
            when (viewType) {
                HEADER -> inflate(
                    R.layout.item_header,
                    parent,
                    false
                ).run {
                    HeaderViewHolder(
                        this
                    )
                }
                else -> inflate(R.layout.item_course, parent, false)
                    .run {
                        if(viewType == PRIVAT) {
                            PrivatCourseViewHolder(
                                this
                            )
                        }else{
                            CryptoCourseViewHolder(
                                this
                            )
                        }
                    }
            }
        }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) =
        when (getItemViewType(position)) {
            HEADER -> (holder as HeaderViewHolder).bind(getItem(position) as Header)
            PRIVAT -> (holder as PrivatCourseViewHolder).bind(getItem(position) as PrivatCourse)
            else -> (holder as CryptoCourseViewHolder).bind(getItem(position) as CryptoCourse)
        }

    override fun getItemViewType(position: Int): Int = when (getItem(position)) {
        is Header -> HEADER
        is PrivatCourse -> PRIVAT
        else -> CRYPTO
    }

}

class HeaderViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    fun bind(item: Header) = with(view) {
        header.text = item.title
    }
}

class PrivatCourseViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    fun bind(item: PrivatCourse) = with(view) {
        course_text.text = "${item.base_ccy}-${item.ccy} = ${item.buy}/${item.sale}"
    }
}
class CryptoCourseViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    fun bind(item: CryptoCourse) = with(view) {
        course_text.text = "#${item.rank} ${item.name}  = ${item.priceUsd}"
    }
}