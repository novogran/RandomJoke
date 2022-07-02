package com.example.randomjoke

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView

class CorrectTextView: AppCompatTextView,ShowText {
    constructor(context: Context): super(context)
    constructor(context: Context,attrs : AttributeSet) : super(context, attrs)
    constructor(context: Context,attrs : AttributeSet, defStyleAttr:Int) : super(
        context,
        attrs,
        defStyleAttr
    )
    override fun show(text: String) {
        setText(text)
    }
}