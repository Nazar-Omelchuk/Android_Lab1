package com.example.lab1;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.stream.Stream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CheckBox size1 = findViewById(R.id.checkBoxSize1);
        CheckBox size2 = findViewById(R.id.checkBoxSize2);
        CheckBox size3 = findViewById(R.id.checkBoxSize3);

        CheckBox typeStandard = findViewById(R.id.checkBoxTypeDoughStandard);
        CheckBox typeThin = findViewById(R.id.checkBoxTypeDoughThin);
        CheckBox typeCheese = findViewById(R.id.checkBoxTypeDoughCheese);

        ArrayList<CheckBox> checkBoxes = new ArrayList<>();
        checkBoxes.add(size1);
        checkBoxes.add(size2);
        checkBoxes.add(size3);
        checkBoxes.add(typeStandard);
        checkBoxes.add(typeThin);
        checkBoxes.add(typeCheese);

//        size1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//
//                if(isChecked) {
//                    size2.setChecked(false);
//                    size3.setChecked(false);
//                }
//            }
//        });
//        size2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//
//                if(isChecked) {
//                    size1.setChecked(false);
//                    size3.setChecked(false);
//                }
//            }
//        });
//        size3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//
//                if(isChecked) {
//                    size1.setChecked(false);
//                    size2.setChecked(false);
//                }
//            }
//        });
//        typeStandard.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//
//                if(isChecked) {
//                    typeThin.setChecked(false);
//                }
//            }
//        });
//        typeThin.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//
//                if(isChecked) {
//                    typeStandard.setChecked(false);
//                }
//            }
//        });
        onButtonOkClicked(checkBoxes);

    }


    public void onButtonOkClicked(ArrayList<CheckBox> checkBoxes) {

        Button responseButton = findViewById(R.id.buttonOk);

        responseButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {

                TextView finalTextView = findViewById(R.id.finalTextView);

                if (checkBoxes.stream().noneMatch(CompoundButton::isChecked))
                    finalTextView.setText("Виберіть розмір піци і тип тіста!");

                else if (checkBoxes.stream().limit(3).noneMatch(CompoundButton::isChecked))
                    finalTextView.setText("Виберіть розмір піци!");

                else if (checkBoxes.stream().skip(3).limit(2).noneMatch(CompoundButton::isChecked))
                    finalTextView.setText("Виберіть тип тіста!");

                else {
                    ArrayList<String> selectedChekBoxes = new ArrayList<>();
                    checkBoxes.stream().filter(CompoundButton::isChecked).forEach(checkBox -> selectedChekBoxes.add((String) checkBox.getText()));

                    finalTextView.setText("Ви вибрали наступні параметри: \n" + selectedChekBoxes);
                }
            }
        });
    }


}