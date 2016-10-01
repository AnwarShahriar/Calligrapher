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
        calligrapher.setFont(this, "alexbrush/AlexBrush-Regular.ttf", true); // Set font for whole window including actionbar
        calligrapher.setFont(findViewById(R.id.btnGroup), "oranienbaum/Oranienbaum.ttf"); // Set another font to buttons
    }
}
