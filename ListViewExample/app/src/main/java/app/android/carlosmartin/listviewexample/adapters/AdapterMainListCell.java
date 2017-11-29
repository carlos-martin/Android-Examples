package app.android.carlosmartin.listviewexample.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import app.android.carlosmartin.listviewexample.R;

/**
 * Created by carlos.martin on 28/11/2017.
 */

public class AdapterMainListCell  extends BaseAdapter {

    private Context context;
    private int layout;
    private List<String> listContent;

    public AdapterMainListCell(Context context, int layout, List<String> listContent) {
        this.context = context;
        this.layout = layout;
        this.listContent = listContent;
    }

    @Override
    public int getCount() {
        return this.listContent.size();
    }

    @Override
    public Object getItem(int position) {
        return this.listContent.get(position);
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {

        // View Holder Pattern
        ViewHolder holder;
        if (convertView == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(this.context);
            convertView = layoutInflater.inflate(R.layout.list_item, null);

            holder = new ViewHolder();
            holder.contentTextView = convertView.findViewById(R.id.textViewCell);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        String currentContent = this.listContent.get(position);

        holder.contentTextView.setText(currentContent);

        return convertView;
    }

    static class ViewHolder {
        private TextView contentTextView;
    }
}
