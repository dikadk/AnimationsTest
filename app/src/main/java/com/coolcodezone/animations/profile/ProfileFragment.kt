package com.coolcodezone.animations.profile

import android.os.Bundle
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.coolcodezone.animations.R
import com.coolcodezone.animations.login.LoginViewModel
import com.coolcodezone.animations.login.LoginViewModel.AuthenticationState.*

class ProfileFragment : Fragment() {

    private val viewModel: LoginViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition = TransitionInflater.from(context).inflateTransition(android.R.transition.move)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        /*val navController = findNavController()
        viewModel.authenticationState.observe(viewLifecycleOwner, Observer { authenticatorState->
            when(authenticatorState){
                AUTHENTICATED -> showWelcomeMessage()
                UNAUTHENTICATED -> navController.navigate(R.id.loginFragment)
            }
        })*/
    }

    private fun showWelcomeMessage() {
        Toast.makeText(context, "Welcome!", Toast.LENGTH_SHORT).show()
    }



}