package otus.gpb.homework.fragments.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import otus.gpb.homework.fragments.COLOR_KEY
import otus.gpb.homework.fragments.ColorGenerator
import otus.gpb.homework.fragments.R
import otus.gpb.homework.fragments.databinding.FragmentAaBinding

class FragmentAA : Fragment() {

    private var _binding: FragmentAaBinding? = null
    private val binding get() = _binding!!
    private var color: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            color = it.getInt(COLOR_KEY)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        color = arguments?.getInt(COLOR_KEY, 0) ?: 0

        if (savedInstanceState != null) {
            color = savedInstanceState.getInt(COLOR_KEY)
        }

        _binding = FragmentAaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.setBackgroundColor(color)
        val newColor = ColorGenerator.generateColor()
        binding.btnOpenAB.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.container_AA_AB, FragmentAB.newInstance(newColor))
                .addToBackStack(null)
                .commit()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(COLOR_KEY, color)
        super.onSaveInstanceState(outState)
    }

    companion object {
        fun newInstance(color: Int) =
            FragmentAA().apply {
                arguments = Bundle().apply {
                    putInt(COLOR_KEY, color)
                }
            }
    }
}