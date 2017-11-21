package layout.safetravel.com.safetravel;

import android.content.Intent;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import layout.safetravel.com.safetravel.Pages.PerjalananPage;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.main_perjalanan) protected RelativeLayout main_perjalanan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        main_perjalanan.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.main_perjalanan:
                startActivity(new Intent(MainActivity.this, PerjalananPage.class));
                break;
        }
    }
}
