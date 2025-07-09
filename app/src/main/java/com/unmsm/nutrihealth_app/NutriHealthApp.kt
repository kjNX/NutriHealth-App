package com.unmsm.nutrihealth_app

import android.app.Application
import com.unmsm.nutrihealth_app.data.AppContainer
import com.unmsm.nutrihealth_app.data.DefaultAppContainer

class NutriHealthApp : Application() {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}