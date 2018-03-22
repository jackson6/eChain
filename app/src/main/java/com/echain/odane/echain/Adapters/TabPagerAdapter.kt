package com.echain.odane.echain.Adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter
import com.echain.odane.echain.Fragments.TabFragments.AccountTab
import com.echain.odane.echain.Fragments.TabFragments.ExploreTab
import com.echain.odane.echain.Fragments.TabFragments.HomeTab
import com.echain.odane.echain.Fragments.TabFragments.ChatTab

/**
 * Created by ksteere on 3/6/2018.
 */
class TabPagerAdapter (fragmentManager: android.support.v4.app.FragmentManager, private val tabCount: Int) : FragmentPagerAdapter(fragmentManager){


    override fun getItem(position: Int): Fragment? {
        when (position) {
            0 -> return ExploreTab()
            1 -> return HomeTab()
            2 -> return ChatTab()
            3 -> return AccountTab()
            else -> return null
        }
    }

    override fun getCount(): Int {
        return tabCount
    }

}