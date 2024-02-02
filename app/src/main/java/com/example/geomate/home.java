package com.example.geomate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class home extends AppCompatActivity {
    //declare
    private ImageButton circleButton, squareButton, rhombusButton, rectangleButton, parallelogramButton, trapezoidButton, triangleButton, rightTriangleButton, sphereButton, cubeButton, rectanglePrismButton, pyramidButton, coneButton, cylinderButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        //search button with id
        circleButton = findViewById(R.id.circle);
        squareButton = findViewById(R.id.square);
        rhombusButton = findViewById(R.id.rhombus);
        rectangleButton = findViewById(R.id.rectangle);
        parallelogramButton = findViewById(R.id.parallelogram);
        trapezoidButton = findViewById(R.id.trapezoid);
        triangleButton = findViewById(R.id.triangle);
        rightTriangleButton = findViewById(R.id.right_triangle);
        sphereButton = findViewById(R.id.sphere);
        cubeButton = findViewById(R.id.cube);
        rectanglePrismButton = findViewById(R.id.rectangle_prism);
        pyramidButton = findViewById(R.id.pyramid);
        coneButton = findViewById(R.id.cone);
        cylinderButton = findViewById(R.id.cylinder);
        //click listeners for circle
        circleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCalculations("circle");
            }
        });
        //click listeners for square
        squareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCalculations("square");
            }
        });
        //click listeners for rhombus
        rhombusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCalculations("rhombus");
            }
        });
        //click listeners for rectangle
        rectangleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCalculations("rectangle");
            }
        });
        //click listeners for parallelogram
        parallelogramButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCalculations("parallelogram");
            }
        });
        //click listeners for trapezoid
        trapezoidButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCalculations("trapezoid");
            }
        });
        //click listeners for triangle
        triangleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCalculations("triangle");
            }
        });
        //click listeners for right triangle
        rightTriangleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCalculations("right triangle");
            }
        });
        //click listeners for sphere
        sphereButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCalculations("sphere");
            }
        });

        //click listeners for cube
        cubeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCalculations("cube");
            }
        });

        //click listeners for rectangle prism
        rectanglePrismButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCalculations("rectangle prism");
            }
        });
        //click listeners for pyramid
        pyramidButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCalculations("pyramid");
            }
        });
        //click listeners for cone
        coneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCalculations("cone");
            }
        });
        //click listeners for cylinder
        cylinderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCalculations("cylinder");
            }
        });
    }

    public void openCalculations(String shape) {
        Intent intent = null;

        switch (shape) {
            case "circle":
                intent = new Intent(this, circle.class);
                break;
            case "square":
                intent = new Intent(this, square.class);
                break;
            case "rhombus":
                intent = new Intent(this, rhombus.class);
                break;
            case "rectangle":
                intent = new Intent(this, rectangle.class);
                break;
            case "parallelogram":
                intent = new Intent(this, parallelogram.class);
                break;
            case "trapezoid":
                intent = new Intent(this, trapezoid.class);
                break;
            case "triangle":
                intent = new Intent(this, triangle.class);
                break;
            case "right triangle":
                intent = new Intent(this, right_triangle.class);
                break;
            case "sphere":
                intent = new Intent(this, sphere.class);
                break;
            case "cube":
                intent = new Intent(this, cube.class);
                break;
            case "rectangle prism":
                intent = new Intent(this, rectangle_prism.class);
                break;
            case "pyramid":
                intent = new Intent(this, pyramid.class);
                break;
            case "cone":
                intent = new Intent(this, cone.class);
                break;
            case "cylinder":
                intent = new Intent(this, cylinder.class);
                break;
            default:
                intent=null;
        }

        if (intent != null) {
            startActivity(intent);
        }

    }
}