package com.abtinandroidstdio.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import com.abtinandroidstdio.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding //because of scope var
    var isSomeDigitEntered = false
    var isDotButtonClicked = false
    var isSecondNumberEntered = false
    var isOperatoinEntered = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //binding view for easily id access
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this)) // alt enter --> split properties
        setContentView(binding.root)
        // binding. root will help us to alter our views with building and its like R.layout.activity_main
    }

    /*
        in this function we are casting view to button and then we will append the text of button to textView
        this is how we add the new clicked number to calculator view
     */
    fun onclickDigit(clickedNumber : View){
        val clickedButton = clickedNumber as Button
        if (isSomeDigitEntered){
            binding.textView.append(clickedButton.text)
        }
        else {
            binding.textView.text = clickedButton.text
            isSomeDigitEntered = true
        }
    }

    /*
         in this function we are checking entered dot or new dot symbol for floating point number
     */
    fun onDotClicked(view : View) {
        if (!isDotButtonClicked && isSomeDigitEntered){
            binding.textView.append(".")
            isDotButtonClicked = true
        }
    }

    /*
        in this fun we are clearing all numbers of calculator view
     */
    fun clearAllNumbers(view: View){
        binding.textView.text = ""
        isSomeDigitEntered = false
        isDotButtonClicked = false
    }

    /*
        in this function we are casting view to button and then we will append the text of button to textView
        this is how we add the new clicked number to calculator view
     */
    fun onclickOperator(clickedNumber : View){
        val clickedButton = clickedNumber as Button
        if (!isSomeDigitEntered){

        }
        else {
            if(isOperatoinEntered){
                var textViewString = binding.textView.text
                //how to use substring in kotlin
                textViewString = textViewString.substring(0, textViewString.length - 1) + clickedButton.text
            }
            binding.textView.append(clickedButton.text)
        }
    }



}
