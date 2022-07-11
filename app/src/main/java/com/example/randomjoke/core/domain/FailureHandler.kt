package com.example.randomjoke.core.domain

import com.example.randomjoke.core.presentation.Failure

interface FailureHandler {
    fun handle(e: Exception): Failure
}