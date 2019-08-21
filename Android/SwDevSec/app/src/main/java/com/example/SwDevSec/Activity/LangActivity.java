package com.example.SwDevSec.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.SwDevSec.R;

public class LangActivity extends AppCompatActivity {
    private String[] LIST_MENU = {"한국어", "English", "中文", "日本語", "ภาษาไทยกลาง","Deutsch",
            "French","русский язык","بهاس إندونيسيا"
            ,"tiếng Việt","español"};
    private String language;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lang);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, LIST_MENU);

        ListView listview = (ListView) findViewById(R.id.listview1);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            // 코드 계속 ...

            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id) {

                // get TextView's Text.
                String strText = (String) parent.getItemAtPosition(position);
                switch (strText) {
                    case "한국어":
                        language = "ko";
                        break;
                    case "中文":
                        language = "zh";
                        break;
                    case "日本語":
                        language = "ja";
                        break;
                    case "ภาษาไทยกลาง":
                        language = "th";
                        break;
                    case "Deutsch":
                        language = "de";
                        break;
                    case "French":
                        language = "fr";
                        break;
                    case "русский язык":
                        language = "ru";
                        break;
//                    case "بهاس ملايو":
//                        language = "ml";
//                        break;
                    case "بهاس إندونيسيا":
                        language = "in";
                        //papago 에선 id
                        break;
//                    case "اللغة العربية":
//                        language = "ar";
//                        break;
                    case "tiếng Việt":
                        language = "vi";
                        break;
//                    case "Монгол хэл":
//                        language = "mn";
//                        break;
                    case "español":
                        language = "es";
                        break;



                    case "English":
                    default:
                        language = "en";
                }
                Intent intent = new Intent(getApplicationContext(), MainMenuActivity.class);
                intent.putExtra("language", language);
                //Activity 실행메소드
                startActivity(intent);

                // TODO : use strText
            }
        });
    }
}
