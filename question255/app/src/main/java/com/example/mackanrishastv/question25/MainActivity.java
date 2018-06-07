package com.example.mackanrishastv.question25;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.mackanrishastv.question25.presenter.add.PresenterAdd;
import com.example.mackanrishastv.question25.presenter.add.PresenterResponseToViewAddListener;
import com.example.mackanrishastv.question25.view.add.DialogHandleTodo;
import com.example.mackanrishastv.question25.view.add.ViewResponseToActivityAddListener;
import com.example.mackanrishastv.question25.view.add.delete.ViewDelete;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener, DialogHandleTodo.OnHeadlineSelectedListener, ViewDelete.deleteCallBack {

    private ListView listViewTodo;
    private TodoListAdapter todoListAdapter;

    private ArrayList<Todo> arrayListTodo;
    private DatabaseAccess databaseAccess;
    private DialogHandleTodo dialogHandleTodo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseAccess = DatabaseAccess.getInstance(getApplicationContext());
        databaseAccess.open();

        arrayListTodo = new ArrayList<>();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        if (!prefs.getBoolean("firstTime", false)) {
            // <---- run your one time code here

            databaseAccess.addTodoNew(1,"Meeting Up", "Pm 7:00", "2018/05/06", "", "2018/05/07");
            databaseAccess.addTodoNew(2,"Gym", "Pm 7:00", "2018/05/08", "", "2018/05/09");
            databaseAccess.addTodoNew(3,"Cooking", "Am 6:00h", "2018/05/10", "", "2018/05/11");

            // mark first time has runned.
            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean("firstTime", true);
            editor.commit();
        }

        arrayListTodo = databaseAccess.getListTodo();

        listViewTodo = (ListView) findViewById(R.id.listView_activity_todolist);
        todoListAdapter = new TodoListAdapter(this, R.layout.activity_main_todo_listview, arrayListTodo);
        listViewTodo.setAdapter(todoListAdapter);


        listViewTodo.setOnItemClickListener(this);
        listViewTodo.setOnItemLongClickListener(this);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_add_todo, menu);
        return super.onCreateOptionsMenu(menu);
    }
    //Action insert Todo
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menuAdd) {
            openDialogHandleTodo("add", 0);
        }
        return super.onOptionsItemSelected(item);
    }


    //Action update Todo
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Todo todoTemp = arrayListTodo.get(position);
        int todo_id = todoTemp.getTodo_id();
        openDialogHandleTodo("update", todo_id);
    }

    //Action delete Todo
    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        Todo todoTemp = arrayListTodo.get(position);
        int todo_id = todoTemp.getTodo_id();

        FragmentManager fm = getSupportFragmentManager();
        Bundle bundle = new Bundle();
        bundle.putInt("todo_id", todo_id);
        ViewDelete viewDelete = ViewDelete.newInstance("Delete");
        viewDelete.setArguments(bundle);
        viewDelete.show(fm, "fragment_delete");

        return true;
    }


    private void openDialogHandleTodo(String action, int todo_id) {

        FragmentManager fm = getSupportFragmentManager();
        final DialogHandleTodo dialogHandleTodo = DialogHandleTodo.newInstance(action);
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
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void addSuccess() {
        updateListTodo();
        Toast.makeText(this, "Added Successfully", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void updateSuccess() {
        updateListTodo();
        Toast.makeText(this, "Update Success", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void deleteSuccess() {
        updateListTodo();
        Toast.makeText(this, "Delete Success", Toast.LENGTH_SHORT).show();

    }

    public void updateListTodo(){
        databaseAccess.open();
        arrayListTodo = databaseAccess.getListTodo();
        todoListAdapter.updateReceiptsList(arrayListTodo);
        todoListAdapter.notifyDataSetChanged();
        listViewTodo.setAdapter(todoListAdapter);
    }



}
