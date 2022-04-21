package com.jay.gherwada.wallpaper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class MainActivity3 extends AppCompatActivity {

    GridView g2;
    int image1[];
    String category_name;
    int pos;

    int animal[]={R.drawable.aa1,R.drawable.aa2,R.drawable.aa3,R.drawable.aa4,R.drawable.aa5,R.drawable.aa6,R.drawable.aa7,R.drawable.aa8,R.drawable.aa9,R.drawable.aa10,R.drawable.aa11,R.drawable.aa12,R.drawable.aa13,R.drawable.aa14,R.drawable.aa15};
    int kids[]={R.drawable.bb2,R.drawable.bb3,R.drawable.bb4,R.drawable.bb5,R.drawable.bb6,R.drawable.bb7,R.drawable.bb8,R.drawable.bb9,R.drawable.bb10,R.drawable.bb11,R.drawable.bb12,R.drawable.bb13,R.drawable.bb14,R.drawable.bb15,R.drawable.bb16};
    int artistic[]={R.drawable.yy2,R.drawable.yy3,R.drawable.yy4,R.drawable.yy5,R.drawable.yy6,R.drawable.yy7,R.drawable.yy8,R.drawable.yy9,R.drawable.yy10,R.drawable.yy11,R.drawable.yy12,R.drawable.yy13,R.drawable.yy14,R.drawable.yy15,R.drawable.yy16};
    int city[]={R.drawable.cc2,R.drawable.cc3,R.drawable.cc4,R.drawable.cc5,R.drawable.cc6,R.drawable.cc7,R.drawable.cc8,R.drawable.cc9,R.drawable.cc10,R.drawable.cc11,R.drawable.cc12,R.drawable.cc13,R.drawable.cc14,R.drawable.cc15,R.drawable.cc16};
    int blur[]={R.drawable.xx2,R.drawable.xx3,R.drawable.xx4,R.drawable.xx5,R.drawable.xx6,R.drawable.xx7,R.drawable.xx8,R.drawable.xx9,R.drawable.xx10,R.drawable.xx11,R.drawable.xx12,R.drawable.xx13,R.drawable.xx14,R.drawable.xx15,R.drawable.xx16};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        g2=findViewById(R.id.g2);
        pos=getIntent().getIntExtra("pos",0);

        if(pos==0)
        {
            image1=animal;
            category_name="Animal";
        }
        if(pos==1)
        {
            image1=kids;
            category_name="Kids";
        }
        if(pos==2)
        {
            image1=artistic;
            category_name="Artistic";
        }
        if(pos==3)
        {
            image1=city;
            category_name="City";
        }
        if(pos==4)
        {
            image1=blur;
            category_name="Blur";
        }

        getSupportActionBar().setTitle(category_name);

        showimage adapter=new showimage(this,image1);
        g2.setAdapter(adapter);

        g2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent=new Intent(MainActivity3.this,MainActivity4.class);
                intent.putExtra("image1",image1);
                intent.putExtra("pos",i);
                intent.putExtra("category_name",category_name);
                startActivity(intent);
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