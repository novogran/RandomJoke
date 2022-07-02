package com.example.randomjoke

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: BaseViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = (application as JokeApp).baseViewModel
        val button = findViewById<Button>(R.id.actionButton)
        val progressBar = findViewById<View>(R.id.progressBar)
        val textView = findViewById<TextView>(R.id.textView)
        val checkBox = findViewById<CheckBox>(R.id.checkBox)
        val changeButton = findViewById<ImageButton>(R.id.changeButton)

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
            state.show(
                object :ShowView{
                    override fun show(show: Boolean) {
                        progressBar.visibility = if(show) View.VISIBLE else View.INVISIBLE
                    }

                },
                object : EnableView {
                    override fun enable(enable: Boolean) {
                        button.isEnabled = enable
                    }
                },
                object : ShowText {
                    override fun show(text: String) {
                        textView.text = text
                    }

                },
                object : ShowImage {
                    override fun show(id: Int) {
                        changeButton.setImageResource(id)
                    }

                })
        }
    }
}