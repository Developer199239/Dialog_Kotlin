package com.surroundapps.customdialog

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.Button

class NotesDialogHelper(context: Context) : BaseDialogHelper() {

    //  dialog view
    override val dialogView: View by lazy {
        LayoutInflater.from(context).inflate(R.layout.custom_dialog, null)
    }

    override val builder: AlertDialog.Builder = AlertDialog.Builder(context,android.R.style.Theme_DeviceDefault_Dialog_NoActionBar).setView(dialogView)



    //  done icon
    private val loginBtn: Button by lazy {
        dialogView.findViewById<Button>(R.id.btnLogin)
    }

    //  close icon
    private val laterBtn: Button by lazy {
        dialogView.findViewById<Button>(R.id.btnLater)
    }

    //  closeIconClickListener with listener
    fun laterClickListener(func: (() -> Unit)? = null) =
        with(laterBtn) {
            setClickListenerToDialogIcon(func)
        }

    //  doneIconClickListener with listener
    fun loginClickListener(func: (() -> Unit)? = null) =
        with(loginBtn) {
            setClickListenerToDialogIcon(func)
        }

    //  view click listener as extension function
    private fun View.setClickListenerToDialogIcon(func: (() -> Unit)?) =
        setOnClickListener {
            func?.invoke()
            dialog?.dismiss()
        }
}