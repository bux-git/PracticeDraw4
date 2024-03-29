package com.hencoder.hencoderpracticedraw4.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw4.R;

public class Practice02ClipPathView extends View {
    Paint paint = new Paint();
    Bitmap bitmap;
    Point point1 = new Point(200, 200);
    Point point2 = new Point(600, 200);
    Path circle1;
    Path circle2;

    public Practice02ClipPathView(Context context) {
        super(context);
    }

    public Practice02ClipPathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice02ClipPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);
        circle1 = new Path();
        circle1.addCircle(200 + bitmap.getWidth(), 200 + bitmap.getHeight(), bitmap.getWidth() * 0.8f, Path.Direction.CCW);


        circle2 = new Path();
        circle2.setFillType(Path.FillType.INVERSE_WINDING);
        circle2.addCircle(600 + bitmap.getWidth(), 200 + bitmap.getHeight(), bitmap.getWidth() *0.7f, Path.Direction.CW);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        canvas.clipPath(circle1);
        canvas.drawBitmap(bitmap, point1.x, point1.y, paint);
        canvas.restore();


        canvas.save();
        canvas.clipPath(circle2);
        //canvas.drawColor(Color.RED);
        canvas.drawBitmap(bitmap, point2.x, point2.y, paint);
        canvas.restore();
    }
}
