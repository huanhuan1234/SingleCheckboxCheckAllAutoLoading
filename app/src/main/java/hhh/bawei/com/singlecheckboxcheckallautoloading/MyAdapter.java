package hhh.bawei.com.singlecheckboxcheckallautoloading;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Huangminghuan on 2017/6/8.
 */

public class MyAdapter extends BaseAdapter {
    List<CheckBean> list;
    Context context;

    public MyAdapter(List<CheckBean> list, Context context) {
        this.list=list;
        this.context=context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        final ViewHolder viewHolder;
        if (view==null){
            viewHolder=new ViewHolder();
            view=View.inflate(context,R.layout.check_box_item,null);
           viewHolder.checkbox_textview = (TextView) view.findViewById(R.id.checkbox_textview);

            viewHolder.checkbox_id=(CheckBox)view.findViewById(R.id.checkbox_id);
            view.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) view.getTag();
        }
        viewHolder.checkbox_textview.setText(list.get(i).getContent());
        viewHolder.checkbox_id.setChecked(list.get(i).ischeck());

        viewHolder.checkbox_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (list.get(i).ischeck){
                    list.get(i).setIscheck(false);
                    viewHolder.checkbox_id.setChecked(false);
                }else {
                    list.get(i).setIscheck(true);
                    viewHolder.checkbox_id.setChecked(true);
                }
                notifyDataSetChanged();
            }
        });
        return view;
    }

    static  class ViewHolder{
         TextView checkbox_textview;
         CheckBox checkbox_id;

    }
}
