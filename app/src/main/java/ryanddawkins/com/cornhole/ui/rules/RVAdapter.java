package ryanddawkins.com.cornhole.ui.rules;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import ryanddawkins.com.cornhole.R;

/**
 * Created by ryan on 12/22/15.
 */
public class RVAdapter extends RecyclerView.Adapter<RVAdapter.RuleViewHolder>{

    private List<String> list;

    public RVAdapter(List<String> list) {
        this.list = list;
    }

    @Override
    public RVAdapter.RuleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        RVAdapter.RuleViewHolder pvh = new RVAdapter.RuleViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(RVAdapter.RuleViewHolder holder, int position) {
        String rule = this.list.get(position);
        holder.text.setText(rule);
    }

    @Override
    public int getItemCount() {
        return this.list.size();
    }

    public static class RuleViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView text;

        RuleViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            this.text = (TextView) itemView.findViewById(R.id.text);
        }
    }

}
