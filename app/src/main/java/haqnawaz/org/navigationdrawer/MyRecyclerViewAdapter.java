package haqnawaz.org.navigationdrawer;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyVH> {
    List<String> SurahNames;
    BookActivity b;

    public MyRecyclerViewAdapter(List<String> n,BookActivity bb)
    {
        this.SurahNames=n;
        this.b=bb;
    }

    @NonNull
    @Override
    public MyVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.names, parent, false);
        return new MyVH(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyVH holder, int position) {
        holder.data=SurahNames.get(position);
        holder.name.setText(holder.data);
        holder.count.setText(String.valueOf(position+1));
    }

    @Override
    public int getItemCount() {
        return SurahNames.size();
    }

    public class MyVH extends RecyclerView.ViewHolder {
        ImageView img;
        TextView name;
        TextView count;
        String data;
        public MyVH(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            name= itemView.findViewById(R.id.name);
            count = itemView.findViewById(R.id.count);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos=getAdapterPosition();
                    b.onItemClick(pos);
                }
            });
             }
    }



}
