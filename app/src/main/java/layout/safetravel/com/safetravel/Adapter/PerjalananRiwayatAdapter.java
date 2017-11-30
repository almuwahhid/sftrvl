package layout.safetravel.com.safetravel.Adapter;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import layout.safetravel.com.safetravel.R;

public class PerjalananRiwayatAdapter extends RecyclerView.Adapter<PerjalananRiwayatAdapter.ViewHolder> {
    Context context;

    public PerjalananRiwayatAdapter(Context context) {
        this.context = context;
    }

    @Override
    public PerjalananRiwayatAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View tampilan = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_perjalanan_riwayat_adapter, parent, false);
        return new PerjalananRiwayatAdapter.ViewHolder(tampilan);
    }

    @Override
    public void onBindViewHolder(PerjalananRiwayatAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 6;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
