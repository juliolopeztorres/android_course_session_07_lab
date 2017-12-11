package oob.tabby.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import oob.tabby.Fragment.FormFragment;
import oob.tabby.Fragment.ListFragment;

public class PageAdapter extends FragmentStatePagerAdapter {

    private int tabsNumber;
    private FormFragment formFragment;
    private ListFragment listFragment;

    public PageAdapter(FragmentManager fm, int tabsNumber) {
        super(fm);
        this.tabsNumber = tabsNumber;
        this.formFragment = new FormFragment();
        this.listFragment = new ListFragment();
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return this.formFragment;
            case 1:
                return this.listFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return this.tabsNumber;
    }
}
