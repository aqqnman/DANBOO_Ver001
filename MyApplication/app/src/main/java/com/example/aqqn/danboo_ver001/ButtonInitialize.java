package com.example.aqqn.danboo_ver001;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by hiraoka on 2014/09/12.
 */
public class ButtonInitialize {
    private DANBOO _danboo;
    public ArrayList<Button> buttonList(DANBOO danboo) {
        //メインフレーム（？）を保持
        _danboo = danboo;

        //TODO buttonの名前も取得できるようにする
        ArrayList<GridLayout.LayoutParams> params = getButtonParams();
        ArrayList<Button> ret = new ArrayList();


        for(int i = 0; i < params.size(); i++ ){
            GridLayout.LayoutParams param = params.get(i);
        //for ( GridLayout.LayoutParams param : params) {

            Button button = new Button(danboo);
            button.setLayoutParams(param);
            button.setText(String.valueOf(i));
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onClickButton();
                }
            });
            _danboo.get(button);
            ret.add(button);
        }
        return ret;
    }

    private ArrayList<GridLayout.LayoutParams> getButtonParams(){
        ArrayList<GridLayout.LayoutParams> ret = new ArrayList<GridLayout.LayoutParams>();

        //TODO パラメータを取得する処理を書く
        GridLayout.LayoutParams params = new GridLayout.LayoutParams();
        for( int i = 0; i < 8; i++ ) {
            params.width = 80;
            params.height = 80;

            params.columnSpec = GridLayout.spec(i%3);
            params.rowSpec = GridLayout.spec(i/3);

            //パラメータを配列に格納
            ret.add(params);
        }
        return ret;
    }
    //click処理
    public void onClickButton() {
        Toast.makeText(_danboo, "テスト", Toast.LENGTH_LONG).show();
    };
}
