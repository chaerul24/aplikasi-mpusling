package com.mpusling;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.mpusling.adapter.ItemAdapter;
import com.mpusling.dataset.ItemMenu;
import com.mpusling.fragment.FragmentHome;
import com.mpusling.fragment.FragmentListBook;
import com.mpusling.fragment.FragmentListSchool;
import com.mpusling.slider.ImageSliderAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DashboardActivity extends AppCompatActivity {

    private RecyclerView recyclerViewItems;
    private BottomNavigationView bottomNavigation;
    private FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        frameLayout = findViewById(R.id.frameLayout);
        bottomNavigation = findViewById(R.id.bottomNavi);
        loadFragment(new FragmentHome());
        bottomNavigation.setSelectedItemId(R.id.bottom_home);
        bottomNavigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment selectedFragment = null;
                if(menuItem.getItemId() == R.id.bottom_home){
                    selectedFragment = new FragmentHome();
                }else if(menuItem.getItemId() == R.id.bottom_book){
                    selectedFragment = new FragmentListBook();
                }else if(menuItem.getItemId() == R.id.bottom_school){
                    selectedFragment = new FragmentListSchool();
                }else if(menuItem.getItemId() == R.id.bottom_profile){
                    return true;
                }else if(menuItem.getItemId() == R.id.bottom_search){
                    return true;
                }
                if (selectedFragment != null) {
                    loadFragment(selectedFragment);
                    return true;
                }
                return false;
            }
        });
        
    }
    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frameLayout, fragment);
        transaction.commit();
    }
}
