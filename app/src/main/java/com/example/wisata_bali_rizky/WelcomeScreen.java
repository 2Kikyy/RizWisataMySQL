package com.example.wisata_bali_rizky;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WelcomeScreen extends AppCompatActivity {

    TextView txtPengguna;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_screen);
        txtPengguna = findViewById(R.id.txtPengguna);
        txtPengguna.setOnClickListener(v->{
            startActivity(new Intent(this,LoginGuest.class));
        });
        final Button getStarted = findViewById(R.id.btnGetStarted);

        getStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), HomepageGuest.class);
                startActivity(intent);
            }
        });
    }
}