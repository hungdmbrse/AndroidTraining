package com.example.mackanrishastv.question30;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class TodoListAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Todo> arrayListTodo;

    public TodoListAdapter(Context context, int layout, List<Todo> arrayListTodo) {
        this.context = context;
        this.layout = layout;
        this.arrayListTodo = arrayListTodo;
    }

    @Override
    public int getCount() {
        return arrayListTodo.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = layoutInflater.inflate(layout, null);

        TextView txtViewTodoTitle = (TextView) convertView.findViewById(R.id.txtViewTodoTitle);
        TextView txtViewTodoContents = (TextView) convertView.findViewById(R.id.txtViewTotoContent);
        TextView txtViewTodoCreated = (TextView) convertView.findViewById(R.id.txtViewTodoCreated);
        TextView txtViewTodoModified = (TextView) convertView.findViewById(R.id.txtViewTodoModified);
        TextView txtViewTodoLimitDate = (TextView) convertView.findViewById(R.id.txtViewTodoLimitDate);

        Todo todo = arrayListTodo.get(position);

        txtViewTodoTitle.setText(todo.getTodo_title());
        txtViewTodoContents.setText(todo.getTodo_contents());
        txtViewTodoCreated.setText(todo.getCreated());
        txtViewTodoModified.setText(todo.getModified());
        txtViewTodoLimitDate.setText(todo.getLimit_date());

        return  convertView;
    }
}
