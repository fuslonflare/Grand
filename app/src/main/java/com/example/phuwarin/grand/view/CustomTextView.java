package com.example.phuwarin.grand.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

/**
 * Created by Phuwarin on 3/29/2017.
 */

public class CustomTextView extends AppCompatTextView {
    public CustomTextView(Context context) {
        super(context);
        if (!isInEditMode()) {
            defineFontFace(context);
        }
    }

    public CustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        if (!isInEditMode()) {
            defineFontFace(context);
        }
    }

    public CustomTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        if (!isInEditMode()) {
            defineFontFace(context);
        }
    }

    private void defineFontFace(Context context) {
        Typeface myFont = Typeface.createFromAsset(context.getAssets(), "DB-HelvethaicaMonX-Med-Cond.ttf");
        this.setTypeface(myFont);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
