package com.example.graphicsandanimationapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btnShapeDrawable).setOnClickListener {
            startActivity(Intent(this, ShapeDrawableActivity::class.java))
        }

        findViewById<Button>(R.id.btnCanvas).setOnClickListener {
            startActivity(Intent(this, CanvasActivity::class.java))
        }

        findViewById<Button>(R.id.btnAnimation).setOnClickListener {
            startActivity(Intent(this, AnimationActivity::class.java))
        }
    }
}