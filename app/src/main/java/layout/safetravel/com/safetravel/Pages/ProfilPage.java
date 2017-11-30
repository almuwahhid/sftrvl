package layout.safetravel.com.safetravel.Pages;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import layout.safetravel.com.safetravel.Adapter.InfoStatusProfil;
import layout.safetravel.com.safetravel.MainActivity;
import layout.safetravel.com.safetravel.R;

public class ProfilPage extends AppCompatActivity implements View.OnClickListener{
    @BindView(R.id.profil_rv) protected RecyclerView recycler_view;
    @BindView(R.id.profil_imgbtn_edit) protected ImageButton btn_edit_profil;
    @BindView(R.id.profil_relative_linimasa) protected RelativeLayout profil_relative_linimasa;
    @BindView(R.id.profil_relative_infopoin) protected RelativeLayout profil_relative_infopoin;
    InfoStatusProfil infoStatusProfil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil_page);
        ButterKnife.bind(this);
        setRecyclerView();
        setToolbar();

        btn_edit_profil.setOnClickListener(this);
        profil_relative_linimasa.setOnClickListener(this);
        profil_relative_infopoin.setOnClickListener(this);
    }

    private void setToolbar() {
        getSupportActionBar().setTitle("Profil Member");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setRecyclerView(){
        recycler_view.setHasFixedSize(true);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
        recycler_view.setLayoutManager(lm);
        infoStatusProfil = new InfoStatusProfil();
        recycler_view.setAdapter(infoStatusProfil);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.profil_imgbtn_edit:
                startActivity(new Intent(ProfilPage.this, EditProfilPage.class));
                break;
            case R.id.profil_relative_linimasa:
                startActivity(new Intent(ProfilPage.this, LiniMasaPages.class));
                break;
            case R.id.profil_relative_infopoin:
                startActivity(new Intent(ProfilPage.this, InfoPoinPage.class));
                break;
        }
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
