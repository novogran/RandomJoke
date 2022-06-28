package com.example.randomjoke

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {

    private lateinit var baseViewModel: BaseViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        baseViewModel = (application as JokeApp).baseViewModel
        val button = findViewById<Button>(R.id.actionButton)
        val progressBar = findViewById<View>(R.id.progressBar)
        val textView = findViewById<TextView>(R.id.textView)
        val checkBox = findViewById<CheckBox>(R.id.checkBox)
        val changeButton = findViewById<ImageButton>(R.id.changeButton)

        changeButton.setOnClickListener {
            baseViewModel.changeJokeStatus()
        }

        checkBox.setOnCheckedChangeListener { _, isChecked ->
            baseViewModel.chooseFavorites(isChecked)
        }

        progressBar.visibility = View.INVISIBLE

        button.setOnClickListener{
            button.isEnabled = false
            progressBar.visibility = View.VISIBLE
            baseViewModel.getJoke()
        }

        baseViewModel.observe(this) { (text, drawableResId) ->
            button.isEnabled = true
            progressBar.visibility = View.INVISIBLE
            textView.text = text
            changeButton.setImageResource(drawableResId)
        }
    }
}