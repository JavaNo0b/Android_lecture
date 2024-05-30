
package com.janob.week13_365

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.BlurMaskFilter
import android.graphics.Canvas
import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Sub2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(MyGraphicView(this))
    }

    private class MyGraphicView(context: Context) : View(context){

        override fun onDraw(canvas: Canvas) {
            super.onDraw(canvas)

            var picture = BitmapFactory.decodeResource(resources, R.drawable.doglogo)

            var picX = (this.width - picture.width) / 2f
            var picY = (this.height - picture.height) / 2f


            var paint = Paint()
            var bMask : BlurMaskFilter

            bMask = BlurMaskFilter(30f, BlurMaskFilter.Blur.NORMAL)
            paint.maskFilter = bMask
            canvas.drawBitmap(picture, picX, picY, paint)
            picture.recycle()

            bMask = BlurMaskFilter(30f, BlurMaskFilter.Blur.INNER)
            paint.maskFilter = bMask
            canvas.drawBitmap(picture, picX, picY, paint)
            picture.recycle()

            bMask = BlurMaskFilter(30f, BlurMaskFilter.Blur.OUTER)
            paint.maskFilter = bMask
            canvas.drawBitmap(picture, picX, picY, paint)
            picture.recycle()

            bMask = BlurMaskFilter(30f, BlurMaskFilter.Blur.SOLID)
            paint.maskFilter = bMask
            canvas.drawBitmap(picture, picX, picY, paint)
            picture.recycle()
        }
    }
}