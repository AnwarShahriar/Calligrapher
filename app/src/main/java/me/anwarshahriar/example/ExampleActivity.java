package me.anwarshahriar.example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import me.anwarshahriar.calligrapher.Calligrapher;

public class ExampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example);

        Calligrapher calligrapher = new Calligrapher(this);
        calligrapher.setFont(this, "Oranienbaum.ttf", false);
    }
}
