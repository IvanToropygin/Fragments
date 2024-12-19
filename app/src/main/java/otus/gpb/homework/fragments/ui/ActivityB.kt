package otus.gpb.homework.fragments.ui

import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import otus.gpb.homework.fragments.R
import otus.gpb.homework.fragments.databinding.ContainerWithOrientationBinding

class ActivityB : AppCompatActivity() {

    private lateinit var binding: ContainerWithOrientationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ContainerWithOrientationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            val orientation = resources.configuration.orientation
            if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.ba_container, FragmentBA())
                    .replace(R.id.bb_container, FragmentBB())
                    .commit()
            } else {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.ba_container, FragmentBA())
                    .commit()
            }
        }
    }
}