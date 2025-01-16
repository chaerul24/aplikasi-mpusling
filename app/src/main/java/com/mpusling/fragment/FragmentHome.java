package com.mpusling.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.mpusling.AddBookActivity;
import com.mpusling.AddSchoolActivity;
import com.mpusling.EndPointListActivity;
import com.mpusling.R;
import com.mpusling.adapter.ItemAdapter;
import com.mpusling.dataset.ItemMenu;
import com.mpusling.slider.ImageSliderAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FragmentHome extends Fragment {
    private View view;
    private RecyclerView recyclerViewItems;

    public FragmentHome() {
        // Konstruktor kosong
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.home_fragment, container, false);

        // Referensi ViewPager2 dan TabLayout
        ViewPager2 viewPager = view.findViewById(R.id.viewPager);
        TabLayout tabLayout = view.findViewById(R.id.tabLayout);

        // Daftar gambar
        List<String> images = Arrays.asList(
                "https://i2.wp.com/lovelybogor.com/wp-content/uploads/2018/01/Mobil-Perpustakaan-Keliling-Mencoba-Menumbuhkan-Minat-Baca-Ternyata-Tidak-Mudah.jpg",
                "https://i3.wp.com/cdn.antaranews.com/cache/730x487/2018/05/mobil_perpustakaan.jpg"
        );

        // Mengatur adapter
        ImageSliderAdapter adapter = new ImageSliderAdapter(images);
        viewPager.setAdapter(adapter);

        // Menghubungkan TabLayout dengan ViewPager2
        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
            // Biarkan kosong untuk indikator bulat otomatis
        }).attach();

        // Data untuk RecyclerView
        ArrayList<ItemMenu> itemMenus = new ArrayList<>();
        itemMenus.add(new ItemMenu(R.color.yellow, "Tambah Pengunjung", R.drawable.baseline_person_add_alt_1_24));
        itemMenus.add(new ItemMenu(R.color.grey, "Tambah Sekolah", R.drawable.book2));
        itemMenus.add(new ItemMenu(R.color.skyblue, "Tambah Buku", R.drawable.diary));
        itemMenus.add(new ItemMenu(R.color.yellow, "Daftar Pengunjung", R.drawable.baseline_person_24));
        itemMenus.add(new ItemMenu(R.color.grey, "Daftar Sekolah", R.drawable.baseline_school_24));
        itemMenus.add(new ItemMenu(R.color.skyblue, "Daftar Buku", R.drawable.books));
        itemMenus.add(new ItemMenu(R.color.yellow, "Daftar Pinjam buku", R.drawable.journal));
        itemMenus.add(new ItemMenu(R.color.grey, "Laporan Bulanan", R.drawable.note));
        itemMenus.add(new ItemMenu(R.color.skyblue, "Daftar User", R.drawable.baseline_person_24));

        recyclerViewItems = view.findViewById(R.id.recycler_item);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3);
        recyclerViewItems.setLayoutManager(gridLayoutManager);
        ItemAdapter itemAdapter = new ItemAdapter(getContext(), itemMenus);
        itemAdapter.setOnItemClickListener(new ItemAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(ItemMenu itemMenu, int position) {
                if(position == 0){
                    loadFragment(new AddVisitorsFragment());
                }
                if(position == 1){
                    Intent intent = new Intent(getContext(), AddSchoolActivity.class);
                    startActivity(intent);
                }
                if(position == 2){
                    Intent intent = new Intent(getContext(), AddBookActivity.class);
                    startActivity(intent);
                }
                if (position == 3){
                    Intent intent = new Intent(getContext(), EndPointListActivity.class);
                    startActivity(intent);
                }
                if (position == 4){
                    loadFragment(new FragmentListSchool());
                }
                if (position == 5){
                    loadFragment(new FragmentListBook());
                }
            }
        });
        recyclerViewItems.setAdapter(itemAdapter);
        return view;
    }

    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
        transaction.replace(R.id.frameLayout, fragment);
        transaction.commit();
    }
}
