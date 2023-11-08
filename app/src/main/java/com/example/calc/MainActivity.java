package com.example.calc;

import androidx.appcompat.app.AppCompatActivity;
import org.mariuszgromada.math.mxparser.*;
import android.annotation.SuppressLint;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;



public class MainActivity extends AppCompatActivity {

    Button plus, minus, multiply, division, floatt, all_clear, equal_to, one, two, three, four, five, six, seven, eight, nine, zero,dot,parenthesis;
    ImageButton imageButton;
    EditText display;




    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        plus = findViewById(R.id.plus);
        parenthesis=findViewById(R.id.bracket);
        minus = findViewById(R.id.substraction);
        multiply = findViewById(R.id.multiply);
        division = findViewById(R.id.division);
        floatt = findViewById(R.id.floatvalue);
        all_clear = findViewById(R.id.allclearr);
        equal_to = findViewById(R.id.equalto);
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);
        zero = findViewById(R.id.zero);
        dot=findViewById(R.id.dot);
        imageButton = findViewById(R.id.cross);
        display = findViewById(R.id.editTextTextPersonName);

        display.setShowSoftInputOnFocus(false);



    }
        private void updateText (String strToadd){

            String oldString = display.getText().toString();
            int cursorPos=display.getSelectionStart();
            String leftstr = oldString.substring(0,cursorPos);
            String rightstr = oldString.substring(cursorPos);

                display.setText(String.format("%s%s%s", leftstr,rightstr,strToadd));
                display.setSelection(cursorPos + 1);


        }


        public void plus(View view){
            updateText("+");
        }
        public void minus(View view){
            updateText("-");
        }
        public void multiply(View view){
            updateText("×");
        }
        public void division(View view){
            updateText("÷");
        }
        public void floatt(View view){
            updateText("%");
        }
        public void equal_to (View view){

            String userExp =display.getText().toString();
            userExp=userExp.replaceAll("÷","/");
            userExp=userExp.replaceAll("×","*");
            Expression exp=new Expression(userExp);
            String result=String.valueOf(exp.calculate());
            display.setText(result);
            display.setSelection(result.length());

        }
        public void dot (View view){
            updateText(".");
        }
        public void zero (View view){
            updateText("0");
        }
        public void one (View view){
            updateText("1");
        }
        public void two (View view){
            updateText("2");
        }
        public void three (View view){
            updateText("3");
        }
        public void four (View view){
            updateText("4");
        }
        public void five (View view){
            updateText("5");
        }
        public void six (View view){
            updateText("6");
        }
        public void seven (View view){
            updateText("7");
        }
        public void eight (View view){
            updateText("8");
        }
        public void nine (View view){
            updateText("9");
        }
        public void all_clear (View view){
            display.setText("");
        }
        public void bracket(View view)
        {
            int cursorPos=display.getSelectionStart();
            int openBracket=0;
            int closedBracket=0;
            int textLen=display.getText().length();

            for(int i=0;i<cursorPos;i++) {
                if (display.getText().toString().charAt(i) == '(') {
                    openBracket += 1;

                }
                if (display.getText().toString().charAt(i) == ')') {
                    closedBracket += 1;
                }
            }
            if((openBracket == closedBracket) || (display.getText().toString().charAt(textLen - 1) == '(')) {
                updateText("(");

            }
            else   if((closedBracket<openBracket) & display.getText().toString().charAt(textLen - 1) != ')'){
                updateText(")");
         }
            else if(openBracket>closedBracket){
                updateText(")");
            }

            display.setSelection(cursorPos+1);


        }
        public void back(View view){

        int cursorPOs=display.getSelectionStart();
        int textlen=display.getText().length();

        if((cursorPOs !=0) && (textlen !=0)){
            SpannableStringBuilder selection= (SpannableStringBuilder) display.getText();
            selection.replace(cursorPOs-1,cursorPOs,"");
            display.setText(selection);
            display.setSelection(cursorPOs-1);

        }

        }



    }
