package otus.gpb.homework.fragments.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import otus.gpb.homework.fragments.COLOR_KEY
import otus.gpb.homework.fragments.databinding.FragmentAbBinding

class FragmentAB : Fragment() {

    private var _binding: FragmentAbBinding? = null
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

        _binding = FragmentAbBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.setBackgroundColor(color)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(COLOR_KEY, color)
        super.onSaveInstanceState(outState)
    }

    companion object {
        fun newInstance(color: Int) =
            FragmentAB().apply {
                arguments = Bundle().apply {
                    putInt(COLOR_KEY, color)
                }
            }
    }
}