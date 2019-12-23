package com.example.loginapp2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {
    EditText input;
    Button addItem;
    ListView listView;
    ArrayList<String> arrayList,arrayListForSerial,arrayString;
    ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        input=findViewById(R.id.add_item_id);
        addItem=findViewById(R.id.add_to_list);
        listView=findViewById(R.id.list_item);
        arrayList=new ArrayList<String>();
        arrayListForSerial=new ArrayList<>();
        arrayString=new ArrayList<>();
        arrayAdapter=new ArrayAdapter(getApplicationContext(),android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(arrayAdapter);
        addItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!input.getText().toString().trim().isEmpty()){
                    arrayListForSerial.add(""+(arrayList.size()+1));
                    arrayString.add(input.getText().toString());
                    arrayList.add((arrayList.size()+1)+". "+input.getText().toString());
                    arrayAdapter.notifyDataSetChanged();
                    input.setText("");

                }
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                final int which_item=position;
                new AlertDialog.Builder(SecondActivity.this).setIcon(android.R.drawable.ic_delete).setTitle("Are you sure!").setMessage("Do you want to delete this item?").setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                            int size=arrayList.size();
                            for(int i=size;size>=which;i--){
                                arrayList.remove(i);
                                //cool
                                //second line is added

                            }
                        arrayAdapter.notifyDataSetChanged();
                    }
                }).setNegativeButton("NO",null).show();

                return true;
            }
        });

      /*  listView.setOnItemLongClickListener(new OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(final AdapterView<?> p, View v,final int po, long id) {

                // your code

                return true;
            }
        });*/

    }

    void listHandler(){


    }
}
