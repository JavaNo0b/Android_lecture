
package com.janob.week13_365

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Canvas
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class SubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(MyGraphicView(this))
    }

    private class MyGraphicView(context: Context) : View(context){

        override fun onDraw(canvas: Canvas) {
            super.onDraw(canvas)

            var picture = BitmapFactory.decodeResource(resources, R.drawable.doglogo)

            var cenX = this.width / 2f
            var cenY = this.height / 2f

            var picX = (this.width - picture.width) / 2f
            var picY = (this.height - picture.height) / 2f

            canvas.rotate(45f,cenX,cenY)
            canvas.drawBitmap(picture, picX, picY, null)

            canvas.translate(-150f,200f)
            canvas.drawBitmap(picture, picX, picY, null)

            canvas.scale(2f,2f,cenX,cenY)
            canvas.drawBitmap(picture, picX, picY, null)

            canvas.skew(0.3f,0.3f)
            canvas.drawBitmap(picture, picX, picY, null)


            picture.recycle()
        }
    }
}