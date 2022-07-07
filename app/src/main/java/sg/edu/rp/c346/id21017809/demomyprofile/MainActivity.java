package sg.edu.rp.c346.id21017809.demomyprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    EditText etGPA;
    RadioGroup rgGender;
    //Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.editTextName);
        etGPA = findViewById(R.id.editTextGPA);
        rgGender = findViewById(R.id.radioGroupGender);
        //btnSave = findViewById(R.id.buttonSave);
    }
//Storing data
        @Override
        protected void onStop() {
            super.onStop();

            //what goes in here? grab input & store into SharedPreferences
            String strName = etName.getText().toString();
            float GPA = Float.parseFloat(etGPA.getText().toString());
            String gender;
            if (rgGender.getCheckedRadioButtonId() == R.id.radioButtonGenderFemale){
                gender = "Female";
            } else {
                gender = "Male";
            }

            SharedPreferences prefs = getPreferences(MODE_PRIVATE);
            SharedPreferences.Editor prefEdit = prefs.edit();
            prefEdit.putString("name", strName);
            prefEdit.putFloat("gpa", GPA);
            prefEdit.putString("gender", gender);
            prefEdit.commit();

    }
        @Override
        protected void onResume() {
            super.onResume();
            SharedPreferences prefs = getPreferences(MODE_PRIVATE);
            String strName = prefs.getString("name", "Jenny");
            float GPA = prefs.getFloat("gpa", 0);
            String gender = prefs.getString("gender", "Female");
            etName.setText(strName);
            etGPA.setText(GPA + "");

            if (gender.equals("Female") ){
                rgGender.check(R.id.radioButtonGenderFemale);
            } else if ( gender.equals("Male") ){
                rgGender.check(R.id.radioButtonGenderMale);
            }
        }
}