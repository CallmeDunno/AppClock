package com.example.appclock;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import java.util.List;

public class ListViewAdapter extends BaseAdapter {

    private final Context context;
    private final int layout;
    private final List<LineListView> lineListViews;

    public ListViewAdapter(Context context, int layout, List<LineListView> lineListViews) {
        this.context = context;
        this.layout = layout;
        this.lineListViews = lineListViews;
    }

    @Override
    public int getCount() {
        return lineListViews.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    private class ViewHolder {
        TextView textViewHour;
        TextView textViewStatus;
        TextView textViewButton;
        //Button buttonDown;
        Switch aSwitch;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder viewHolder;

        if (view == null) {
            viewHolder = new ViewHolder();

            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(layout, null);

            viewHolder.textViewHour = view.findViewById(R.id.textViewHour);
            viewHolder.textViewStatus = view.findViewById(R.id.textViewStatus);
            //viewHolder.buttonDown = view.findViewById(R.id.buttonDown);
            viewHolder.aSwitch = view.findViewById(R.id.switchStatus);
            viewHolder.textViewButton = view.findViewById(R.id.buttonDown);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.textViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (lineListViews.get(i).getStatusButton().equals("up")) {
                    viewHolder.textViewButton.setBackgroundResource(R.drawable.chevron_down);
                    lineListViews.get(i).setStatusButton("down");


                } else {
                    viewHolder.textViewButton.setBackgroundResource(R.drawable.chevron_up);
                    lineListViews.get(i).setStatusButton("up");


                }
            }
        });
//        viewHolder.buttonDown.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (lineListViews.get(i).getStatusButton().equals("up")) {
//                    viewHolder.buttonDown.setBackgroundResource(R.drawable.chevron_down);
//                    lineListViews.get(i).setStatusButton("down");
//                    viewHolder.buttonM.setVisibility(View.INVISIBLE);
//
//                } else {
//                    viewHolder.buttonDown.setBackgroundResource(R.drawable.chevron_up);
//                    lineListViews.get(i).setStatusButton("up");
//                    viewHolder.buttonM.setVisibility(View.VISIBLE);
//
//                }
//            }
//        });

        viewHolder.aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    viewHolder.textViewStatus.setText("Yes");
                } else {
                    viewHolder.textViewStatus.setText(lineListViews.get(i).getStatus());
                }
            }
        });
        viewHolder.textViewHour.setText(lineListViews.get(i).getHour());

        return view;
    }

}
