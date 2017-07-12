package com.sevenwest.activity.channeldetail;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.sevenwest.R;
import com.sevenwest.model.program.Program;
import com.sevenwest.util.DateUtil;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by srilatha on 7/07/2017.
 */

public class ProgramsAdapter extends BaseAdapter {

    private List<Program> programsList;
    private Context _ctxt;

    public ProgramsAdapter(List<Program> programsList, Context ctxt) {
        this.programsList = programsList;
        this._ctxt = ctxt;
    }

    @Override
    public int getCount() {
        return programsList.size();
    }

    @Override
    public Program getItem(int position) {
        return programsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = View.inflate(this._ctxt, R.layout.program_row, null);
            new ViewHolder(convertView);
        }
        ViewHolder holder = (ViewHolder) convertView.getTag();

        holder.tv_program_name.setText(programsList.get(position).getProgramName());
        holder.tv_description.setText("Description: "+programsList.get(position).getSynopsis());

        holder.tv_start_time.setText(DateUtil.parseStringDateToStringDate(programsList.get(position).getStart_time(),"hh:mm a"));
        holder.tv_end_time.setText(" - "+DateUtil.parseStringDateToStringDate(programsList.get(position).getEnd_time(),"hh:mm a"));

        Picasso.with(this._ctxt)
                .load(programsList.get(position).getImageUrl())
                .resize(200,600)
                .centerInside()
                .into(holder.iv_program_picture);

        return convertView;
    }

    class ViewHolder {

        TextView tv_program_name;
        TextView tv_start_time;
        TextView tv_end_time;
        TextView tv_description;
        ImageView iv_program_picture;

        public ViewHolder(View view) {

            tv_program_name = (TextView) view.findViewById(R.id.tv_program_name);
            tv_start_time = (TextView) view.findViewById(R.id.tv_start_time);
            tv_end_time = (TextView) view.findViewById(R.id.tv_end_time);
            tv_description = (TextView) view.findViewById(R.id.tv_description);
            iv_program_picture = (ImageView)view.findViewById(R.id.iv_program_picture);
            view.setTag(this);
        }
    }

}