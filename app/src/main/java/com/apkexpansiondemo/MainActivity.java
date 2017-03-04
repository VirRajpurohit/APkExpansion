package com.apkexpansiondemo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ziplibrary.APKExpansionSupport;
import com.example.ziplibrary.ZipResourceFile;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            //1 and O are version code of main and patch file respectively
            ZipResourceFile expansionFile = APKExpansionSupport.getAPKExpansionZipFile(this, 1, 0);
            InputStream is = expansionFile.getInputStream("ic_launcher.png");
            Bitmap bitmap = BitmapFactory.decodeStream(is);
            ((ImageView) findViewById(R.id.image_expansion_obb)).setImageBitmap(bitmap);
        } catch (Exception e)
        {
            ((TextView)findViewById(R.id.text_expansion_title)).setText("Something went wrong\nPlease read the doc or ReadMe file and follow the steps as Written");
            Toast.makeText(this,"Please read the doc or ReadMe file and follow the steps as Written",Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }
}

