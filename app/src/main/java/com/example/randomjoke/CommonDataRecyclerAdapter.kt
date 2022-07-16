package com.example.randomjoke

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.randomjoke.core.presentation.CommonCommunication
import com.example.randomjoke.presentation.CommonUiModel
import com.example.randomjoke.presentation.CorrectImageButton
import com.example.randomjoke.presentation.CorrectTextView
import com.example.randomjoke.presentation.FailedCommonUiModel

class CommonDataRecyclerAdapter<T>(
    private val listener: FavoriteItemClickListener<T>,
    private val communication: CommonCommunication<T>
    ):
    RecyclerView.Adapter<CommonDataRecyclerAdapter.CommonDataViewHolder<T>>(){

    override fun getItemViewType(position: Int) = when(communication.getList()[position]){
        is FailedCommonUiModel -> 0
        else -> 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommonDataViewHolder<T> {
        val emptyList = viewType == 0
        val view = LayoutInflater.from(parent.context).inflate(
            if(emptyList)
                R.layout.no_favorite_item
            else
                R.layout.common_data_item,
            parent,false
        )
        return if(emptyList) EmptyFavoritesViewHolder(view) else CommonDataViewHolder.Base(view,listener)
    }

    override fun onBindViewHolder(holder: CommonDataViewHolder<T>, position: Int) {
        holder.bind(communication.getList()[position])
    }

    override fun getItemCount() = communication.getList().size

    fun update(){
        notifyDataSetChanged()
    }

    fun update(pair:Pair<Boolean,Int>){
        if(pair.first){
            notifyItemInserted(pair.second)
        } else {
            notifyItemRemoved(pair.second)
        }
    }

    abstract class CommonDataViewHolder<T>(view: View): RecyclerView.ViewHolder(view){
        private val textView = itemView.findViewById<CorrectTextView>(R.id.commonDataTextView)

        open fun bind(model: CommonUiModel<T>) = model.show(textView)

        class Base<T>(view:View,private val listener: FavoriteItemClickListener<T>) : CommonDataViewHolder<T>(view){
            private val iconView = itemView.findViewById<CorrectImageButton>(R.id.changeButton)
            override fun bind(model: CommonUiModel<T>) {
                super.bind(model)
                iconView.setOnClickListener {
                    model.change(listener)
                }
            }
        }
    }

    inner class EmptyFavoritesViewHolder<T>(view:View):CommonDataViewHolder<T>(view)

    interface FavoriteItemClickListener<T> {
        fun change(id:T)
    }
}

