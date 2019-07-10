package com.coolcodezone.animations


import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.dynamicanimation.animation.DynamicAnimation
import androidx.dynamicanimation.animation.SpringAnimation
import androidx.dynamicanimation.animation.SpringForce
import androidx.dynamicanimation.animation.springAnimationOf
import androidx.transition.*
import kotlinx.android.synthetic.main.fragment_physics_animation.*

/**
 * A simple [Fragment] subclass.
 */
class PhysicsAnimationFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_physics_animation, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dismissBtn.setOnClickListener {
            TransitionManager.beginDelayedTransition(root, BannerTrasition())
            bannerView.visibility = View.GONE
        }

        showBannerBtn.setOnClickListener {
            TransitionManager.beginDelayedTransition(root, BannerTrasition())
            bannerView.visibility = View.VISIBLE
        }

        leftBtn.setOnClickListener {
            val springAnim = SpringAnimation(showBannerBtn, SpringAnimation.TRANSLATION_Y).apply {
                val springForce = SpringForce().apply {
                    dampingRatio = SpringForce.DAMPING_RATIO_LOW_BOUNCY
                    stiffness = SpringForce.STIFFNESS_VERY_LOW
                }
                spring = springForce
            }
            springAnim.animateToFinalPosition(800f)

        }

        rightBtn.setOnClickListener {
            val springAnim = SpringAnimation(
                showBannerBtn,
                SpringAnimation.TRANSLATION_Y
            )
            springAnim.animateToFinalPosition(0f)
        }
    }

    inner class BannerTrasition : TransitionSet() {
        init {
            ordering = ORDERING_TOGETHER

            addTransition(ChangeBounds())
                .addTransition(Slide(Gravity.TOP))
        }
    }
}
