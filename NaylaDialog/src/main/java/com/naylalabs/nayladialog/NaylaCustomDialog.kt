package com.customnayladialog

import android.app.Dialog
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentActivity
import com.naylalabs.nayladialog.listeners.NaylaDialogListener
import com.naylalabs.nayladialog.model.NaylaDialogType
import com.naylalabs.nayladialog.ui.NaylaErrorDialog
import com.naylalabs.nayladialog.ui.NaylaSuccessDialog

class NaylaCustomDialog constructor(
    private val activity: FragmentActivity,
    private var cancelable: Boolean = false,
    private val popupListener: NaylaDialogListener
) {

    public fun show(dialogType: NaylaDialogType) {
        val fragment = decidePopup(dialogType)
        fragment.isCancelable = cancelable
        fragment.show(activity.supportFragmentManager, "NaylaSuccessDialog")
    }

    private fun decidePopup(dialogType: NaylaDialogType): DialogFragment {
        return if (dialogType == NaylaDialogType.SUCCESS_DIALOG)
            NaylaSuccessDialog(
                listener = object : NaylaSuccessDialog.SuccessDialogFragmentListener {
                    override fun onPositiveButtonClicked() {
                        popupListener.positiveButtonClicked()
                    }
                }
            )
        else {
            NaylaErrorDialog(
                listener = object : NaylaErrorDialog.ErrorDialogFragmentListener {
                    override fun onPositiveButtonClicked() {
                        popupListener.positiveButtonClicked()
                    }
                }
            )
        }

    }

    fun setCancelable(isCancelable: Boolean) {
        this.cancelable = isCancelable
    }
}
