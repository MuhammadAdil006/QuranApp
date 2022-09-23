package haqnawaz.org.navigationdrawer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;

public class selectTarjama extends AppCompatActivity {

    RadioGroup r1;
    RadioGroup r2;
    RadioButton e1;
    RadioButton e2;
    RadioButton u1;
    RadioButton u2;
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_tarjama);

        r1= findViewById(R.id.radioGroup);
        r2=findViewById(R.id.radioGroup2);
        u1=findViewById(R.id.Fateh);
        u2=findViewById(R.id.Mehmood);
        e1=findViewById(R.id.Dr);
        e2=findViewById(R.id.Mufti);
        u1.setChecked(true);
        e1.setChecked(true);
        b=findViewById(R.id.Proceed);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int UrduRadioId=r1.getCheckedRadioButtonId();
                int EnglishRadioId=r2.getCheckedRadioButtonId();

                String urdu=""
                        ;
                switch(UrduRadioId)
                {
                    case R.id.Fateh:
                        urdu="FatehMuhammadJalandhrield";
                        break;
                    case R.id.Mehmood:
                            urdu="MehmoodulHassan";
                    break;

                }
                String Eng=""
                        ;
                switch(EnglishRadioId)
                {
                    case R.id.Dr:
                        Eng="DrMohsinKhan";
                        break;
                    case R.id.Mufti:
                            Eng="MuftiTaqiUsmani";
                    break;

                }

                Intent pre = getIntent();
                Intent next= new Intent(selectTarjama.this,DisplayPara.class);
                next.putExtra("index",pre.getStringExtra("index"));
                next.putExtra("Eng",Eng);
                next.putExtra("Urdu",urdu);
                startActivity(next);
            }
        });
    }
}