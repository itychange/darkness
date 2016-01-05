package com.itychange.darkness;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.felipecsl.gifimageview.library.GifImageView;

public class InsertandUpdate extends AppCompatActivity implements View.OnClickListener{

    private EditText id_baiviet,thongtin;
    private GifImageView mGifImageView;
    private ImageView mImageView;
    private Button insert;
    private Button update;
    public static final String getKey="GetKey";
    private String txt_intent;

    private String 	insert_all_animater_cute="insert_all_animater_cute.php";
    private String insert_all_narutal="insert_all_narutal.php";
    private String insert_all_product="insert_all_product.php";

    private String update_all_animater_cute="update_all_animater_cute .php";
    private String update_all_narutal="update_all_narutal.php";
    private String update_all_products="update_all_products.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertand_update);
        Intent intent=this.getIntent();
        String txt=intent.getStringExtra("getKey");
        Toast.makeText(this,"show"+txt,Toast.LENGTH_SHORT).show();
//        if(txt.equals("image")){
//            Toast.makeText(this,"show"+intent.getStringExtra("getKey"),Toast.LENGTH_SHORT).show();
//
//        }else if(txt.equals("get_all_animater_cute")){
//            Toast.makeText(this,"show"+intent.getStringExtra("getKey"),Toast.LENGTH_SHORT).show();
//
//        }else if(txt.equals("getallnarutal")){
//            Toast.makeText(this,"show"+intent.getStringExtra("getKey"),Toast.LENGTH_SHORT).show();
//
//        }
        id_baiviet= (EditText) findViewById(R.id.id_baiviet);
        thongtin= (EditText) findViewById(R.id.id_thongtin);
        mGifImageView= (GifImageView) findViewById(R.id.imggif);
        mImageView= (ImageView) findViewById(R.id.img);
        insert= (Button) findViewById(R.id.insert);
        insert.setOnClickListener(this);
        update= (Button) findViewById(R.id.update);
        update.setOnClickListener(this);

    }

    @Override
    protected void onStart() {
        super.onStart();
//        Intent intent=this.getIntent();
//        txt_intent=intent.getStringExtra("getKey");
//        if(txt_intent.equals("get_all_products")){
//
//        }
//        else if(txt_intent.equals("get_all_animater_cute")){
//            //gif
//
//        }else if(txt_intent.equals("getallnarutal")){
//
//
//        }
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.update){

        }
        else if(v.getId()==R.id.insert) {

        }
    }
}
