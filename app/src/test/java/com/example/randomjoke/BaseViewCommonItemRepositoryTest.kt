package com.example.randomjoke

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.randomjoke.data.CommonDataModel
import com.example.randomjoke.domain.CommonRepository
import com.example.randomjoke.presentation.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Test

class BaseViewCommonItemRepositoryTest{

    @ExperimentalCoroutinesApi
    @Test
    fun test_get_joke_from_cloud_success(): Unit = runBlocking {
        val model = TestCommonRepository()
        val communication = TestCommunication()
        val viewModel = BaseViewModel(,communication,TestCoroutineDispatcher())

        model.success = true
        viewModel.chooseFavorites(false)
        viewModel.getJoke()

        val actualText = communication.text
        val actualId = communication.id
        val expectedText = "cloudJokeText\ncloudJokePunchline"
        assertEquals(expectedText,actualText)
        assertNotEquals(0,actualId)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun test_get_joke_from_cloud_fail(): Unit = runBlocking {
        val model = TestCommonRepository()
        val communication = TestCommunication()
        val viewModel = BaseViewModel(model,communication, TestCoroutineDispatcher())

        model.success = false
        viewModel.chooseFavorites(false)
        viewModel.getJoke()

        val actualText = communication.text
        val actualId = communication.id
        val expectedText = "no connection"
        val expectedId = 0
        assertEquals(expectedText,actualText)
        assertEquals(expectedId,actualId)
    }

    private inner class TestCommonRepository : CommonRepository {

        private val cacheJokeUiModel = BaseCommonUiModel("cachedJokeText", "cachedJokePunchline")
        private val cachedJokeFailure = FailedCommonUiModel("cacheFailed")
        private val cloudJokeUiModel = BaseCommonUiModel("cloudJokeText", "cloudJokePunchline")
        private val cloudJokeFailure = FailedCommonUiModel("no connection")
        var success: Boolean = false
        private var getFromCache = false
        private var cachedJoke: CommonDataModel? = null

        override suspend fun getCommonItem(): CommonDataModel? {
            return if(success) {
                if (getFromCache){
                    cacheJokeUiModel.also {
                        cachedJoke = it
                    }
                } else {
                    cloudJokeUiModel.also {
                        cachedJoke = it
                    }
                }
            } else{
                cachedJoke = null
                if (getFromCache){
                    cachedJokeFailure
                } else {
                    cloudJokeFailure
                }
            }
        }

        override suspend fun changeStatus(): CommonDataModel

        override fun chooseDataSource(cached: Boolean) {
            getFromCache = cached
        }

    }

    private inner class TestCommunication : Communication {
        var text = ""
        var id = -1
        var observerCount = 0
        override fun showState(state: State) {
        }

        override fun observe(owner: LifecycleOwner, observer: Observer<State>) {
            observerCount++
        }

    }
}