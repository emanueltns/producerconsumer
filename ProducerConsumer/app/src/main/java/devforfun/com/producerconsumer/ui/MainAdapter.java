package devforfun.com.producerconsumer.ui;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

import devforfun.com.producerconsumer.R;

/**
 * @author emanueltanasa Date: 10/31/16.
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private List<String> items = Collections.EMPTY_LIST;
    private Context context;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;

        public ViewHolder(CardView itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.product_tv);
        }
    }

    public MainAdapter(Context context) {
        this.context = context;
    }

    public void update(List<String> items){
        this.items = items;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView v = (CardView) LayoutInflater.from(context).inflate(R.layout.list_item_view, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textView.setText(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
