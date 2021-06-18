package com.example.a6_4.fragmetns;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.a6_4.Car.ListElement;
import com.example.a6_4.Car.MyAdapter;
import com.example.a6_4.MainActivity;
import com.example.a6_4.R;
import com.stx.xhb.xbanner.XBanner;

import java.util.ArrayList;
import java.util.List;

public class QucheFragment extends Fragment {
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //加载系统里面的布局文件
        view = inflater.inflate(R.layout.activity_frag_quche, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        XBanner banner = getActivity().findViewById(R.id.banner);
        List<String> imgesUrl = new ArrayList<>();
        imgesUrl.add("https://img1.baidu.com/it/u=2366909382,3145439918&fm=26&fmt=auto&gp=0.jpg");
        imgesUrl.add("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Ffile108.mafengwo.net%2Fs9%2FM00%2F19%2F0C%2FwKgBs1fKgjKAJ1kOAAXN8_JK1rE85.jpeg%3FimageView2%2F2%2Fw%2F530%2Fh%2F8000%2Fq%2F100&refer=http%3A%2F%2Ffile108.mafengwo.net&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1626584012&t=78219918d67a5e0f5d319fb65ac3d554");
        imgesUrl.add("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fyouimg1.c-ctrip.com%2Ftarget%2F100c0m000000e0a497861.jpg&refer=http%3A%2F%2Fyouimg1.c-ctrip.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1626584069&t=9de8358b5ccfa3b97743eb2196385b2b");
        imgesUrl.add("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fs9.sinaimg.cn%2Fmw690%2F001HKgoIzy6Ml06pUBWe8%26690&refer=http%3A%2F%2Fs9.sinaimg.cn&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1626584574&t=27de5d9099323502eb2269784eb64141");
        // 为XBanner绑定数据
        banner.setData(imgesUrl,null);//第二个参数为提示文字资源集合
        // XBanner适配数据
        banner.setmAdapter(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, Object model, View view, int position) {
                Glide.with(QucheFragment.this).load(imgesUrl.get(position)).into((ImageView) view);
            }
        });
    }
}


