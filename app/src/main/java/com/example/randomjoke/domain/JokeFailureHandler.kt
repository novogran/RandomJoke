package com.example.randomjoke.domain

interface JokeFailureHandler {
    fun handle(e: Exception): JokeFailure
}