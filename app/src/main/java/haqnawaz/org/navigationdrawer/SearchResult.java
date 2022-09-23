package haqnawaz.org.navigationdrawer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class SearchResult extends AppCompatActivity {
    RecyclerView lv;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_para);
        Intent i=getIntent();
        String values=i.getStringExtra("Search");
        String Input=i.getStringExtra("Input");
        DbHelper db= new DbHelper(this);
        ArrayList<tayah> Results=new ArrayList<tayah>();

      Results=db.Search(Input);
      lv=findViewById(R.id.ParaConsole);


        lv.setHasFixedSize(true);
        layoutManager= new LinearLayoutManager(SearchResult.this,LinearLayoutManager.VERTICAL,false);
        lv.setLayoutManager(layoutManager);

        adapter=new  MyRecyclerViewAdapterForDisplay(Results);
        lv.setAdapter(adapter);

    }
}