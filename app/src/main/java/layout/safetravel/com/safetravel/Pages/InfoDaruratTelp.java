package layout.safetravel.com.safetravel.Pages;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import butterknife.BindView;
import butterknife.ButterKnife;
import layout.safetravel.com.safetravel.Adapter.DaruratTelpAdapter;
import layout.safetravel.com.safetravel.Adapter.LiniMasaAdapter;
import layout.safetravel.com.safetravel.R;

public class InfoDaruratTelp extends AppCompatActivity {
    @BindView(R.id.darurat_telp_rv) protected RecyclerView darurat_telp_rv;
    DaruratTelpAdapter daruratTelpAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_darurat_telp);
        ButterKnife.bind(this);
        setRecyclerView();
        setToolbar();
    }
    private void setToolbar() {
        getSupportActionBar().setTitle("Info Darurat Telp. KBRI");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    private void setRecyclerView(){
        darurat_telp_rv.setHasFixedSize(true);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
        darurat_telp_rv.setLayoutManager(lm);
        daruratTelpAdapter = new DaruratTelpAdapter(this);
        darurat_telp_rv.setAdapter(daruratTelpAdapter);
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
}
