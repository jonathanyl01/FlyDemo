package com.example.administrator.flydemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.race604.flyrefresh.FlyRefreshLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private FlyRefreshLayout flyRefreshLayout;
    private ListView mListView;
    private List mList = new ArrayList();
    private MyAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        flyRefreshLayout = (FlyRefreshLayout) findViewById(R.id.fly);
        mListView = (ListView) findViewById(R.id.list);
        initData();
        initAdapter();

        flyRefreshLayout.setOnPullRefreshListener(new FlyRefreshLayout.OnPullRefreshListener() {
            @Override
            public void onRefresh(FlyRefreshLayout view) {

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        mAdapter.clear();
                        loadMore();

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {

                                mAdapter.notifyDataSetChanged();
                                flyRefreshLayout.onRefreshFinish();
                            }
                        });

                    }
                }).start();


            }

            @Override
            public void onRefreshAnimationEnd(FlyRefreshLayout view) {


            }
        });


    }

    private void initAdapter() {
        mAdapter = new MyAdapter(this);
        mListView.setAdapter(mAdapter);
        mAdapter.setData(mList);

    }

    private void initData() {

        mList.add(R.mipmap.ic_launcher);
        mList.add(R.mipmap.ic_launcher);
        mList.add(R.mipmap.ic_launcher);
        mList.add(R.mipmap.ic_launcher);
        mList.add(R.mipmap.ic_launcher);
        mList.add(R.mipmap.ic_launcher);
        mList.add(R.mipmap.ic_launcher);
        mList.add(R.mipmap.ic_launcher);
        mList.add(R.mipmap.ic_launcher);
        mList.add(R.mipmap.ic_launcher);
        mList.add(R.mipmap.ic_launcher);
        mList.add(R.mipmap.ic_launcher);

    }

    private void loadMore() {
        mList.add(R.drawable.image_holder_banner);
        mList.add(R.drawable.image_holder_banner);
        mList.add(R.drawable.image_holder_banner);
        mList.add(R.drawable.image_holder_banner);
        mList.add(R.drawable.image_holder_banner);
        mList.add(R.drawable.image_holder_banner);
        mList.add(R.drawable.image_holder_banner);

    }
}
