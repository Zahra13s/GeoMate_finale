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

public class rhombus_area extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_rhombus_area, container, false);

        EditText diagonal1 = view.findViewById(R.id.diagonal1);
        EditText diagonal2 = view.findViewById(R.id.diagonal2);
        Button button = view.findViewById(R.id.calculate);
        TextView area_result = view.findViewById(R.id.area_result);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String diagonal1_str = diagonal1.getText().toString();
                String diagonal2_str = diagonal2.getText().toString();

                if (TextUtils.isEmpty(diagonal1_str)) {
                    diagonal1.setError("Enter Diagonal 1 Number");
                    diagonal1.requestFocus();
                } else if (TextUtils.isEmpty(diagonal2_str)) {
                    diagonal2.setError("Enter Diagonal 2 Number");
                    diagonal2.requestFocus();
                } else {
                    double diagonal1_value = Double.parseDouble(diagonal1_str);
                    double diagonal2_value = Double.parseDouble(diagonal2_str);
                    if (diagonal1_value <= 0 || diagonal2_value <= 0) {
                        Toast.makeText(getContext(), "Invalid Input. Please enter valid values.", Toast.LENGTH_SHORT).show();
                    } else {
                        double area = calculateRhombusArea(diagonal1_value, diagonal2_value);
                        DecimalFormat decimalFormat = new DecimalFormat("Area: 0.00");
                        String formattedArea = decimalFormat.format(area);
                        area_result.setText(formattedArea);
                    }
                }
            }
        });

        return view;
    }

    private double calculateRhombusArea(double diagonal1Length, double diagonal2Length) {
        return (diagonal1Length * diagonal2Length) / 2.0;
    }
}
