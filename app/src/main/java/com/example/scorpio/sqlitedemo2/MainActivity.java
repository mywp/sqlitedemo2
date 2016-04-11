package com.example.scorpio.sqlitedemo2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.scorpio.sqlitedemo.R;
import com.example.scorpio.sqlitedemo2.dao.PersonDAO;
import com.example.scorpio.sqlitedemo2.entities.Person;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout llList = (LinearLayout) findViewById(R.id.ll_list);

        PersonDAO dao = new PersonDAO(this);
        List<Person> personList = dao.queryAll();

        if (personList != null) {
            TextView tv;
            for (Person person : personList) {
                //向线性布局中添加一个TextView
                tv = new TextView(this);
                tv.setText(person.toString());
                tv.setTextSize(18);
                llList.addView(tv);
            }

        }
    }
}
