package com.padcmyanmar.hello_android_padc;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

/**
 * Created by htoo on 11/5/2017.
 */

public class LoginActivity extends AppCompatActivity {

    //Constant Attribute
    private static final String CORRECT_EMAIL = "abc@gmail.com";
    private static final String CORRECT_PASSWORD = "Abcdefg";

    private Button btnLogin;
    private EditText etEmailOrPhone;
    private EditText etPasswrod;
    private TextView btnForgotPassword;
    private TextView btnNewSellerRegister;

    public static Intent newLoginActivityIntent(Context context){
        Intent intent = new Intent(context, LoginActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = findViewById(R.id.btn_login);
        etEmailOrPhone = findViewById(R.id.et_email_or_phone);
        etPasswrod = findViewById(R.id.et_password);
        btnForgotPassword = findViewById(R.id.btn_forget_password);
        btnNewSellerRegister = findViewById(R.id.btn_new_seller_register);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailOrPhone = etEmailOrPhone.getText().toString();
                String password = etPasswrod.getText().toString();

                if(TextUtils.isEmpty(emailOrPhone)){
                    etEmailOrPhone.setError("Email or phone cannot be empty.");
                    return;
                }

                if (TextUtils.isEmpty(password)){
                    etPasswrod.setError("Password cannot be empty.");
                    return;
                }

                if(TextUtils.equals(emailOrPhone, CORRECT_EMAIL)
                        && TextUtils.equals(password, CORRECT_PASSWORD)){
//                    Toast.makeText(getApplicationContext(), "Login Success", Toast.LENGTH_LONG).show();
                    Intent intent = HelloAndroidActivity.newIntent(getApplicationContext());
                    startActivity(intent);

                } else {
                    Snackbar.make(v, "Incorrect email or password. Please try again.",
                            Snackbar.LENGTH_INDEFINITE).show();
                }

//                Snackbar.make(v, "Login button click", Snackbar.LENGTH_SHORT).setAction("Action",null).show();
            }
        });

        btnForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "\"Forgot Password\" is coming soon.", Snackbar.LENGTH_INDEFINITE).show();
            }
        });

        btnNewSellerRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = RegistrationActivity.RegistrationIntent(getApplicationContext());
                startActivity(intent);
//                Snackbar.make(v, "Registration Screen is coming soon.", Snackbar.LENGTH_INDEFINITE).show();
            }
        });

    }
}
