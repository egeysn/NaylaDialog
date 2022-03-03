package com.naylalabs.nayladialog.ui

import android.os.Bundle
import android.view.*
import androidx.fragment.app.DialogFragment
import com.naylalabs.nayladialog.databinding.DialogFragmentSuccessBinding

class NaylaSuccessDialog constructor(private val listener: SuccessDialogFragmentListener) : DialogFragment() {

    private lateinit var binding: DialogFragmentSuccessBinding

    interface SuccessDialogFragmentListener {
        fun onPositiveButtonClicked()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DialogFragmentSuccessBinding.inflate(inflater, container, false)
        listeners()
        return binding.root
    }

    private fun listeners(){
        binding.okButton.setOnClickListener{
            listener.onPositiveButtonClicked()
            dismiss()
        }
    }

    companion object {
        fun newInstance(listener: SuccessDialogFragmentListener): NaylaSuccessDialog {
            return NaylaSuccessDialog(listener = listener)
        }
    }
}
