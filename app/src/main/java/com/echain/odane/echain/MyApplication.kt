package com.echain.odane.echain

import android.app.Application
import io.realm.Realm

/**
 * Created by ksteere on 2/28/2018.
 */

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        // Initialize Realm. Should only be done once when the application starts.
        Realm.init(this)
    }
}