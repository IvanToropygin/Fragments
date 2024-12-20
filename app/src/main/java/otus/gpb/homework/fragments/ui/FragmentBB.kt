package otus.gpb.homework.fragments.ui

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import otus.gpb.homework.fragments.COLOR_KEY
import otus.gpb.homework.fragments.ColorGenerator
import otus.gpb.homework.fragments.R
import otus.gpb.homework.fragments.databinding.FragmentBbBinding

class FragmentBB : Fragment() {

    private var _binding: FragmentBbBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentBbBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSendColorToBa.setOnClickListener {
            val color = ColorGenerator.generateColor()
            setFragmentResult(COLOR_KEY, bundleOf(COLOR_KEY to color))
            if (resources.configuration.orientation != Configuration.ORIENTATION_LANDSCAPE) {
                parentFragmentManager.beginTransaction()
                    .replace(R.id.ba_container, FragmentBA())
                    .commit()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}