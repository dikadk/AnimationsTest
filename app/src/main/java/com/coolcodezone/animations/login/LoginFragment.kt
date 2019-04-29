package com.coolcodezone.animations.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.coolcodezone.animations.R
import kotlinx.android.synthetic.main.login_fragment.*
import com.coolcodezone.animations.login.LoginViewModel.AuthenticationState.*
import com.google.android.material.snackbar.Snackbar


class LoginFragment : Fragment() {

    private val viewModel: LoginViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.login_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        login_btn.setOnClickListener {
            viewModel.authenticate(username_edittext.text.toString(),
                password_edittext.text.toString())
        }

        val navController = findNavController()

        requireActivity().addOnBackPressedCallback(viewLifecycleOwner, OnBackPressedCallback {
            viewModel.refuseAuthentication()
            navController.popBackStack(R.id.mainFragment, false)
            true
        })

        viewModel.authenticationState.observe(viewLifecycleOwner, Observer { authenticationState ->
            when (authenticationState) {
                AUTHENTICATED -> navController.popBackStack()
                INVALID_AUTHENTICATION ->
                    Snackbar.make(view,
                        "Invalid credentials",
                        Snackbar.LENGTH_SHORT
                    ).show()
            }
        })
    }
}
