package com.echain.odane.echain

import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.aurelhubert.ahbottomnavigation.AHBottomNavigation
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem
import com.echain.odane.echain.Adapters.TabPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var tabAdapter: TabPagerAdapter

    private var TAG: String = "MAIN_ACTIVITYS"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tabAdapter = TabPagerAdapter(supportFragmentManager, 4)
        tabPager.adapter = tabAdapter
        tabPager.setCurrentItem(1)

        var status: Boolean = intent.getBooleanExtra("LOGGED_IN", false)

        if (status != true) {
            val loginIntent = Intent(this, loginActivity::class.java)
            startActivity(loginIntent)
        }else{
            initTab()
        }
    }

    fun initTab(){
        // Create items
        val item1 = AHBottomNavigationItem(R.string.nav_explore, R.drawable.ic_explore_black_24dp, R.color.colorBottomNavigationInactive)
        val item2 = AHBottomNavigationItem(R.string.nav_home, R.drawable.ic_home_black_24dp, R.color.colorBottomNavigationInactive)
        val item3 = AHBottomNavigationItem(R.string.nav_message, R.drawable.ic_message_black_24dp, R.color.colorBottomNavigationInactive)
        val item4 = AHBottomNavigationItem(R.string.nav_account, R.drawable.ic_person_black_24dp, R.color.colorBottomNavigationInactive)

        // Add items
        bottom_navigation.addItem(item1)
        bottom_navigation.addItem(item2)
        bottom_navigation.addItem(item3)
        bottom_navigation.addItem(item4)

        bottom_navigation.setDefaultBackgroundColor(Color.parseColor("#000000"));

        // Disable the translation inside the CoordinatorLayout
        bottom_navigation.setBehaviorTranslationEnabled(false);

        bottom_navigation.setAccentColor(Color.parseColor("#F63D2B"));
        bottom_navigation.setInactiveColor(Color.parseColor("#747474"));

        // Manage titles
        bottom_navigation.setTitleState(AHBottomNavigation.TitleState.SHOW_WHEN_ACTIVE);

        // Use colored navigation with circle reveal effect
        bottom_navigation.setColored(true);

        // Set current item programmatically
        bottom_navigation.setCurrentItem(1);

        bottom_navigation.setOnTabSelectedListener(AHBottomNavigation.OnTabSelectedListener { position, wasSelected ->
            tabPager.setCurrentItem(position)
            Log.d(TAG, position.toString())
            true
        })
    }

}
