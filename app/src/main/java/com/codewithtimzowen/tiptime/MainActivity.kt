package com.codewithtimzowen.tiptime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.codewithtimzowen.tiptime.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    // initialize binding here
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //add click listener to the button
        binding.calculateButton.setOnClickListener { calculateTip() }

    }


    // function to calculate the tip
    private fun calculateTip() {
        val stringEditText = binding.costOfService.text.toString()
        val cost = stringEditText.toDoubleOrNull()

        if(cost == null){
            binding.tipResult.text = ""
            return
        }

        // get the checked radio button
        val tipPercentage = when(binding.tipOption.checkedRadioButtonId){
            R.id.twenty_option -> 0.20
            R.id.eighteen_option -> 0.18
            else -> 0.15
        }
        var tip = tipPercentage * cost
        if(binding.roundUpSwitch.isChecked){
            tip = kotlin.math.ceil(tip)
        }

        val formattedTip = NumberFormat.getCurrencyInstance().format(tip)
        binding.tipResult.text = getString(R.string.tip_amount,formattedTip)

    }

}