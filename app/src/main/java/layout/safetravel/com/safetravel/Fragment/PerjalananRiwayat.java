package layout.safetravel.com.safetravel.Fragment;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import layout.safetravel.com.safetravel.Adapter.DaruratTelpAdapter;
import layout.safetravel.com.safetravel.Adapter.PerjalananRiwayatAdapter;
import layout.safetravel.com.safetravel.R;

public class PerjalananRiwayat extends Fragment {
    @BindView(R.id.riwayat_rv) protected RecyclerView riwayat_rv;
    PerjalananRiwayatAdapter perjalananRiwayatAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View tampilan = inflater.inflate(R.layout.activity_perjalanan_riwayat, container, false);
        ButterKnife.bind(this, tampilan);
        setRecyclerView();

        return tampilan;
    }
    private void setRecyclerView(){
        riwayat_rv.setHasFixedSize(true);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(getContext());
        riwayat_rv.setLayoutManager(lm);
        perjalananRiwayatAdapter = new PerjalananRiwayatAdapter(getContext());
        riwayat_rv.setAdapter(perjalananRiwayatAdapter);
    }
}
