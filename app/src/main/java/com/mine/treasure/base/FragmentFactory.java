package com.mine.treasure.base;

import com.mine.treasure.basemvp.BaseMvpFragment;
import com.mine.treasure.fragment.FirstFragment;
import com.mine.treasure.fragment.SecondFragment;
import com.mine.treasure.fragment.ThirdFragment;

import java.util.HashMap;

public class FragmentFactory {

    private static final int TAB_FIRST = 0;
    private static final int TAB_SECOND = 1;
    private static final int TAB_THIRD = 2;


    private static HashMap<Integer, BaseMvpFragment> mFragments = new HashMap<Integer, BaseMvpFragment>();

    public static BaseMvpFragment createFragment(int position) {
        // 从缓存中取出
        BaseMvpFragment fragment = mFragments.get(position);
        if (null == fragment) {
            switch (position) {
                case TAB_FIRST:
                    fragment = new FirstFragment();
                    break;
                case TAB_SECOND:
                    fragment = new SecondFragment();
                    break;
                case TAB_THIRD:
                    fragment = new ThirdFragment();
                    break;


                default:
                    break;
            }
            // 把frament加入到缓存中
            mFragments.put(position, fragment);
        }
        return fragment;
    }
}
