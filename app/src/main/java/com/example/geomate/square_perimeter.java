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

public class square_perimeter extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_square_perimeter, container, false);

        EditText side = view.findViewById(R.id.side);
        Button button = view.findViewById(R.id.calculate);
        TextView perimeter_result = view.findViewById(R.id.perimeter_result);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String side_str = side.getText().toString();

                if (TextUtils.isEmpty(side_str)) {
                    side.setError("Enter Side Number");
                    side.requestFocus();
                } else {
                    double side_value = Double.parseDouble(side_str);
                    if (side_value <= 0) {
                        Toast.makeText(getContext(), "Invalid Input. Please enter valid values.", Toast.LENGTH_SHORT).show();
                    } else {
                        double perimeter = calculateSquarePerimeter(side_value);
                        DecimalFormat decimalFormat = new DecimalFormat("Perimeter:  0.00");
                        String formattedPerimeter = decimalFormat.format(perimeter);
                        perimeter_result.setText(formattedPerimeter);
                    }
                }
            }
        });

        return view;
    }

    private double calculateSquarePerimeter(double radius_input) {
        return 4 * radius_input;
    }
}
