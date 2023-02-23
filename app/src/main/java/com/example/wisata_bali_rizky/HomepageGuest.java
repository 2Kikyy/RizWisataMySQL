package com.example.wisata_bali_rizky;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class HomepageGuest extends AppCompatActivity {

    protected Cursor cursor;

    DatabaseHelper databaseHelper;

    TextView txtSayHello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage_guest);

        databaseHelper = new DatabaseHelper(this);
        txtSayHello = findViewById(R.id.sayHello);

//        SQLiteDatabase db = databaseHelper.getReadableDatabase();
//        cursor = db.rawQuery("SELECT * FROM user WHERE nama = '" + getIntent().getStringExtra("name") + "'", null);

        ImageView imageView = findViewById(R.id.imgMountBromo);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomepageGuest.this, MountBromoDetail.class);
                startActivity(intent);
            }
        });
    }
}