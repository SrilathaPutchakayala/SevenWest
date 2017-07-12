package com.sevenwest.activity.channels;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.sevenwest.R;
import com.sevenwest.model.channel.Channel;

import java.util.List;

/**
 * Created by srilatha on 6/07/2017.
 */

public class ChannelsAdapter extends BaseAdapter {

    private List<Channel> channelsList;
    private Context _ctxt;

    public ChannelsAdapter(List<Channel> channelsList, Context ctxt){
        this.channelsList = channelsList;
        this._ctxt = ctxt;
    }

    @Override
    public int getCount() {
        return channelsList.size();
    }

    @Override
    public Channel getItem(int position) {
        return channelsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = View.inflate(this._ctxt, R.layout.channel_row, null);
            new ViewHolder(convertView);
        }
        ViewHolder holder = (ViewHolder) convertView.getTag();

        holder.tv_channel_name.setText(channelsList.get(position).getChannelName());

        return convertView;
    }

    class ViewHolder {

        TextView tv_channel_name;

        public ViewHolder(View view) {

            tv_channel_name = (TextView) view.findViewById(R.id.tv_channel_name);
            view.setTag(this);
        }
    }
}