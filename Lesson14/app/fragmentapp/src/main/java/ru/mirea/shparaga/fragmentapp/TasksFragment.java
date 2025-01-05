package ru.mirea.shparaga.fragmentapp;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class TasksFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tasks, container, false);

        int studentNumber = requireArguments().getInt("my_number_student");
        Log.d(TasksFragment.class.getSimpleName(), "Student number: " + studentNumber);

        TextView textView = view.findViewById(R.id.studentNumberTextView);
        textView.setText("Номер студента: " + studentNumber);

        return view;
    }
}

