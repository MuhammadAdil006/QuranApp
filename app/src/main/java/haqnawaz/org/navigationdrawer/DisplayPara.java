package haqnawaz.org.navigationdrawer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class DisplayPara extends AppCompatActivity {
    RecyclerView lv;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_para);
        lv= findViewById(R.id.ParaConsole);
        Intent intent=getIntent();
       int id=Integer.parseInt((intent.getStringExtra("index")))+1 ;
       DbHelper db=new DbHelper(this);

       String eng=intent.getStringExtra("Eng");
       String urdu=intent.getStringExtra("Urdu");
       lv.setHasFixedSize(true);

       ArrayList<tayah> ay =db.getSurahWithTranslation(id,urdu,eng);
       layoutManager= new LinearLayoutManager(DisplayPara.this,LinearLayoutManager.VERTICAL,false);
       lv.setLayoutManager(layoutManager);

       adapter=new  MyRecyclerViewAdapterForDisplay(ay);
       lv.setAdapter(adapter);
//       CustomizedAdapter cA=new CustomizedAdapter(this,ay);
//       lv.setAdapter(cA);


    }
}