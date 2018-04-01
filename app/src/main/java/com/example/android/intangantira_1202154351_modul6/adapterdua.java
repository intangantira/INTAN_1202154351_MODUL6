package com.example.android.intangantira_1202154351_modul6;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Intan Gantira on 4/1/2018.
 */

public class adapterdua extends RecyclerView.Adapter<adapterdua.PostViewHolder> {
    //deklarasi variable
    private List<databasedua> list;
    private Context context;
    //konstruktor yang digunakan pada kelas ini
    public adapterdua(List<databasedua> list, Context context){
        this.list = list;
        this.context=context;
    }

    //mengembalikan view holder untuk adapter post
    @Override
    public adapterdua.PostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PostViewHolder(LayoutInflater.from(context).inflate(R.layout.feeds, parent, false));
    }


    @Override
    public void onBindViewHolder(PostViewHolder holder, int position) {
        databasedua crnt = list.get(position);
        //string array
        String [] usr = crnt.usr.split("@");
        //set user judul deskripsi dan variable sesuai dengan nilai yang di dapat
        holder.usr.setText(usr[0]);
        holder.usr.setTag(crnt.getKey());
        holder.judul.setText(crnt.getJudul());
        holder.deskripsi.setText(crnt.getDeskripsi());
        holder.deskripsi.setTag(crnt.getGmbr());
        //mengambil gambar dan menempatkan nya pada holder dengan ukuran 400x400
        Glide.with(context).load(crnt.getGmbr()).override(400,400).into(holder.gmbr);
    }

    //mendapatkan jumlah item pada recycler
    @Override
    public int getItemCount() {
        return list.size();
    }

    //class yang akan dijalankan sebagai viewholder
    class PostViewHolder extends RecyclerView.ViewHolder{
        ImageView gmbr;
        TextView judul, deskripsi, usr;
        public PostViewHolder(View itemView){
            super(itemView);
            //mengakses id dari layout
            gmbr = itemView.findViewById(R.id.uploadedimage);
            judul = itemView.findViewById(R.id.judulpost);
            deskripsi = itemView.findViewById(R.id.deskripsipost);
            usr = itemView.findViewById(R.id.uploader);
            //ketika postingan di klik
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //intent ke kelas posts
                    Intent intent = new Intent(context, post.class);
                    //mengirimkan data pada activity yang dituju (user, judul deskripsi dan gambar)
                    intent.putExtra("usr", usr.getText());
                    intent.putExtra("key", usr.getTag().toString());
                    intent.putExtra("judul", judul.getText());
                    intent.putExtra("deskripsi", deskripsi.getText());
                    intent.putExtra("gmbr", deskripsi.getTag().toString());
                    //memulai intent
                    context.startActivity(intent);
                }
            });
        }
    }
}
