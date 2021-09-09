package com.example.converterapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.converterapp.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.covert.setOnClickListener {

            calculatebtc()

        }
    }

    private fun calculatebtc() {

        val input = binding.naira.text.toString().toDoubleOrNull() ?: return


        val btc = 0.0000000462356

        var result = input * btc
        val roundup = binding.switchbtn.isChecked


        if (roundup) {
            result = kotlin.math.round(result)
        }

        displayresult(result)

    }
    private fun displayresult(result: Double) {
        val formattedresult = NumberFormat.getNumberInstance().format(result)
        binding.bitcoin.text = getString(R.string.Bitcoin_Value, formattedresult)

    }
}