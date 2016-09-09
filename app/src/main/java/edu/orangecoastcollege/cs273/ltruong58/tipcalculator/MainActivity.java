package edu.orangecoastcollege.cs273.ltruong58.tipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    final DecimalFormat  precision = new DecimalFormat("0.00");

    //Associate the controller with the needed views
    private EditText amountEditText;
    private TextView amountTextView;
    private TextView percentTextView;
    private TextView tipAmountTextView;
    private TextView totalAmountTextView;
    private SeekBar percentSeekBar;


    // Associate the controller with the needed model
    RestaurantBill currentBill = new RestaurantBill();

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Connect the controller with the widgets in our app
        amountEditText = (EditText) findViewById(R.id.amountEditText);
        amountTextView = (TextView) findViewById(R.id.amountTextView);
        percentTextView = (TextView) findViewById(R.id.percentTextView);
        tipAmountTextView = (TextView) findViewById(R.id.tipAmountTextView);
        totalAmountTextView = (TextView) findViewById(R.id.totalAmountTextView);
        percentSeekBar = (SeekBar) findViewById(R.id.percentSeekBar);

        // Define a listener for the amountEditText
        amountEditText.addTextChangedListener(amountTextChangedListener);

        // Define a listener for the percentSeekBar
        percentSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                currentBill.setTipPercent( (double) progress / 100.0);
                percentTextView.setText(String.valueOf(progress) + "%");
                tipAmountTextView.setText("$" + precision.format(currentBill.getTipAmount()));
                totalAmountTextView.setText("$" + precision.format(currentBill.getTotalAmount()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private TextWatcher amountTextChangedListener = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            // Do nothing
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            // Try to get the amount from amountEditText
            try {
                double amount = Double.parseDouble(charSequence.toString()) / 100.00;
                currentBill.setAmount(amount);
                amountTextView.setText("$" + precision.format(currentBill.getAmount()));
                tipAmountTextView.setText("$" + precision.format(currentBill.getTipAmount()));
                totalAmountTextView.setText("$" + precision.format(currentBill.getTotalAmount()));
            }
            catch(NumberFormatException e){
                amountEditText.setText("");
            }
        }

        @Override
        public void afterTextChanged(Editable editable) {
            // Do nothing
        }
    };
}
