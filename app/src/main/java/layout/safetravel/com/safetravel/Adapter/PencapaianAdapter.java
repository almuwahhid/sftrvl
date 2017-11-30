package layout.safetravel.com.safetravel.Adapter;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import layout.safetravel.com.safetravel.R;

public class PencapaianAdapter extends RecyclerView.Adapter<PencapaianAdapter.ViewHolder>  {
    Context context;

    public PencapaianAdapter(Context context) {
        this.context = context;
    }

    @Override
    public PencapaianAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View tampilan = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_pencapaian_adapter, parent, false);
        return new PencapaianAdapter.ViewHolder(tampilan);
    }

    @Override
    public void onBindViewHolder(PencapaianAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 25;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
