package com.example.android.agenda;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetalleActivity extends AppCompatActivity {

    TextView Nombre, Telefono, Mail;
    ImageView ImagenTelefono, ImagenMail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        Nombre = (TextView) findViewById(R.id.VistaNombre);
        Telefono = (TextView) findViewById(R.id.vistaTelefono);
        Mail = (TextView) findViewById(R.id.TextoMail);


        Bundle datos = getIntent().getExtras();

        Nombre.setText(datos.get("Nombre").toString());
        Telefono.setText(datos.get("Telefono").toString());
        Mail.setText(datos.get("Mail").toString());

        ImagenTelefono = (ImageView) findViewById(R.id.ImagenTelefono);
        ImagenMail = (ImageView) findViewById(R.id.ImagenMail);


        ImagenTelefono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intento = new Intent(Intent.ACTION_CALL);
                intento.setData(Uri.parse("tel:" + Telefono.getText().toString()));
                if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(intento);
            }
        });


    }
}
