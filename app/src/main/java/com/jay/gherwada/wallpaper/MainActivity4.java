package com.jay.gherwada.wallpaper;

import static com.jay.gherwada.wallpaper.R.id.position;
import static com.jay.gherwada.wallpaper.R.id.viewpager1;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.viewpager.widget.ViewPager;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.WallpaperManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

public class MainActivity4 extends AppCompatActivity {

    Button back, download, share, next, set;
    int pos;
    int image[];
    String image_name;
    ViewPager viewPager1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        back = findViewById(R.id.back);
        download = findViewById(R.id.download);
        share = findViewById(R.id.share);
        next = findViewById(R.id.next);
        set = findViewById(R.id.set);
        viewPager1 = findViewById(viewpager1);

        image = getIntent().getIntArrayExtra("image1");
        pos = getIntent().getIntExtra("pos", 0);
        image_name = getIntent().getStringExtra("category_name");

        viewpager_adapter adapter=new viewpager_adapter(MainActivity4.this,image,pos);
        viewPager1.setAdapter(adapter);
        viewPager1.setCurrentItem(pos);

        getSupportActionBar().setTitle(image_name);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pos=viewPager1.getCurrentItem();
                pos--;
                viewPager1.setCurrentItem(pos);
            }
        });

        download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pos=viewPager1.getCurrentItem();
                File file1 = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + "/Wallpaper");

                if (!file1.exists()) {
                    file1.mkdirs();
                    Toast.makeText(MainActivity4.this, "Folder Created", Toast.LENGTH_SHORT).show();
                }

                // TODO:bitmap>> bytearrayoutputstream>>bitmapcompress>>byte[]

                Bitmap bitmap1 = BitmapFactory.decodeResource(getResources(),image[viewPager1.getCurrentItem()]);
                ByteArrayOutputStream bos1 = new ByteArrayOutputStream();

                bitmap1.compress(Bitmap.CompressFormat.JPEG, 99, bos1);
                byte[] byte1 = bos1.toByteArray();

                int random = new Random().nextInt(10000);
                String image1 = random + "Image.jpg";
                File file2 = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + "/Wallpaper/" + image1);

                try {
                    FileOutputStream fos1 = new FileOutputStream(file2);

                    try {
                        file2.createNewFile();
                        fos1.write(byte1);
                        fos1.close();
                        Toast.makeText(MainActivity4.this, "Image Download Succesfully", Toast.LENGTH_SHORT).show();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

            }
        });

        set.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {

                WallpaperManager myWallpaperManager = WallpaperManager.getInstance(getApplicationContext());
                try {
//                    myWallpaperManager.setResource(image[viewPager1.getCurrentItem()]);
                   myWallpaperManager.setResource(image[pos],WallpaperManager.FLAG_LOCK);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                Toast.makeText(MainActivity4.this, "Wallpaper Set Succesfully", Toast.LENGTH_SHORT).show();
            }
        });

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bitmap bitmap1= BitmapFactory.decodeResource(getResources(),image[viewPager1.getCurrentItem()]);

                String path = MediaStore.Images.Media.insertImage(getContentResolver(), bitmap1, "Image Description", null);
                Uri uri = Uri.parse(path);

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("image/jpg");
                intent.putExtra(Intent.EXTRA_STREAM, uri);
                startActivity(Intent.createChooser(intent, "Share Image"));
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pos=viewPager1.getCurrentItem();
                pos++;
                viewPager1.setCurrentItem(pos);

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.option_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        return super.onOptionsItemSelected(item);
    }
}