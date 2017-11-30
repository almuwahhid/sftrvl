package layout.safetravel.com.safetravel.Adapter;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import layout.safetravel.com.safetravel.R;

public class LevelTravelAdapter extends RecyclerView.Adapter<LevelTravelAdapter.ViewHolder> {
    Context context;

    public LevelTravelAdapter(Context context) {
        this.context = context;
    }

    @Override
    public LevelTravelAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View tampilan = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_level_travel_adapter, parent, false);
        return new LevelTravelAdapter.ViewHolder(tampilan);
    }

    @Override
    public void onBindViewHolder(LevelTravelAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
