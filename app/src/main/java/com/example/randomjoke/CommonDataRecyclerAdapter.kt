package com.example.randomjoke

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.randomjoke.presentation.CommonUiModel
import com.example.randomjoke.presentation.CorrectTextView

class CommonDataRecyclerAdapter<E>:
    RecyclerView.Adapter<CommonDataRecyclerAdapter<E>.CommonDataViewHolder<E>>(){

    inner class CommonDataViewHolder<E>(view: View): RecyclerView.ViewHolder(view){
        private val textView = itemView.findViewById<CorrectTextView>(R.id.commonDataTextView)
        fun bind(model: CommonUiModel) = model.show(textView)
    }

    private val list = ArrayList<CommonUiModel>()

    fun show(data:List<CommonUiModel>){
        list.clear()
        list.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommonDataViewHolder<E> {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.common_data_item,parent,false)
        return CommonDataViewHolder(view)
    }

    override fun onBindViewHolder(holder: CommonDataViewHolder<E>, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size
}