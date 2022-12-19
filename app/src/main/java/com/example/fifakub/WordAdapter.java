package com.example.fifakub;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class WordAdapter extends RecyclerView.Adapter<WordAdapter.MyViewHolder> {

    String data1[],data2[];
    int images[];
    int sounds[];
    Context context;

    public  WordAdapter(Context ct, String s1[], String s2[], int image[], int sound[]){
        context = ct;
        data1 = s1;
        data2 = s2;
        images = image;
        sounds = sound;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_r, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.mytext1.setText(data1[position]);
        holder.mytext2.setText(data2[position]);
        holder.myimage.setImageResource(images[position]);
        holder.Cards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.showSound = MediaPlayer.create(context,sounds[holder.getAdapterPosition()]);
                holder.showSound.start();
            }
        });
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView mytext1, mytext2;
        ImageView myimage;
        MediaPlayer showSound;
        CardView Cards;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mytext1 = itemView.findViewById(R.id.word);
            mytext2 = itemView.findViewById(R.id.description);
            myimage = itemView.findViewById(R.id.imageword);
            Cards = itemView.findViewById(R.id.card);
        }
    }
}
