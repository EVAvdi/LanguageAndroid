package ru.netology.languageandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    Spinner lang;
    Button btn_ok;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }
    private void initView (){
        lang = findViewById(R.id.language);
        btn_ok = findViewById(R.id.ok);
        initSpinnerLang();
    }

    private void initSpinnerLang (){
        ArrayAdapter <CharSequence> adepterLang = ArrayAdapter.createFromResource(this,
                R.array.languages, android.R.layout.simple_spinner_item);
        adepterLang.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        lang.setAdapter(adepterLang);
        lang.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
                String[] stringLangs = getResources().getStringArray(R.array.languages);
                click(stringLangs[i]);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    private void click(String language){
        switch (language) {
            case "Английский": btn_ok.setOnClickListener(clickEng);
            break;
            case "Russian": btn_ok.setOnClickListener(clickRu);
            break;
        }
    }

    private View.OnClickListener clickEng = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Locale locale = new Locale("en");
            Configuration config = new Configuration();
            config.setLocale(locale);
            getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
            recreate();
        }
    };
    private View.OnClickListener clickRu = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Locale locale = new Locale("ru");
            Configuration config = new Configuration();
            config.setLocale(locale);
            getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
            recreate();
        }
    };
}
