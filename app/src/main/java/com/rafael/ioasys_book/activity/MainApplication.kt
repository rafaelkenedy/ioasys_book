package com.rafael.ioasys_book.activity

import android.app.Application
import com.rafael.ioasys_book.di.PresentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(PresentationModule).androidContext(applicationContext)
        }
    }
}