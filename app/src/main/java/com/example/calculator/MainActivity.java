package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import org.mariuszgromada.math.mxparser.*;

public class MainActivity extends AppCompatActivity {

    private TextView previousCalculation;
    private EditText display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        previousCalculation = findViewById(R.id.previousCalculactionView);
        display = findViewById(R.id.displayEditText);
        display.setShowSoftInputOnFocus(false);
    }
    private void updateString(String str){
        String oldStr = display.getText().toString();
        //wpisanie w srodku stringa
        int cursor = display.getSelectionStart();
        String leftStr = oldStr.substring(0,cursor);
        String rightStr = oldStr.substring(cursor);

        display.setText(String.format("%s%s%s",leftStr,str,rightStr));
        display.setSelection(cursor+str.length());


    }

    //BUTTON CLICKING
    public void zeroButtonPush (View view){
        updateString(getResources().getString(R.string.zeroText));
    }
    public void oneButtonPush (View view){
        updateString(getResources().getString(R.string.oneText));
    }
    public void twoButtonPush (View view){
        updateString(getResources().getString(R.string.twoText));
    }
    public void threeButtonPush (View view){
        updateString(getResources().getString(R.string.threeText));
    }
    public void fourButtonPush (View view){
        updateString(getResources().getString(R.string.fourText));
    }
    public void fiveButtonPush (View view){
        updateString(getResources().getString(R.string.fiveText));
    }
    public void sixButtonPush (View view){
        updateString(getResources().getString(R.string.sixText));
    }
    public void sevenButtonPush (View view){
        updateString(getResources().getString(R.string.sevenText));
    }
    public void eightButtonPush (View view){
        updateString(getResources().getString(R.string.eightText));
    }
    public void nineButtonPush (View view){
        updateString(getResources().getString(R.string.nineText));
    }
    public void multiplyButtonPush (View view){
        updateString(getResources().getString(R.string.multiplyText));
    }
    public void divideButtonPush (View view){
        updateString(getResources().getString(R.string.divideText));
    }
    public void addButtonPush (View view){
        updateString(getResources().getString(R.string.addText));
    }
    public void subtractButtonPush (View view){
        updateString(getResources().getString(R.string.subtractText));
    }
    public void equalButtonPush (View view){
        String userExp = display.getText().toString();
        previousCalculation.setText(userExp);
        userExp = userExp.replaceAll(getResources().getString(R.string.divideText),"/");
        userExp = userExp.replaceAll(getResources().getString(R.string.multiplyText),"*");
        Expression exp = new Expression(userExp);
        String result = String.valueOf(exp.calculate());
        display.setText(result);
        display.setSelection(result.length());

    }
    public void backSpaceButtonPush (View view){
        int cursor = display.getSelectionStart();
        int textLen = display.getText().length();

        if(cursor != 0 && textLen != 0){
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            selection.replace(cursor-1, cursor, "");
            display.setText(selection);
            display.setSelection(cursor-1);
        }

    }
    public void decimalButtonPush (View view){
        updateString(getResources().getString(R.string.decimalText));
    }
    public void clearButtonPush (View view){
        display.setText("");
        previousCalculation.setText("");
    }
    public void parOpenButtonPush (View view){
        updateString(getResources().getString(R.string.parenthesesOpenText));
    }
    public void parCloseButtonPush (View view){
        updateString(getResources().getString(R.string.parenthesesCloseText));
    }

}