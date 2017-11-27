package layout.safetravel.com.safetravel;

import android.content.Intent;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import layout.safetravel.com.safetravel.Pages.CheckInPage;
import layout.safetravel.com.safetravel.Pages.InfoDaruratPage;
import layout.safetravel.com.safetravel.Pages.PerjalananPage;
import layout.safetravel.com.safetravel.Pages.ProfilPage;
import layout.safetravel.com.safetravel.Pages.TambahTempatWisata;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.main_perjalanan) protected RelativeLayout main_perjalanan;
    @BindView(R.id.main_profil) protected RelativeLayout main_profil;
    @BindView(R.id.main_checkin) protected RelativeLayout main_checkin;
    @BindView(R.id.main_tambahisata) protected RelativeLayout main_tambahisata;
    @BindView(R.id.main_infodarurat) protected RelativeLayout main_infodarurat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        main_perjalanan.setOnClickListener(this);
        main_profil.setOnClickListener(this);
        main_checkin.setOnClickListener(this);
        main_tambahisata.setOnClickListener(this);
        main_infodarurat.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.main_perjalanan:
                startActivity(new Intent(MainActivity.this, PerjalananPage.class));
                break;
            case R.id.main_profil:
                startActivity(new Intent(MainActivity.this, ProfilPage.class));
                break;
            case R.id.main_checkin:
                startActivity(new Intent(MainActivity.this, CheckInPage.class));
                break;
            case R.id.main_tambahisata:
                startActivity(new Intent(MainActivity.this, TambahTempatWisata.class));
                break;
            case R.id.main_infodarurat:
                startActivity(new Intent(MainActivity.this, InfoDaruratPage.class));
                break;
        }
    }
}
