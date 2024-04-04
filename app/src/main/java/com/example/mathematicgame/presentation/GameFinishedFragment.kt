package com.example.mathematicgame.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mathematicgame.R
import com.example.mathematicgame.databinding.FragmentChooseLevelBinding
import com.example.mathematicgame.databinding.FragmentGameFinishedBinding

class GameFinishedFragment : Fragment() {
    private var _binding: FragmentGameFinishedBinding? = null
    private val binding: FragmentGameFinishedBinding
        get() = _binding?:throw  RuntimeException("_binding = null")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGameFinishedBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            GameFinishedFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}