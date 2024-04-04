package com.example.mathematicgame.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mathematicgame.R
import com.example.mathematicgame.databinding.FragmentChooseLevelBinding
import com.example.mathematicgame.databinding.FragmentGameBinding
import com.example.mathematicgame.databinding.FragmentGameFinishedBinding

class GameFragment : Fragment() {
    private var _binding: FragmentGameBinding? = null
    private val binding: FragmentGameBinding
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
        _binding = FragmentGameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            GameFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}