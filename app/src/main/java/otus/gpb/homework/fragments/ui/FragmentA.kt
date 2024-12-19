package otus.gpb.homework.fragments.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import otus.gpb.homework.fragments.ColorGenerator
import otus.gpb.homework.fragments.R
import otus.gpb.homework.fragments.databinding.FragmentABinding

class FragmentA : Fragment() {

    private var _binding: FragmentABinding? = null
    private val binding get() = _binding!!

    private var step = 0
    private var color = 0

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        step = savedInstanceState?.getInt(STEP_KEY) ?: 0
        color = savedInstanceState?.getInt(STEP_KEY) ?: 0
        _binding = FragmentABinding.inflate(inflater, container, false)
        step = arguments?.getInt(STEP_KEY, 0)?: 0
        color = arguments?.getInt(COLOR_KEY, 0)?: 0
        val title = binding.textView
        val button = binding.btnOpenNextA
        val tvStep = binding.textViewStep

        when (step) {
            0 -> {
                title.text = getString(R.string.fragment_name, "A")
                button.text = getString(R.string.open_fragment_, "AA")
                tvStep.text = getString(R.string.step, step)
            }
            1 -> {
                title.text = getString(R.string.fragment_name, "AA")
                button.text = getString(R.string.open_fragment_, "AB")
                tvStep.text = getString(R.string.step, step)
            }
            2 -> {
                title.text = getString(R.string.fragment_name, "AB")
                button.text = "No more step"
                button.isEnabled = false
                button.isClickable = false
                tvStep.text = getString(R.string.step, step)
            }
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.setBackgroundColor(color)
        binding.btnOpenNextA.setOnClickListener {
            step++
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_a_container, newInstance(step, color))
                .addToBackStack(null)
                .commit()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(STEP_KEY, step)
        outState.putInt(COLOR_KEY, color)
        super.onSaveInstanceState(outState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object{
        private const val STEP_KEY = "STEP"
        private const val COLOR_KEY = "COLOR"
        fun newInstance(step: Int, color: Int) = FragmentA().apply {
            arguments = Bundle().apply {
                putInt(STEP_KEY, step)
                putInt(COLOR_KEY, ColorGenerator.generateColor())
            }
        }
    }
}