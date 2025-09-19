package com.alness.bottomnavbar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.alness.bottomnavbar.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    // _binding es nullable y se limpia en onDestroyView
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!  // acceso seguro dentro del ciclo de vida de la vista


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflamos con viewBinding
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    // Aquí ya puedes usar binding para inicializar vistas, listeners, etc.
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Ejemplo: configurar un botón definido en fragment_home.xml con id btnExample
        binding.tvF1.setOnClickListener {
            Toast.makeText(requireContext(), "Botón presionado", Toast.LENGTH_SHORT).show()
        }

        // Ejemplo: poner texto a un TextView con id tvTitle
        binding.tvF1.text = "Hola desde Home Fragment"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Muy importante: prevenir memory leaks
        _binding = null
    }


}