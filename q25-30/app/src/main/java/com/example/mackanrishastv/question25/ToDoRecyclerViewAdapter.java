package com.example.mackanrishastv.question25;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class ToDoRecyclerViewAdapter extends RecyclerView.Adapter<ToDoViewHolder> {
    private List<ToDo> todoList;

    interface TodoAdapterListener{
        void selectedTodo(ToDo todo);
        void onLongClicked(int position);
    }

    private TodoAdapterListener listener;

    @NonNull
    @Override
    public ToDoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent,false);
        return new ToDoViewHolder(inflate);
    }

    public void setTodoList(List<ToDo> todoList) {
        this.todoList = todoList;
    }

    @Override
    public void onBindViewHolder(@NonNull final ToDoViewHolder holder, int position) {
        holder.getTitle().setText(todoList.get(position).getTitle());
        holder.getContent().setText(todoList.get(position).getContent());
        holder.getLimit().setText(todoList.get(position).getLimit());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                ToDo todo = todoList.get(position);
                if(listener != null){
                    listener.selectedTodo(todo);
                } else {
                    listenerError();
                }
            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                int position = holder.getAdapterPosition();
                if(listener != null){
                    listener.onLongClicked(position);
                    return true;
                }
                listenerError();
                return false;
            }
        });
    }

    void setListener(TodoAdapterListener listener){
        this.listener = listener;
    }

    @Override
    public int getItemCount() {
        return todoList.size();
    }

    void listenerError(){
        Log.e("ListenerError","Listener have not setted");
    }
}
