package com.example.aqqn.danboo_ver001;

import android.widget.Button;
import android.widget.GridLayout;

import java.util.ArrayList;

/**
 * Created by hiraoka on 2014/09/12.
 */
public class GridInitialize {
    private GridLayout _gl;
    private DANBOO _danboo;

    public void initialize(DANBOO danboo)
    {
        //メインフレーム（？）を保持
        _danboo = danboo;

        //グリッドレイアウトを作成
        _gl = new GridLayout(danboo);
        int[] ret = getSize();

        System.out.println(ret[0]);
        System.out.println(ret[1]);
        //取得したサイズでグリッドを作成
        _gl.setColumnCount(ret[0]);
        _gl.setRowCount(ret[1]);

        //画面へグリッドを配置
        danboo.setContentView(_gl);
    }

    private int[] getSize(){
        //TODO サイズを取得する処理が必要
        int[] ret = {3,3};
        return  ret;
    }

    //とりあえずボタンの登録だけ。。。
    public boolean setParams(ArrayList<Button> buttons){
        for( Button button : buttons ) {
            _gl.addView(button);
        }
        return true;
    }

    public GridLayout get_gl(){
        return _gl;
    }


}
