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

public class triangle_perimeter extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_triangle_perimeter, container, false);
        EditText base = view.findViewById(R.id.base);
        EditText side1 = view.findViewById(R.id.side1);
        EditText side2 = view.findViewById(R.id.side2);
        Button button = view.findViewById(R.id.calculate);
        TextView perimeter_result = view.findViewById(R.id.perimeter_result);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String base_str = base.getText().toString();
                String side1_str = side1.getText().toString();
                String side2_str = side2.getText().toString();

                if (TextUtils.isEmpty(base_str)) {
                    base.setError("Enter Length");
                    base.requestFocus();
                } else if (TextUtils.isEmpty(side1_str)) {
                    side1.setError("Enter Width");
                    side1.requestFocus();
                } else if (TextUtils.isEmpty(side2_str)) {
                    side2.setError("Enter Width");
                    side2.requestFocus();
                } else {
                    double base_value = Double.parseDouble(base_str);
                    double side1_value = Double.parseDouble(side1_str);
                    double side2_value = Double.parseDouble(side2_str);
                    if (base_value <= 0 || side1_value <= 0 || side2_value <= 0) {
                        Toast.makeText(getContext(), "Invalid Input. Please enter valid values.", Toast.LENGTH_SHORT).show();
                    } else {
                        double perimeter = calculateTrianglePerimeter(base_value, side1_value, side2_value);
                        DecimalFormat decimalFormat = new DecimalFormat("Perimeter: 0.00");
                        String formattedPerimeter = decimalFormat.format(perimeter);
                        perimeter_result.setText(formattedPerimeter);
                    }
                }
            }
        });

        return view;
    }

    private double calculateTrianglePerimeter(double base, double side1, double side2) {
        return base + side1 + side2;
    }
}
