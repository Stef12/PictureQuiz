package com.example.stefa.picturequiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.Currency;

public class MainActivity extends AppCompatActivity {

    private int currentImageIndex = 0;
    private int[] mImageNames;
    private ImageView mImageView;
    private Button mNextButton;
    private Button mPrevButton;
    private Button mCheckButton;
    private RadioGroup mGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImageView = findViewById(R.id.imageView);
        mGroup = findViewById(R.id.radioGroup);
        mNextButton = findViewById(R.id.btnNext);
        mPrevButton = findViewById(R.id.btnPrev);
        mCheckButton = findViewById(R.id.btnCheck);
        mImageNames = new int[]{R.drawable.image1, R.drawable.image2, R.drawable.image3};

        // Define what happens when the user clicks the next image button
        mNextButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               currentImageIndex++;
               if (currentImageIndex >= mImageNames.length) {
                   currentImageIndex = 0;
               }
               mImageView.setImageResource(mImageNames[currentImageIndex]);
           }
        });

        // Define what happens when the user clicks the previous image button
        mPrevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentImageIndex--;
                if (currentImageIndex < 0) {
                    currentImageIndex = 2;
                }
                mImageView.setImageResource(mImageNames[currentImageIndex]);
            }
        });

        // Define what happens when the user clicks the check image button
        mCheckButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int radioButtonID = mGroup.getCheckedRadioButtonId();
                View radioButton = mGroup.findViewById(radioButtonID);
                int answerIndex = mGroup.indexOfChild(radioButton);

                if (answerIndex == currentImageIndex) {
                    Toast.makeText(MainActivity.this, "Great", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Wrong", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
