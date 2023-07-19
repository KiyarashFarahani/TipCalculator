package lol.kiyarash.tipcalculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import lol.kiyarash.tipcalculator.databinding.ActivityMainBinding
import kotlin.math.round

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setNumbersOnClicks()

        binding.button10.setOnClickListener { calculateResult() }


    }

    private fun calculateResult() {
        val inputNumber = binding.input.text.toString().toIntOrNull()
        if (inputNumber == null){
            binding.textView.setText(R.string.error_message)
            return
        }

        val tipPercentage = when (binding.radioGroup.checkedRadioButtonId) {
            R.id.radioButton -> 1.15
            R.id.radioButton2 -> 1.18
            else -> 1.2
        }
        val doRoundUp = binding.checkBox.isChecked

        if (doRoundUp) {
            binding.textView.text = round(inputNumber * tipPercentage).toInt().toString()
        } else {
            binding.textView.text = (inputNumber * tipPercentage).toString()
        }


    }

    private fun setNumbersOnClicks() {
        binding.button0.setOnClickListener { binding.input.text = addToInput("0") }
        binding.button1.setOnClickListener { binding.input.text = addToInput("1") }
        binding.button2.setOnClickListener { binding.input.text = addToInput("2") }
        binding.button3.setOnClickListener { binding.input.text = addToInput("3") }
        binding.button4.setOnClickListener { binding.input.text = addToInput("4") }
        binding.button5.setOnClickListener { binding.input.text = addToInput("5") }
        binding.button6.setOnClickListener { binding.input.text = addToInput("6") }
        binding.button7.setOnClickListener { binding.input.text = addToInput("7") }
        binding.button8.setOnClickListener { binding.input.text = addToInput("8") }
        binding.button9.setOnClickListener { binding.input.text = addToInput("9") }
        binding.buttonClear.setOnClickListener { clearInput() }

    }

    private fun clearInput() {
        binding.input.text = ""
    }

    private fun addToInput(number: String): String {
        return binding.input.text.toString() + "" + number
    }
}