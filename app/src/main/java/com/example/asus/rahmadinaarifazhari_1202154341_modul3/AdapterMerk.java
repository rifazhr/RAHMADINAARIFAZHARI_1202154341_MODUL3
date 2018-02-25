package com.example.asus.rahmadinaarifazhari_1202154341_modul3;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.List;

/**
 * Created by asus on 2/25/2018.
 */

public class AdapterMerk extends RecyclerView.Adapter<AdapterMerk.holdermn>{
    private Context context;
    private List<MenuMerk> listmerk;

    //adpater yang akan menyiapkan layout untuk daftar menu
    public AdapterMerk(Context context, List<MenuMerk> listmerk) {
        this.context = context;
        this.listmerk = listmerk;
    }

    @Override
    //membuat suatu tampilan dan mengembalikannya
    public holdermn onCreateViewHolder(ViewGroup parent, int viewType) {
        //membuat view baru
        View vw = LayoutInflater.from(context).inflate(R.layout.card_view, parent, false);
        holdermn hldr = new holdermn(vw);
        return hldr;
    }

    @Override
    //menghubungkan data dengan view holder pada posisi yang ditentukan dalam RecyclerView
    public void onBindViewHolder(holdermn holder, int position) {
        //mengambil elemen dari array pada posisi tertentu
        MenuMerk dt = listmerk.get(position);
        //mengeset isi view dengan elemen dari data
        holder.nama.setText(dt.getNama());
        holder.detail.setText(dt.getDesc());
        //kondisi gambar dari drawable dijadikan sebagai background dari cardview
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            holder.rl.setBackground(holder.rl.getResources().getDrawable(dt.getGambar()));
        }
        holder.rl.setTag(dt.getGambar());
    }

    @Override
    //men
    // ghitung ukuran dataset/jumlah data yang akan ditampilkan
    public int getItemCount() {
        return listmerk.size();
    }

    class holdermn extends RecyclerView.ViewHolder{
        //deklarasi variable
        TextView nama, detail;
        RelativeLayout rl;
        public holdermn(View itemView) {
            super(itemView);
            //mengakses nama, detail, dan rl yang ada pada layout
            nama = itemView.findViewById(R.id.namaAir);
            detail = itemView.findViewById(R.id.detailAir);
            rl = itemView.findViewById(R.id.rl);
            //implementasi onclicklistener
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                //ketika cardview di klik
                public void onClick(View view) {
                    //bmembuat intent bernama move
                    Intent move = new Intent(context, DetailAir.class);
                    //mengirimkan data data yang diambil ke detail air untuk di tampilkan
                    move.putExtra("nama", nama.getText());
                    move.putExtra("detail", detail.getText());
                    move.putExtra("gambar",rl.getTag().toString());
                    //mengeksekusi intent
                    context.startActivity(move);
                }
            });
        }
    }
}

