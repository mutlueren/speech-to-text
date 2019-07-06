package com.example.speechtotext;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Handler;
import android.view.Display;
import android.view.View;

public class AppView extends View {

    Handler handler;
    Runnable runnable;
    final int UPDATE_MILLIS=30;
    Bitmap backround;
    Display display;
    Point point;
    int dWidth, dHeight;
    Rect rect;

    //Kendi olusturdugum View sınıfı
    public AppView(Context context){
        super(context);
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                //onDraw metodunu çagıran metod
                invalidate();
            }
        };

        //Play ikonuna basıldıktan sonraki acılacak yeni arkaplan
        backround = BitmapFactory.decodeResource(getResources(),R.drawable.backround2);
        display = ((Activity)getContext()).getWindowManager().getDefaultDisplay();
        point = new Point();
        display.getSize(point);
        dWidth = point.x;
        dHeight = point.y;
        rect = new Rect(0,0,dWidth,dHeight);
    }


    //Ekrana cizdigimiz metod
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //Thread suresi kadar bekleme yapar
        canvas.drawBitmap(backround,null,rect,null);
        handler.postDelayed(runnable,UPDATE_MILLIS);

    }
}
