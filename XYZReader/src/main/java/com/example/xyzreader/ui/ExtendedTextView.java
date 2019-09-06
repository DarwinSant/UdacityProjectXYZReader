package com.example.xyzreader.ui;

import android.widget.TextView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView;

public class ExtendedTextView extends android.support.v7.widget.AppCompatTextView {

    private Rect bounds = new Rect();
    private TextPaint textPaint;

    public ExtendedTextView(Context context) {
        super(context);
    }

    public ExtendedTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean hasOverlappingRendering() {
        return false;
    }
}
