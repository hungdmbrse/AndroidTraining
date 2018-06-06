package com.example.mackanrishastv.question25;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ToDoViewHolder extends RecyclerView.ViewHolder {

    private TextView title;
    private TextView content;
    private TextView limit;
    private LinearLayout linear;

    public ToDoViewHolder(View itemView) {
        super(itemView);
        linear = (LinearLayout)itemView.findViewById(R.id.row_linearLayout);
        title = (TextView)itemView.findViewById(R.id.txtViewTodoTitle);
        content = (TextView) itemView.findViewById(R.id.txtViewTotoContent);
        limit = (TextView)itemView.findViewById(R.id.txtViewTodoLimitDate);
    }

    public TextView getTitle() {
        return title;
    }

    public TextView getLimit() {
        return limit;
    }

    public TextView getContent() {
        return content;
    }


    public LinearLayout getLinear() {
        return linear;
    }
}
