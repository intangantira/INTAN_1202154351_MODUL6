package com.example.android.intangantira_1202154351_modul6;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Intan Gantira on 4/1/2018.
 */

public class adaptersatu extends RecyclerView.Adapter {
    public adaptersatu(post post, ArrayList<databasesatu> list) {
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class AdapterC extends RecyclerView.Adapter<AdapterC.CommentViewHolder> {
        Context context;
        List<databasesatu> list;

        //konstruktor dari adapterc
        public AdapterC(Context context, List<databasesatu> list){
            this.context=context;
            this.list=list;
        }

        //return viewholder dari recyclerview
        @Override
        public CommentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new CommentViewHolder(LayoutInflater.from(context).inflate(R.layout.komen, parent, false));
        }

        //mengikat nilai dari list dengan view
        @Override
        public void onBindViewHolder(CommentViewHolder holder, int position) {
            databasesatu crnt = list.get(position);
            //set textview commenter dengan nilai yang didapatatkan
            holder.commenter.setText(crnt.getCommenters());
            //set textview comments dengan nilai yang didapatkan
            holder.comments.setText(crnt.getComments());
        }


        //mendapatkan jumlah item pada recyclernya
        @Override
        public int getItemCount() {
            return list.size();
        }


        //class yang akan dipanggil dan dijalankan sebagai viewholder
        class CommentViewHolder extends RecyclerView.ViewHolder{
            //deklarasi variable yang digunakan
            TextView commenter, comments;
            public CommentViewHolder(View itemView){
                super(itemView);
                //mengakses id textview pada layout
                commenter = itemView.findViewById(R.id.commenter);
                comments = itemView.findViewById(R.id.comments);
            }
        }
    }

}
