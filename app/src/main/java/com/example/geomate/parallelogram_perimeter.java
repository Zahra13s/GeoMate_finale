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

public class parallelogram_perimeter extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_parallelogram_perimeter, container, false);
        EditText length = view.findViewById(R.id.length);
        EditText width = view.findViewById(R.id.width);
        Button button = view.findViewById(R.id.calculate);
        TextView perimeter_result = view.findViewById(R.id.perimeter_result);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String length_str = length.getText().toString();
                String width_str = width.getText().toString();

                if (TextUtils.isEmpty(length_str)) {
                    length.setError("Enter Side 1 Number");
                    length.requestFocus();
                } else if (TextUtils.isEmpty(width_str)) {
                    width.setError("Enter Side 2 Number");
                    width.requestFocus();
                } else {
                    double length_value = Double.parseDouble(length_str);
                    double width_value = Double.parseDouble(width_str);
                    if (length_value <= 0 || width_value <= 0) {
                        Toast.makeText(getContext(), "Invalid Input. Please enter valid values.", Toast.LENGTH_SHORT).show();
                    } else {
                        double perimeter = calculateParallelogramPerimeter(length_value, width_value);
                        DecimalFormat decimalFormat = new DecimalFormat("Perimeter: 0.00");
                        String formattedPerimeter = decimalFormat.format(perimeter);
                        perimeter_result.setText(formattedPerimeter);
                    }
                }
            }
        });

        return view;
    }

    private double calculateParallelogramPerimeter(double lengthLength, double widthLength) {
        return 2 * (lengthLength + widthLength);
    }
}
