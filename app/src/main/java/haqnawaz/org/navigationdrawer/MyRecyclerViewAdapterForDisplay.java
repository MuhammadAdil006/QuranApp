package haqnawaz.org.navigationdrawer;

import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyRecyclerViewAdapterForDisplay extends RecyclerView.Adapter<MyRecyclerViewAdapterForDisplay.MyVHForDisplay> {

    List<tayah> list;
    public MyRecyclerViewAdapterForDisplay(List<tayah> l)
    {
        this.list=l;
    }
    @NonNull
    @Override
    public MyVHForDisplay onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.customizedview, parent, false);
        return new MyVHForDisplay(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyVHForDisplay holder, int position) {
        holder.data=list.get(position);
        holder.ayah.setText(holder.data.getArabicText());
        holder.eng.setText(String.valueOf(holder.data.getEnlishTarjama()));
        holder.urdu.setText(holder.data.getUrduTarajama());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyVHForDisplay extends RecyclerView.ViewHolder {

        TextView ayah;
        TextView eng;
        TextView urdu;
        tayah data;
        public MyVHForDisplay(@NonNull View itemView) {
            super(itemView);
            ayah = itemView.findViewById(R.id.ayah);
            ayah.setMovementMethod(new ScrollingMovementMethod());
            eng = itemView.findViewById(R.id.englishTarjama);
            eng.setMovementMethod(new ScrollingMovementMethod());
            urdu = itemView.findViewById(R.id.urduTarjama);
            urdu.setMovementMethod(new ScrollingMovementMethod());


        }
    }



}
