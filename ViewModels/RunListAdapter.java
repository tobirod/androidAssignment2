package skistarassignment.tobias.home.com.skistar.ViewModels;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import skistarassignment.tobias.home.com.skistar.Model.Run;
import skistarassignment.tobias.home.com.skistar.databinding.ListItemBinding;

public class RunListAdapter extends RecyclerView.Adapter<RunListAdapter.ViewHolder> {

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ListItemBinding binder;

        public ViewHolder(View v) {
            super(v);
            binder = DataBindingUtil.bind(v);
        }
    }

    private List<Run> list;

    public RunListAdapter(List<Run> list) {
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = ListItemBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false).getRoot();
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Run info = list.get(position);
        holder.binder.setViewmodel(info);
        holder.binder.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
