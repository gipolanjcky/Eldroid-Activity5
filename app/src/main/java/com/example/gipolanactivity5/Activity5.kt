package com.example.gipolanactivity5

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity


class Activity5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_5)
        findViewById<View>(R.id.btnNavigate).setOnClickListener {
            startActivity(
                Intent(
                    this@Activity5,
                    SecondActivity::class.java
                )
            )
        }
    }
}
