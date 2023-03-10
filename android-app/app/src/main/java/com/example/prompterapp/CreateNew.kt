package com.example.prompterapp

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class CreateNew : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            // Get the layout inflater
            val inflater = requireActivity().layoutInflater;

            // Inflate and set the layout for the dialog
            // Pass null as the parent view because its going in the dialog layout
            builder.setView(inflater.inflate(R.layout.activity_dialog_create, null))
                // Add action buttons
                .setPositiveButton("Добавить",
                    DialogInterface.OnClickListener { dialog, id ->
                        dialog.cancel()
                    })
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}