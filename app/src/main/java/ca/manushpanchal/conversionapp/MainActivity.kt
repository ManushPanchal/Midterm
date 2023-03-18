package ca.manushpanchal.convi

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import ca.manushpanchal.conversionapp.R

class MainActivity : AppCompatActivity() , AdapterView.OnItemSelectedListener {
    // creating array for the spinner
    var Conversion = arrayOf(
        "in to cm",
        "cm to in",
        "miles to km",
        "km to miles",
        "lb to kg",
        "kg to lb",
        "oz to gram",
        "gram to oz",
        "cups to liter",
        "liter to cups",
        "c to f",
        "f to c",
        "c to k",
        "f to k"
    )
    var currentValue = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val spin = findViewById<View>(R.id.spinner3) as Spinner
        spin.onItemSelectedListener = this

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, Conversion)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spin.adapter = adapter
        spin.onItemSelectedListener = this
        val yourEditText = findViewById<View>(R.id.editText1) as EditText
        val yourEditText2 = findViewById<View>(R.id.editText2) as EditText

// creating a button on which user can click and get the values converted
        val button: Button = findViewById<View>(R.id.calCButton) as Button
        button.setOnClickListener{

// creating if else statements to pass the math values for units used
            if (yourEditText.text.toString().isEmpty()) {
                yourEditText2.setText("please enter a valid value")
            } else if (spin.selectedItem == "in to cm") {
                yourEditText2.setText(
                    (yourEditText.text.toString().toDouble() * 2.54).toString()
                )
            } else if (spin.selectedItem == "cm to in") {
                yourEditText2.setText(
                    (yourEditText.text.toString().toDouble() / 2.54).toString()
                )
            } else if (spin.selectedItem == "km to miles") {
                yourEditText2.setText(
                    (yourEditText.text.toString().toDouble() * 0.62).toString()
                )
            } else if (spin.selectedItem == "miles to km") {
                yourEditText2.setText(
                    (yourEditText.text.toString().toDouble() * 1.60934).toString()
                )
            } else if (spin.selectedItem == "kg to lb") {
                yourEditText2.setText(
                    (yourEditText.text.toString().toDouble() * 2.2).toString()
                )
            } else if (spin.selectedItem == "lb to kg") {
                yourEditText2.setText(
                    (yourEditText.text.toString().toDouble() * 0.45).toString()
                )
            } else if (spin.selectedItem == "gram to oz") {
                yourEditText2.setText(
                    (yourEditText.text.toString().toDouble() * 0.04).toString()
                )
            } else if (spin.selectedItem == "oz to gram") {
                yourEditText2.setText(
                    (yourEditText.text.toString().toDouble() * 28.35).toString()
                )
            } else if (spin.selectedItem == "liter to cups") {
                yourEditText2.setText(
                    (yourEditText.text.toString().toDouble() * 4.17).toString()
                )
            } else if (spin.selectedItem == "cups to liter") {
                yourEditText2.setText(
                    (yourEditText.text.toString().toDouble() * 0.24).toString()
                )
            } else if (spin.selectedItem == "c to f") {
                val tempValue = yourEditText.text.toString().toDouble()
                yourEditText2.setText((tempValue * 1.8 + 32).toString())
            } else if (spin.selectedItem == "f to c") {
                val tempValue = yourEditText.text.toString().toDouble()
                yourEditText2.setText(((tempValue - 32) * 5 / 9).toString())
            } else if (spin.selectedItem == "c to k") {
                val tempValue = yourEditText.text.toString().toDouble()
                yourEditText2.setText((tempValue + 273.15).toString())
            } else if (spin.selectedItem == "f to k") {
                val tempValue = yourEditText.text.toString().toDouble()
                yourEditText2.setText(((tempValue - 32) * 5 / 9 + 273.15).toString())
            } else {
                yourEditText.setText("not a valid number")
            }
        }

    }

    override fun onItemSelected(arg0: AdapterView<*>?, arg1: View?, position: Int, id: Long) {
        //you get the position
        // variable to store position ex 4
        currentValue = Conversion[position]
        //     toast.makeText(getApplicationContext(),Conversion[position], Toast.LENGTH_LONG).show);
    }

    override fun onNothingSelected(arg0: AdapterView<*>?) {
        // TODO Auto-generated method stub
    }

}



