package com.example.name_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText data;
    EditText data2;
    Button save;
    Button delete;
    Button update;
    Button search;
    ArrayList<String> addarray = new ArrayList<String>();
    ArrayList<String> addarray2 = new ArrayList<String>();
    ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializecomp();
        settinguplistner();
    }

    private void settinguplistner()
    {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, addarray);
        save.setOnClickListener(view -> {
            String n = data.getText().toString();
//         if(addarray.contains(n))
//         {
//             Toast.makeText(getBaseContext(), "Item Already Exist", Toast.LENGTH_LONG).show();
//         }((EditText)findViewById(R.id.data)).setText(" ");
//         else if(n == null || n.trim().equals(""))
//         {
//             Toast.makeText(getBaseContext(), "Input field is Empty", Toast.LENGTH_LONG).show();
//         }
//         else
//         {
             addarray.add(n);
//             ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, addarray);
             list.setAdapter(adapter);
//
//         }
        });
        delete.setOnClickListener(view -> {
            String n = data.getText().toString();
            for(int i  = 0 ; i<addarray.size(); i++)
            {
                if(addarray.get(i).equals(n))
                {
                    addarray.remove(i);
//                    //ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, addarray);
                    list.setAdapter(adapter);
                    break;
                }
                else
                {
                    Toast.makeText(getBaseContext(), "No such item found", Toast.LENGTH_SHORT).show();
                }

            }
        });

        update.setOnClickListener(view-> {
            String n = data.getText().toString();
            int position = list.getCheckedItemPosition();
            if(!n.isEmpty() && n.length()>0)
            {
//                ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, addarray);
                adapter.remove(addarray.get(position));
                adapter.insert(n,position);
                adapter.notifyDataSetChanged();
                Toast.makeText(getBaseContext(), "Updated", Toast.LENGTH_SHORT).show();

            }
            else
            {
                Toast.makeText(getBaseContext(), "No Data Found", Toast.LENGTH_LONG).show();
            }
        });

        search.setOnClickListener(view -> {
            String n = data2.getText().toString();
            for(int i = 0; i < addarray.size(); i++)
            {
                if(addarray.get(i).equals(n))
                {
                    ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, addarray2);
                    addarray2.add(n);
                    list.setAdapter(adapter2);
                    break;
                }
//                else
//                {
//                    Toast.makeText(getBaseContext(), "No such item found", Toast.LENGTH_SHORT).show();
//                }
            }
        });

    }
    private void initializecomp()
    {
        data = findViewById(R.id.data);
        data2 = findViewById(R.id.data2);
        save = findViewById(R.id.save);
        delete = findViewById(R.id.delete);
        update = findViewById(R.id.update);
        search = findViewById(R.id.search);
        list = findViewById(R.id.list);
    }
}