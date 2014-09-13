package com.example.aqqn.danboo_ver001;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ScrollView;

import java.util.ArrayList;


public class DANBOO extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danboo);

        //スクロールさせる
        ScrollView scroll = new ScrollView(this);
        setContentView(scroll);

        //gridの作成と初期化
        GridInitialize gridInit = new GridInitialize();
        GridLayout grid = gridInit.initialize(this);

        //スクロールにgridを登録
        scroll.addView(grid);

        //buttonの作成と初期化
        ButtonInitialize button_init = new ButtonInitialize();
        ArrayList<DraggableButton> buttons = button_init.buttonList(this);


        for( DraggableButton button: buttons){
            //GridLayout gl = grid.get_gl();
            grid.addView( button );
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
