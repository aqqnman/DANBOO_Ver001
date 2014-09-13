package com.example.aqqn.danboo_ver001;

import android.content.ClipData;
import android.content.Context;
import android.view.View;
import android.widget.Button;

/**
 * Created by hiraokaakira on 2014/09/13.
 */
public class DraggableButton extends Button {
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
}