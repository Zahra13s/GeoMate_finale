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

public class circle_perimeter extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_circle_perimeter, container, false);
        EditText radius = view.findViewById(R.id.radius);
        Button button = view.findViewById(R.id.circle_perimeter_calculate);
        TextView perimeter_result = view.findViewById(R.id.circle_perimeter_result);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String radius_str = radius.getText().toString();

                if (TextUtils.isEmpty(radius_str)) {
                    radius.setError("Enter radius Number");
                    radius.requestFocus();
                } else {
                    double radius_value = Double.parseDouble(radius_str);
                    if (radius_value <= 0) {
                        Toast.makeText(getContext(), "Invalid Input. Please enter valid values.", Toast.LENGTH_SHORT).show();
                    } else {
                        double perimeter = calculateCirclePerimeter(radius_value);
                        DecimalFormat decimalFormat = new DecimalFormat("Perimeter: 0.00");
                        String formattedPerimeter = decimalFormat.format(perimeter);
                        perimeter_result.setText(formattedPerimeter);
                    }
                }
            }
        });

        return view;
    }

    private double calculateCirclePerimeter(double radiusLength) {
        return 2 * Math.PI * radiusLength;
    }
}
