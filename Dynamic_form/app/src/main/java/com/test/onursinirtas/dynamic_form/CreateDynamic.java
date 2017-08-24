package com.test.onursinirtas.dynamic_form;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import fr.ganfra.materialspinner.MaterialSpinner;

import static com.test.onursinirtas.dynamic_form.R.layout.create_button;
import static com.test.onursinirtas.dynamic_form.R.layout.create_datepicker;
import static com.test.onursinirtas.dynamic_form.R.layout.create_edittext;
import static com.test.onursinirtas.dynamic_form.R.layout.create_spinner;
import static com.test.onursinirtas.dynamic_form.R.layout.create_textview;

public class CreateDynamic extends AppCompatActivity {

    Context context;
    Integer viewCount = 0;
    List<View> itemsView = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_dynamic);
        context = this;

        LayoutInflater layoutInflater = getLayoutInflater();
        LinearLayout lyCharInflate = (LinearLayout) findViewById(R.id.lyCreateForm);
        lyCharInflate.removeAllViews();


        textView(layoutInflater, lyCharInflate);
        editText(layoutInflater, lyCharInflate);
        datePicker(layoutInflater, lyCharInflate);
        spinner(layoutInflater, lyCharInflate);
        button(layoutInflater, lyCharInflate);

    }

    public void textView(LayoutInflater layoutInflater, LinearLayout lyCharInflate) {
        itemsView.add(layoutInflater.inflate(create_textview, lyCharInflate, false)); // itemsView sırayla inflate dosyasını ekleme işlemi yapıyoruz.
        //İnflate edilen dosyanın içindeki Text View bulup setText özelliğine değerini veriyoruz.
        final TextView editTextViewStr = (TextView) itemsView.get(viewCount).findViewById(R.id.editTextView);
        editTextViewStr.setText(getResources().getString(R.string.textView));
        lyCharInflate.addView(itemsView.get(viewCount)); //Burda da itemsView ekleme yapmıştır.Şimdi lyCharInflate addView ekranda gösterilmesini sağlıyoruz.
        viewCount++;
    }

    public void editText(LayoutInflater layoutInflater, LinearLayout lyCharInflate) {
        itemsView.add(layoutInflater.inflate(create_edittext, lyCharInflate, false));
        final EditText editTextStr = (EditText) itemsView.get(viewCount).findViewById(R.id.editTextStr);
        final TextInputLayout textInputLayout = (TextInputLayout) itemsView.get(viewCount).findViewById(R.id.textInputLayout);
        textInputLayout.setHint(getResources().getString(R.string.editTextInput));
        editTextStr.setText(getResources().getString(R.string.editText));
        lyCharInflate.addView(itemsView.get(viewCount));
        viewCount++;
    }

    public void datePicker(LayoutInflater layoutInflater, LinearLayout lyCharInflate) {
        itemsView.add(layoutInflater.inflate(create_datepicker, lyCharInflate, false));
        final EditText editTextDate = (EditText) itemsView.get(viewCount).findViewById(R.id.editTextDate);
        final TextInputLayout textInputLayoutDate = (TextInputLayout) itemsView.get(viewCount).findViewById(R.id.textInputLayoutDate);
        textInputLayoutDate.setHint(getResources().getString(R.string.textInputLayoutDate));
        final Calendar myCalendar = Calendar.getInstance();


        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                String myFormat = "dd/MM/yyyy"; //In which you need put here
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

                editTextDate.setText(sdf.format(myCalendar.getTime()));
            }

        };

        editTextDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(context, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        lyCharInflate.addView(itemsView.get(viewCount));
        viewCount++;

    }

    public void spinner(LayoutInflater layoutInflater, LinearLayout lyCharInflate) {
        itemsView.add(layoutInflater.inflate(create_spinner, lyCharInflate, false));
        final MaterialSpinner materialSpinner = (MaterialSpinner) itemsView.get(viewCount).findViewById(R.id.spinner);
        materialSpinner.setHint(getResources().getString(R.string.materialSpinner));

        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("Türkiye");
        stringList.add("Almanya");
        stringList.add("Avusturya");

        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_item, stringList);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        materialSpinner.setAdapter(spinnerAdapter);


        lyCharInflate.addView(itemsView.get(viewCount));
        viewCount++;
    }

    public void button(LayoutInflater layoutInflater, LinearLayout lyCharInflate) {
        itemsView.add(layoutInflater.inflate(create_button, lyCharInflate, false));
        final Button button = (Button) itemsView.get(viewCount).findViewById(R.id.button);
        button.setText(getString(R.string.button));
        lyCharInflate.addView(itemsView.get(viewCount));
        viewCount++;
    }


}
