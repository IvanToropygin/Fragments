package otus.gpb.homework.fragments.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import otus.gpb.homework.fragments.ColorGenerator
import otus.gpb.homework.fragments.R
import otus.gpb.homework.fragments.databinding.FragmentABinding

class FragmentA : Fragment() {

    private var _binding: FragmentABinding? = null
    private val binding get() = _binding!!

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (childFragmentManager.backStackEntryCount > 0) {
                    childFragmentManager.popBackStack()
                } else {
                    isEnabled = false
                    activity?.onBackPressed()
                }
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(this, callback)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentABinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val newColor = ColorGenerator.generateColor()
        binding.btnOpenAB.setOnClickListener {
            childFragmentManager.beginTransaction()
                .replace(R.id.container_AA_AB, FragmentAA.newInstance(newColor))
                .addToBackStack("null")
                .commit()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}