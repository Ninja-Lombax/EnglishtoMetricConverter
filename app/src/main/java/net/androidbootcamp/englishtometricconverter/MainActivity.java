package net.androidbootcamp.englishtometricconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity {
    public static final double metricConversion[] = {.9144, 1.60934, 2.54, 1.60934, 3.78541, .453592}; // ydToMeters = .9144, milesToKM = 1.60934, inchesToCM = 2.54, mphToKmh = 1.60934, gallonToLiters = 3.78541, lbsToKgs = .453592;
    double userMeasurementInput;
    int userSelectionIndex;
    double total;
    String totalMeasurement;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText userNumber = (EditText)findViewById(R.id.txtUserNumber);
        final Spinner measurement = (Spinner)findViewById(R.id.txtMeasurement);
        Button conversion = (Button)findViewById(R.id.btnConversion);


        conversion.setOnClickListener(new View.OnClickListener() {
            //final TextView result = ((TextView)findViewById(R.id.txtResult));
            final TextView result = (EditText)findViewById(R.id.txtResult);
            //final TextView result = ((TextView)findViewById(R.id.txtSpi));
            @Override
            public void onClick(View v) {
                userMeasurementInput = Float.parseFloat(userNumber.getText().toString());
                userSelectionIndex = measurement.getSelectedItemPosition();
                total = userMeasurementInput * metricConversion[userSelectionIndex];
                //measurement.getSelectedItemId()
                //totalMeasurement = total.toString();
                String totalMeasurement = new Double(total).toString();

                result.setText(totalMeasurement);
            }
        });

    }
}
