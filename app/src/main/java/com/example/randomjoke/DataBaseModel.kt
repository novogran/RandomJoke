package com.example.randomjoke

import com.example.randomjoke.core.Mapper
import com.example.randomjoke.data.CommonDataModel
import io.realm.RealmObject

abstract class DataBaseModel: RealmObject(), Mapper<CommonDataModel>