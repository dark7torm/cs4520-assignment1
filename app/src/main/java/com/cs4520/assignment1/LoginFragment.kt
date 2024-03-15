package com.cs4520.assignment1

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.cs4520.assignment1.databinding.FragmentLoginBinding

class LoginFragment : Fragment(R.layout.fragment_login) {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: android.view.LayoutInflater,
        container: android.view.ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.loginButton.setOnClickListener {
            login()
        }
    }

    private fun login() {
        val username = binding.usernameEditText.text.toString()
        val password = binding.passwordEditText.text.toString()

        if (password == "admin" && username == "admin") {
            binding.usernameEditText.text.clear()
            binding.passwordEditText.text.clear()
            findNavController().navigate(R.id.action_loginFragment_to_productListFragment)
        } else {
            Toast.makeText(context, "Invalid username or password", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
