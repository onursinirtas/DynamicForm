# DynamicForm
 Dynamic form with android


Let's do it first.Inflate is create files folder.

Create TextView folder name: create_textview.xml 

?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@color/form_background"
    android:orientation="vertical">

    <TextView
        android:id="@+id/editTextView"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginBottom="5dp"
        android:layout_marginLeft="5dp"
        android:layout_marginRight="5dp"
        android:layout_marginTop="10dp"
        android:textSize="15sp"
        android:textStyle="bold" />
</LinearLayout>

Create EditText folder name: create_edittext.xml

?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@color/form_background"
    android:orientation="vertical">

    <android.support.design.widget.TextInputLayout
        android:id="@+id/textInputLayout"
        android:layout_width="fill_parent"
        android:layout_height="wrap_content"
        app:hintTextAppearance="@style/TextLabel">

        <EditText
            android:id="@+id/editTextStr"
            android:layout_width="fill_parent"
            android:layout_height="wrap_content"
            android:layout_marginStart="5dp"
            android:maxLines="1"
            android:singleLine="true"
            android:textSize="15sp" />
    </android.support.design.widget.TextInputLayout>
</LinearLayout>


Create Datepicker folder name: create_datepicker.xml

<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@color/form_background"
    android:orientation="vertical">

    <android.support.design.widget.TextInputLayout
        android:id="@+id/textInputLayoutDate"
        android:layout_width="fill_parent"
        android:layout_height="wrap_content"
        app:hintTextAppearance="@style/TextLabel">

        <EditText
            android:id="@+id/editTextDate"
            android:layout_width="fill_parent"
            android:layout_height="wrap_content"
            android:layout_marginStart="5dp"
            android:focusable="false"
            android:maxLines="1"
            android:singleLine="true"
            android:textSize="15sp" />

    </android.support.design.widget.TextInputLayout>

</LinearLayout>


Create Spinner folder name: create_spinner.xml

<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@color/form_background"
    android:orientation="vertical">

    <fr.ganfra.materialspinner.MaterialSpinner
        android:id="@+id/spinner"
        android:layout_width="fill_parent"
        android:layout_height="wrap_content"
        android:textSize="15sp" />
</LinearLayout>

Create Button folder name: create_button.xml

<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@color/form_background"
    android:orientation="vertical">

    <Button
        android:id="@+id/button"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginBottom="5dp"
        android:layout_marginLeft="5dp"
        android:layout_marginRight="5dp"
        android:layout_marginTop="10dp"
        android:textSize="16sp"
        android:textStyle="bold" />
</LinearLayout>


After preparing the files to be inflated, we are preparing the java file and the xml file. The Java file is named CreateDynamic and the activity_create_dynamic in xml is created.

The activity_create_dynamic.xml file consists of the following code.

<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context="com.test.onursinirtas.dynamic_form.CreateDynamic">

    <ScrollView
        android:id="@+id/scrollCreate"
        android:layout_width="match_parent"
        android:layout_height="wrap_content">

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:orientation="vertical">

            <LinearLayout
                android:id="@+id/lyCreateForm"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:orientation="vertical"
                android:padding="8dp">

            </LinearLayout>
        </LinearLayout>
    </ScrollView>

</LinearLayout>


Once we have created the xml file, let's start writing the code we need for the java file.


First we set the viewCount variable of type Integer to determine the number of dynamically created on the screen and print them sequentially on the screen. We give 0 as the first value. We then created a View of the List type and gave it the name itemsView. We used to show the inflated to the screen.

Integer viewCount = 0;
List<View> itemsViev = new ArrayList<>();


We find the LinearLayout in the activity_create_dynamic.xml file.

LayoutInflater layoutInflater = getLayoutInflater();
LinearLayout lyCharInflate = (LinearLayout) findViewById(R.id.lyCreateForm);
lyCharInflate.removeAllViews();


Once you have found the LinearLayout we can add the files to be prepared for inflate in order.

### TextView

itemsView.add(layoutInflater.inflate(create_textview, lyCharInflate, false)); //We are in the process of adding the inflate file in the order of itemsView.
//We find the Text View in the file being inspected and set the value of the setText property.

final TextView editTextViewStr = (TextView) itemsView.get(viewCount).findViewById(R.id.editTextView);
editTextViewStr.setText(getResources().getString(R.string.textView));
lyCharInflate.addView(itemsView.get(viewCount)); //Here we have also added the itemsView. Now we make lyCharInflate addView show up on the screen.
viewCount++;

### EditText

itemsView.add(layoutInflater.inflate(create_edittext, lyCharInflate, false));
final EditText editTextStr = (EditText) itemsView.get(viewCount).findViewById(R.id.editTextStr);
final TextInputLayout textInputLayout = (TextInputLayout) itemsView.get(viewCount).findViewById(R.id.textInputLayout);
textInputLayout.setHint(getResources().getString(R.string.editTextInput));
editTextStr.setText(getResources().getString(R.string.editText));
lyCharInflate.addView(itemsView.get(viewCount));
viewCount++;

### Spinner

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

### DatePicker

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

### Button

itemsView.add(layoutInflater.inflate(create_button, lyCharInflate, false));
final Button button = (Button) itemsView.get(viewCount).findViewById(R.id.button);
button.setText(getString(R.string.button));
lyCharInflate.addView(itemsView.get(viewCount));
viewCount++;








