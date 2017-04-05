package com.customview.kang.retrofitwithdeezer;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.customview.kang.retrofitwithdeezer.Domain.Needs;

import java.util.List;

/**
 * Created by kang on 2017-04-06.
 */

public class RecyclerViewAdpt extends RecyclerView.Adapter<RecyclerViewAdpt.Holder>{
    Context context;
    List<Needs> datas;
    public RecyclerViewAdpt(Context context, List<Needs> datas){
        this.context = context;
        this.datas = datas;
    }
    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_item,parent,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {

    }

    @Override
    public int getItemCount() {return datas.size();}

    public class Holder extends RecyclerView.ViewHolder {
        ImageView cover_image;
        ImageButton btnplay,btnMore;
        TextView txtTitle, txtArtist, txtAlbum;
        CardView cardView;

        public Holder(View view) {
            super(view);
            cover_image = (ImageView)view.findViewById(R.id.imageView);
            btnplay = (ImageButton)view.findViewById(R.id.btnPlay);
            btnMore = (ImageButton)view.findViewById(R.id.btnMore);
            txtTitle = (TextView)view.findViewById(R.id.txtTitle);
            txtArtist= (TextView)view.findViewById(R.id.txtArtist);
            txtAlbum= (TextView)view.findViewById(R.id.txtAlbum);
            cardView = (CardView)view.findViewById(R.id.cardView);


        }
        private View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.btnPlay:
                        break;
                    case R.id.btnMore:
                        break;
                }
            }
        };
    }
}
