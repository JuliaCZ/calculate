package com.example.julia.calculate2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private EditText login, password;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        //textView = (TextView)findViewById(R.id.textView);

        button = (Button)findViewById(R.id.button);
        ImageView imageViewLogo = (ImageView) findViewById(R.id.imageView);
        ImageView imageViewPass = (ImageView) findViewById(R.id.imageView2);
        ImageView facebook = (ImageView)findViewById(R.id.imageView3);
        ImageView google = (ImageView)findViewById(R.id.imageView4);
        ImageView twitter = (ImageView)findViewById(R.id.imageView5);

        imageViewLogo.setImageResource(R.drawable.login);
        imageViewPass.setImageResource(R.drawable.password);
        facebook.setImageResource(R.drawable.facebook);
        google.setImageResource(R.drawable.google);
        twitter.setImageResource(R.drawable.twitter);

        login = (EditText)findViewById(R.id.editText);
        password = (EditText)findViewById(R.id.editText2);
        /*button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                textView.setText("Ты вышел!");
            }
        });*/

    }
    /*public void SignIn(View view)
    {
        textView.setText("Ты вошел!");
    }*/
    private boolean check(EditText login, EditText password, String checkLogin, String checkPassword)
    {
        login = (EditText)findViewById(R.id.editText);
        password = (EditText)findViewById(R.id.editText2);
        if(login.getText().toString().equals(checkLogin) &&
                password.getText().toString().equals(checkPassword)) {
            return true;
        }
        else
            return false;
    }
    public void goToNewActivity(View v){
        if(check(login, password, "admin", "admin"))
        {
            Intent intent = new Intent(this, Activity2.class);
            startActivity(intent);
        }
    }
    public void enterWithFacebook(View v)
    {
        if(check(login, password, "facebook", "facebook"))
        {
            Intent intent = new Intent(this, Activity2.class);
            startActivity(intent);
        }
    }
    public void enterWithGoogle(View v)
    {
        if(check(login, password, "google", "google"))
        {
            Intent intent = new Intent(this, Activity2.class);
            startActivity(intent);
        }
    }
    public void enterWithTwitter(View v)
    {
        if(check(login, password, "twitter", "twitter"))
        {
            Intent intent = new Intent(this, Activity2.class);
            startActivity(intent);
        }
    }

}
