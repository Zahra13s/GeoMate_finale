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

public class trapezoid_area extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_trapezoid_area, container, false);
        EditText base1 = view.findViewById(R.id.base1);
        EditText base2 = view.findViewById(R.id.base2);
        EditText height = view.findViewById(R.id.height);
        Button button = view.findViewById(R.id.calculate);
        TextView area_result = view.findViewById(R.id.area_result);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String base1_str = base1.getText().toString();
                String base2_str = base2.getText().toString();
                String height_str = height.getText().toString();

                if (TextUtils.isEmpty(base1_str)) {
                    base1.setError("Enter Base 1 Number");
                    base1.requestFocus();
                } else if (TextUtils.isEmpty(base2_str)) {
                    base2.setError("Enter Base 2 Number");
                    base2.requestFocus();
                } else if (TextUtils.isEmpty(height_str)) {
                    height.setError("Enter Height Number");
                    height.requestFocus();
                } else {
                    double base1_value = Double.parseDouble(base1_str);
                    double base2_value = Double.parseDouble(base2_str);
                    double height_value = Double.parseDouble(height_str);
                    if (base1_value <= 0 || base2_value <= 0 || height_value <= 0) {
                        Toast.makeText(getContext(), "Invalid Input. Please enter valid values.", Toast.LENGTH_SHORT).show();
                    } else {
                        double area = calculateTrapezoidArea(base1_value, base2_value, height_value);
                        DecimalFormat decimalFormat = new DecimalFormat("Area: 0.00");
                        String formattedArea = decimalFormat.format(area);
                        area_result.setText(formattedArea);
                    }
                }
            }
        });

        return view;
    }

    private double calculateTrapezoidArea(double base1Length, double base2Length, double heightLength) {
        return 0.5 * (base1Length + base2Length) * heightLength;
    }
}
