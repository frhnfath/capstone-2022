package layout

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.content.ContextCompat
import com.frhnfath.mycustomview.R

class MyEditText : AppCompatEditText, View.OnTouchListener {

    internal lateinit var mClearButtonImage: Drawable

    constructor(context: Context) : super(context) {

    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {

    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {

    }

    private fun init() {
        mClearButtonImage = ContextCompat.getDrawable(context, R.drawable.ic_baseline_close_24dp) as Drawable
        setOnTouchListener(this)
    }

    override fun onTouch(v: View, event: MotionEvent): Boolean {
        if (compoundDrawables[2] != null) {
            val clearButtonStart: Float
            val clearButtonEnd: Float
            var isClearButtonClicked = false
            when (layoutDirection) {
                View.LAYOUT_DIRECTION_RTL -> {
                    clearButtonEnd = (mClearButtonImage.intrinsicWidth + paddingStart).toFloat()
                    when {
                        event.x < clearButtonEnd -> isClearButtonClicked = true
                    }
                }
                else -> {
                    clearButtonStart =
                        (width - paddingEnd - mClearButtonImage.intrinsicHeight).toFloat()
                    when {
                        event.x > clearButtonStart -> isClearButtonClicked = true
                    }
                }
            }
            when {
                isClearButtonClicked -> when {
                    event.action == Motio
                }
            }
        }
    }

    private fun showClearButton() {
        setCompoundDrawablesWithIntrinsicBounds(null, null, mClearButtonImage, null)
    }

    private fun hideClearButton() {
        setCompoundDrawablesWithIntrinsicBounds(null, null, null, null)
    }

}