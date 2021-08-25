package com.example.braintrainer;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.graphics.Typeface;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    CountDownTimer countdowntimer;
    Boolean counterIsActive = false;
    Animation rotatelay1,rotatelay2,rotatelay3,scoreboardanimation;
    ImageView lay1;
    ImageView lay2,lay3,scoress;
    int score=0;
    Animation aftercountdowns;
    int noofquestions=0;
    TextView countDown,resulti,sumtext,questionnumber,scores;
    Button btn1,btn2,btn3,btn4,playAgn;
    int locationofcorrectans;
    Typeface Af, Ff,Flf,Lf,Qbf,FFfont,FWFfont,MOFfont;
    ArrayList<Integer> answers=new ArrayList<>();
    public void questionanswersetup(ArrayList<Integer> answers){
        Random random=new Random();
        int a=random.nextInt(40);
        int b=random.nextInt(20);
        int correctans=a+b;
        locationofcorrectans=random.nextInt(4);
        for(int i=0;i<4;i++){
            if(i==locationofcorrectans){
                answers.add(correctans);
            }else {
                int wrongans=random.nextInt(50);
                while (correctans==wrongans){
                    wrongans=random.nextInt(30);
                }
                answers.add(wrongans);
            }

        }
        sumtext.setText(Integer.toString(a)+" + "+Integer.toString(b));
        btnseting();

    }
    public void btnseting(){
        btn1.setText(Integer.toString(answers.get(0)));
        btn2.setText(Integer.toString(answers.get(1)));
        btn3.setText(Integer.toString(answers.get(2)));
        btn4.setText(Integer.toString(answers.get(3)));

    }
    public void playagn(View view){
        scores.setAlpha(0.0f);
        scoress.setAlpha(0.0f);
        btn1.setEnabled(true);
        btn2.setEnabled(true);
        btn3.setEnabled(true);
        btn4.setEnabled(true);
        answers.clear();
        noofquestions=0;
        score=0;
        questionanswersetup(answers);
        playAgn.setAlpha(0.0f);
        playAgn.setEnabled(false);
        questionnumber.setText("0/0");
        countDown.setAlpha(1.0f);
        resulti.setAlpha(1.0f);
        sumtext.setAlpha(1.0f);
        questionnumber.setAlpha(1.0f);
        btn1.setAlpha(1.0f);
        btn2.setAlpha(1.0f);
        btn3.setAlpha(1.0f);
        btn4.setAlpha(1.0f);
        lay1.setAnimation(rotatelay1);
        lay2.setAnimation(rotatelay2);
        lay3.setAnimation(rotatelay3);
        new CountDownTimer(31000,1000){
            @Override
            public void onTick(long l) {
                int sec=(int)l/1000;
                countDown.setText(Integer.toString(sec)+"S");
                MediaPlayer mp=MediaPlayer.create(getApplicationContext(),R.raw.tick);
                mp.start();
            }
            @Override
            public void onFinish() {
                MediaPlayer mpp=MediaPlayer.create(getApplicationContext(),R.raw.ring);
                mpp.start();
                scores.setAlpha(1.0f);
                scoress.setAlpha(1.0f);
                playAgn.setEnabled(true);
                playAgn.setAlpha(1.0f);
                scores.setText(Integer.toString(score)+"/"+Integer.toString(noofquestions));
                btn1.setEnabled(false);
                btn2.setEnabled(false);
                btn3.setEnabled(false);
                btn4.setEnabled(false);
                countDown.setAlpha(0.0f);
                resulti.setAlpha(0.0f);
                sumtext.setAlpha(0.0f);
                questionnumber.setAlpha(0.0f);
                btn1.setAlpha(0.0f);
                btn2.setAlpha(0.0f);
                btn3.setAlpha(0.0f);
                btn4.setAlpha(0.0f);
                lay1.setAnimation(aftercountdowns);
                lay2.setAnimation(aftercountdowns);
                lay3.setAnimation(aftercountdowns);
                resulti.setText(null);

            }
        }.start();
    }

    public void start() {
        playagn(findViewById(R.id.cd));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lay1=(ImageView)findViewById(R.id.lay1);
        lay2=(ImageView)findViewById(R.id.lay2);
        lay3=(ImageView)findViewById(R.id.lay3);
        countDown=(TextView)findViewById(R.id.cd);
        answers=new ArrayList<>();
        btn1=(Button)findViewById(R.id.button1);
        btn2=(Button)findViewById(R.id.button2);
        btn3=(Button)findViewById(R.id.button3);
        btn4=(Button)findViewById(R.id.button4);
        resulti=(TextView)findViewById(R.id.result);
        sumtext=(TextView)findViewById(R.id.sumtext);
        scores=(TextView)findViewById(R.id.score);
        playAgn=(Button)findViewById(R.id.plyagn);
        playAgn.setAlpha(0.0f);
        playAgn.setEnabled(false);
        scoress=(ImageView)findViewById(R.id.scoreboard);
        scoress.setAlpha(0.0f);
        scores.setAlpha(0.0f);
        questionnumber=(TextView)findViewById(R.id.questions);
        Af=Typeface.createFromAsset(getAssets(),"fonts/AF.ttf");
        Ff=Typeface.createFromAsset(getAssets(),"fonts/FF.ttf");
        Flf=Typeface.createFromAsset(getAssets(),"fonts/FLF.ttf");
        Lf=Typeface.createFromAsset(getAssets(),"fonts/LF.ttf");
        Qbf=Typeface.createFromAsset(getAssets(),"fonts/QBF.otf");
        FFfont=Typeface.createFromAsset(getAssets(),"fonts/MM.ttf");
        FWFfont=Typeface.createFromAsset(getAssets(),"fonts/QH.ttf");
        MOFfont=Typeface.createFromAsset(getAssets(),"fonts/RS.TTF");
        rotatelay1= AnimationUtils.loadAnimation(this,R.anim.rotatelay1);
        rotatelay2= AnimationUtils.loadAnimation(this,R.anim.rotatelay2);
        rotatelay3= AnimationUtils.loadAnimation(this,R.anim.rotatelay3);
        aftercountdowns=AnimationUtils.loadAnimation(this,R.anim.aftercountdown);
        lay1.setAnimation(rotatelay1);
        lay2.setAnimation(rotatelay2);
        lay3.setAnimation(rotatelay3);
        countDown.setTypeface(Af);
        sumtext.setTypeface(Lf);
        scores.setTypeface(FWFfont);
        playAgn.setTypeface(Ff);
        questionnumber.setTypeface(MOFfont);
        start();
    }

    public void chooseAns(View view){
        if(Integer.toString(locationofcorrectans).equals(view.getTag().toString())){
            resulti.setText("Correct!");
            resulti.setTypeface(Flf);
            score++;
        }
        else{
            resulti.setText("Wrong");
            resulti.setTypeface(Qbf);
        }
        noofquestions++;
        questionnumber.setText(Integer.toString(score)+"/"+Integer.toString(noofquestions));
        answers.clear();
        questionanswersetup(answers);
    }
}
