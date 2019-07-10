package com.coolcodezone.animations

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import androidx.cardview.widget.CardView

class Banner : CardView {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    private val bordersPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.BLUE
        style = Paint.Style.STROKE
    }

    override fun onDraw(c: Canvas) {
        super.onDraw(c)
        c.drawRect(left.toFloat(), top.toFloat(), right.toFloat(), bottom.toFloat(), bordersPaint)
    }
}