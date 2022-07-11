package com.example.randomjoke.domain

interface FailureHandler {
    fun handle(e: Exception): Failure
}