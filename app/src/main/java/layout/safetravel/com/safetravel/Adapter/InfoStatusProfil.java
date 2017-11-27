package layout.safetravel.com.safetravel.Adapter;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import layout.safetravel.com.safetravel.R;

public class InfoStatusProfil extends RecyclerView.Adapter<InfoStatusProfil.Wadah> {

    public InfoStatusProfil() {

    }

    @Override
    public InfoStatusProfil.Wadah onCreateViewHolder(ViewGroup parent, int viewType) {
        View tampilan = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_info_status_profil, parent, false);
        return new Wadah(tampilan);
    }

    @Override
    public void onBindViewHolder(InfoStatusProfil.Wadah holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class Wadah extends RecyclerView.ViewHolder {
        public Wadah(View itemView) {
            super(itemView);
        }
    }
}
