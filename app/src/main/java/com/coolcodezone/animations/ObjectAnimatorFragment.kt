package com.coolcodezone.animations

import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.BounceInterpolator
import android.view.animation.OvershootInterpolator
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_animator_test.*

class ObjectAnimatorFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_animator_test, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Single single value animation
        val slow_text_anim = ObjectAnimator.ofFloat(slow_text, View.ALPHA, 0f, 1f).apply {
            duration = 500
        }


        //Multiplevalues animator
        val scaleX = PropertyValuesHolder.ofFloat(View.SCALE_X, 0.5f, 1f)
        val scaleY = PropertyValuesHolder.ofFloat(View.SCALE_Y, 0.5f, 1f)
        val alpha = PropertyValuesHolder.ofFloat(View.ALPHA, 0f, 1f)
        val oh_snap_anim = ObjectAnimator.ofPropertyValuesHolder(oh_snap_text, scaleX, scaleY, alpha).apply {
            interpolator = OvershootInterpolator()
        }

        val button_appear_anim = ObjectAnimator.ofFloat(submit_btn, View.ALPHA, 0f, 1.0f).apply {
            duration = 200
        }

        //Group animations together
        val animatorSet = AnimatorSet()
        animatorSet.playSequentially(
            slow_text_anim,
            oh_snap_anim,
            button_appear_anim
        )
        animatorSet.start()

        var firstTimePlay = true

        submit_btn.setOnClickListener {
            firstTimePlay = true
            animatorSet.reverse()

            animatorSet.addListener(object : Animator.AnimatorListener {
                override fun onAnimationRepeat(animation: Animator?) {}

                override fun onAnimationCancel(animation: Animator?) {}

                override fun onAnimationStart(animation: Animator?) {}

                override fun onAnimationEnd(animation: Animator?) {
                    if (firstTimePlay) {
                        firstTimePlay = false
                        animatorSet.startDelay = 100
                        animatorSet.start()
                    }
                }

            })
        }

        other_one_btn.setOnClickListener {
            it.animate().apply {
                rotationXBy(360.0f).interpolator = BounceInterpolator()
                duration = 1000
            }
        }

    }
}