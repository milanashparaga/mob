package ru.mirea.shparaga.scrollviewapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout wrapper = findViewById(R.id.wrapper);
        int value = 1;  // Начальное значение прогрессии

        for (int i = 1; i <= 100; i++) {
            View view = LayoutInflater.from(this).inflate(R.layout.item, wrapper, false);
            TextView textView = view.findViewById(R.id.textView);
            textView.setText(String.format("Элемент %d: %d", i, value));
            wrapper.addView(view);
            value *= 2;  // Умножаем на знаменатель прогрессии
        }
    }
}