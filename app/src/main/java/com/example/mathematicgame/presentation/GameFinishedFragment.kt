package com.example.mathematicgame.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.mathematicgame.R
import com.example.mathematicgame.databinding.FragmentGameFinishedBinding
import com.example.mathematicgame.domain.entities.Result

class GameFinishedFragment : Fragment() {

    private val args by navArgs<GameFinishedFragmentArgs>()

    private var _binding: FragmentGameFinishedBinding? = null
    private val binding: FragmentGameFinishedBinding
        get() = _binding ?: throw RuntimeException("FragmentGameFinishedBinding == null")



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGameFinishedBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listenerForButton()
        setArgs(args.gameResult)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun listenerForButton(){
        binding.buttonRetry.setOnClickListener {
            retryGame()
        }
    }

    private fun setArgs(result: Result){
        val smileResourceId = if (result.winner) {
            R.drawable.ic_smile
        } else {
            R.drawable.ic_bad_smile
        }
        binding.emojiResult.setImageResource(smileResourceId)
        binding.tvScorePercentage.text = formatString(
            requireContext().resources.getString(R.string.score_percentage),
            getPercent(result.countOfQuestions, result.countOfRightAnswers)
        )
        binding.tvScoreAnswers.text = formatString(
            requireContext().resources.getString(R.string.score_answers),
            result.countOfRightAnswers
        )
        binding.tvRequiredAnswers.text = formatString(
            requireContext().resources.getString(R.string.required_score),
            result.gameSettings.minCountOfRightAnswers
        )
        binding.tvRequiredPercentage.text = formatString(
            requireContext().resources.getString(R.string.required_percentage),
            result.gameSettings.minPercentOfRightAnswers
        )

    }

    private fun formatString(str: String, number: Int): String{
        return String.format(
            str,
            number
        )
    }

    private fun getPercent(questions: Int, score: Int): Int{
        if (questions == 0){
            return 0
        }
        return ((score / questions.toDouble()) * 100).toInt()
    }


    private fun retryGame() {
        findNavController().popBackStack()
    }

    companion object {

         const val KEY_GAME_RESULT = "game_result"

        fun newInstance(gameResult: Result): GameFinishedFragment {
            return GameFinishedFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(KEY_GAME_RESULT, gameResult)
                }
            }
        }
    }
}