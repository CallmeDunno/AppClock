package com.example.appclock;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<LineListView> lineListViews;
    Calendar calendar = Calendar.getInstance();
    ListViewAdapter listViewAdapter;

    private void AnhXa(){
        listView = findViewById(R.id.listView);
        lineListViews = new ArrayList<>();
        listViewAdapter = new ListViewAdapter(this, R.layout.list_view_line, lineListViews);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();

        listView.setAdapter(listViewAdapter);

        //Tôi có để setOnClick
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, i+"", Toast.LENGTH_SHORT).show();
            }
        });

//        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//            @Override
//            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(MainActivity.this, "Bug", Toast.LENGTH_SHORT).show();
//                DialogConfirmDeleteItem(i);
//                return false;
//            }
//        });
    }

    private void TimePicker(){
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        SimpleDateFormat simpleTimeFormat = new SimpleDateFormat("HH:mm");
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                calendar.set(0,0,0, i, i1);
                String strHour = simpleTimeFormat.format(calendar.getTime());
                lineListViews.add(new LineListView(strHour, "No", "down", false));
                listViewAdapter.notifyDataSetChanged();
            }
        }, hour, minute, true);
        timePickerDialog.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_item, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.addButton){
            TimePicker();
        }
        return super.onOptionsItemSelected(item);
    }

    private void DialogConfirmDeleteItem(int position){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("Delete");
        alertDialog.setMessage("Are you sure?");
        alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                lineListViews.remove(position);
                listViewAdapter.notifyDataSetChanged();
            }
        });
        alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        alertDialog.show();
    }
}