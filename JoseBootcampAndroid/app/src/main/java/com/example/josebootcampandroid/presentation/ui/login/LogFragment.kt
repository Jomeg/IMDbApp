package com.example.josebootcampandroid.presentation.ui.login

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.josebootcampandroid.R
import com.example.josebootcampandroid.databinding.FragmentLogBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth

class LogFragment : Fragment() {

    private var _binding: FragmentLogBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentLogBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun login() {
        if (!binding.etUsuario.text.isNullOrEmpty() && !binding.etContrasena.text.isNullOrEmpty()) {
            FirebaseAuth.getInstance().signInWithEmailAndPassword(
                binding.etUsuario.text.toString(),
                binding.etContrasena.text.toString()
            ).addOnCompleteListener {
                if (it.isSuccessful) {
                    showSuccessful()
                    showHome()
                } else {
                    showAlert()
                }
            }
        }
    }

    //Se utiliza para crear enlaces de acuerdo a los textos que tengamos en el login principal.
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.txtContinuarComoInvitado.setOnClickListener {
            findNavController().navigate(
                R.id.navigation_home,
                null
            )
        }
        binding.buttonLogin.setOnClickListener { login() }
        binding.txtRegistrate.setOnClickListener {
            findNavController().navigate(
                R.id.navigation_registration,
                null
            )
        }
    }

    override fun onResume() {
        super.onResume()
        activity?.findViewById<BottomNavigationView>(R.id.nav_view)?.visibility = View.GONE
    }

    override fun onStop() {
        super.onStop()
        activity?.findViewById<BottomNavigationView>(R.id.nav_view)?.visibility = View.VISIBLE
    }

    private fun showAlert() {
        val builder = AlertDialog.Builder(this.context)//verificar si esto es correcto
        builder.setTitle("Error")
        builder.setMessage("Se ha producido un error autenticando al usuario")
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    private fun showSuccessful() {
        val builder = AlertDialog.Builder(this.context)
        builder.setTitle("Bienvenido")
        builder.setMessage("Ingreso Exitoso")
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    private fun showHome() {
        findNavController().navigate(R.id.navigation_home)
    }
}