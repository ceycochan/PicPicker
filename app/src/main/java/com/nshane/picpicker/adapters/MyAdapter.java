package com.nshane.picpicker.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Toast;

import com.nshane.picpicker.R;
import com.nshane.picpicker.bean.ImageBean;
import com.nshane.picpicker.utils.Loader;
import com.nshane.picpicker.utils.LogUtil;
import com.yzs.imageshowpickerview.ImageShowPickerBean;
import com.yzs.imageshowpickerview.ImageShowPickerListener;
import com.yzs.imageshowpickerview.ImageShowPickerView;

import java.util.List;


public class MyAdapter extends BaseAdapter {

    private List<List<ImageBean>> mDataList;
    private Context context;

    public MyAdapter(List<List<ImageBean>> list, Context context) {
        this.mDataList = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return mDataList.size();
    }

    @Override
    public List<ImageBean> getItem(int position) {
        return mDataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final MyViewHolder holder;

        if (convertView != null) {
            holder = (MyViewHolder) convertView.getTag();
        } else {
            holder = new MyViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item, null);
            holder.pickerView = (ImageShowPickerView) convertView.findViewById(R.id.iv_picker_view);
            convertView.setTag(holder);
        }

        final List<ImageBean> list = getItem(position);

//        LogUtil.d("cg", "======" + list.size());

        holder.pickerView.setImageLoaderInterface(new Loader());
        holder.pickerView.setNewData(list);
        // 调整有无动画效果
        if (position % 2 == 1) {
            holder.pickerView.setShowAnim(true);
        } else {
            holder.pickerView.setShowAnim(false);
        }

        holder.pickerView.setPickerListener(new ImageShowPickerListener() {
            @Override
            public void addOnClickListener(int remainNum) { // remainNum
                Toast.makeText(context, "remainNum" + remainNum, Toast.LENGTH_SHORT).show();
                list.add(new ImageBean("http://pic78.huitu.com/res/20160604/1029007_20160604114552332126_1.jpg"));

                LogUtil.d("cg", list.size() + "");
                holder.pickerView.addData(new ImageBean("http://pic78.huitu.com/res/20160604/1029007_20160604114552332126_1.jpg"));

            }

            @Override
            public void picOnClickListener(List<ImageShowPickerBean> list, int position, int remainNum) {
                Toast.makeText(context, list.size() + "========" + position + "remainNum" + remainNum, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void delOnClickListener(int position, int remainNum) {
                list.remove(position);
            }
        });
        holder.pickerView.show();
        return convertView;
    }


    class MyViewHolder {
        private ImageShowPickerView pickerView;
    }
}
