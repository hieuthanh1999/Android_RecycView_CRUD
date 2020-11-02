package com.example.menxinhgai;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<Model> models;
    Model model;    AdapterList adapterList;
    Button btn_sua, btn_them, btn_dong;
    EditText edit_ma, edit_ten, eit_khuyemai;
    RadioButton rb_nam, rb_nu, rb_da, rb_kimloai, rb_khac;
    String text_sex ="", text_loai="", ma="", ten="", khuyenmai="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        models = new ArrayList<>();
        anhxa();
        data();

        biultRecycview();
        thoat();
    }

    public void thoat()
    {
        btn_dong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder b = new AlertDialog.Builder(MainActivity.this);
                b.setTitle("Xác nhận");
                b.setMessage("Bạn có đồng ý thoát chương trình không?");
                b.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                    }
                });
                b.setNegativeButton("Không đồng ý", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
                AlertDialog al = b.create();
                al.show();
            }
        });

    }
    public void anhxa()
    {
        btn_sua=findViewById(R.id.btn_sua);
        btn_dong= findViewById(R.id.btn_dong);
        recyclerView = findViewById(R.id.recycview);
        btn_them = findViewById(R.id.btn_them);
        edit_ma = findViewById(R.id.et_madh);
        edit_ten = findViewById(R.id.et_tendh);
        eit_khuyemai = findViewById(R.id.et_khuyenmai);
        rb_nam = findViewById(R.id.nam);
        rb_nu = findViewById(R.id.nu);
        rb_khac = findViewById(R.id.khac);
        rb_da = findViewById(R.id.da);
        rb_kimloai = findViewById(R.id.kimloai);
    }
    public  void data()
    {

        btn_them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(rb_nam.isChecked()) {
                    text_sex = rb_nam.getText().toString();
                } else if(rb_nu.isChecked()) {
                    text_sex = rb_nu.getText().toString();
                }
                if(rb_da.isChecked()) {
                    text_loai = rb_da.getText().toString();
                } else if(rb_kimloai.isChecked()) {
                    text_loai = rb_kimloai.getText().toString();
                }else if(rb_khac.isChecked()){
                    text_loai = rb_khac.getText().toString();
                }
                ma = edit_ma.getText().toString();
                ten =edit_ten.getText().toString();
                khuyenmai =  eit_khuyemai.getText().toString();

                models.add(new Model(ma,ten,text_sex,text_loai, khuyenmai));
                adapterList.notifyDataSetChanged();

                edit_ma.setText("");
                edit_ten.setText("");
                eit_khuyemai.setText("");
            }
        });

        models.add(new Model("123", "hiếm", "Nam", "kim loại", "không"));
        models.add(new Model("123", "hiếm", "Nữ", "kim loại", "không"));
        models.add(new Model("123", "hiếm", "Nữ", "kim loại", "không"));
    }
    public void biultRecycview()
    {
        adapterList = new AdapterList(this, models);
        recyclerView.setAdapter(adapterList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapterList.notifyDataSetChanged();

        adapterList.setCallBack(new OnClick() {
            @Override
            public void onClickTvName(Model model) {
                edit_ma.setText(model.getMa());
                edit_ten.setText(model.getTen());
                eit_khuyemai.setText(model.getKhuyenmai());
                if(model.getLoai().equals("Nam"))
                {

                    //Toast.makeText(MainActivity.this, model.getLoai(), Toast.LENGTH_SHORT).show();
                    rb_nam.setChecked(true);
                }
                if(model.getLoai().equals("Nữ")){
                    rb_nu.setChecked(true);
                    //Toast.makeText(MainActivity.this, model.getLoai(), Toast.LENGTH_SHORT).show();
                }
                if(model.getDay().equals("da"))
                {
                    //Toast.makeText(MainActivity.this, model.getDay(), Toast.LENGTH_SHORT).show();
                    rb_da.setChecked(true);

                }
                if(model.getDay().equals("kim loại")){
                    rb_kimloai.setChecked(true);
                   // Toast.makeText(MainActivity.this, model.getDay(), Toast.LENGTH_SHORT).show();
                }

                if (model.getDay().equals("Khác")){
                   // Toast.makeText(MainActivity.this, model.getDay(), Toast.LENGTH_SHORT).show();
                    rb_khac.setChecked(true);

                }
                btn_sua.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        data();
                    }
                });
            }
        });


    }

}
