package com.example.fifakub;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.fifakub.SliderItems;

import java.util.List;

public class MyAdapterpp extends RecyclerView.Adapter<MyAdapterpp.ViewHolder> {
    private List<SliderItems> dataList;
    private Context context;
    //ประกาศตัวแปรอาร์เรย์ เพื่อเก็บไฟล์เสียง ไฟล์ข้อความ ไฟล์ลิงค์เว็บ ตามจำนวนการเลื่อนข้อมูลที่ต้องการ
    //เปลี่ยนข้อมูลได้ตามต้องการหรือเพิ่มได้ตามต้องการ


    public MyAdapterpp(List<SliderItems> dataList, Context context) {
        this.dataList = dataList;
        this.context = context;
    }



    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.slider_item, parent, false);
        return new ViewHolder(view);
    }
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);

        }
    }

    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imageView.setImageResource(dataList.get(position).getImage());
    }
}

