package com.example.a6_4.fragmetns;

import android.util.Log;

import androidx.fragment.app.Fragment;

import com.example.a6_4.fragmetns.HomeFragment;
import com.example.a6_4.fragmetns.OrderFragment;
import com.example.a6_4.fragmetns.SettingFragment;

public class FragmentUtil {

    //工厂模式的使用
    public static final Fragment CreateFragment(int type) {
        Fragment fragment = null;
        switch (type) {
            case 0:
                Log.e("TAG", "type:" + type);
                break;
            case 1:
                fragment = new OrderFragment();
                break;
            case 2:
                fragment = new HomeFragment();
                break;
            case 3:
                fragment = new SettingFragment();
                break;
        }
        return fragment;
    }

    //反射的使用
    public static final String[] fragmentNames = {"TourFragment", "OrderFragment", "HomeFragment",
            "QucheFragment", "SettingFragment"};

    public static final Fragment CreateFragment2(int type) {

        try {
            //通过一个类的字符串对象，转换成一个Class 类类型
            Class className = Class.forName("com.example.a6_4" + fragmentNames[type]);
            //通过类的类型去创建实例  必须有无参构造方法 并且是公开的
            return (Fragment) className.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;

    }


}
