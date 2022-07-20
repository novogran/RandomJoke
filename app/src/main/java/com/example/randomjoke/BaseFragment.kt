package com.example.randomjoke

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.randomjoke.presentation.BaseViewModel
import com.example.randomjoke.presentation.FavoriteDataView
import com.example.randomjoke.presentation.JokeApp
import com.google.android.material.snackbar.Snackbar

abstract class BaseFragment<V: BaseViewModel<T>,T>: Fragment() {

    private lateinit var viewModel: BaseViewModel<T>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(
            this,
            (requireActivity().application as JokeApp).viewModelsFactory
        ).get(getViewModelClass())
    }

    protected abstract fun getViewModelClass(): Class<V>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment,container,false)
    }

    @StringRes
    protected abstract fun checkBoxText():Int

    @StringRes
    protected abstract fun actionButtonText(): Int

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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
        }, viewModel.communication)
        recycleView.adapter = adapter
        viewModel.observeList(this) { adapter.update() }
        viewModel.getItemList()
    }
}