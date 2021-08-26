/*
CREATED BY

NAME: BISWARUP BHATTACHARJEE
PH NO.: 6290272740
EMAIL: bbiswa471@gmail.com
*/
package com.example.braintrainer;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class gointent extends AppCompatActivity {
    TextView txt1;
    TextView txt2;
    Button btn;
    ImageView imgsplash;
    Animation btngone;
    Animation btntwogone;
    Animation atg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gointent);
        txt1=(TextView)findViewById(R.id.txt1);
        txt2=(TextView)findViewById(R.id.txt2);
        btn=(Button) findViewById(R.id.button);
        imgsplash=(ImageView)findViewById(R.id.img1);
        Typeface FFfont=Typeface.createFromAsset(getAssets(),"fonts/MM.ttf");
        Typeface FWFfont=Typeface.createFromAsset(getAssets(),"fonts/QH.ttf");
        Typeface MOFfont=Typeface.createFromAsset(getAssets(),"fonts/RS.TTF");
        btngone= AnimationUtils.loadAnimation(this,R.anim.btngone);
        btntwogone= AnimationUtils.loadAnimation(this,R.anim.btntwogone);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a=new Intent(gointent.this,MainActivity.class);
                startActivity(a);
            }
        });
        atg= AnimationUtils.loadAnimation(this,R.anim.atg);
        txt1.setTypeface(FFfont);
        txt2.setTypeface(FWFfont);
        btn.setTypeface(MOFfont);
        imgsplash.setAnimation(atg);
        txt1.setAnimation(btngone);
        txt2.setAnimation(btngone);
        btn.setAnimation(btntwogone);
    }
}

