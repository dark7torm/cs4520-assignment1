package com.cs4520.assignment1
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController


class LoginFragment : Fragment(R.layout.fragment_login) {
    private lateinit var mainActivity: MainActivity
    private lateinit var editTextUsername: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var loginButton: Button


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)


        editTextUsername = view.findViewById(R.id.usernameEditText)
        editTextPassword = view.findViewById(R.id.passwordEditText)
        loginButton = view.findViewById(R.id.loginButton)


        loginButton.setOnClickListener {
            login()
        }


        return view
    }


    private fun login() {
        val username = editTextUsername.text.toString()
        val password = editTextPassword.text.toString()
        val duration = Toast.LENGTH_SHORT
        val message = "Invalid username or password"
        val toast = Toast.makeText(context, message, duration)


        if (password == "admin" && username == "admin") {
            editTextUsername.text.clear();
            editTextPassword.text.clear();
            findNavController().navigate(R.id.action_loginFragment_to_productListFragment)
        } else {
            toast.show();
        }
    }


}
