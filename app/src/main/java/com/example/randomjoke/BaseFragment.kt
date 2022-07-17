package com.example.randomjoke

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.randomjoke.presentation.BaseCommunication
import com.example.randomjoke.presentation.BaseViewModel
import com.example.randomjoke.presentation.FavoriteDataView
import com.example.randomjoke.presentation.JokeApp
import com.google.android.material.snackbar.Snackbar

abstract class BaseFragment<T>: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment,container,false)
    }

    protected abstract fun getViewModel(app: JokeApp): BaseViewModel<T>
    protected abstract fun getCommunication(app: JokeApp): BaseCommunication<T>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val application = requireActivity().application as JokeApp
        val viewModel = getViewModel(application)
        val communication = getCommunication(application)

        val favoriteDataView = view.findViewById<FavoriteDataView>(R.id.favoriteDataView)
        favoriteDataView.checkBoxText(checkBoxText())
        favoriteDataView.actionButtonText(actionButtonText())
        favoriteDataView.linkWith(viewModel)
        viewModel.observe(this) { state ->
            favoriteDataView.show(state)
        }

        val recycleView = view.findViewById<RecyclerView>(R.id.recycleView)
        val adapter= CommonDataRecyclerAdapter(object :
            CommonDataRecyclerAdapter.FavoriteItemClickListener<T>{
            override fun change(id: T) {
                Snackbar.make(
                    favoriteDataView,
                    R.string.remove_from_favorites,
                    Snackbar.LENGTH_SHORT
                ).setAction(R.string.yes){
                    viewModel.changeItemStatus(id)
                }.show()
            }
        }, communication)
        recycleView.adapter = adapter
        viewModel.observeList(this) { adapter.update() }
        viewModel.getItemList()
    }

    @StringRes
    protected abstract fun checkBoxText() : Int

    @StringRes
    protected abstract fun actionButtonText() : Int
}