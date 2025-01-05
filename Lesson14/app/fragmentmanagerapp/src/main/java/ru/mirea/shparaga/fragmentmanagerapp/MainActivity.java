package ru.mirea.shparaga.fragmentmanagerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.headerContainerView, new FragmentCountries(), "countries")
                    .replace(R.id.detailsContainerView, new FragmentDetails(), "details")
                    .commit();
        }
    }
}