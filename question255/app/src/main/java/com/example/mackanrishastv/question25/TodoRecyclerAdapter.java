package com.example.mackanrishastv.question25;

import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mackanrishastv.question25.view.add.DialogHandleTodo;

import java.util.List;

public class TodoRecyclerAdapter extends RecyclerView.Adapter<TodoRecyclerAdapter.ViewHolder> {

    private List<Todo> todoList;
    private Context context;

    public TodoRecyclerAdapter(List<Todo> todoList, Context context) {
        this.todoList = todoList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.activity_main_todo_recyclerview, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Todo todoTemp = todoList.get(position);

        holder.txtViewTodoTitle.setText(todoTemp.getTodo_title());
        holder.txtViewTodoContents.setText(todoTemp.getTodo_contents());
        holder.txtViewTodoCreated.setText(todoTemp.getCreated());
        holder.txtViewTodoModified.setText(todoTemp.getModified());
        holder.txtViewTodoLimitDate.setText(todoTemp.getLimit_date());


        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                Intent intent = new Intent("getIdTodo");
                if(!isLongClick){
                    intent.putExtra("isLongClick", false);
                    intent.putExtra("todo_id", position);
                }else {
                    intent.putExtra("isLongClick", true);
                    intent.putExtra("todo_id", position);
                }
                LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return todoList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

        TextView txtViewTodoTitle;
        TextView txtViewTodoContents;
        TextView txtViewTodoCreated;
        TextView txtViewTodoModified;
        TextView txtViewTodoLimitDate;

        private ItemClickListener itemClickListener;

        public ViewHolder(View itemView) {
            super(itemView);

            txtViewTodoTitle = itemView.findViewById(R.id.txtViewTodoTitleR);
            txtViewTodoContents = itemView.findViewById(R.id.txtViewTotoContentR);
            txtViewTodoCreated = itemView.findViewById(R.id.txtViewTodoCreatedR);
            txtViewTodoModified = itemView.findViewById(R.id.txtViewTodoModifiedR);
            txtViewTodoLimitDate = itemView.findViewById(R.id.txtViewTodoLimitDateR);

            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);

        }

        public void setItemClickListener(ItemClickListener itemClickListener)
        {
            this.itemClickListener = itemClickListener;
        }

        @Override
        public void onClick(View v) {
            itemClickListener.onClick(v, getAdapterPosition(), false);
        }

        @Override
        public boolean onLongClick(View v) {
            itemClickListener.onClick(v, getAdapterPosition(), true);
            return true;
        }
    }




}
