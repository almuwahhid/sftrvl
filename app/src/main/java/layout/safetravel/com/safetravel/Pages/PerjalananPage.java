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
import layout.safetravel.com.safetravel.Fragment.PerjalananPendaftaran;
import layout.safetravel.com.safetravel.Fragment.PerjalananRiwayat;
import layout.safetravel.com.safetravel.R;

public class PerjalananPage extends AppCompatActivity {
    @BindView(R.id.perjalanan_tablayout) protected TabLayout perjalanan_tablayout;
    @BindView(R.id.perjalanan_vp) protected ViewPager perjalanan_vp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perjalanan_page);
        ButterKnife.bind(this);

        setToolbar();
        setTabAdapter();
    }

    private void setToolbar() {
        getSupportActionBar().setTitle(getString(R.string.pendaftaran_perjalanan));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setTabAdapter() {
        perjalanan_vp.setAdapter(new Tab(getSupportFragmentManager()));
        perjalanan_vp.setOffscreenPageLimit(0);
        perjalanan_tablayout.setupWithViewPager(perjalanan_vp);
        perjalanan_tablayout.setTabGravity(TabLayout.GRAVITY_FILL);
        perjalanan_tablayout.getTabAt(0).setText(getString(R.string.pendaftaran));
        perjalanan_tablayout.getTabAt(1).setText(getString(R.string.riwayat));
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
                    fragment = new PerjalananPendaftaran();
                    break;
                case 1 :
                    fragment = new PerjalananRiwayat();
                    break;
            }
            return fragment;
        }

        @Override
        public int getCount() {
            return 2;
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
