package com.example.a6_4.fragmetns;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a6_4.Car.ListElement;
import com.example.a6_4.Car.MyAdapter;
import com.example.a6_4.R;


public class TourFragment extends Fragment {
    private View view;
    public RecyclerView mCollectRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //加载系统里面的布局文件
        view = inflater.inflate(R.layout.recycleview, container, false);
        init_recylerview();
        return view;
    }

    private void init_recylerview(){
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
//        RecyclerView.LayoutManager layoutManager = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        RecyclerView.Adapter adapter = new MyAdapter(getContext(),generate_customer_list());
        recyclerView.setAdapter(adapter);
    }
    private ListElement[] generate_customer_list() {

        ListElement[] elements = {
                new ListElement(0, "宝马"),
                new ListElement(1, "宝马X3 ", "自动挡", "5", "2019", "汽油", "5.9", 2800, "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fx0.ifengimg.com%2Fres%2F2021%2F09E0E83D3966CCE99A0A82EF1112CCA875E998BD_size237_w900_h600.jpeg&refer=http%3A%2F%2Fx0.ifengimg.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1625209679&t=b8d6633aa422f86724d8d351523390a2"),
                new ListElement(1, "宝马X1", "手动挡", "3", "2019", "汽油", "6.8", 2609, "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fx0.ifengimg.com%2Fres%2F2021%2F09E0E83D3966CCE99A0A82EF1112CCA875E998BD_size237_w900_h600.jpeg&refer=http%3A%2F%2Fx0.ifengimg.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1625209679&t=b8d6633aa422f86724d8d351523390a2"),
                new ListElement(1, "宝马X7", "自动挡", "3", "2019", "汽油", "5.8", 2620, "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fx0.ifengimg.com%2Fres%2F2021%2F09E0E83D3966CCE99A0A82EF1112CCA875E998BD_size237_w900_h600.jpeg&refer=http%3A%2F%2Fx0.ifengimg.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1625209679&t=b8d6633aa422f86724d8d351523390a2"),
                new ListElement(0, "奔驰"),
                new ListElement(1, "奔驰A级160", "手动挡", "5", "2019", "柴油", "5.9", 2860, "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fimagecn.gasgoo.com%2Fmoblogo%2FNews%2FUEditor%2Fimage%2F20210602%2F6375822585944714231512988.jpg&refer=http%3A%2F%2Fimagecn.gasgoo.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1625209679&t=06cb81af4758a5f757fab01403046d68"),
                new ListElement(1, "奔驰CLK", "自动挡", "3", "2019", "柴油", "7.1", 2883, "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fimagecn.gasgoo.com%2Fmoblogo%2FNews%2FUEditor%2Fimage%2F20210602%2F6375822585944714231512988.jpg&refer=http%3A%2F%2Fimagecn.gasgoo.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1625209679&t=06cb81af4758a5f757fab01403046d68"),
                new ListElement(1, "200K 敞篷版", "手动挡", "3", "2019", "柴油", "5.5", 2925, "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fimagecn.gasgoo.com%2Fmoblogo%2FNews%2FUEditor%2Fimage%2F20210602%2F6375822585944714231512988.jpg&refer=http%3A%2F%2Fimagecn.gasgoo.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1625209679&t=06cb81af4758a5f757fab01403046d68"),
                new ListElement(0, "奥迪"),
                new ListElement(1, "奥迪A3", "手动挡", "5", "2019", "柴油", "5.9", 2860, "https://img0.baidu.com/it/u=4133842759,1180070172&fm=224&fmt=auto&gp=0.jpg"),
                new ListElement(1, "奥迪A4L", "自动挡", "3", "2019", "柴油", "7.1", 2883, "https://img0.baidu.com/it/u=4133842759,1180070172&fm=224&fmt=auto&gp=0.jpg"),
                new ListElement(1, "奥迪A6L", "手动挡", "3", "2019", "柴油", "5.5", 2925, "https://img0.baidu.com/it/u=4133842759,1180070172&fm=224&fmt=auto&gp=0.jpg")
        };

        return elements;
    }
}

