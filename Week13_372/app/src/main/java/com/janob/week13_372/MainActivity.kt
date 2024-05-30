package com.janob.week13_372

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Canvas
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {

    lateinit var ibZoomin : ImageButton
    lateinit var ibZoomout : ImageButton
    lateinit var ibRotate : ImageButton
    lateinit var ibBright : ImageButton
    lateinit var ibDark : ImageButton
    lateinit var ibGray : ImageButton
    lateinit var graphicView : MyGraphicView

    companion object{
        var sX = 1f
        var sY = 1f
        var angle = 0f
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var pictureLayout = findViewById<LinearLayout>(R.id.pictureLayout)
        graphicView = MyGraphicView(this)
        pictureLayout.addView(graphicView)

        clickIcons()
    }
    private fun clickIcons() {
        ibZoomin = findViewById(R.id.ibZoomin)
        ibZoomin.setOnClickListener{
            sX = sX + 0.2f
            sY = sY + 0.2f
            graphicView.invalidate()
        }
        ibZoomout = findViewById(R.id.ibZoomout)
        ibZoomout.setOnClickListener{
            sX = sX - 0.2f
            sY = sY - 0.2f
            graphicView.invalidate()
        }

        ibRotate = findViewById(R.id.ibReroad)
        ibRotate.setOnClickListener{
            angle = angle + 20
            graphicView.invalidate()
        }
    }

    class MyGraphicView(context: Context) : View(context){
        override fun onDraw(canvas: Canvas) {
            super.onDraw(canvas)

            var cenX = this.width / 2f
            var cenY = this.height / 2f
            canvas.scale(sX,sY,cenX,cenY)
            canvas.rotate(angle,cenX,cenY)

            var picture = BitmapFactory.decodeResource(resources, R.drawable.doglogo)
            var picX = (this.width - picture.width) / 2f
            var picY = (this.height - picture.height) / 2f
            canvas.drawBitmap(picture,picX,picY,null)

            picture.recycle()
        }
    }
}