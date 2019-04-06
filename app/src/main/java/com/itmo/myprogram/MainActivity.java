package com.itmo.myprogram;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView avatar=findViewById(R.id.img);
        avatar.getLayoutParams().height=200;
        avatar.getLayoutParams().width=200;
        avatar.setImageResource(R.drawable.ponny);

        initTextView(R.id.login_label,"Логин:",R.color.colorBlack,Gravity.LEFT);
        initTextView(R.id.pass_label,"Пароль:",R.color.colorBlack,Gravity.LEFT);

        initTextView(R.id.ok,"Вход",R.color.colorAccent,Gravity.CENTER).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(((EditText)findViewById(R.id.login)).getText().toString().equals("marfa") &&
                        ((EditText)findViewById(R.id.pass)).getText().toString().equals("qwerty"))
                    findViewById(R.id.login_screen).setVisibility(View.GONE);
            }
        });
    }

    TextView initTextView(final int id,final String text,final int color,final int gravity){
        TextView tv=findViewById(id);
        tv.setText(Html.fromHtml("<font color="+getResources().getColor(color)+">"+text+"</font>"));
        tv.setGravity(gravity);
        return tv;
    }
}
