package com.example.geomate;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.text.DecimalFormat;

public class trapezoid_perimeter extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_trapezoid_perimeter, container, false);
        EditText base1 = view.findViewById(R.id.base1);
        EditText side1 = view.findViewById(R.id.side1);
        EditText base2 = view.findViewById(R.id.base2);
        EditText side2 = view.findViewById(R.id.side2);
        Button button = view.findViewById(R.id.calculate);
        TextView perimeter_result = view.findViewById(R.id.perimeter_result);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String base1_str = base1.getText().toString();
                String side1_str = side1.getText().toString();
                String base2_str = base2.getText().toString();
                String side2_str = side2.getText().toString();

                if (TextUtils.isEmpty(side1_str)) {
                    side1.setError("Enter Side 1 Number");
                    side1.requestFocus();
                } else if (TextUtils.isEmpty(side2_str)) {
                    side2.setError("Enter Side 2 Number");
                    side2.requestFocus();
                } else if (TextUtils.isEmpty(base1_str)) {
                    base1.setError("Enter Base 1 Number");
                    base1.requestFocus();
                } else if (TextUtils.isEmpty(base2_str)) {
                    base2.setError("Enter Base 2 Number");
                    base2.requestFocus();
                } else {
                    double base1_value = Double.parseDouble(base1_str);
                    double side1_value = Double.parseDouble(side1_str);
                    double base2_value = Double.parseDouble(base2_str);
                    double side2_value = Double.parseDouble(side2_str);
                    if (side1_value <= 0 || side2_value <= 0 || base1_value <= 0 || base2_value <= 0) {
                        Toast.makeText(getContext(), "Invalid Input. Please enter valid positive values.", Toast.LENGTH_SHORT).show();
                    } else {
                        double perimeter = calculateTrapezoidPerimeter(base1_value, side1_value, base2_value, side2_value);
                        DecimalFormat decimalFormat = new DecimalFormat("Perimeter: 0.00");
                        String formattedPerimeter = decimalFormat.format(perimeter);
                        perimeter_result.setText(formattedPerimeter);
                    }
                }
            }
        });

        return view;
    }

    private double calculateTrapezoidPerimeter(double base1Length, double side1Length, double base2Length, double side2Length) {
        return base1Length + side1Length + base2Length + side2Length;
    }
}
