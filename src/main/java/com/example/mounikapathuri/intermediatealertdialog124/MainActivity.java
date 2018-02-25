package com.example.mounikapathuri.intermediatealertdialog124;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView mListView;
    final ArrayList<Data> mList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = (ListView) findViewById(R.id.myListView);
    }

    public boolean onCreateOptionsMenu(Menu menu){

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem){
        int id = menuItem.getItemId();
        if (id==R.id.add){
            dialog();
            Toast.makeText(this,"Menu Clicked..!!",Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(menuItem);
    }
    private void dialog() {

        final Dialog dialog = new Dialog(this);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setContentView(R.layout.dialog);

        dialog.show();

        Button btnSave = (Button) dialog.findViewById(R.id.btnSave);
        Button btnCancel = (Button) dialog.findViewById(R.id.btnCancel);

        final EditText etName = (EditText) dialog.findViewById(R.id.etEnterName);
        final EditText etNumber = (EditText) dialog.findViewById(R.id.etPhoneNumber);
        final DatePicker etDate = (DatePicker) dialog.findViewById(R.id.datepicker);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mName = etName.getText().toString();
                int mNumber = Integer.parseInt(etNumber.getText().toString());
                int mMonth,mYear,mDate;
                mMonth=etDate.getMonth()+1;
                mYear= etDate.getYear();
                mDate=etDate.getDayOfMonth();
                String getDate=mDate+"/"+mMonth+"/"+mYear;

                //storing data to arraylist
                Data data = new Data();
                data.setmName(mName);
                data.setmNumber(mNumber);
                data.setmDate(getDate);
                mList.add(data);

                CustomAdapter adapter = new CustomAdapter(MainActivity.this,mList);
                mListView.setAdapter(adapter);
                Toast.makeText(MainActivity.this,"Saved..!!",Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                Toast.makeText(MainActivity.this,"Cancel Clicked..!!",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
