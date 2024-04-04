package com.example.mathematicgame.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mathematicgame.R
import com.example.mathematicgame.databinding.FragmentGameBinding
import com.example.mathematicgame.domain.entities.GameSettings
import com.example.mathematicgame.domain.entities.Level
import com.example.mathematicgame.domain.entities.Result

class GameFragment : Fragment() {
    private var _binding: FragmentGameBinding? = null
    private val binding: FragmentGameBinding
        get() = _binding ?: throw RuntimeException("_binding = null")

    private lateinit var level: Level

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        parseArguments()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvOption1.setOnClickListener{
            val fragment = GameFinishedFragment.newInstance(Result(
                true,
                10,
                15,
                GameSettings(
                    200,
                    10,
                    50,
                    60
                )
            ))
            requireActivity().supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container_main, fragment)
                .commit()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun parseArguments(){
        level = requireArguments().getSerializable(KEY_LEVEL) as Level
    }

    companion object {
        private const val KEY_LEVEL = "level"

        @JvmStatic
        fun newInstance(level: Level): GameFragment {
            return GameFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(KEY_LEVEL, level)
                }
            }
        }
    }
}