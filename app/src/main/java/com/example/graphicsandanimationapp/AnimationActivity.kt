package com.example.graphicsandanimationapp

import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class AnimationActivity : AppCompatActivity() {

    private val MENU_ALPHA_ID = 1
    private val MENU_SCALE_ID = 2
    private val MENU_TRANSLATE_ID = 3
    private val MENU_ROTATE_ID = 4
    private val MENU_COMBO_ID = 5

    private lateinit var tv: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation)
        tv = findViewById(R.id.tv)
        registerForContextMenu(tv)
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        if (v?.id == R.id.tv) {
            menu?.add(0, MENU_ALPHA_ID, 0, "alpha")
            menu?.add(0, MENU_SCALE_ID, 0, "scale")
            menu?.add(0, MENU_TRANSLATE_ID, 0, "translate")
            menu?.add(0, MENU_ROTATE_ID, 0, "rotate")
            menu?.add(0, MENU_COMBO_ID, 0, "combo")
        }
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        var anim: Animation? = null

        when (item.itemId) {
            MENU_ALPHA_ID -> anim = AnimationUtils.loadAnimation(this, R.anim.myalpha)
            MENU_SCALE_ID -> anim = AnimationUtils.loadAnimation(this, R.anim.myscale)
            MENU_TRANSLATE_ID -> anim = AnimationUtils.loadAnimation(this, R.anim.mytrans)
            MENU_ROTATE_ID -> anim = AnimationUtils.loadAnimation(this, R.anim.myrotate)
            MENU_COMBO_ID -> anim = AnimationUtils.loadAnimation(this, R.anim.mycombo)
        }

        anim?.let { tv.startAnimation(it) }
        return true
    }
}