package com.janob.week13_360

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.MotionEvent
import android.view.SubMenu
import android.view.View

class MainActivity : AppCompatActivity() {
    companion object {
        const val LINE = 1
        const val CIRCLE = 2
        const val RECTANGLE = 3
        const val TRIANGLE = 4
        var curShape = LINE
        var paintColor = Color.RED
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(MyGraphicView(this))

        title = "도형 그리기"
        getSupportActionBar()?.setDisplayShowHomeEnabled(true)
        getSupportActionBar()?.setIcon(R.drawable.smile)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menu!!.add(0,1,0,"선 그리기")
        menu!!.add(0,2,0,"원 그리기")
        menu!!.add(0,3,0,"사각형 그리기")
        menu!!.add(0,4,0,"삼각형 그리기")

        //서브메뉴 만들기
        var sMenu: SubMenu = menu.addSubMenu("색상 변경 >>")
        sMenu.add(0,5,0,"파란색")
        sMenu.add(0,6,0,"빨간색")

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            1 -> {
                curShape = LINE
                return true
            }
            2 -> {
                curShape = CIRCLE
                return true
            }
            3 -> {
                curShape = RECTANGLE
                return true
            }
            4 -> {
                curShape = TRIANGLE
                return true
            }
            5 -> {
                paintColor = Color.BLUE
                return true
            }
            6 -> {
                paintColor = Color.RED
                return true
            }
        }
        return super.onOptionsItemSelected(item)

    }

    private class MyGraphicView(context: Context) : View(context) {
        var startX = -1
        var startY = -1
        var stopX = -1
        var stopY = -1

        override fun onTouchEvent(event: MotionEvent?): Boolean {
            when(event!!.action) {
                MotionEvent.ACTION_DOWN -> {
                    startX = event.x.toInt()
                    startY = event.y.toInt()
                }
                MotionEvent.ACTION_MOVE, MotionEvent.ACTION_UP -> {
                    stopX = event.x.toInt()
                    stopY = event.y.toInt()
                    this.invalidate()
                }
            }

            return true
        }

        override fun onDraw(canvas: Canvas) {
            super.onDraw(canvas)
            val paint = Paint()
            paint.isAntiAlias = true
            paint.strokeWidth = 5f
            paint.style = Paint.Style.STROKE
            paint.color = paintColor

            when (curShape) {
                LINE -> canvas.drawLine(startX.toFloat(), startY.toFloat(),
                    stopX.toFloat(), stopY.toFloat(),paint)
                CIRCLE -> {
                    var radius = Math.sqrt(Math.pow((stopX - startX).toDouble(),2.0)+ Math.pow((stopY - startY).toDouble(),2.0))
                    canvas.drawCircle(startX.toFloat(), startY.toFloat(), radius.toFloat(), paint)
                }
                RECTANGLE -> {
                    canvas.drawRect(startX.toFloat(), startY.toFloat(),
                        stopX.toFloat(), stopY.toFloat(),paint)
                }
                TRIANGLE -> {
                    val path = Path()
                    path.moveTo(startX.toFloat(), startY.toFloat())
                    path.lineTo(stopX.toFloat(), stopY.toFloat())
                    path.lineTo(startX.toFloat(), stopY.toFloat())
                    path.close()
                    canvas.drawPath(path, paint)
                }
            }
        }
    }
}