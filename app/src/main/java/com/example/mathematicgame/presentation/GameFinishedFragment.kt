package com.example.mathematicgame.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mathematicgame.R
import com.example.mathematicgame.databinding.FragmentChooseLevelBinding
import com.example.mathematicgame.databinding.FragmentGameFinishedBinding
import com.example.mathematicgame.domain.entities.Result

class GameFinishedFragment : Fragment() {
    private var _binding: FragmentGameFinishedBinding? = null
    private val binding: FragmentGameFinishedBinding
        get() = _binding?:throw  RuntimeException("_binding = null")

    private lateinit var result: Result

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        parseArguments()
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

    private fun parseArguments(){
        result = requireArguments().getSerializable(KEY_RESULT) as Result
    }

    companion object {
        private const val KEY_RESULT = "result"
        @JvmStatic
        fun newInstance(gameResult: Result) =
            GameFinishedFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(KEY_RESULT, gameResult)
                }
            }
    }
}