package com.example.uts_akb_10117205;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

public class OnClickListenerTambah implements View.OnClickListener {
    public void onClick(View view) {
       Context context = view.getRootView().getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View formElementsView = inflater.inflate(R.layout.tambah_kontak, null, false);
        final EditText editTextNIM = (EditText) formElementsView.findViewById(R.id.tNIM);
        final EditText editTextNama = (EditText) formElementsView.findViewById(R.id.tNama);
        final EditText editTextEmail = (EditText) formElementsView.findViewById(R.id.tEmail);
        final EditText editTextSocial = (EditText) formElementsView.findViewById(R.id.tSocialMedia);
        new AlertDialog.Builder(context)
                .setView(formElementsView)
                .setTitle("Tambah Kontak")
                .setPositiveButton("Tambah",new DialogInterface.OnClickListener(){
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        }).show();
    }
}

