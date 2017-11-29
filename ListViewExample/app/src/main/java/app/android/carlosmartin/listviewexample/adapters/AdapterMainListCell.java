package app.android.carlosmartin.listviewexample.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import app.android.carlosmartin.listviewexample.R;

/**
 * Created by carlos.martin on 28/11/2017.
 */

public class AdapterMainListCell  extends RecyclerView.Adapter<AdapterMainListCell.ViewHolder> {

    private List<String> listContent;
    private int layout;
    private OnItemClickListener itemClickListener;

    /*
    public AdapterMainListCell(Context context, int layout, List<String> listContent) {
        this.context = context;
        this.layout = layout;
        this.listContent = listContent;
    }
     */

    public AdapterMainListCell(List<String> listContent, int layout, OnItemClickListener listener) {
        this.listContent = listContent;
        this.layout = layout;
        this.itemClickListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(this.listContent.get(position), this.itemClickListener);
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    @Override
    public int getItemCount() { return this.listContent.size(); }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView contentTextView;

        public ViewHolder(View view) {
            super(view);
            this.contentTextView = view.findViewById(R.id.textViewCell);
        }

        public void bind(final String content, final OnItemClickListener listener) {
            this.contentTextView.setText(content);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(content, getAdapterPosition());
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(String content, int position);
    }
}
