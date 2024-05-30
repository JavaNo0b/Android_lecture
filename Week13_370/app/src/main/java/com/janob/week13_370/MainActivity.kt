package com.janob.week13_370

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.EmbossMaskFilter
import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(MyGraphicView(this))
    }

    private class MyGraphicView(context: Context) : View(context){

        override fun onDraw(canvas: Canvas) {
            super.onDraw(canvas)

            var cenX = (this.width) / 2f
            var cenY = (this.height) / 2f

            var paint = Paint()

            paint.color = Color.GRAY
            var eMask : EmbossMaskFilter

            eMask = EmbossMaskFilter(floatArrayOf(3f,3f,3f), 0.5f, 5f, 10f)
            paint.maskFilter = eMask
            canvas.drawCircle(cenX,cenY,150f,paint)

            eMask = EmbossMaskFilter(floatArrayOf(10f,3f,3f), 0.5f, 5f, 10f)
            paint.maskFilter = eMask
            canvas.drawCircle(cenX,cenY,150f,paint)


            eMask = EmbossMaskFilter(floatArrayOf(3f,10f,3f), 0.5f, 5f, 10f)
            paint.maskFilter = eMask
            canvas.drawCircle(cenX,cenY,150f,paint)

            eMask = EmbossMaskFilter(floatArrayOf(3f,3f,10f), 0.5f, 5f, 10f)
            paint.maskFilter = eMask
            canvas.drawCircle(cenX,cenY,150f,paint)
        }
    }
}