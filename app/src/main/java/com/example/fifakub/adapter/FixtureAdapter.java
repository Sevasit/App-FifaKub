package com.example.fifakub.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fifakub.Models.FixtureData;
import com.example.fifakub.R;
import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class FixtureAdapter extends RecyclerView.Adapter<FixtureViewHolder>{

    Context context;
    List<FixtureData> list;

    public FixtureAdapter(Context context, List<FixtureData> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public FixtureViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FixtureViewHolder(LayoutInflater.from(context).inflate(R.layout.list_fixture, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull FixtureViewHolder holder, int position) {
        final FixtureData data = list.get(position);

        Picasso.get().load("https://countryflagsapi.com/png/" + data.homeName.toLowerCase()).into(holder.imageView_home);
        Picasso.get().load("https://countryflagsapi.com/png/" + data.awayName.toLowerCase()).into(holder.imageView_away);

        holder.textView_home.setText(data.homeName);
        holder.textView_away.setText(data.awayName);

        holder.textView_math.setText("การเเข่งระหว่าง "+data.homeName + " vs " + data.awayName);

        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE d MMM");
        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm a");

        SimpleDateFormat givenFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            Date date = givenFormat.parse(data.date);
            holder.textView_time.setText(dateFormat.format(date) + "\n"+timeFormat.format(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

class FixtureViewHolder extends RecyclerView.ViewHolder {
    ImageView imageView_home, imageView_away;
    TextView textView_home, textView_away, textView_time, textView_math;

    public FixtureViewHolder(@NonNull View itemView) {
        super(itemView);

        imageView_home = itemView.findViewById(R.id.imageView_home);
        imageView_away = itemView.findViewById(R.id.imageView_away);
        textView_home = itemView.findViewById(R.id.textView_home);
        textView_away = itemView.findViewById(R.id.textView_away);
        textView_time = itemView.findViewById(R.id.textView_time);
        textView_math = itemView.findViewById(R.id.textView_math);
    }
}
