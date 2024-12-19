package otus.gpb.homework.fragments.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import otus.gpb.homework.fragments.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnStartTask1.setOnClickListener {
            startActivity(Intent(this, ActivityA::class.java))
        }

        binding.btnStartTask2.setOnClickListener {
            startActivity(Intent(this, ActivityB::class.java))
        }
    }
}