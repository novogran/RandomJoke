package com.example.randomjoke.presentation

import android.app.ProgressDialog.show
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.randomjoke.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = (application as JokeApp).viewModel
        val button = findViewById<CorrectButton>(R.id.actionButton)
        val progressBar = findViewById<CorrectProgress>(R.id.progressBar)
        val textView = findViewById<CorrectTextView>(R.id.textView)
        val checkBox = findViewById<CheckBox>(R.id.checkBox)
        val changeButton = findViewById<CorrectImageButton>(R.id.changeButton)
        val favoriteDataView = findViewById<FavoriteDataView>(R.id.favoriteDataView)

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

        changeButton.setOnClickListener {
            viewModel.changeJokeStatus()
        }

        checkBox.setOnCheckedChangeListener { _, isChecked ->
            viewModel.chooseFavorites(isChecked)
        }

        progressBar.visibility = View.INVISIBLE

        button.setOnClickListener {
            viewModel.getJoke()
        }

        viewModel.observe(this) { state ->
            state.show(progressBar, button, textView, changeButton)
        }


    }
}