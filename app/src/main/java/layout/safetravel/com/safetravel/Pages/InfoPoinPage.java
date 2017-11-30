package layout.safetravel.com.safetravel.Pages;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import butterknife.BindView;
import butterknife.ButterKnife;
import layout.safetravel.com.safetravel.Fragment.LevelTravel;
import layout.safetravel.com.safetravel.Fragment.PanduanPoin;
import layout.safetravel.com.safetravel.Fragment.Pencapaian;
import layout.safetravel.com.safetravel.Fragment.PerjalananPendaftaran;
import layout.safetravel.com.safetravel.Fragment.PerjalananRiwayat;
import layout.safetravel.com.safetravel.R;

public class InfoPoinPage extends AppCompatActivity {
    @BindView(R.id.info_poin_tablayout) protected TabLayout info_poin_tablayout;
    @BindView(R.id.info_poin_vp) protected ViewPager info_poin_vp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_poin_page);
        ButterKnife.bind(this);

        setToolbar();
        setTabAdapter();
    }

    private void setTabAdapter() {
        info_poin_vp.setAdapter(new InfoPoinPage.Tab(getSupportFragmentManager()));
        info_poin_vp.setOffscreenPageLimit(0);
        info_poin_tablayout.setupWithViewPager(info_poin_vp);
        info_poin_tablayout.setTabGravity(TabLayout.GRAVITY_FILL);
        info_poin_tablayout.getTabAt(0).setText("PANDUAN POIN");
        info_poin_tablayout.getTabAt(1).setText("PENCAPAIAN");
        info_poin_tablayout.getTabAt(2).setText("LEVEL TRAVEL");
    }
    private void setToolbar() {
        getSupportActionBar().setTitle("Info Poin");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private class Tab extends FragmentPagerAdapter {

        public Tab(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment = null;
            switch (position){
                case 0 :
                    fragment = new PanduanPoin();
                    break;
                case 1 :
                    fragment = new Pencapaian();
                    break;
                case 2 :
                    fragment = new LevelTravel();
                    break;
            }
            return fragment;
        }

        @Override
        public int getCount() {
            return 3;
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
