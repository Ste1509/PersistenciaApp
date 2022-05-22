package com.example.registration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Operation extends AppCompatActivity {

    private String salaryEmployee;
    private TextView txtBonus;
    private TextView txtLayoffs;
    private TextView txtHolidays;
    private TextView txtHealth;
    private TextView txtPension;
    private TextView txtCompensationBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operation);
        Intent intent = getIntent();
        salaryEmployee = intent.getStringExtra("salary");
        double salary = Double.parseDouble(salaryEmployee);
        txtBonus = findViewById(R.id.txtBonus);
        txtLayoffs = findViewById(R.id.txtLayoffs);
        txtHolidays = findViewById(R.id.txtVacation);
        txtHealth = findViewById(R.id.txtHealth);
        txtPension = findViewById(R.id.txtPension);
        txtCompensationBox = findViewById(R.id.txtCompensationBox);
        Double bonus = calculateBonus(salary);
        txtBonus.setText(bonus.toString());
        Double layoffs = calculateLayoffs(salary);
        txtLayoffs.setText(layoffs.toString());
        Double holidays = calculateHolidays(salary);
        txtHolidays.setText(holidays.toString());
        Double health = calculateHealth(salary);
        txtHealth.setText(health.toString());
        Double pension = calculatePension(salary);
        txtPension.setText(pension.toString());
        Double compensationBox = calculateCompensationBox(salary);
        txtCompensationBox.setText(compensationBox.toString());
    }
    public Double calculateBonus(double salary){
        double bonus = ((salary + 90000) * 28) / 360;
        return  bonus;
    }
    public Double calculateLayoffs(double salary){
        double layoffs = ((salary + 90000) * 28) / 360;
        return  layoffs;
    }
    public Double calculateHolidays(double salary){
        double holidays = ((salary + 90000) * 28) / 360;
        return holidays;
    }
    public Double calculateHealth(double salary){
        double health = salary * 0.04;
        return health;
    }
    public Double calculatePension(double salary){
        double pension = salary * 0.04;
        return pension;
    }
    public Double calculateCompensationBox(double salary){
        double compensationBox = salary * 0.04;
        return compensationBox;
    }
}