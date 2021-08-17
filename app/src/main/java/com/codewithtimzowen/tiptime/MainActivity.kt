package com.codewithtimzowen.tiptime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.codewithtimzowen.tiptime.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // initialize binding here
    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }

}