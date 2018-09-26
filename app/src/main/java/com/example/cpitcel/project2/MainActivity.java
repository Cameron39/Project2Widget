package com.example.cpitcel.project2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.SeekBar;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final java.util.Random Random = new Random();
    Button theButton, btnValue;
    TextView lbltheButton, lbltheChkBox, lbltheSwitch, lbltheRB, lbltheWhiteCastle, txtValue;
    CheckBox theChkBox;
    Switch theSwitch;
    RadioButton theRB1, theRB2, theRB3;
    SeekBar theWhiteCastle;
    EditText txtInput;
    Integer btnPressCNT = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        theButton = findViewById(R.id.btn1);
        lbltheButton = findViewById(R.id.btnText);
        theChkBox = findViewById(R.id.chbx1);
        lbltheChkBox = findViewById(R.id.chbxText);
        theSwitch = findViewById(R.id.switch1);
        lbltheSwitch = findViewById(R.id.swtchText);
        theRB1 = findViewById(R.id.rdB1);
        theRB2 = findViewById(R.id.rdB2);
        theRB3 = findViewById(R.id.rdB3);
        lbltheRB = findViewById(R.id.rdBText);
        theWhiteCastle = findViewById(R.id.skBr1);
        lbltheWhiteCastle = findViewById(R.id.skBrText);
        btnValue = findViewById(R.id.btlLblUpdate);
        txtInput = findViewById(R.id.txtVInput);
        txtValue = findViewById(R.id.txtVOutput);

        theButton.requestFocus();
        theWhiteCastle.setProgress(Random.nextInt(101));
        lbltheWhiteCastle.setText(String.valueOf(theWhiteCastle.getProgress()));


        theChkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    lbltheChkBox.setText("Checked");
                } else {
                    lbltheChkBox.setText("Not Checked");
                }
            }
        });

        theSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    lbltheSwitch.setText("On");
                } else {
                    lbltheSwitch.setText("Off");
                }
            }
        });

        theRB1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    lbltheRB.setText("Radio 1 Selected");
                }
            }
        });

        theRB2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    lbltheRB.setText("Radio 2 Selected");
                }
            }
        });

        theRB3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    lbltheRB.setText("Radio 3 Selected");
                }
            }
        });

        theWhiteCastle.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                lbltheWhiteCastle.setText(String.valueOf(theWhiteCastle.getProgress()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //theWhiteCastle.setBackgroundColor(getResources().getColor(android.R.color.holo_red_dark));
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //theWhiteCastle.setBackgroundColor(getResources().getColor(android.R.color.white));
            }
        });

    }

    public void btn1Pressed (View view){
        if (lbltheButton.getText().toString().toLowerCase().contains("pressed")) {
            btnPressCNT++;
            lbltheButton.setText(TextUtils.concat("Button Pressed: ", btnPressCNT.toString()));
        } else {
            lbltheButton.setText("Button Pressed");
            btnPressCNT++;
        }
    }

    public void btnValuePressed (View view) {
        if (!TextUtils.isEmpty(txtInput.getText().toString())) {
            txtValue.setText(txtInput.getText());
        } else {
            txtValue.setText("Enter a Value");
        }
    }
}
