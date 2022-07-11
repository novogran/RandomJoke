package com.example.randomjoke.presentation

import androidx.annotation.DrawableRes

sealed class State {
    protected abstract  val type: Int
    companion object{
        const val INITIAL = 0
        const val PROGRESS = 1
        const val FAILED = 2
    }

    fun isType(type: Int): Boolean = this.type == type

    fun show(
        process: ShowView,
        button: EnableView,
        textView: ShowText,
        imageButton: ShowImage
    ){
        show(process,button)
        show(textView,imageButton)
    }

    protected open fun show(progress: ShowView, button: EnableView){}
    protected open fun show(textView: ShowText, imageButton: ShowImage){}

    object Progress: State() {
        override val type: Int = PROGRESS

        override fun show(progress: ShowView, button: EnableView) {
            progress.show(true)
            button.enable(false)
        }
    }

    abstract class Info(private val text: String, @DrawableRes private val id: Int): State(){
        override fun show(progress: ShowView, button: EnableView) {
            progress.show(false)
            button.enable(true)
        }
        override fun show(textView: ShowText, imageButton: ShowImage) {
            textView.show(text)
            imageButton.show(id)
        }
    }

    class Initial(text:String, @DrawableRes private val id: Int): Info(text, id) {
        override val type = INITIAL
    }

    class Failed(text: String, @DrawableRes private val id: Int): Info(text, id){
        override val type = FAILED
    }
}