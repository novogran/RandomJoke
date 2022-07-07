package com.example.randomjoke.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.randomjoke.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = (application as JokeApp).viewModel
        val progressBar = findViewById<CorrectProgress>(R.id.progressBar)
        val favoriteDataView = findViewById<FavoriteDataView>(R.id.jokeFavoriteDataView)

        favoriteDataView.listenChanges { isChecked ->
            viewModel.chooseFavorites(isChecked)
        }
        favoriteDataView.handleChangeButton {
            viewModel.changeJokeStatus()
        }
        favoriteDataView.handleActionButton {
            viewModel.getJoke()
        }

        viewModel.observe(this) { state ->
           favoriteDataView.show(state)
        }


        progressBar.visibility = View.INVISIBLE

    }
}