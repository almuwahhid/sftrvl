package layout.safetravel.com.safetravel.Fragment;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import layout.safetravel.com.safetravel.Adapter.PanduanPoinAdapter;
import layout.safetravel.com.safetravel.Adapter.PanduanSaranAdapter;
import layout.safetravel.com.safetravel.Adapter.PerjalananRiwayatAdapter;
import layout.safetravel.com.safetravel.R;

public class PanduanPoin extends Fragment implements View.OnClickListener{
    @BindView(R.id.panduan_poin_rv) protected RecyclerView panduan_poin_rv;
    @BindView(R.id.panduan_saran_rv) protected RecyclerView panduan_saran_rv;
    @BindView(R.id.panduan_poin_img_saran) protected ImageView panduan_poin_img_saran;
    @BindView(R.id.panduan_poin_linear_saran) protected LinearLayout panduan_poin_linear_saran;

    PanduanPoinAdapter panduanPoinAdapter;
    PanduanSaranAdapter panduanSaranAdapter;

    boolean isSaran = true;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View tampilan = inflater.inflate(R.layout.activity_panduan_poin, container, false);
        ButterKnife.bind(this, tampilan);
        panduanPoinAdapter = new PanduanPoinAdapter(getContext());
        panduanSaranAdapter = new PanduanSaranAdapter(getContext());
        setRecyclerView(panduan_poin_rv, panduanPoinAdapter);
        setRecyclerView(panduan_saran_rv, panduanSaranAdapter);

        panduan_poin_linear_saran.setOnClickListener(this);
        return tampilan;
    }

    private void setRecyclerView(RecyclerView rv, RecyclerView.Adapter adapter) {
        rv.setHasFixedSize(true);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(getContext());
        rv.setLayoutManager(lm);
        rv.setAdapter(adapter);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.panduan_poin_linear_saran :
                if(isSaran){
                    panduan_poin_img_saran.setImageResource(R.drawable.ic_keyboard_arrow_down_black_24dp);
                    panduan_saran_rv.setVisibility(View.GONE);
                }else{
                    panduan_poin_img_saran.setImageResource(R.drawable.ic_keyboard_arrow_up_black_24dp);
                    panduan_saran_rv.setVisibility(View.VISIBLE);
                }
                isSaran = !isSaran;
                break;
        }
    }
}
