package com.example.graphicsandanimationapp

import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.graphics.RectF
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.ArcShape
import android.graphics.drawable.shapes.OvalShape
import android.graphics.drawable.shapes.PathShape
import android.graphics.drawable.shapes.RectShape
import android.graphics.drawable.shapes.RoundRectShape
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class ShapeDrawableActivity : AppCompatActivity() {

    private val IDM_LINE = 101
    private val IDM_OVAL = 102
    private val IDM_RECT = 103
    private val IDM_ROUNDRECT = 104
    private val IDM_STAR = 105
    private val IDM_ARC = 106

    private lateinit var mImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shape_drawable)
        mImage = findViewById(R.id.image)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menu.add(Menu.NONE, IDM_LINE, Menu.NONE, "Line")
        menu.add(Menu.NONE, IDM_OVAL, Menu.NONE, "Oval")
        menu.add(Menu.NONE, IDM_RECT, Menu.NONE, "Rectangle")
        menu.add(Menu.NONE, IDM_ROUNDRECT, Menu.NONE, "Round Rect. Fill")
        menu.add(Menu.NONE, IDM_STAR, Menu.NONE, "Path")
        menu.add(Menu.NONE, IDM_ARC, Menu.NONE, "Arc")
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var drawable: ShapeDrawable? = null

        when (item.itemId) {
            IDM_LINE -> {
                drawable = ShapeDrawable(RectShape())
                drawable.intrinsicHeight = 2
                drawable.intrinsicWidth = 150
                drawable.paint.color = Color.MAGENTA
            }
            IDM_OVAL -> {
                drawable = ShapeDrawable(OvalShape())
                drawable.intrinsicHeight = 100
                drawable.intrinsicWidth = 150
                drawable.paint.color = Color.RED
            }
            IDM_RECT -> {
                drawable = ShapeDrawable(RectShape())
                drawable.intrinsicHeight = 100
                drawable.intrinsicWidth = 150
                drawable.paint.color = Color.BLUE
            }
            IDM_ROUNDRECT -> {
                val outerRadii = floatArrayOf(6f, 6f, 6f, 6f, 6f, 6f, 6f, 6f)
                val rectF = RectF(8f, 8f, 8f, 8f)
                val innerRadii = floatArrayOf(6f, 6f, 6f, 6f, 6f, 6f, 6f, 6f)
                drawable = ShapeDrawable(RoundRectShape(outerRadii, rectF, innerRadii))
                drawable.intrinsicHeight = 100
                drawable.intrinsicWidth = 150
                drawable.paint.color = Color.WHITE
            }
            IDM_STAR -> {
                val path = Path().apply {
                    moveTo(50f, 0f)
                    lineTo(25f, 100f)
                    lineTo(100f, 50f)
                    lineTo(0f, 50f)
                    lineTo(75f, 100f)
                    lineTo(50f, 0f)
                }
                drawable = ShapeDrawable(PathShape(path, 100f, 100f))
                drawable.intrinsicHeight = 100
                drawable.intrinsicWidth = 100
                drawable.paint.color = Color.YELLOW
                drawable.paint.style = Paint.Style.STROKE
            }
            IDM_ARC -> {
                drawable = ShapeDrawable(ArcShape(0f, 255f))
                drawable.intrinsicHeight = 100
                drawable.intrinsicWidth = 100
                drawable.paint.color = Color.YELLOW
            }
        }

        drawable?.let { mImage.background = it }
        return true
    }
}