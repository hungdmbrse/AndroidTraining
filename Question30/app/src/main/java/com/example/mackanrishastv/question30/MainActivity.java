package com.example.mackanrishastv.question30;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.mackanrishastv.question30.view.add.DialogHandleTodo;
import com.example.mackanrishastv.question30.view.add.delete.ViewDelete;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

    private ListView listViewTodo;
    private TodoListAdapter todoListAdapter;
    private ArrayList<Todo> arrayListTodo;
    private DatabaseAccess databaseAccess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arrayListTodo = new ArrayList<>();

//        getArrayListTodo();

        databaseAccess = DatabaseAccess.getInstance(getApplicationContext());
        databaseAccess.open();
        arrayListTodo = databaseAccess.getListTodo();

        listViewTodo = (ListView) findViewById(R.id.listView_activity_todolist);
        todoListAdapter = new TodoListAdapter(this, R.layout.activity_main_todo_listview, arrayListTodo);
        listViewTodo.setAdapter(todoListAdapter);

        //Action update Todolist
        listViewTodo.setOnItemClickListener(this);
        listViewTodo.setOnItemLongClickListener(this);

        String sql = "UPDATE SQLITE_SEQUENCE SET seq = 7 WHERE name = 'tr_todo'";
        databaseAccess.update1(sql);

//        String sql = "DELETE FROM tr_todo WHERE todo_id = '" + 9 + "'";
//        databaseAccess.deleteTemp(sql);


        showListTodo();

    }

    private void showListTodo() {
        arrayListTodo = databaseAccess.getListTodo();
        for(int i = 0; i < arrayListTodo.size(); i++){
            Log.d("Varr", "Title " + i + " :" + arrayListTodo.get(i).getTodo_id());
        }
    }

    public void getArrayListTodo() {

        databaseAccess = DatabaseAccess.getInstance(getApplicationContext());
        databaseAccess.open();
        arrayListTodo = databaseAccess.getListTodo();
        databaseAccess.close();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_add_todo, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menuAdd) {
            openDialogHandleTodo("add", 0);
        }
        return super.onOptionsItemSelected(item);
    }

    private void openDialogHandleTodo(String action, int todo_id) {

        FragmentManager fm = getSupportFragmentManager();
        final DialogHandleTodo dialogHandleTodo = DialogHandleTodo.newInstance(action);
        DialogHandleTodo.receiveDatabase(databaseAccess);

        if(action.equals("update")){
            Bundle bundle = new Bundle();
            bundle.putInt("todo_id", todo_id);
            dialogHandleTodo.setArguments(bundle);
            dialogHandleTodo.show(fm, "dialog_handle_todo");
        } else {
            dialogHandleTodo.show(fm, "dialog_handle_todo");
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        int todo_id = position+1;
        openDialogHandleTodo("update", todo_id);
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        int todo_id = position+1;

        FragmentManager fm = getSupportFragmentManager();
        Bundle bundle = new Bundle();
        bundle.putInt("todo_id", todo_id);
        ViewDelete viewDelete = ViewDelete.newInstance("Delete");
        viewDelete.setArguments(bundle);
        viewDelete.show(fm, "fragment_delete");

        return true;
    }
}
