package com.example.pokestar.universityset.Activity;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.example.pokestar.universityset.Fragment.HomePageFragment;
import com.example.pokestar.universityset.Fragment.MineFragment;
import com.example.pokestar.universityset.Fragment.NotificationFragment;
import com.example.pokestar.universityset.Fragment.SchoolFragment;
import com.example.pokestar.universityset.R;

public class MainActivity extends FragmentActivity implements BottomNavigationBar.OnTabSelectedListener {

    private BottomNavigationBar bottomNavigationBar;
    int lastSelectedPosition = 0;
    private HomePageFragment mHomePageFragment;
    private SchoolFragment mSchoolFragment;
    private NotificationFragment mNotificationFragment;
    private MineFragment mMineFragment;

    private String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //bottomNavigationBar 相关设置
        bottomNavigationBar = (BottomNavigationBar)findViewById(R.id.bottom_navigation_bar);

        //Bar 基础设置
        bottomNavigationBar
                .setTabSelectedListener(this)
                .setMode(BottomNavigationBar.MODE_FIXED)
                /**
                 *  setMode() 内的参数有三种模式类型：
                 *  MODE_DEFAULT 自动模式：导航栏Item的个数<=3 用 MODE_FIXED 模式，否则用 MODE_SHIFTING 模式
                 *  MODE_FIXED 固定模式：未选中的Item显示文字，无切换动画效果。
                 *  MODE_SHIFTING 切换模式：未选中的Item不显示文字，选中的显示文字，有切换动画效果。
                 */
                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_RIPPLE)
            /**
             *  setBackgroundStyle() 内的参数有三种样式
             *  BACKGROUND_STYLE_DEFAULT: 默认样式 如果设置的Mode为MODE_FIXED，将使用BACKGROUND_STYLE_STATIC
            *                                    如果Mode为MODE_SHIFTING将使用BACKGROUND_STYLE_RIPPLE。
            *  BACKGROUND_STYLE_STATIC: 静态样式 点击无波纹效果
            *  BACKGROUND_STYLE_RIPPLE: 波纹样式 点击有波纹效果
            */
                .setActiveColor("#FFD9D9D9")  //背景颜色
                .setInActiveColor("#000000")  //未选中颜色
                .setBarBackgroundColor("#FF15AAF4");  //选中颜色

        /**
         * in-active color : is the icon and text color of the in-active/un-selected tab

         是图标和文字的颜色（选中/未选中）

         active color : In BACKGROUND_STYLE_STATIC active color is the icon and text color of the active/selected tab. In BACKGROUND_STYLE_RIPPLE active color is the bottom bar background color (which comes with ripple animation)

         在BACKGROUND_STYLE_STATIC 模式下颜色是图标和文字的颜色（选中/未选中），在BACKGROUND_STYLE_RIPPLE 模式下是底部导航栏背景色。

         background color : In BACKGROUND_STYLE_STATIC background color is the bottom bar background color. In BACKGROUND_STYLE_RIPPLE background color is the icon and text color of the active/selected tab.

         在BACKGROUND_STYLE_STATIC 模式下颜色是底部导航栏背景色，BACKGROUND_STYLE_RIPPLE模式下是图标和文字的颜色（选中/未选中）
         */


        /** 添加导航按钮 */
        bottomNavigationBar
                .addItem(new BottomNavigationItem(R.mipmap.homepage,"首页"))
                .addItem(new BottomNavigationItem(R.mipmap.school, "高校"))
                .addItem(new BottomNavigationItem(R.mipmap.notification, "通知"))
                .addItem(new BottomNavigationItem(R.mipmap.mine, "我的"))
                .setFirstSelectedPosition(lastSelectedPosition )
                .initialise(); //initialise 一定要放在 所有设置的最后一项

        setDefaultFragment();//设置默认导航栏





    }

    //设置默认导航栏

    private void setDefaultFragment() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        mHomePageFragment = HomePageFragment.newInstance();
        transaction.replace(R.id.ui_container, mHomePageFragment);
        transaction.commit();
    }


    /**
     * Called when a tab enters the selected state.
     *设置导航选中事件
     * @param position The position of the tab that was selected
     */
    @Override
    public void onTabSelected(int position) {
        Log.d(TAG,"OnTabSelcted() call with:" + "position = [" + position + "]");
        FragmentManager fm = this.getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        switch (position){
            case 0:
                if (mHomePageFragment == null){
                    mHomePageFragment = HomePageFragment.newInstance();
                }
                transaction.replace(R.id.ui_container, mHomePageFragment);
                break;
            case 1:
                if (mSchoolFragment == null) {
                    mSchoolFragment = SchoolFragment.newInstance();
                }
                transaction.replace(R.id.ui_container, mSchoolFragment);
                break;
            case 2:
                if (mNotificationFragment == null) {
                    mNotificationFragment = NotificationFragment.newInstance();
                }
                transaction.replace(R.id.ui_container, mNotificationFragment);
                break;
            case 3:
                if (mMineFragment == null) {
                    mMineFragment = MineFragment.newInstance("个人中心");
                }
                transaction.replace(R.id.ui_container, mMineFragment);
                break;

            default:
                break;
        }
        transaction.commit();

    }

    /**
     * Called when a tab exits the selected state.
     *设置未选中Fragment事物
     * @param position The position of the tab that was unselected
     */
    @Override
    public void onTabUnselected(int position) {

    }

    /**
     * Called when a tab that is already selected is chosen again by the user. Some applications
     * may use this action to return to the top level of a category.
     *设置释放Fragment事物
     * @param position The position of the tab that was reselected.
     */
    @Override
    public void onTabReselected(int position) {

    }

}
