package oob.tabby.Activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import oob.tabby.Adapter.PageAdapter;
import oob.tabby.Fragment.ListFragment;
import oob.tabby.Interface.FormFragmentEvents;
import oob.tabby.Model.Person;
import oob.tabby.R;

public class MainActivity extends AppCompatActivity implements FormFragmentEvents {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private PageAdapter pageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.bindUI();
        this.attachToolbar();
        this.pageAdapter = new PageAdapter(getSupportFragmentManager(), this.tabLayout.getTabCount());
        this.viewPager.setAdapter(this.pageAdapter);

        this.viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(this.tabLayout));
        this.tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }

    private void bindUI() {
        this.toolbar = this.findViewById(R.id.toolbar);
        this.tabLayout = this.findViewById(R.id.tabLayout);
        this.viewPager = this.findViewById(R.id.viewPager);
    }

    private void attachToolbar() {
        setSupportActionBar(this.toolbar);
    }

    @Override
    public void onCreatePerson(Person person) {
        ListFragment listFragment = (ListFragment) this.pageAdapter.getItem(1);
        listFragment.addPerson(person);
        this.viewPager.setCurrentItem(1);
    }
}
