package com.example.randomjoke.core.domain

import io.realm.internal.IOException

class NoConnectionException: IOException()
class ServiceUnavailableException: IOException()
class NoCachedDataException: IOException()