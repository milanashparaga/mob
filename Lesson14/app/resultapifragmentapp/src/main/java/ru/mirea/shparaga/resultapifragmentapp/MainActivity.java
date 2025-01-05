package ru.mirea.shparaga.resultapifragmentapp;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements FragmentListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Если сохраненного состояния нет, загружаем фрагмент
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new DataFragment())
                    .commit();
        }

        // Устанавливаем слушателя для получения результатов от фрагмента
        getSupportFragmentManager().setFragmentResultListener(
                "requestKey", this, (requestKey, bundle) -> {
                    String result = bundle.getString("key");
                    Log.d(BottomSheetFragment.class.getSimpleName(), "I'm MainActivity " + result);
                });
    }

    @Override
    public void sendResult(String message) {
        Log.d(MainActivity.class.getSimpleName(), "message: " + message);
    }
}
