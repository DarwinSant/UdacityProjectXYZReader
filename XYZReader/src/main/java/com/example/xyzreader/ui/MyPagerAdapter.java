package com.example.xyzreader.ui;

import android.app.Fragment;
import android.app.FragmentManager;
import android.database.Cursor;
import android.support.v13.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;

import com.example.xyzreader.data.ArticleLoader;

public class MyPagerAdapter extends FragmentStatePagerAdapter
{
    private int mSelectedItemUpButtonFloor = Integer.MAX_VALUE;
    private Cursor mCursor;
    private String mPhotoTransitionName;

    MyCallback mCallback;

    public MyPagerAdapter(FragmentManager fm,
                          MyCallback callback)
    {
        super(fm);
        mCallback = callback;
    }

    public void setName(String name)
    {
        mPhotoTransitionName = name;
    }

    public void setCursor(Cursor cursor)
    {
        mCursor = cursor;
    }

    @Override
    public void setPrimaryItem(ViewGroup container,
                               int position,
                               Object object)
    {
        super.setPrimaryItem(container, position, object);
        ArticleDetailFragment fragment = (ArticleDetailFragment) object;
        if (fragment != null) {
            mSelectedItemUpButtonFloor = fragment.getUpButtonFloor();
            mCallback.callbackUpdate();
        }
    }

    @Override
    public Fragment getItem(int position) {
        mCursor.moveToPosition(position);
        return ArticleDetailFragment.newInstance(mCursor.getLong(ArticleLoader.Query._ID), mPhotoTransitionName, position);
    }

    @Override
    public int getCount() {
        return (mCursor != null) ? mCursor.getCount() : 0;
    }
}