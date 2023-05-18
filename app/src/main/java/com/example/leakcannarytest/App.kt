package com.example.leakcannarytest

import android.app.Application
import android.view.View


class App : Application() {

    override fun onCreate() {
        super.onCreate()
    }

    private val listViews = mutableListOf<View>()
    fun addTextView(view: View) {
        listViews.add(view)
    }

}