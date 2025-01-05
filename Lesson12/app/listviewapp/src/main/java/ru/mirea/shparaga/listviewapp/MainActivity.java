package ru.mirea.shparaga.listviewapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private final String[] books = {
            "Оруэлл - Скотный двор",
            "Набоков - Лолита",
            "Брэдбери - Вино из одуванчиков",
            "Ремарк - Три товарища",
            "Оруэлл - 1984",
            "Ремарк - На западном фронте без перемен",
            "Селинджер - Над пропастью во ржи",
            "Ремарк - Жизнь взаймы, или у неба любимчиков нет",
            "Ремарк - Триумфальная арка",
            "Фицджеральд - Великий Гэтсби",
            "Булгаков - Мастер и Маргарита",
            "Кинг - Оно",
            "Бронте - Незнакомка из Уайлдфелл-Холла",
            "Лондон - Мартин Иден",
            "Лондон - Маленькая хозяйка большого дома",
            "Зузак - Книжный вор",
            "Бронте - Джейн Эйр",
            "Бронте - Грозовой перевал",
            "Митчелл - Унесённые ветром",
            "Брэдбери - 451 градус по Фарентейту",
            "Ремарк - Ночь в Лиссабоне",
            "Уайльд - Портрет Дориана Грея",
            "Маккалоу - Поющие в терновнике",
            "Остин - Гордость и предубеждение",
            "Теккерей - Ярмарка тщеславия",
            "Флобер - Мадам Бовари",
            "Кэрролл - Алиса в стране чудес",
            "Олкотт - Маленькие женщины",
            "Толстой - Анна Каренина",
            "Сент-Экзюпери - Маленький принц"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.book_list_view);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                books
        );

        listView.setAdapter(adapter);
    }
}