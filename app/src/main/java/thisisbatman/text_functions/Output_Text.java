package thisisbatman.text_functions;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;


public class Output_Text extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output__text);
        Bundle extras = getIntent().getExtras();
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        int[] form = extras.getIntArray("numbers");
        TextView jokeroutput = (TextView)findViewById(R.id.jokeroutput);

        //   FORMATTING        THE       TEXT




        //COLOR
        if(form[1]==0)
        {
            jokeroutput.setTextColor(Color.BLACK);
        }
        else if(form[1]==1)
        {
            jokeroutput.setTextColor(Color.BLUE);
        }
        else if(form[1]==2)
        {
            jokeroutput.setTextColor(Color.GREEN);
        }
        else if(form[1]==3)
        {
            jokeroutput.setTextColor(Color.RED);
        }


        //FONT
        if(form[0]==1)
        {
            if (form[2] == 0)
            {
                jokeroutput.setTypeface(null,Typeface.BOLD);
            } else if (form[2] == 1)
            {
                jokeroutput.setTypeface(Typeface.MONOSPACE,Typeface.BOLD);
            }
            if (form[2] == 2)
            {
                jokeroutput.setTypeface(Typeface.SANS_SERIF,Typeface.BOLD);
            }
        }
        else if(form[4]==1)
        {
            if (form[2] == 0)
            {
                jokeroutput.setTypeface(null,Typeface.ITALIC);
            } else if (form[2] == 1)
            {
                jokeroutput.setTypeface(Typeface.MONOSPACE,Typeface.ITALIC);
            }
            if (form[2] == 2)
            {
                jokeroutput.setTypeface(Typeface.SANS_SERIF,Typeface.ITALIC);
            }
        }
        if((form[4]==1)&&(form[0]==1))
        {
            if (form[2] == 0)
            {
                jokeroutput.setTypeface(null,Typeface.BOLD_ITALIC);
            } else if (form[2] == 1)
            {
                jokeroutput.setTypeface(Typeface.MONOSPACE,Typeface.BOLD_ITALIC);
            }
            if (form[2] == 2)
            {
                jokeroutput.setTypeface(Typeface.SANS_SERIF,Typeface.BOLD_ITALIC);
            }
        }
        else if((form[4]!=1)&&(form[0]!=1))
        {
            if (form[2] == 0)
            {
                jokeroutput.setTypeface(Typeface.DEFAULT);
            } else if (form[2] == 1)
            {
                jokeroutput.setTypeface(Typeface.MONOSPACE);
            }
            if (form[2] == 2)
            {
                jokeroutput.setTypeface(Typeface.SANS_SERIF);
            }
        }


        //SIZE
        if(form[3]==0)
        {
            jokeroutput.setTextSize(10);
        }
        if(form[3]==1)
        {
            jokeroutput.setTextSize(20);
        }
        if(form[3]==2)
        {
            jokeroutput.setTextSize(30);
        }
        if(form[3]==3)
        {
            jokeroutput.setTextSize(40);
        }

        jokeroutput.setText(message);

    }
    public void onclick(View view)
    {
        Intent backmain = new Intent(this,MainActivity.class);
        startActivity(backmain);
    }
    public void jonclick(View arg0)
    {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("EXIT", true);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_output__text, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
