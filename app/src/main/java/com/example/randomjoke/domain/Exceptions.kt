package com.example.randomjoke.domain

import io.realm.internal.IOException

class NoConnectionException: IOException()
class ServiceUnavailableException: IOException()
class NoCachedJokesException: IOException()