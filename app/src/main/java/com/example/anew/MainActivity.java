package com.example.anew;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private EditText emailEditText;
    private EditText passwordEditText;
    private TextView welcomeTextView;
    private TextView bottomTextView;
    private TextView hintTextView;
    private TextView enter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        emailEditText = findViewById(R.id.email);
        passwordEditText = findViewById(R.id.password);
        welcomeTextView = findViewById(R.id.welcome);
        bottomTextView = findViewById(R.id.bottomTextView);
        hintTextView = findViewById(R.id.hint);
        enter = findViewById(R.id.enter);

        emailEditText.addTextChangedListener(textWatcher);
        passwordEditText.addTextChangedListener(textWatcher);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkCredentials();
            }
        });
    }

    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        @Override
        public void afterTextChanged(Editable editable) {
            boolean isEmailFilled = emailEditText.getText().length() > 0;
            boolean isPasswordFilled = passwordEditText.getText().length() > 0;

            if (isEmailFilled && isPasswordFilled) {
                button.setBackgroundColor(Color.parseColor("#935600"));
            } else {
                button.setBackgroundColor(Color.parseColor("#CCCCCC"));
            }
        }
    };

    private void checkCredentials() {
        String enteredEmail = emailEditText.getText().toString();
        String enteredPassword = passwordEditText.getText().toString();

        if (enteredEmail.equals("admin") && enteredPassword.equals("admin")) {
            showWelcomeMessage();
        } else {
            showErrorMessage();
        }
    }

    private void showWelcomeMessage() {
        emailEditText.setVisibility(View.GONE);
        passwordEditText.setVisibility(View.GONE);
        button.setVisibility(View.GONE);
        welcomeTextView.setVisibility(View.VISIBLE);
        bottomTextView.setVisibility(View.GONE);
        hintTextView.setVisibility(View.GONE);
        enter.setVisibility(View.GONE);
        welcomeTextView.setText("Добро пожаловать!");
    }

    private void showErrorMessage() {
        Toast.makeText(this, "Неправильный логин и пароль", Toast.LENGTH_SHORT).show();
    }
}
