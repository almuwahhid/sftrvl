package layout.safetravel.com.safetravel.Fragment;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import layout.safetravel.com.safetravel.R;

public class PerjalananRiwayat extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View tampilan = inflater.inflate(R.layout.activity_perjalanan_riwayat, container, false);
        ButterKnife.bind(this, tampilan);
        return tampilan;
    }
}
