package com.thunt.quan.demngayxaem;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Calendar calendar1, calendar2;
    SimpleDateFormat simpleDateFormat;
    EditText edt1, edt2;
    Button btnTinh;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        edt1 = (EditText) findViewById(R.id.edtNgay1);
        edt2 = (EditText) findViewById(R.id.edtNgay2);
        btnTinh = (Button)findViewById(R.id.btnTinh);
        textView = (TextView) findViewById(R.id.textView);
        edt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chonNgay1();
            }
        });

        edt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chonNgay2();
            }
        });
        btnTinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(calendar2.getTimeInMillis() > calendar1.getTimeInMillis()) {
                    int ngayyeunhau = (int) ((calendar2.getTimeInMillis() - calendar1.getTimeInMillis()) / (1000 * 60 * 60 * 24));
                    textView.setText("So ngay yeu nhau : " + ngayyeunhau);
                }else {
                    Toast.makeText(MainActivity.this," Du lieu nhap sai, ban kiem tra lai", Toast.LENGTH_SHORT).show();}
            }
        });

    }

    private void chonNgay1() {
        calendar1 = Calendar.getInstance();
        int nam = calendar1.get(Calendar.YEAR);
        int thang = calendar1.get(Calendar.MONTH);
        int ngay = calendar1.get(Calendar.DATE);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar1.set(year, month, dayOfMonth);
                edt1.setText(simpleDateFormat.format(calendar1.getTime()));

            }
        }, nam, thang, ngay);
        datePickerDialog.show();
    }

    private void chonNgay2() {
        calendar2 = Calendar.getInstance();
        int nam = calendar2.get(Calendar.YEAR);
        int thang = calendar2.get(Calendar.MONTH);
        int ngay = calendar2.get(Calendar.DATE);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar2.set(year, month, dayOfMonth);
                edt2.setText(simpleDateFormat.format(calendar2.getTime()));

            }
        }, nam, thang, ngay);

        datePickerDialog.show();
    }
}
