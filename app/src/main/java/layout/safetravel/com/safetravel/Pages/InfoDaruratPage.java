package layout.safetravel.com.safetravel.Pages;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import layout.safetravel.com.safetravel.MainActivity;
import layout.safetravel.com.safetravel.R;

public class InfoDaruratPage extends AppCompatActivity implements View.OnClickListener{
    @BindView(R.id.info_darurat_linear_lokasi) protected LinearLayout info_darurat_linear_lokasi;
    @BindView(R.id.info_darurat_linear_telp_kbri) protected LinearLayout info_darurat_linear_telp_kbri;
    @BindView(R.id.info_darurat_linear_rekam_kejadian) protected LinearLayout info_darurat_linear_rekam_kejadian;
    @BindView(R.id.info_darurat_linear_foto_kejadian) protected LinearLayout info_darurat_linear_foto_kejadian;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_darurat_page);
        ButterKnife.bind(this);
        setToolbar();

        info_darurat_linear_lokasi.setOnClickListener(this);
        info_darurat_linear_telp_kbri.setOnClickListener(this);
        info_darurat_linear_rekam_kejadian.setOnClickListener(this);
        info_darurat_linear_foto_kejadian.setOnClickListener(this);
    }
    private void setToolbar() {
        getSupportActionBar().setTitle("Info Darurat");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.info_darurat_linear_lokasi:
                startActivity(new Intent(InfoDaruratPage.this, InfoDaruratLokasi.class));
                break;
            case R.id.info_darurat_linear_telp_kbri:
                startActivity(new Intent(InfoDaruratPage.this, InfoDaruratTelp.class));
                break;
            case R.id.info_darurat_linear_foto_kejadian:
                startActivity(new Intent(InfoDaruratPage.this, InfoDaruratPhoto.class));
                break;
            case R.id.info_darurat_linear_rekam_kejadian:
                startActivity(new Intent(InfoDaruratPage.this, InfoDaruratVideo.class));
                break;
        }
    }
}
