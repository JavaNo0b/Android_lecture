package com.janob.week13

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.graphics.Rect
import android.graphics.RectF
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(MyGraphicView(this))
    }

    private class MyGraphicView(context: Context) : View(context) {

        override fun onDraw(canvas: Canvas) {
            super.onDraw(canvas)
            val paint = Paint()
            paint.isAntiAlias = true
            paint.color = Color.GREEN
            canvas.drawLine(10f,10f,300f,10f,paint)

            paint.color = Color.BLUE
            paint.strokeWidth = 5f
            canvas.drawLine(10f,30f,300f,30f,paint)

            paint.color = Color.RED
            paint.strokeWidth = 0f

            paint.style = Paint.Style.FILL
            val rect1 = Rect(10,50,10+100,50+100)
            canvas.drawRect(rect1,paint)

            paint.style = Paint.Style.STROKE
            val rect2 = Rect(130,50,130+100,50+100)
            canvas.drawRect(rect2,paint)

            val rect3 = RectF(250f,50f,250f+100f, 50f+100f)
            canvas.drawRoundRect(rect3,20f,20f,paint)

            canvas.drawCircle(60f,220f,50f,paint)

            paint.strokeWidth = 5f
            val path1 = Path()
            path1.moveTo(10f,290f)
            path1.lineTo(10f+50f, 290f+50f)
            path1.lineTo(10f+100f, 290f)
            path1.lineTo(10f+150f, 290f+50f)
            path1.lineTo(10f+200f, 290f)
            canvas.drawPath(path1,paint)
            paint.strokeWidth = 0f
            paint.textSize = 30f
            canvas.drawText("안드로이드",10f,390f,paint)

        }
    }

}