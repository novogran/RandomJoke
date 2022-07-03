package com.example.randomjoke.presentation

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatButton
import com.example.randomjoke.presentation.EnableView

class CorrectButton:AppCompatButton, EnableView {
    constructor(context: Context):super(context)
    constructor(context: Context, attrs: AttributeSet?):super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int):super(
        context,
        attrs,
        defStyleAttr
            )
    override fun enable(enable: Boolean) {
        isEnabled = enable
    }
}