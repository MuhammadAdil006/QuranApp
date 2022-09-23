package haqnawaz.org.navigationdrawer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class Searching extends AppCompatActivity {
EditText Input;
Button Search;
TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searching);
        Intent intent3= new Intent(Searching.this,SearchResult.class);
        Intent i=getIntent();
        String values=i.getStringExtra("Search");
        Input=findViewById(R.id.Input);
        Search=findViewById(R.id.Search);
        tv=findViewById(R.id.textView);

        Search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input=Input.getText().toString();


                intent3.putExtra("Input",input);
                intent3.putExtra("Search",values);
                startActivity(intent3);
            }
        });


    }
}