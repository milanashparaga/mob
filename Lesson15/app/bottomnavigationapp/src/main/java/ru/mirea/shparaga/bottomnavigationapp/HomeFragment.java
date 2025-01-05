package ru.mirea.shparaga.bottomnavigationapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment {

    private String[] quotes = {
            "Судьба проказница, шалунья\n" +
                    "Определила так сама:\n" +
                    "Всем глупым счастье от безумья,\n" +
                    "А умным - горе от ума.",
            "Горячий лёд, круглый квадрат, некрасивая женщина — то, чего быть в принципе не может!",
            "Новый год – это грустное расставание со старыми иллюзиями и радостная встреча с новыми.",
            "Забудьте об этом. Раскаяние-самая бесполезная вещь на свете. Вернуть ничего нельзя. Ничего нельзя исправить. Иначе все мы были бы святыми. Жизнь не имела в виду сделать нас совершенными. Тому, кто совершенен, место в музее. ",
            "Почти во всех случаях, лучшее время для начала - сейчас."
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ListView trackListView = view.findViewById(R.id.quotes);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_list_item_1, quotes);
        trackListView.setAdapter(adapter);
        return view;
    }
}
