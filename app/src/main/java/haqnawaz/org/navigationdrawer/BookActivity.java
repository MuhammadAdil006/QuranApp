package haqnawaz.org.navigationdrawer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class BookActivity extends AppCompatActivity {
    RecyclerView lv;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager lm;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        Toast.makeText(getApplicationContext(),"Retur is Clicked",Toast.LENGTH_LONG).show();
        DbHelper db= new DbHelper(BookActivity.this);
        lv=findViewById(R.id.SurahNames);
        lv.setHasFixedSize(true);

        lm= new LinearLayoutManager(BookActivity.this,LinearLayoutManager.VERTICAL,false);
        List<String> surahNames=  db.getAllSurah();
        adapter = new MyRecyclerViewAdapter(surahNames,this);
        lv.setLayoutManager(lm);
        lv.setAdapter(adapter);
//        lv.setOnTouchListener(new RecyclerItemClickListener);



    }
    public void onItemClick(int pos)
    {
        Intent i = new Intent(this,selectTarjama.class);
        i.putExtra("index",String.valueOf(pos));
        startActivity(i);
    }


}