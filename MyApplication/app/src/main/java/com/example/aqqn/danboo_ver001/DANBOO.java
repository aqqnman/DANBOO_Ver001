package com.example.aqqn.danboo_ver001;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.GridLayout;

import java.util.ArrayList;


public class DANBOO extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danboo);

        //gridの作成と初期化
        GridInitialize grid = new GridInitialize();
        grid.initialize(this);

        //buttonの作成と初期化
        ButtonInitialize button_init = new ButtonInitialize();
        ArrayList<Button> buttons = button_init.buttonList(this);


        for( Button button: buttons){
            GridLayout gl = grid.get_gl();
            gl.addView( button );
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.danboo, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
/*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     //   setContentView(R.layout.activity_test001);
     //   Button btn = new Button( this );
     //   btn.setText("push");
        GridLayout gl = new GridLayout(this);

        gl.setColumnCount(3);
        gl.setRowCount(3);

        setContentView(gl);

        GridLayout.LayoutParams params1 = new GridLayout.LayoutParams();
        params1.width = 60;
        params1.height = 60;
        params1.columnSpec = GridLayout.spec(1);
        params1.rowSpec = GridLayout.spec(2);

        gl.addView( button );
    }

    private ArrayList getButtonParams(){
        ArrayList list = new ArrayList();
        return list;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.test001, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public void onClickButton() {
        Toast.makeText(this, "テスト", Toast.LENGTH_LONG).show();
    };
 */