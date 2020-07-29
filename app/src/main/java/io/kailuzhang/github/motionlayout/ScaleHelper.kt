package io.kailuzhang.github.motionlayout

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Context
import android.util.AttributeSet
import android.view.animation.LinearInterpolator
import androidx.constraintlayout.widget.ConstraintHelper
import androidx.constraintlayout.widget.ConstraintLayout

class ScaleHelper(context: Context?, attrs: AttributeSet?) : ConstraintHelper(context, attrs) {
    override fun updatePreLayout(container: ConstraintLayout?) {
        super.updatePreLayout(container)
        val views = getViews(container)
        views.forEach {
            val animatorX =
                ObjectAnimator.ofFloat(it, "scaleX", 1f, 0.3f)
            val animatorY =
                ObjectAnimator.ofFloat(it, "scaleY", 1f, 0.3f)
            AnimatorSet().apply {
                playTogether(animatorX, animatorY)
                duration = 300
                interpolator = LinearInterpolator()
            }.start()
        }
    }
}