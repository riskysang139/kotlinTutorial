package com.example.kotlintutorial.base

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration

class HorizontalItemDecorationNew(
    /**
     * Evenly spaced between item.
     */
    private val spacingHorizontal: Int, private val spacingVertical: Int
) : ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        val frameWidth = parent.width - spacingHorizontal.toFloat()
        val padding = (parent.width / frameWidth).toInt()
        val itemPosition = parent.getChildAdapterPosition(view)
        outRect.top = spacingVertical
        outRect.left = spacingHorizontal
        outRect.right = padding
        if (parent.adapter != null) { //spacing last item.
            if (itemPosition == parent.adapter!!.itemCount - 1) outRect.right = spacingHorizontal
        }
    }
}