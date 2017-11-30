package layout.safetravel.com.safetravel.Adapter;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import layout.safetravel.com.safetravel.R;

public class PanduanPoinAdapter extends RecyclerView.Adapter<PanduanPoinAdapter.ViewHolder> {
    Context context;

    public PanduanPoinAdapter(Context context) {
        this.context = context;
    }

    @Override
    public PanduanPoinAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View tampilan = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_panduan_poin_adapter, parent, false);
        return new PanduanPoinAdapter.ViewHolder(tampilan);
    }

    @Override
    public void onBindViewHolder(PanduanPoinAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 4;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
