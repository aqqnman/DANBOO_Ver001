package com.example.aqqn.danboo_ver001;

import android.content.ClipData;
import android.content.Context;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.widget.Button;

/**
 * Created by hiraokaakira on 2014/09/13.
 */
public class DraggableButton extends Button {
    boolean inDragging = false;
    int width = -1, height = -1;
    int moveY = -1, moveX = -1;

    public DraggableButton(Context context) {
        super(context);
        setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View v) {
                ClipData data = ClipData.newPlainText("text", "text : " + v.toString());
                v.startDrag(data, new DragShadowBuilder(v),(Object)v, 0);
                return true;
            }
        });
    }

    @Override
    public boolean onDragEvent(DragEvent event){
        boolean result = true;

        //ボタンの高さと幅を取得してない場合に取得する
        if (width < 0) {
            width = getWidth();
        }
        if (height < 0) {
            height = getHeight();
        }

        //Dragが終了したらフラグをおる
        if( event.getAction() == DragEvent.ACTION_DROP ) {
            Log.i("Drop",String.valueOf( event ) );
            result = true;
            inDragging = false;

        }

        if (!inDragging) {
            switch (event.getAction()) {
                case DragEvent.ACTION_DRAG_STARTED: {
                    inDragging = true;
//ドラッグ開始時に呼び出し
                    Log.i("DragSample", "Drag started, event=" + event);
                    result = true;
                }
                case DragEvent.ACTION_DRAG_LOCATION: {
                    Log.i("DragSample", String.valueOf(event));
                    result = true;
                }
                case DragEvent.ACTION_DRAG_ENDED: {
                    int h = 0,w = 0;
                    if (height != 0) {
                        h = (int) getY() / height;
                    }
                    if ( width != 0 ) {
                        w = (int) getX() / width;
                    }
                    Log.i("rect", "" + h + "," + w);
                    result = true;
                }

                break;
            }
            getDefaultMovementMethod();
        }
        return result;
    }
}