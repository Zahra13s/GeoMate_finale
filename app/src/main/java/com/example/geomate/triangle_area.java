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

public class triangle_area extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_triangle_area, container, false);

        EditText base = view.findViewById(R.id.base);
        EditText height = view.findViewById(R.id.height);
        Button button = view.findViewById(R.id.calculate);
        TextView area_result = view.findViewById(R.id.area_result);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String base_str = base.getText().toString();
                String height_str = height.getText().toString();

                if (TextUtils.isEmpty(base_str)) {
                    base.setError("Enter Base");
                    base.requestFocus();
                } else if (TextUtils.isEmpty(height_str)) {
                    height.setError("Enter Height");
                    height.requestFocus();
                } else {
                    double base_value = Double.parseDouble(base_str);
                    double height_value = Double.parseDouble(height_str);
                    if (base_value <= 0 || height_value <= 0) {
                        Toast.makeText(getContext(), "Invalid Input. Please enter valid values.", Toast.LENGTH_SHORT).show();
                    } else {
                        double area = calculateTriangleArea(base_value, height_value);
                        DecimalFormat decimalFormat = new DecimalFormat("Area: 0.00");
                        String formattedArea = decimalFormat.format(area);
                        area_result.setText(formattedArea);
                    }
                }
            }
        });

        return view;
    }

    private double calculateTriangleArea(double baseLength, double heightLength) {
        return 0.5 * baseLength * heightLength;
    }
}
