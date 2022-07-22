package com.example.randomjoke

class MainModule(private val persistentDataSource: PersistentDataSource) : Module<MainViewModel> {
    override fun getViewModel() = MainViewModel(
        ScreenPosition.Base(persistentDataSource),
        NavigationCommunication.Base()
    )

}