package thisisbatman.text_functions;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.CheckBox;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;
public class MainActivity extends Activity implements AdapterView.OnItemSelectedListener {

    public final static String EXTRA_MESSAGE = "com.mycompany.myfirstapp.MESSAGE";
    int values[]={0,0,0,0,0};
     //checkbox
     public void oncheck() {
         final CheckBox ch1 = (CheckBox) findViewById(R.id.batecheck1);
         final CheckBox ch2 = (CheckBox) findViewById(R.id.batecheck2);
         ch1.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 if (ch1.isChecked())
                     values[0] = 1;
                 else
                     values[0] = 0;


             }
         });
         ch2.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 if (ch2.isChecked())
                     values[4] = 1;
                 else
                     values[4] = 0;
             }

         });
     }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      //GETTEXT

        final EditText batemantext = (EditText)findViewById(R.id.batemantext);


        //checkbox
        oncheck();
       //color
        Spinner colordropdown = (Spinner)findViewById(R.id.colorspin);
        String[] colors= new String[]{"Black(default)", "Blue", "Green","Red"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, colors);
        colordropdown.setAdapter(adapter);
        colordropdown.setOnItemSelectedListener(this);

        //font
        String[] batefont = {"Default","Monospace", "SansSerif"};
        ListAdapter fontadapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, batefont);
        ListView fontlist = (ListView) findViewById(R.id.fontlist);
        fontlist.setAdapter(fontadapter);
        fontlist.setOnItemClickListener
                (
                        new AdapterView.OnItemClickListener() {

                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
                            {
                                if (position == 0)
                                {


                                    values[2]=0;


                                }
                                if (position == 1)
                                {

                                   values[2]=1;

                                }
                                if (position == 2)
                                {

                                    values[2] = 2;

                                }

                                Intent i = new Intent(MainActivity.this,Output_Text.class);
                                final String message = batemantext.getText().toString();
                                i.putExtra("numbers",values);
                                i.putExtra(EXTRA_MESSAGE, message);
                                startActivity(i);
                            }

                        }


                );

        //size
        Spinner sizedrop = (Spinner)findViewById(R.id.sizespin);
        String[] sizes= new String[]{"Very Small", "Small", "Normal","Large"};
        ArrayAdapter<String> sizeadapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, sizes);
        sizedrop.setAdapter(sizeadapter);
        sizedrop.setOnItemSelectedListener(MainActivity.this);
        if (getIntent().getBooleanExtra("EXIT", false))
        {
            finish();
        }
    }

    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {

        switch(parent.getId())
        {
            case R.id.colorspin :
            switch (position)
            {
                case 0:
                    values[1]=0;
                    break;
                case 1:
                    values[1]=1;
                    break;
                case 2:
                    values[1]=2;
                    break;
                case 3:
                    values[1]=3;
                    break;

            }
            case R.id.sizespin:
            {
                switch (position)
                {
                    case 0:
                        values[3]=0;
                        break;
                    case 1:
                        values[3]=1;
                        break;
                    case 2:
                        values[3]=2;
                        break;
                    case 3:
                        values[3]=3;
                        break;
                }
            }
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent)
    {
        Toast.makeText(this, "You selected nothing", Toast.LENGTH_LONG).show();

    }


}
