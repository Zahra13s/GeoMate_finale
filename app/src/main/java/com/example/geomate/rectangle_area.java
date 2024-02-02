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

public class rectangle_area extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_rectangle_area, container, false);
        EditText length = view.findViewById(R.id.length);
        EditText width = view.findViewById(R.id.width);
        Button button = view.findViewById(R.id.calculate);
        TextView area_result = view.findViewById(R.id.area_result);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String length_str = length.getText().toString();
                String width_str = width.getText().toString();

                if (TextUtils.isEmpty(length_str)) {
                    length.setError("Enter Length");
                    length.requestFocus();
                } else if (TextUtils.isEmpty(width_str)) {
                    width.setError("Enter Width");
                    width.requestFocus();
                } else {
                    double length_value = Double.parseDouble(length_str);
                    double width_value = Double.parseDouble(width_str);
                    if (length_value <= 0 || width_value <= 0) {
                        Toast.makeText(getContext(), "Invalid Input. Please enter valid values.", Toast.LENGTH_SHORT).show();
                    } else {
                        double area = calculateRectangleArea(length_value, width_value);
                        DecimalFormat decimalFormat = new DecimalFormat("Area: 0.00");
                        String formattedArea = decimalFormat.format(area);
                        area_result.setText(formattedArea);
                    }
                }
            }
        });

        return view;
    }

    private double calculateRectangleArea(double length, double width) {
        return length * width;
    }
}
