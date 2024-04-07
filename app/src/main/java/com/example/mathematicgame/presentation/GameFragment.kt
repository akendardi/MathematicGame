package com.example.mathematicgame.presentation

import android.content.res.ColorStateList
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.mathematicgame.R
import com.example.mathematicgame.databinding.FragmentGameBinding
import com.example.mathematicgame.domain.entities.Level
import com.example.mathematicgame.domain.entities.Question
import com.example.mathematicgame.domain.entities.Result

class GameFragment : Fragment() {

    private val args by navArgs<GameFragmentArgs>()

    private val viewModelFactory by lazy {
        GameViewModelFactory(
            requireActivity().application,
            args.level
        )
    }

    private val viewModel by lazy {
        ViewModelProvider(
            this,
            viewModelFactory
        )[GameViewModel::class.java]
    }

    private var _binding: FragmentGameBinding? = null
    private val binding: FragmentGameBinding
        get() = _binding ?: throw RuntimeException("FragmentGameBinding == null")


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observers()
        listenersForButtons()
    }

    private fun listenersForButtons(){
        val listOfButtons = listOf(
            binding.tvOption1,
            binding.tvOption2,
            binding.tvOption3,
            binding.tvOption4,
            binding.tvOption5,
            binding.tvOption6
        )
        listOfButtons.forEach{button ->
            button.setOnClickListener {
                val selectedOption = it as TextView
                viewModel.chooseAnswer(selectedOption.text.toString().toInt())
            }
        }
    }

    private fun observers(){
        observeTimer()
        observeQuestion()
        observeGameFinish()
        observeProgressBar()
        observeAnswerProgress()
    }

    private fun observeQuestion(){
        viewModel.question.observe(viewLifecycleOwner){
            setQuestion(it)
        }
    }

    private fun observeTimer(){
        viewModel.formattedTime.observe(viewLifecycleOwner){
            binding.tvTimer.text = it
        }
    }

    private fun observeProgressBar(){
        viewModel.minPercent.observe(viewLifecycleOwner){
            binding.progressBar.secondaryProgress = it
        }
        viewModel.percentOfRightAnswers.observe(viewLifecycleOwner){
            binding.progressBar.setProgress(it, true)
        }
        viewModel.enoughPercentOfRightAnswers.observe(viewLifecycleOwner){
            val color = if (it){
                ContextCompat.getColor(requireContext(), android.R.color.holo_green_dark)
            } else {
                ContextCompat.getColor(requireContext(), android.R.color.holo_red_dark)
            }
            binding.progressBar.setProgressTintList(ColorStateList.valueOf(color))
        }
    }

    private fun observeAnswerProgress(){
        viewModel.progressAnswers.observe(viewLifecycleOwner){
            binding.tvAnswersProgress.text = it
        }
        viewModel.enoughCountOfRightAnswers.observe(viewLifecycleOwner){
            val color = if (it){
                ContextCompat.getColor(requireContext(), android.R.color.holo_green_dark)
            } else {
                ContextCompat.getColor(requireContext(), android.R.color.holo_red_dark)
            }
            binding.tvAnswersProgress.setTextColor(color)
        }
    }

    private fun setQuestion(question: Question){
        binding.tvSum.text = question.sum.toString()
        binding.tvLeftNumber.text = question.visibleNumber.toString()
        binding.tvOption1.text = question.options[0].toString()
        binding.tvOption2.text = question.options[1].toString()
        binding.tvOption3.text = question.options[2].toString()
        binding.tvOption4.text = question.options[3].toString()
        binding.tvOption5.text = question.options[4].toString()
        binding.tvOption6.text = question.options[5].toString()
    }

    private fun observeGameFinish(){
        viewModel.gameResult.observe(viewLifecycleOwner){
            launchGameFinishedFragment(it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    private fun launchGameFinishedFragment(gameResult: Result) {
        findNavController().navigate(
            GameFragmentDirections.actionGameFragmentToGameFinishedFragment(gameResult)
        )
    }

    companion object {

        const val NAME = "GameFragment"
        const val KEY_LEVEL = "level"

        fun newInstance(level: Level): GameFragment {
            return GameFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(KEY_LEVEL, level)
                }
            }
        }
    }
}