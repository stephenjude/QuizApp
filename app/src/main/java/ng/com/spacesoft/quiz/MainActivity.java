package ng.com.spacesoft.quiz;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RadioButton option1A, option1B, option2A, option2B, option3A, option3B, option4A,
            option4B, option7A, option7B, option8A, option8B;
    private CheckBox option5A, option5B, option5C, option5D;
    private EditText answer6, answer9, answer0;
    private RelativeLayout quizLayout, resultLayout;
    private TextView scoreView, commentView;
    private Button closeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setup();
    }

    private void setup() {

        // initialize Floating Action Button
        FloatingActionButton submitButtom = (FloatingActionButton) findViewById(R.id.submit_button);
        submitButtom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideKeyboard(quizLayout);
                boolean answerIsComplete = validateAnswers();
                if (answerIsComplete){
                    showResult();
                }
            }
        });

        //initialize close button
        closeButton = (Button) findViewById(R.id.close_button);
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //initialize layouts
        quizLayout = (RelativeLayout) findViewById(R.id.quiz_layout);
        resultLayout = (RelativeLayout) findViewById(R.id.result_layout);

        //initialize textviews
        scoreView = (TextView) findViewById(R.id.score);
        commentView = (TextView) findViewById(R.id.comment);

        // initialize radio buttons
        option1A = (RadioButton) findViewById(R.id.answer_a_ques_1);
        option1B = (RadioButton) findViewById(R.id.answer_b_ques_1);

        option2A = (RadioButton) findViewById(R.id.answer_a_ques_2);
        option2B = (RadioButton) findViewById(R.id.answer_b_ques_2);

        option3A = (RadioButton) findViewById(R.id.answer_a_ques_3);
        option3B = (RadioButton) findViewById(R.id.answer_b_ques_3);

        option4A = (RadioButton) findViewById(R.id.answer_a_ques_4);
        option4B = (RadioButton) findViewById(R.id.answer_b_ques_4);

        option7A = (RadioButton) findViewById(R.id.answer_a_ques_7);
        option7B = (RadioButton) findViewById(R.id.answer_b_ques_7);

        option8A = (RadioButton) findViewById(R.id.answer_a_ques_8);
        option8B = (RadioButton) findViewById(R.id.answer_b_ques_8);

        // initialize checkbox
        option5A = (CheckBox) findViewById(R.id.answer_a_ques_5);
        option5B = (CheckBox) findViewById(R.id.answer_b_ques_5);
        option5C = (CheckBox) findViewById(R.id.answer_c_ques_5);
        option5D = (CheckBox) findViewById(R.id.answer_d_ques_5);

        // initialize EditText
        answer0 = (EditText) findViewById(R.id.answer_ques_0);
        answer6 = (EditText) findViewById(R.id.answer_ques_6);
        answer9 = (EditText) findViewById(R.id.answer_ques_9);

    }

    private void showResult() {
        int score = calculateScore();
        String message = "";
        if(score < 3){
            message = "You will need to repeat this quiz!!!";
        }else if(score < 6){
            message = "You can do better next time!";
        }else if(score < 8){
            message = "Good, a little push is all you need!";
        }else if(score < 10){
            message = "You are almost there, keep it up!";
        }else{
            message = "You did it, kudos!";
        }
        scoreView.setText("Your Score is "+score);
        commentView.setText(message);
        quizLayout.setVisibility(View.GONE);
        resultLayout.setVisibility(View.VISIBLE);
    }

    private void hideKeyboard(View view) {
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)this.getSystemService(this.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    private boolean validateAnswers() {
        if (!option1A.isChecked() && !option1B.isChecked()) {
            showToastMessage("Question 1 have not been answered");
            return false;
        }

        if (!option2A.isChecked() && !option2B.isChecked()) {
            showToastMessage("Question 2 have not been answered");
            return false;
        }

        if (answer0.getText().toString().isEmpty()) {
            showToastMessage("Question 3 have not been answered");
            return false;
        }

        if (!option3A.isChecked() && !option3B.isChecked()) {
            showToastMessage("Question 4 have not been answered");
            return false;
        }

        if (!option5A.isChecked() && !option5B.isChecked() && !option5C.isChecked() && !option5C.isChecked()) {
            showToastMessage("Question 5 have not been answered");
            return false;
        }

        if (!option4A.isChecked() && !option4B.isChecked()) {
            showToastMessage("Question 6 have not been answered");
            return false;
        }

        if (answer6.getText().toString().isEmpty()) {
            showToastMessage("Question 7 have not been answered");
            return false;
        }

        if (!option7A.isChecked() && !option7B.isChecked()) {
            showToastMessage("Question 8 have not been answered");
            return false;
        }

        if (!option8A.isChecked() && !option8B.isChecked()) {
            showToastMessage("Question 9 have not been answered");
            return false;
        }

        if (answer9.getText().toString().isEmpty()) {
            showToastMessage("Question 10 have not been answered");
            return false;
        }

        return true;
    }

    private void showToastMessage(String message) {
        Toast toast = Toast.makeText(this, message,Toast.LENGTH_LONG);
        toast.show();
    }

    private int calculateScore(){
        int score = 0;
        if(option1A.isChecked()){
            score+= 1;
        }

        if(option1A.isChecked()){
            score+= 1;
        }

        if(option2A.isChecked()){
            score+= 1;
        }

        if(option3B.isChecked()){
            score+= 1;
        }

        if(option4B.isChecked()){
            score+= 1;
        }

        if(option7B.isChecked()){
            score+= 1;
        }

        if(option8A.isChecked()){
            score+= 1;
        }

        if(!option5C.isChecked()){
            score+= 1;
        }

        boolean answer3 = answer0.getText()
                .toString().toLowerCase()
                .equals(getString(R.string.option_of_ques_0).toLowerCase());
        if(answer3){
            score+= 1;
        }

        boolean answer7 = answer6.getText()
                .toString().toLowerCase()
                .equals(getString(R.string.option_of_ques_6).toLowerCase());

        if(answer7){
            score+= 1;
        }

        boolean answer10 = answer9.getText()
                .toString().toLowerCase()
                .equals(getString(R.string.option_of_ques_9).toLowerCase());
        if(answer10){
            score+= 1;
        }

        return score;
    }
}
