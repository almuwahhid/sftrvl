package layout.safetravel.com.safetravel.Pages;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import layout.safetravel.com.safetravel.R;
import layout.safetravel.com.safetravel.Utility.FormSetter;

public class PerjalananMenetap extends AppCompatActivity implements View.OnClickListener, View.OnFocusChangeListener {
    @BindView(R.id.btn_perjalanan) protected Button btn_perjalanan;
    @BindView(R.id.btn_anggota_perjalanan) protected Button btn_anggota_perjalanan;

    @BindView(R.id.edt_email) protected EditText edt_email;
    @BindView(R.id.edt_nama_lengkap) protected EditText edt_nama_lengkap;
    @BindView(R.id.edt_masa_berlaku) protected EditText edt_masa_berlaku;
    @BindView(R.id.edt_no_passport) protected EditText edt_no_passport;
    @BindView(R.id.edt_tgl_berangkat) protected EditText edt_tgl_berangkat;
    @BindView(R.id.edt_tgl_pulang) protected EditText edt_tgl_pulang;
    @BindView(R.id.edt_tgl_lahir) protected EditText edt_tgl_lahir;

    @BindView(R.id.tv_tgl_lahir) protected TextView tv_tgl_lahir;
    @BindView(R.id.tv_tgl_berangkat) protected TextView tv_tgl_berangkat;
    @BindView(R.id.tv_tgl_pulang) protected TextView tv_tgl_pulang;
    @BindView(R.id.tv_masa_berlaku) protected TextView tv_masa_berlaku;

    Dialog dialog;
    Dialog dialog_form;
    DatePickerDialog datePickerDialog;
    int year, month, day;

    PerjalananMenetap.InitAnggota initAnggota;
    PerjalananMenetap.InitPerjalanan initPerjalanan;

    Boolean isPerjalanan; // digunakan sebagai identifikasi edit/tambah perjalanan
    Boolean isAnggota; // digunakan sebagai identifikasi edit/tambah anggota

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perjalanan_menetap);
        ButterKnife.bind(this);
        setToolbar();

        btn_perjalanan.setOnClickListener(this);
        btn_anggota_perjalanan.setOnClickListener(this);

        edt_masa_berlaku.setOnFocusChangeListener(this);
        edt_tgl_berangkat.setOnFocusChangeListener(this);
        edt_tgl_pulang.setOnFocusChangeListener(this);
        edt_tgl_lahir.setOnFocusChangeListener(this);
    }
    void setToolbar(){
        getSupportActionBar().setTitle("Perjalanan Menetap");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    // TODO: 11/21/17 Fungsi untuk set dialog formulir berdasarkan data
    private void setFormDialog(int layout){
        dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(layout);
        dialog.setCanceledOnTouchOutside(true);
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        Window window = dialog.getWindow();
        lp.copyFrom(window.getAttributes());
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        window.setAttributes(lp);
        dialog.show();
    }

    private void setDateNow(){
        Date date = new Date(); // your date
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        year = cal.get(Calendar.YEAR);
        month = cal.get(Calendar.MONTH);
        day = cal.get(Calendar.DAY_OF_MONTH);
    }

    private void initDatePicker(final EditText editText, final TextView tv){
        setDateNow();
        datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                String m = String.valueOf(month+1);
                String d = String.valueOf(dayOfMonth);
                if((month+1)<10)
                    m = "0"+m;
                if(dayOfMonth<10)
                    d = "0"+d;
                editText.setText(d+" "+new FormSetter().getMonthText(month+1)+" "+year);
                tv.setText(year+"-"+m+"-"+d);
            }
        }, year, month, day);
        datePickerDialog.show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_perjalanan:
                isPerjalanan = true;
                setFormDialog(R.layout.form_tujuan_perjalanan);
                initPerjalanan  = new PerjalananMenetap.InitPerjalanan(dialog);
                initPerjalanan.initKomponen();

                break;
            case R.id.btn_anggota_perjalanan:
                isAnggota = true;
                setFormDialog(R.layout.form_anggota_perjalanan);
                initAnggota = new PerjalananMenetap.InitAnggota(dialog);
                initAnggota.initKomponen();
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

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if(hasFocus){
            switch (v.getId()){
                case R.id.edt_tgl_berangkat:
                    initDatePicker(edt_tgl_berangkat, tv_tgl_berangkat);
                    break;
                case R.id.edt_tgl_pulang:
                    initDatePicker(edt_tgl_pulang, tv_tgl_pulang);
                    break;
                case R.id.edt_tgl_lahir:
                    initDatePicker(edt_tgl_lahir, tv_tgl_lahir);
                    break;
                case R.id.edt_masa_berlaku:
                    initDatePicker(edt_masa_berlaku, tv_masa_berlaku);
                    break;
            }
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    // TODO: 11/21/17 inisialisasi komponen untuk form anggota
    protected class InitAnggota implements View.OnFocusChangeListener {
        Dialog dialog;
        @BindView(R.id.edt_anggota_perjalanan_paspor) protected EditText edt_anggota_perjalanan_paspor;
        @BindView(R.id.layout_anggota_perjalanan_paspor) protected TextInputLayout layout_anggota_perjalanan_paspor;

        @BindView(R.id.edt_anggota_perjalanan_jk) protected EditText edt_anggota_perjalanan_jk;
        @BindView(R.id.layout_anggota_perjalanan_jk) protected TextInputLayout layout_anggota_perjalanan_jk;

        @BindView(R.id.edt_anggota_perjalanan_nama) protected EditText edt_anggota_perjalanan_nama;
        @BindView(R.id.layout_anggota_perjalanan_nama) protected TextInputLayout layout_anggota_perjalanan_nama;

        @BindView(R.id.edt_anggota_perjalanan_tgl_lahir) protected EditText edt_anggota_perjalanan_tgl_lahir;
        @BindView(R.id.layout_anggota_perjalanan_tgl_lahir) protected TextInputLayout layout_anggota_perjalanan_tgl_lahir;
        @BindView(R.id.tv_anggota_tgl_lahir) protected TextView tv_anggota_tgl_lahir;

        @BindView(R.id.edt_anggota_perjalanan_masa_berlaku) protected EditText edt_anggota_perjalanan_masa_berlaku;
        @BindView(R.id.layout_anggota_perjalanan_masa_berlaku) protected TextInputLayout layout_anggota_perjalanan_masa_berlaku;
        @BindView(R.id.tv_anggota_masa_berlaku) protected TextView tv_anggota_masa_berlaku;

        @BindView(R.id.btn_anggota_perjalanan_submit) protected Button btn_anggota_perjalanan_submit;

        public InitAnggota(Dialog dialog) {
            this.dialog = dialog;
            ButterKnife.bind(this, dialog);
        }

        protected void initKomponen(){
            layout_anggota_perjalanan_jk.setHint("Jenis Kelamin");
            layout_anggota_perjalanan_nama.setHint("Nama Lengkap");
            layout_anggota_perjalanan_paspor.setHint("No. Paspor");
            layout_anggota_perjalanan_masa_berlaku.setHint("Masa Berlaku Paspor");
            layout_anggota_perjalanan_tgl_lahir.setHint("Tanggal Lahir");

            edt_anggota_perjalanan_masa_berlaku.setOnFocusChangeListener(this);
            edt_anggota_perjalanan_tgl_lahir.setOnFocusChangeListener(this);
        }

        @Override
        public void onFocusChange(View v, boolean hasFocus) {
            if(hasFocus){
                switch (v.getId()){
                    case R.id.edt_anggota_perjalanan_masa_berlaku:
                        initDatePicker(edt_anggota_perjalanan_masa_berlaku, tv_anggota_masa_berlaku);
                        break;
                    case R.id.edt_anggota_perjalanan_tgl_lahir:
                        initDatePicker(edt_anggota_perjalanan_tgl_lahir, tv_anggota_tgl_lahir);
                        break;
                }
            }
        }
    }

    // TODO: 11/21/17 inisialisasi komponen untuk form perjalanan
    protected class InitPerjalanan implements View.OnFocusChangeListener {
        Dialog dialog;
        @BindView(R.id.edt_perjalanan_masa_berlaku) protected EditText edt_perjalanan_masa_berlaku;
        @BindView(R.id.tv_perjalanan_masa_berlaku) protected TextView tv_perjalanan_masa_berlaku;

        protected void initKomponen(){
            edt_perjalanan_masa_berlaku.setOnFocusChangeListener(this);
        }

        public InitPerjalanan(Dialog dialog) {
            this.dialog = dialog;
            ButterKnife.bind(this, dialog);
        }

        @Override
        public void onFocusChange(View v, boolean hasFocus) {
            if(hasFocus){
                switch (v.getId()){
                    case R.id.edt_perjalanan_masa_berlaku:
                        initDatePicker(edt_perjalanan_masa_berlaku, tv_perjalanan_masa_berlaku);
                        break;
                }
            }
        }
    }
}