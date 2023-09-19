package com.gusta.passwordgenerator

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val passwordText = findViewById<TextView>(R.id.passwordText)
        val copyPasswordBtn = findViewById<Button>(R.id.copyPasswordBtn)
        val refreshPasswordBtn = findViewById<Button>(R.id.refreshPasswordBtn)
        val upperCaseSwitch = findViewById<Switch>(R.id.upperCaseSwitch)
        val numbersSwitch = findViewById<Switch>(R.id.numbersSwitch)
        val specialCharsSwitch = findViewById<Switch>(R.id.specialCharsSwitch)
        val seekBar = findViewById<SeekBar>(R.id.lengthSeekBar)
        val seekBarProgress = findViewById<TextView>(R.id.seekBarProgress)

        passwordText.text = PasswordGenerator.generate(seekBar.progress, upperCaseSwitch.isChecked, numbersSwitch.isChecked, specialCharsSwitch.isChecked)

        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                seekBarProgress.text = progress.toString()
                passwordText.text = PasswordGenerator.generate(progress, upperCaseSwitch.isChecked, numbersSwitch.isChecked, specialCharsSwitch.isChecked)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                // O usuário começou a tocar na SeekBar
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                // O usuário parou de tocar na SeekBar
            }
        })
        upperCaseSwitch.setOnCheckedChangeListener { _, _ ->
            passwordText.text = PasswordGenerator.generate(seekBar.progress, upperCaseSwitch.isChecked, numbersSwitch.isChecked, specialCharsSwitch.isChecked)
        }
        numbersSwitch.setOnCheckedChangeListener { _, _ ->
            passwordText.text = PasswordGenerator.generate(seekBar.progress, upperCaseSwitch.isChecked, numbersSwitch.isChecked, specialCharsSwitch.isChecked)
        }
        specialCharsSwitch.setOnCheckedChangeListener { _, _ ->
            passwordText.text = PasswordGenerator.generate(seekBar.progress, upperCaseSwitch.isChecked, numbersSwitch.isChecked, specialCharsSwitch.isChecked)
        }

        copyPasswordBtn.setOnClickListener {
            val clipboardManager =
                getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager

            val clipData = ClipData.newPlainText("", passwordText.text.toString())
            clipboardManager.setPrimaryClip(clipData)

            Toast.makeText(this, "Password copied to clipboard!", Toast.LENGTH_SHORT).show()
        }
        refreshPasswordBtn.setOnClickListener {
            passwordText.text = PasswordGenerator.generate(seekBar.progress, upperCaseSwitch.isChecked, numbersSwitch.isChecked, specialCharsSwitch.isChecked)
        }

    }
}