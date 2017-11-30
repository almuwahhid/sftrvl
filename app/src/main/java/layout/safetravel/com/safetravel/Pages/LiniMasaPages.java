package layout.safetravel.com.safetravel.Pages;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import layout.safetravel.com.safetravel.Adapter.InfoStatusProfil;
import layout.safetravel.com.safetravel.Adapter.LiniMasaAdapter;
import layout.safetravel.com.safetravel.R;

public class LiniMasaPages extends AppCompatActivity {
    @BindView(R.id.lini_masa_rv) protected RecyclerView lini_masa_rv;
    LiniMasaAdapter liniMasaAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lini_masa_pages);
        ButterKnife.bind(this);
        setToolbar();
        setRecyclerView();
    }
    private void setToolbar() {
        getSupportActionBar().setTitle("Lini Masa");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    private void setRecyclerView(){
        lini_masa_rv.setHasFixedSize(true);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
        lini_masa_rv.setLayoutManager(lm);
        liniMasaAdapter = new LiniMasaAdapter(this);
        lini_masa_rv.setAdapter(liniMasaAdapter);
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
