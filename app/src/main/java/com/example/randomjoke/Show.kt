package com.example.randomjoke

interface Show<T>{
    fun show(arg:T)
}

interface ShowView: Show<Boolean>

interface ShowImage: Show<Int>

interface ShowText: Show<String>

interface EnableView{
    fun enable(enable:Boolean)
}