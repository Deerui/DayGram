package com.example.sdr123.listview;


import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends Activity {
    private ListView listView;
    private ArrayAdapter<String> arr_adapter;
    private SimpleAdapter simp_adapter;
    private List<Map<String,Object>>dataList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        listView = (ListView) findViewById(R.id.listView);
        //1、新建一个适配器
        //ArrayAdapter(上下文，当前List View加载的每一个列表项所对应的布局文件）
        //2、适配器加载数据源
        String[]arr_data={"android 1","android 2","android 3","android 4"};
        dataList=new ArrayList<Map<String,Object>>();
        arr_adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,arr_data);
        simp_adapter=new SimpleAdapter(this,getData(),R.layout.item,new String[]{"text","week","day"},new int[]{R.id.tex,R.id.week,R.id.day});
        //3、视图（List View）加载适配器
        //listView.setAdapter(arr_adapter);
        listView.setAdapter(simp_adapter);
    }
    private List<Map<String,Object>> getData()
    {
        for(int i=0;i<20;i++)
        {
            Map<String,Object>map=new HashMap<String,Object>();
            map.put("week","SUN");
            map.put("day","1");
            map.put("text","Demo"+i);
            dataList.add(map);
        }
        return dataList;
    }
}
