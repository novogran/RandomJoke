package com.example.randomjoke.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.randomjoke.JokesFragment
import com.example.randomjoke.QuoteFragment
import com.example.randomjoke.R
import com.example.randomjoke.TabListener
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        val tabChosen: (Boolean) -> Unit = { jokeChosen ->
            if (jokeChosen)
                show(JokesFragment())
            else
                show(QuoteFragment())
        }
        tabLayout.addOnTabSelectedListener(TabListener(tabChosen))
        show(JokesFragment())
    }

    private fun show(fragment: Fragment){
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .commit()
    }
}