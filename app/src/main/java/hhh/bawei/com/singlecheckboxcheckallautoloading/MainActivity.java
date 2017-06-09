package hhh.bawei.com.singlecheckboxcheckallautoloading;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private ListView lv;

    private boolean checked;

    private List<CheckBean> list=new ArrayList<CheckBean>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        getData();

      final  MyAdapter adapter = new MyAdapter(list,this);
        lv.setAdapter(adapter);

        //ittem的点击事件
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, ""+i, Toast.LENGTH_SHORT).show();
            }
        });
        findViewById(R.id.btn_id).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                for(int i=0;i<list.size();i++){
                    if(!checked){
                        list.get(i).setIscheck(true);
                    }else {
                        list.get(i).setIscheck(false);
                    }
                }
                adapter.notifyDataSetChanged();

                if(!checked){
                    checked = true;
                }else {
                    checked = false;
                }

            }
        });



        lv.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {


                if(scrollState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE ){

                    //婊氬姩鍋滄
                    if(mFotalItemCount - mVisibleItemCount - mFirstVisibleItem <= 5){

                        for(int i=51;i<100;i++){
                            CheckBean checkBean = new CheckBean();
                            checkBean.setContent(i+"");
                            list.add(checkBean);
                        }
                        adapter.notifyDataSetChanged();

                    }

                }

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {


                mFirstVisibleItem = firstVisibleItem;
                mVisibleItemCount = visibleItemCount;
                mFotalItemCount = totalItemCount;

                System.out.println("firstVisibleItem = " + firstVisibleItem);
                System.out.println("visibleItemCount = " + visibleItemCount);
                System.out.println("totalItemCount = " + totalItemCount);




            }
        });


    }

    public  int mFirstVisibleItem ; int mVisibleItemCount; int mFotalItemCount;




    private void initView() {
        lv = (ListView) findViewById(R.id.listView);

    }
    private void getData() {
        for (int i = 0; i <30 ; i++) {
            CheckBean checkBean = new CheckBean();
            checkBean.setContent(i+"");
            list.add(checkBean);
        }
    }


}
