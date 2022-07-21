package com.example.josebootcampandroid.presentation.ui.register

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.josebootcampandroid.R
import com.example.josebootcampandroid.databinding.FragmentHomeBinding
import com.example.josebootcampandroid.databinding.FragmentLogBinding
import com.example.josebootcampandroid.databinding.FragmentSingUpBinding
import com.example.josebootcampandroid.presentation.ui.home.HomeFragment
import com.example.josebootcampandroid.presentation.ui.home.ProviderType
import com.example.josebootcampandroid.presentation.ui.login.LogFragment
import com.google.firebase.auth.FirebaseAuth

class fragment_sing_up : Fragment() {
    private var _binding: FragmentSingUpBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentSingUpBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun setup() {
        binding.buttonAceptar.setOnClickListener {
            if (!binding.etEmail.text.isNullOrEmpty() && !binding.etPass.text.isNullOrEmpty()) {
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(
                    binding.etEmail.text.toString(),
                    binding.etPass.text.toString()
                ).addOnCompleteListener {
                    if (it.isSuccessful) {
                        showCorrect()
                        showLog()
                    } else {
                        showAlert()
                    }
                }
            }
        }
    }

    private fun showAlert() {
        val builder = AlertDialog.Builder(this.context)//verificar si esto es correcto
        builder.setTitle("Error")
        builder.setMessage("Se ha producido un error registrando el usuario o contraseña")
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    private fun showCorrect() {
        val builder = AlertDialog.Builder(this.context)
        builder.setTitle("Felicidades")
        builder.setMessage("Usuario y contraseña registrados satisfactoriamente")
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    private fun showLog() {
        findNavController().navigate(R.id.navigation_login)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonAceptar.setOnClickListener {
            setup()
        }
    }
}

