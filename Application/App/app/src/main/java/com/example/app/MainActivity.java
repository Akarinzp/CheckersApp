package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public int firstImgId = 0;
    public int secondImgId = 0;
    public int thirdImgId = 0;
    public int fourthImgId = 0;
    public int Turn = 1;
    public int Checker= 0;
    public int Text = 0;
    public int tmp;
    public int idtmp = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        firstImgId=R.drawable.white;
        secondImgId=R.drawable.black;
        thirdImgId=R.drawable.chudomin;
        fourthImgId=R.drawable.avatar;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        for (int i = 0; i < 8; i++) {
            LinearLayout row = new LinearLayout(this);
            row.setLayoutParams(new LinearLayout.LayoutParams
                    (LinearLayout.LayoutParams.WRAP_CONTENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT));
            for (int j = 0; j < 8; j++) {
                ImageButton btnTag = new ImageButton(this);
                btnTag.setLayoutParams(new LinearLayout.LayoutParams(130, 130));
                if (i%2==0) {
                    if (j % 2 != 0) {
                        btnTag.setImageResource(firstImgId);
                        btnTag.setTag("w");
                    } else {
                        btnTag.setImageResource(secondImgId);
                        btnTag.setTag("b");
                }

            }
                else {
                    if (j % 2 == 0) {
                        btnTag.setImageResource(firstImgId);
                        btnTag.setTag("w");
                    } else {
                        btnTag.setImageResource(secondImgId);
                        btnTag.setTag("b");
                    }

                }
                if(i==0) {
                    if (j % 2 != 0) {
                        btnTag.setImageResource(fourthImgId);
                        btnTag.setTag("p2");
                    } else {
                        btnTag.setImageResource(secondImgId);
                        btnTag.setTag("b");
                    }
                }
                if(i==7) {
                    if (j % 2 == 0) {
                        btnTag.setImageResource(thirdImgId);
                        btnTag.setTag("p1");
                    } else {
                        btnTag.setImageResource(secondImgId);
                        btnTag.setTag("b");
                    }
                }

                btnTag.setId(j + 1 + (i * 8));
                btnTag.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ImageButton btnTag = (ImageButton) v;
                        String imageName = (String) btnTag.getTag();
                        if(imageName.equals("b")) {
                            Toast toast = Toast.makeText(getApplicationContext(),
                                    "Wrong button",
                                    Toast.LENGTH_SHORT);
                            toast.show();

                        }
                        else {
                            if(imageName.equals("w")) {
                                if(Checker == 0) {
                                    Toast toast = Toast.makeText(getApplicationContext(),
                                            "Pick checker to move",
                                            Toast.LENGTH_SHORT);
                                    toast.show();
                                }
                                else {
                                    if(Checker == 1) {
                                        idtmp = btnTag.getId();
                                        if(tmp == idtmp){
                                            btnTag.setImageResource(thirdImgId);
                                            btnTag.setTag("p1");
                                            Checker = 0;
                                        } else {
                                            btnTag.setImageResource(thirdImgId);
                                            btnTag.setTag("p1");
                                            Checker = 0;
                                            Turn++;
                                        }
                                    }
                                    else {
                                        if(Checker == 2) {
                                            idtmp = btnTag.getId();
                                            if(tmp == idtmp){
                                                btnTag.setImageResource(fourthImgId);
                                                btnTag.setTag("p2");
                                                Checker = 0;
                                            } else {
                                                btnTag.setImageResource(fourthImgId);
                                                btnTag.setTag("p2");
                                                Checker = 0;
                                                Turn++;
                                            }
                                        }
                                    }
                                }
                            }
                            else {
                                if(Turn%2 !=0) {
                                    if(imageName.equals("p1")) {
                                        Checker = 1;
                                        Text = btnTag.getId();
                                        tmp = btnTag.getId();
                                        btnTag.setImageResource(firstImgId);
                                        btnTag.setTag("w");
                                    }
                                    else {
                                        if(imageName.equals("p2")) {
                                            Toast toast = Toast.makeText(getApplicationContext(),
                                                    "Your opponent's Turn",
                                                    Toast.LENGTH_SHORT);
                                            toast.show();
                                        }
                                    }
                                }
                                else {
                                    if(Turn%2 == 0) {
                                        if(imageName.equals("p2")) {
                                            Checker = 2;
                                            Text = btnTag.getId();
                                            tmp = btnTag.getId();
                                            btnTag.setImageResource(firstImgId);
                                            btnTag.setTag("w");
                                        }
                                        else {
                                            if(imageName.equals("p1")) {
                                                Toast toast = Toast.makeText(getApplicationContext(),
                                                        "Your opponent's Turn",
                                                        Toast.LENGTH_SHORT);
                                                toast.show();
                                            }
                                        }

                                    }
                                }
                            }
                        }
                    }
                });
                row.addView(btnTag);
            }
            layout.addView(row);
        }
        setContentView(layout);
    }
}
