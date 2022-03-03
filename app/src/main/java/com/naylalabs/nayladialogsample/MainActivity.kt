package com.naylalabs.nayladialogsample

import android.app.Dialog
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.customnayladialog.NaylaCustomDialog
import com.naylalabs.nayladialog.listeners.NaylaDialogListener
import com.naylalabs.nayladialog.model.NaylaDialogType
import com.naylalabs.nayladialogsample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        listeners()
    }

    private fun listeners() {
        binding.btnErrorDialog.setOnClickListener {
            val dialog = NaylaCustomDialog(
                this@MainActivity, cancelable = false,
                popupListener = object :
                    NaylaDialogListener {
                    override fun positiveButtonClicked() {
                        Toast.makeText(
                            this@MainActivity,
                            "Success Dialog button clicked",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            )
            dialog.show(dialogType = NaylaDialogType.ERROR_DIALOG)
        }

        binding.btnSuccessDialog.setOnClickListener {
            val dialog = NaylaCustomDialog(
                this@MainActivity, cancelable = false,
                popupListener = object : NaylaDialogListener {
                    override fun positiveButtonClicked() {
                        Toast.makeText(
                            this@MainActivity,
                            "Error Dialog button clicked",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            )
            dialog.show(dialogType = NaylaDialogType.SUCCESS_DIALOG)
        }
    }
}
