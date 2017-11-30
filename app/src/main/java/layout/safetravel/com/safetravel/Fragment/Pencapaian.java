package layout.safetravel.com.safetravel.Fragment;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import layout.safetravel.com.safetravel.Adapter.PencapaianAdapter;
import layout.safetravel.com.safetravel.R;

public class Pencapaian extends Fragment {
    @BindView(R.id.pencapaian_rv) protected RecyclerView pencapaian_rv;
    PencapaianAdapter pencapaianAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View tampilan = inflater.inflate(R.layout.activity_pencapaian, container, false);
        ButterKnife.bind(this, tampilan);
        pencapaianAdapter = new PencapaianAdapter(getContext());
        setRecyclerView(pencapaian_rv, pencapaianAdapter);

        return tampilan;
    }
    private void setRecyclerView(RecyclerView rv, RecyclerView.Adapter adapter) {
        rv.setHasFixedSize(true);
        RecyclerView.LayoutManager lm = new GridLayoutManager(getContext(), 5);
        rv.setLayoutManager(lm);
        rv.setAdapter(adapter);

    }
}
