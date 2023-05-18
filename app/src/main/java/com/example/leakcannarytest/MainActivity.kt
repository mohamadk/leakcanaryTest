package com.example.leakcannarytest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlin.jvm.internal.Intrinsics

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val app = this.application as App

        findViewById<View>(R.id.button).setOnClickListener {
            app.addTextView(findViewById(R.id.textView))
        }

        findViewById<View>(R.id.second).setOnClickListener {
            startActivity(Intent(this@MainActivity, SecondActivity::class.java))
        }

        val x = Intrinsics.areEqual(1,1)
        println(Intrinsics::class)


    }
}