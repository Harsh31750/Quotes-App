package com.example.quotesapp;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private ArrayList<String> arrayList;
    private Context context;

    public MyAdapter(ArrayList<String> arrayList) {
        this.arrayList = arrayList;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context  =parent.getContext();

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items,parent,false);
        return new MyViewHolder(view);
            }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        String quote = arrayList.get(position);
        holder.quote.setText(quote);

        holder.copy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipboardManager clipboard = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("Copied text", quote);
                clipboard.setPrimaryClip(clip);
            }
        });
        holder.share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent =   new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT,quote);
                context.startActivity(intent);

            }
        });


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView quote;
        Button share,copy;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            quote = itemView.findViewById(R.id.quotes);
            share = itemView.findViewById(R.id.share);
            copy = itemView.findViewById(R.id.copy);
        }
    }

}
