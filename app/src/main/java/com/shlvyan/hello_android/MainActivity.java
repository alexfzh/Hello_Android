package com.shlvyan.hello_android;

import android.content.Intent;
import android.graphics.Canvas;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static android.widget.Toast.LENGTH_LONG;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //拿到listview对象
        ListView lv= (ListView) findViewById(R.id.lv_main);

        //数据源
        List<Map<String,Object>> list=new ArrayList<Map<String, Object>>();
        Map<String,Object> mymap=new HashMap<String, Object>();
        mymap.put("logo",R.drawable.logo_1);
        mymap.put("title","千千静听");
        mymap.put("version","版本:8.4.0");
        mymap.put("size","大小:32.8M");
        list.add(mymap);

        mymap=new HashMap<String, Object>();
        mymap.put("logo",R.drawable.logo_2);
        mymap.put("title","Maxthon");
        mymap.put("version","版本:8.4.0");
        mymap.put("size","大小:32.8M");
        list.add(mymap);

        mymap=new HashMap<String, Object>();
        mymap.put("logo",R.drawable.logo_3);
        mymap.put("title","极品飞车");
        mymap.put("version","版本:8.4.0");
        mymap.put("size","大小:32.8M");
        list.add(mymap);

        mymap=new HashMap<String, Object>();
        mymap.put("logo",R.drawable.logo_4);
        mymap.put("title","小小赛车");
        mymap.put("version","版本:8.4.0");
        mymap.put("size","大小:32.8M");
        list.add(mymap);

        mymap=new HashMap<String, Object>();
        mymap.put("logo",R.drawable.logo_5);
        mymap.put("title","弹珠人");
        mymap.put("version","版本:8.4.0");
        mymap.put("size","大小:32.8M");
        list.add(mymap);

        mymap=new HashMap<String, Object>();
        mymap.put("logo",R.drawable.logo_6);
        mymap.put("title","飞信");
        mymap.put("version","版本:8.4.0");
        mymap.put("size","大小:32.8M");
        list.add(mymap);

        mymap=new HashMap<String, Object>();
        mymap.put("logo",R.drawable.logo_7);
        mymap.put("title","金山词霸");
        mymap.put("version","版本:8.4.0");
        mymap.put("size","大小:32.8M");
        list.add(mymap);


//        String[] data={
//                "1111",
//                "2222",
//                "3333",
//                "4444",
//                "5555",
//                "6666",
//                "7777",
//                "8888",
//                "9999",
//                "0000",
//                "aaaa",
//                "bbbb",
//                "cccc",
//                "dddd"
//        };

        //设置适配器
        MyAdapter myadapter=new MyAdapter(this);
        myadapter.setList(list);
//        SimpleAdapter myadapter=new SimpleAdapter(
//                this, //上下文
//                mylist,//数据源
//                R.layout.item,//行布局,自定义
//                new String[]{"logo","title","version","size"},//map中的keys
//                new int[]{R.id.logo,R.id.title,R.id.version,R.id.size}//行布局中的id
//                );

        //关联适配器
        lv.setAdapter(myadapter);

        //
        lv.setOnItemClickListener(this);
        lv.setOnItemLongClickListener(this);


        //

        Button btn_1= (Button) findViewById(R.id.btn_1);
        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Haha,Alex is the king of the world!",Toast.LENGTH_LONG).show();
            }
        });

        Button btn_learndrawing= (Button) findViewById(R.id.btn_learndrawing);
        btn_learndrawing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(MainActivity.this,DrawingActivity.class);
                startActivity(intent);
            }
        });

        Button btn_chuanzhi= (Button) findViewById(R.id.btn_chuanzhi);
        btn_chuanzhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText etx1= (EditText) findViewById(R.id.etx_1);
                String str1=etx1.getText().toString();
                Intent intent1=new Intent();
                intent1.setClass(MainActivity.this,TestActivity.class);
                intent1.putExtra("alex",str1);
                startActivity(intent1);
            }
        });

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this,"点击了"+position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this,"长按了"+position, Toast.LENGTH_SHORT).show();
    return true;
    }
}
