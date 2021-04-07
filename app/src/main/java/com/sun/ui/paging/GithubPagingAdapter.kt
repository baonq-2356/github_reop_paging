package com.sun.ui.paging

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.sun.data.model.Post
import com.sun.ui.base.BaseViewHolder

class GithubPagingAdapter(
    @LayoutRes private val layoutId: Int,
    private val bind: (holder: BaseViewHolder<ViewDataBinding>, item: Post?, position: Int) -> Unit,
    diffCallback: DiffUtil.ItemCallback<Post>
) : PagingDataAdapter<Post, BaseViewHolder<ViewDataBinding>>(diffCallback) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<ViewDataBinding> {
        val binding = DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context),
            layoutId,
            parent,
            false
        )
        return BaseViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<ViewDataBinding>, position: Int) {
        // Note that item may be null. ViewHolder must support binding a
        // null item as a placeholder.
        val item = getItem(position)
        bind(holder, item, position)
        holder.binding.executePendingBindings()
    }
}

object PostComparator: DiffUtil.ItemCallback<Post>() {
    override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean {
        // Id is unique.
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean {
        return oldItem == newItem
    }
}
