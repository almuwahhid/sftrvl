package layout.safetravel.com.safetravel.Fragment;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import layout.safetravel.com.safetravel.Pages.PerjalananMenetap;
import layout.safetravel.com.safetravel.Pages.PerjalananSementara;
import layout.safetravel.com.safetravel.R;

public class PerjalananPendaftaran extends Fragment implements View.OnClickListener{
    @BindView(R.id.layout_perjalanan_sementara) protected RelativeLayout layout_perjalanan_sementara;
    @BindView(R.id.layout_perjalanan_menetap) protected RelativeLayout layout_perjalanan_menetap;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View tampilan = inflater.inflate(R.layout.activity_perjalanan_pendaftaran, container, false);
        ButterKnife.bind(this, tampilan);

        layout_perjalanan_sementara.setOnClickListener(this);
        layout_perjalanan_menetap.setOnClickListener(this);

        return tampilan;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.layout_perjalanan_sementara:
                startActivity(new Intent(getContext(), PerjalananSementara.class));
                break;
            case R.id.layout_perjalanan_menetap:
                startActivity(new Intent(getContext(), PerjalananMenetap.class));
                break;
        }
    }
}
