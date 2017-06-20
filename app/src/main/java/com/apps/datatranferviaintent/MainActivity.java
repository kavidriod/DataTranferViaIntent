package com.apps.datatranferviaintent;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText phoneNoEditeText,nameEditeText;
    TextInputLayout nameTextInputLayout,phoneNoTextInputLayout;
    Button startIntentButton;

    String name;
    int phoneNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEditeText = (EditText) findViewById(R.id.nameEditeText);
        phoneNoEditeText = (EditText) findViewById(R.id.phoneNoEditeText);
        startIntentButton = (Button) findViewById(R.id.startIntentButton);

        nameTextInputLayout  = (TextInputLayout) findViewById(R.id.nameTextInputLayout);
        phoneNoTextInputLayout  = (TextInputLayout) findViewById(R.id.phoneNoTextInputLayout);

        nameEditeText.addTextChangedListener(new TextWatcher(nameEditeText));
        phoneNoEditeText.addTextChangedListener(new TextWatcher(phoneNoEditeText));

        startIntentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startIntent();
            }
        });

    }

    private void startIntent() {
        if (!validateNameEditText()){
             return;
        }

        if (!validatephoneNoEditeText()){
            return;
        }

        phoneNo = Integer.parseInt(phoneNoEditeText.getText().toString());
        name = nameEditeText.getText().toString();


        Intent in = new Intent(MainActivity.this,SecondActivity.class);
        in.putExtra("NAME",name);
        in.putExtra("PHONENO",phoneNo);
        startActivity(in);
    }

    class  TextWatcher implements android.text.TextWatcher{

        View view;

        public  TextWatcher(View view){
            this.view = view;
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
  switch (view.getId()){
      case  R.id.nameEditeText:
          validateNameEditText();
          break;
      case  R.id.phoneNoEditeText:
          validatephoneNoEditeText();
          break;
  }
        }
    }

    private boolean validateNameEditText() {
        if (nameEditeText.getText().toString().trim().isEmpty()){
            nameTextInputLayout.setError("Please Enter Name");
            requestFocus(nameEditeText);
            return  false;
        }else {
            nameTextInputLayout.setErrorEnabled(false);
        }
        return true;
    }

    private void requestFocus(View view) {
if (view.requestFocus()){
    getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
}

    }


    private boolean validatephoneNoEditeText() {
 if (phoneNoEditeText.getText().toString().trim().isEmpty()){
     phoneNoTextInputLayout.setError("Please Enter Phone Number");
     requestFocus(phoneNoEditeText);
     return false;
 }else {
     phoneNoTextInputLayout.setErrorEnabled(false);
 }
        return true;
    }
}
