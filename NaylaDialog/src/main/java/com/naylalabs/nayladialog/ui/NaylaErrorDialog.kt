package com.naylalabs.nayladialog.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.naylalabs.nayladialog.databinding.DialogFragmentErrorBinding


class NaylaErrorDialog constructor(private val listener : ErrorDialogFragmentListener) : DialogFragment() {

    private lateinit var binding: DialogFragmentErrorBinding

    interface ErrorDialogFragmentListener {
        fun onPositiveButtonClicked()
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DialogFragmentErrorBinding.inflate(inflater, container, false)
        listeners()
        return binding.getRoot()
    }

    private fun listeners(){
        binding.okButton.setOnClickListener{
            listener.onPositiveButtonClicked()
            dismiss()
        }
    }

    companion object {
        fun newInstance(listener : ErrorDialogFragmentListener): NaylaErrorDialog {
            return NaylaErrorDialog(listener = listener)
        }
    }
}