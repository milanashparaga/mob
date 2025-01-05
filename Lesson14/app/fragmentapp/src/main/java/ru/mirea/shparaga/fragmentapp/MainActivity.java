package ru.mirea.shparaga.fragmentapp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            TasksFragment tasksFragment = new TasksFragment();

            Bundle bundle = new Bundle();
            bundle.putInt("my_number_student", 30);  // по таблице с репозиториями я 30
            tasksFragment.setArguments(bundle);

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container_view, tasksFragment);
            transaction.commit();
        }
    }
}
