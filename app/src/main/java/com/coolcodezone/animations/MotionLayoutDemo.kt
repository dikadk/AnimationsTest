package com.coolcodezone.animations


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.transition.TransitionManager
import kotlinx.android.synthetic.main.fragment_motion_layout_demo_end.*
import kotlinx.android.synthetic.main.fragment_motion_layout_demo_start.*
import kotlinx.android.synthetic.main.fragment_motion_layout_demo_start.button

/**
 * A simple [Fragment] subclass.
 */
class MotionLayoutDemo : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_motion_layout_demo_start, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        button.setOnClickListener {
            if(motionLayoutDemo.currentState == R.id.start){
                motionLayoutDemo.transitionToState(R.id.end)
            }else
                motionLayoutDemo.transitionToStart()
            Log.e("motionlayoutdemo","CLICKED")
        }
    }
}
