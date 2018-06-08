package com.edgar.testdao;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.UserListViewHolder> {

    private Context context;
    private List<User> userList;

    public UserListAdapter(Context context) {
        this.context = context;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UserListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.layout_user_item, parent, false);
        return new UserListViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull UserListViewHolder holder, int position) {

        if (userList == null) {
            return;
        }

        holder.tvUserId.setText(context.getString(R.string.user_id_string, userList.get(position).getId()));
        holder.tvFirstName.setText(context.getString(R.string.user_first_name_string, userList.get(position).getFirstName()));
        holder.tvLastName.setText(context.getString(R.string.user_last_name_string, userList.get(position).getLastName()));
    }

    @Override
    public int getItemCount() {
        return (userList == null ? 0 : userList.size());
    }

    protected class UserListViewHolder extends RecyclerView.ViewHolder {

        protected TextView tvUserId;
        protected TextView tvFirstName;
        protected TextView tvLastName;

        protected UserListViewHolder(View itemView) {
            super(itemView);

            tvUserId = (TextView) itemView.findViewById(R.id.tv_user_item_id);
            tvFirstName = (TextView) itemView.findViewById(R.id.tv_user_item_first_name);
            tvLastName = (TextView) itemView.findViewById(R.id.tv_user_item_last_name);

        }
    }
}
