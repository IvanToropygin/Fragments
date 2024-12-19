package otus.gpb.homework.fragments.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import otus.gpb.homework.fragments.databinding.ActivityABinding

class ActivityA : AppCompatActivity() {

    private lateinit var binding: ActivityABinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityABinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}