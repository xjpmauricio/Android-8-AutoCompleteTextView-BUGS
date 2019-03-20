package net.gottsolutions.android8tests.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.support.v7.widget.ListPopupWindow;
import android.util.AttributeSet;
import android.widget.PopupWindow;

import net.gottsolutions.android8tests.R;

public class CustomListPopupWindow extends ListPopupWindow {

    int mListItemExpandMaximum = Integer.MAX_VALUE;

    public CustomListPopupWindow(@NonNull Context context) {
        super(context, null, R.attr.listPopupWindowStyle);
    }

    public CustomListPopupWindow(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs, R.attr.listPopupWindowStyle);
    }

    public CustomListPopupWindow(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr, 0);
    }

    public CustomListPopupWindow(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr, @StyleRes int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    /**
     * The maximum number of list items that can be visible and still have
     * the list expand when touched.
     *
     * @param max Max number of items that can be visible and still allow the list to expand.
     */
    public void setListItemExpandMax(int max) {
        mListItemExpandMaximum = max;
    }

    @Override
    public void show() {
        super.show();
    }



}
