package com.surroundapps.customdialog

import android.app.Activity
import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private var notesDialog: AlertDialog? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    public fun  showDialog(view: View) {
        if (notesDialog == null)
            notesDialog = showNotesAlertDialog {

                cancelable = false

                laterClickListener {
                    Toast.makeText(this@MainActivity,"later btn clicked",Toast.LENGTH_LONG).show()
                }

                loginClickListener {
                    Toast.makeText(this@MainActivity,"login btn clicked",Toast.LENGTH_LONG).show()
                }
            }
        //  and showing
        notesDialog?.show()
    }

    inline fun Activity.showNotesAlertDialog(func: NotesDialogHelper.() -> Unit): AlertDialog =
        NotesDialogHelper(this).apply {
            func()
        }.create()

    private fun playMusic(view:View) {
        var intent = Intent(MainActivity@this,MusicActivity::class.java)
        startActivity(intent)
    }
}
