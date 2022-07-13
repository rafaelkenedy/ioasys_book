package com.rafael.ioasys_book.activity

import android.app.Application
import com.rafael.ioasys_book.di.dataLocalModule
import com.rafael.ioasys_book.di.presentationModule
import com.rafael.ioasys_book.di.dataModule
import com.rafael.ioasys_book.di.dataRemoteModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(
                presentationModule,
                dataModule,
                dataRemoteModule,
                dataLocalModule
            ).androidContext(applicationContext)
        }
    }
}