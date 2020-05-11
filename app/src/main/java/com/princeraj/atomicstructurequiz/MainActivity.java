package com.princeraj.atomicstructurequiz;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Calculate the total score
     *
     * @return score
     */
    private int calculateScore() {
        int score = 0;

        RadioButton ans1RadioButton = findViewById(R.id.ans1_radio_button);
        // if answer radio button is check add 1 in score
        if (ans1RadioButton.isChecked()) {
            score++;
        }

        CheckBox ans1CheckBok = findViewById(R.id.ans1_check_bok);
        CheckBox ans2CheckBok = findViewById(R.id.ans2_check_bok);
        CheckBox ans3CheckBok = findViewById(R.id.ans3_check_bok);
        CheckBox ans4CheckBok = findViewById(R.id.ans4_check_bok);
        // If ans1, ans3, ans4 are check and ans2 are not check add 1 in score
        if ((ans1CheckBok.isChecked() && ans3CheckBok.isChecked() && ans4CheckBok.isChecked()) &&
                !ans2CheckBok.isChecked()) {
            score++;
        }

        RadioButton ans2RadioButton = findViewById(R.id.ans2_radio_button);
        // if answer radio button is check add 1 in score
        if (ans2RadioButton.isChecked()) {
            score++;
        }

        EditText editText = findViewById(R.id.edit_text);
        String userInput = editText.getText().toString();
        // If userInput is equal to "gold" add 1 in score
        if (userInput.equalsIgnoreCase(getString(R.string.T4_Ans))) {
            score++;
        }
        return score;
    }

    public void submitAnswer(View view) {
        int score = calculateScore();
        String totalScore = getString(R.string.score_0) + " " + score;
        Toast.makeText(this, totalScore, Toast.LENGTH_SHORT).show();
    }
}
