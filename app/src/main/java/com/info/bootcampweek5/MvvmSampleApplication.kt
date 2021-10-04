package com.info.bootcampweek5

import android.app.Application
import com.info.bootcampweek5.network.ServiceConnector

class MvvmSampleApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        ServiceConnector.init() // ServiceConnectorun kendini init edip istek geliş gidişlerini ayarlayabilmesi için
    }
}