package com.example.implicitintents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
EditText ed_share, ed_loc, ed_site;
Button browser, share, loc,photo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed_site=findViewById(R.id.ed_web);
        browser=findViewById(R.id.btn_browser);
        browser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String site=ed_site.getText().toString();
                Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse("http://"+site));
                startActivity(i);
            }
        });
        ed_loc=findViewById(R.id.ed_loc);
        loc=findViewById(R.id.btn_loc);
        loc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String location=ed_loc.getText().toString();
                Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q="+location));
                startActivity(i);
            }
        });
        ed_share=findViewById(R.id.ed_text);
        share=findViewById(R.id.btn_share);
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              String  text=ed_share.getText().toString();
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, text);
                sendIntent.setType("text/plain");

                Intent shareIntent = Intent.createChooser(sendIntent, null);
                startActivity(shareIntent);
            }
        });
        photo=findViewById(R.id.btn_ph);
        photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent("android.media.action.IMAGE_CAPTURE");
                startActivity(i);
            }
        });
    }
}