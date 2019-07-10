package com.coolcodezone.animations

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_main.*


class MainFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val navController = findNavController();
        imageView.setOnClickListener {
            val extras = FragmentNavigatorExtras(imageView to "imageView")
            navController.navigate(R.id.action_mainFragment_to_profileFragment, null, null, extras)
        }

        object_anim_btn.setOnClickListener {
            navController.navigate(R.id.action_mainFragment_to_objectAnimatorFragment)
        }

        phys_anim_btn.setOnClickListener {
            navController.navigate(R.id.action_mainFragment_to_physicsAnimationFragment)
        }

        motionBtn.setOnClickListener {
            navController.navigate(R.id.action_to_motionLayoutDemo)
        }
    }
}
