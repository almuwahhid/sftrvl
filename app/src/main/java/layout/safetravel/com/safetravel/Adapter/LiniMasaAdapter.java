package layout.safetravel.com.safetravel.Adapter;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.vipulasri.timelineview.TimelineView;

import butterknife.BindView;
import butterknife.ButterKnife;
import layout.safetravel.com.safetravel.R;

public class LiniMasaAdapter extends RecyclerView.Adapter<LiniMasaAdapter.ViewHolder> {
    Context context;

    public LiniMasaAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        return TimelineView.getTimeLineViewType(position,getItemCount());
    }

    @Override
    public LiniMasaAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View tampilan = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_lini_masa_adapter, parent, false);
        return new LiniMasaAdapter.ViewHolder(tampilan, viewType);
    }

    @Override
    public void onBindViewHolder(LiniMasaAdapter.ViewHolder holder, int position) {
        holder.mTimelineView.setMarker(context.getResources().getDrawable(R.drawable.loc_circle));
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.timeline_marker)
        TimelineView mTimelineView;
        public ViewHolder(View itemView, int viewType) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mTimelineView.initLine(viewType);
        }
    }
}
