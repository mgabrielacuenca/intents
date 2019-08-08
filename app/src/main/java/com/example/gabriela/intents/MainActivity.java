package com.example.gabriela.intents;

import android.content.Intent;
import android.net.Uri;
import android.provider.AlarmClock;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void OnClickExplicita(View view) {
        Intent ie = new Intent(this, telaExplicita.class);
        startActivity(ie);
    }

    public void OnClickLigar(View view) {
        Intent il = new Intent(Intent.ACTION_CALL);
        il.setData(Uri.parse("tel:64992851953"));
        startActivity(il);
    }

    public void OnClickContato(View view) {
        Uri ucontato = Uri.parse("content://com.android.contacts/contacts/");
        Intent ic = new Intent(Intent.ACTION_PICK, ucontato);
        startActivity(ic);

    }

    public void OnClickAlarme(View view) {
        Intent ia = new Intent(AlarmClock.ACTION_SET_ALARM);
        startActivity(ia);

    }

    public void OnClickBuscarContato(View view) {
        Uri ubuscacontato = Uri.parse("content://com.android.contacts/contacts/");
        Intent ibc = new Intent(Intent.ACTION_PICK, ubuscacontato);
        startActivityForResult(ibc, 50);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Uri contato = data.getData();
        data.getData();
        Intent iar = new Intent(Intent.ACTION_VIEW, contato);
        startActivity(iar);
    }

    public void OnClickMapa(View view){
        String local = "geo:-37.979450, -23.716220";
        Uri umapa = Uri.parse(local);
        Intent im = new Intent(Intent.ACTION_VIEW, umapa);
        startActivity(im);

    }

    public void OnClickCamera(View view){
        Intent icm = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivity(icm);
    }

    public void OnClickEmail(View view){
        Uri uemail = Uri.parse("mailto:");
        Intent ie = new Intent(Intent.ACTION_SENDTO, uemail);
        startActivity(ie);
    }

    public void OnClickFilter(View view){
        Intent iff = new Intent(Intent.ACTION_SEND);
        iff.setType("text/plain");
        startActivity(iff);
    }
}