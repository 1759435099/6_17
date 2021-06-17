package com.example.a6_4;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.a6_4.fruit.Fruit;
import com.example.a6_4.fruit.FruitAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

/**
 * Created by Administrator on 2016/10/25 0025.
 */

public class OrderFragment extends Fragment {
    private View view;
    NavigationView navView;
    DrawerLayout drawerLayout;
    FloatingActionButton mFloatingActionButton;
    private Fruit[] fruits = {new Fruit("大好苏州，为什么不来苏州园林看看呢？",R.drawable.yuanlin),new Fruit("自古华山一条道，谁说的！",R.drawable.huashan),new Fruit("cherry",R.drawable.cherry),new Fruit("grape",R.drawable.grape),new Fruit("mango",R.drawable.mango),new Fruit("orange",R.drawable.orange),new Fruit("pear",R.drawable.pineapple)};
    private List<Fruit> fruitList = new ArrayList<>();
    private FruitAdapter adapter;
    private SwipeRefreshLayout swipeRefresh;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_frag_dingdan, container, false);
//        Toolbar toolbar;
//        toolbar = getActivity().findViewById(R.id.toolbar);
//        toolbar.inflateMenu(R.menu.toolbar);
        return view;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        AppCompatActivity appCompatActivity= (AppCompatActivity) getActivity();
//        Toolbar toolbar= (Toolbar) appCompatActivity.findViewById(R.id.toolbar);
//        appCompatActivity.setSupportActionBar(toolbar);
        Toolbar toolbar = appCompatActivity.findViewById(R.id.toolbar);
        navView = appCompatActivity.findViewById(R.id.navView);
        drawerLayout = appCompatActivity.findViewById(R.id.drawerLayout);
        mFloatingActionButton = appCompatActivity.findViewById(R.id.fab);
        toolbar.inflateMenu(R.menu.toolbar);

        ActionBar actionBar = appCompatActivity.getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
        }
//        navView.setCheckedItem(R.id.navCall);
//        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(MenuItem item) {
//                drawerLayout.closeDrawers();
//                return true;
//            }
//        });

        navView.setCheckedItem(R.id.navCall);
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {
                drawerLayout.closeDrawers();
                return true;
            }
        });

        mFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(view,"点错了?", Snackbar.LENGTH_SHORT)
                        .setAction("Undo", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(getActivity(),"小心！",Toast.LENGTH_SHORT).show();
                            }
                        }).show();
            }
        });

        initFruits();
        RecyclerView recyclerView = appCompatActivity.findViewById(R.id.recyclerView_fruit);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
//        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        adapter = new FruitAdapter(fruitList);
        recyclerView.setAdapter(adapter);

        swipeRefresh = appCompatActivity.findViewById(R.id.swipeRefresh);
        swipeRefresh.setColorSchemeResources(R.color.colorPrimary);
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshFruits();
            }
        });
        super.onActivityCreated(savedInstanceState);
    }

    private void refreshFruits() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        initFruits();
                        adapter.notifyDataSetChanged();
                        swipeRefresh.setRefreshing(false);
                    }
                });
            }
        }).start();
    }

    private void initFruits() {
        fruitList.clear();
        for (int i = 0; i < 25; i++) {
            Random random = new Random();
            int index = random.nextInt(fruits.length);
            fruitList.add(fruits[index]);
        }
    }
}
