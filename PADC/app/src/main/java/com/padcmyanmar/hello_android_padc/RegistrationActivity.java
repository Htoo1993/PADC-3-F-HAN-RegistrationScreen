package com.padcmyanmar.hello_android_padc;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

/**
 * Created by htoo on 11/13/2017.
 */

public class RegistrationActivity extends AppCompatActivity {

    private TextView btnToLogin;
    private EditText etName;
    private EditText etPhone;
    private EditText etEmail;
    private EditText etPassword;
    private EditText etConfirm_password;
    private EditText etAddress;
    private CheckBox chkIAmAtHome;
    private RadioButton rdoMale;
    private RadioButton rdoFemale;
    private Button btnRegister;

    public static Intent RegistrationIntent(Context context){
        Intent intent = new Intent(context, RegistrationActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_seller_register);

        btnToLogin = findViewById(R.id.btn_to_login);
        etName = findViewById(R.id.et_name);
        etPhone = findViewById(R.id.et_phone);
        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_password);
        etConfirm_password = findViewById(R.id.et_confirm_password);
        etAddress = findViewById(R.id.et_address);
        chkIAmAtHome = findViewById(R.id.chk_i_am_at_my_home);
        rdoMale = findViewById(R.id.rdo_male);
        rdoFemale = findViewById(R.id.rdo_female);
        btnRegister = findViewById(R.id.btn_register);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strCanNotBeEmpty = "can not be empty.";

                String name = etName.getText().toString();
                String phone = etPhone.getText().toString();
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();
                String confirmPassword = etConfirm_password.getText().toString();
                String address = etAddress.getText().toString();

                if(TextUtils.isEmpty(name)){
                    etName.setError("Name " + strCanNotBeEmpty);
                    return;
                }

                if(TextUtils.isEmpty(phone)){
                    etPhone.setError("Phone " + strCanNotBeEmpty);
                    return;
                }

                if(TextUtils.isEmpty(email)){
                    etEmail.setError("Email " + strCanNotBeEmpty);
                    return;
                }

                if(TextUtils.isEmpty(password)){
                    etPassword.setError("Password " + strCanNotBeEmpty);
                    return;
                }

                if(TextUtils.isEmpty(confirmPassword)){
                    etConfirm_password.setError("Confirm password " + strCanNotBeEmpty);
                    return;
                }

                if(TextUtils.isEmpty(address)){
                    etAddress.setError("Address " + strCanNotBeEmpty);
                    return;
                }

                if(!(rdoMale.isChecked() || rdoFemale.isChecked())){
                    Snackbar.make(v, "Please select Male or Female.", Snackbar.LENGTH_INDEFINITE).show();
                    return;
                }

                if(TextUtils.equals(password, confirmPassword)){
                    Intent intent = LoginActivity.newLoginActivityIntent(getApplicationContext());
                    startActivity(intent);
                } else {
                    Snackbar.make(v, "Password and confirm password must be same.", Snackbar.LENGTH_INDEFINITE).show();
                }

//                Toast.makeText(getApplicationContext(),"Register button click.", Toast.LENGTH_SHORT).show();
            }
        });

        btnToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = LoginActivity.newLoginActivityIntent(getApplicationContext());
                startActivity(intent);
            }
        });

    }
}
