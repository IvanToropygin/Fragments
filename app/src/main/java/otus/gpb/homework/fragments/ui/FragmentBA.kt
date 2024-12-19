package otus.gpb.homework.fragments.ui

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import otus.gpb.homework.fragments.COLOR_KEY
import otus.gpb.homework.fragments.R
import otus.gpb.homework.fragments.databinding.FragmentBaBinding

class FragmentBA : Fragment() {

    private var _binding: FragmentBaBinding? = null
    private val binding get() = _binding!!

    private var color = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        color = savedInstanceState?.getInt(COLOR_KEY) ?: 0
        color = arguments?.getInt(COLOR_KEY, 0) ?: 0
        _binding = FragmentBaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.setBackgroundColor(color)

        val orientation = resources.configuration.orientation
        when (orientation) {
            Configuration.ORIENTATION_LANDSCAPE -> binding.btnOpenBb.isVisible = false
            Configuration.ORIENTATION_PORTRAIT -> {
                with(binding) {
                    btnOpenBb.isVisible = true
                    btnOpenBb.setOnClickListener {
                        parentFragmentManager.beginTransaction()
                            .replace(R.id.ba_container, FragmentBB())
                            .commit()
                    }
                }
            }

            else -> throw IllegalArgumentException("Unknown orientation")
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(COLOR_KEY, color)
        super.onSaveInstanceState(outState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance(color: Int) = FragmentBA().apply {
            arguments = Bundle().apply {
                putInt(COLOR_KEY, color)
            }
        }
    }
}