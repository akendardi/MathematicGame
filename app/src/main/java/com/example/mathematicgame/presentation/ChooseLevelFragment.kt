package com.example.mathematicgame.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mathematicgame.R
import com.example.mathematicgame.databinding.FragmentChooseLevelBinding
import com.example.mathematicgame.domain.entities.Level

class ChooseLevelFragment : Fragment() {
    private var _binding: FragmentChooseLevelBinding? = null
    private val binding: FragmentChooseLevelBinding
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
        _binding = FragmentChooseLevelBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonListeners()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun buttonListeners(){
        binding.buttonChooseTest.setOnClickListener {
            launchFragment(Level.TEST)
        }
        binding.buttonChooseEasy.setOnClickListener {
            launchFragment(Level.EASY)
        }
        binding.buttonChooseMedium.setOnClickListener {
            launchFragment(Level.MEDIUM)
        }
        binding.buttonChooseHard.setOnClickListener {
            launchFragment(Level.HARD)
        }
    }

    private fun launchFragment(level: Level){
        val fragment = GameFragment.newInstance(level)
        requireActivity().supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container_main, fragment)
            .addToBackStack(null)
            .commit()
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            ChooseLevelFragment()
    }
}