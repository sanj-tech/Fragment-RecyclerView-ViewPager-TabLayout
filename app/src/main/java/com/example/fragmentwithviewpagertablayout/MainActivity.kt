package com.example.fragmentwithviewpagertablayout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.fragmentwithviewpagertablayout.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)



        setSupportActionBar(binding.toolbar)
        setupViewPager(binding.tabViewpager)
        binding.tabTablayout.setupWithViewPager(binding.tabViewpager)
    }

    private fun setupViewPager(viewpager: ViewPager) {

        var adapter = ViewPagerAdapter(supportFragmentManager)

        // LoginFragment is the name of Fragment and the Login
        // is a title of tab
        adapter.addFragment(SweetFragment(), "Sweet")
        adapter.addFragment(SweetFragment(), "Fruit")

        // setting adapter to view pager.
        viewpager.setAdapter(adapter)

    }

    class ViewPagerAdapter : FragmentPagerAdapter {
        private final var fragmentList1: ArrayList<Fragment> = ArrayList()
        private final var fragmentTitleList1: ArrayList<String> = ArrayList()

        // this is a secondary constructor of ViewPagerAdapter class.
        public constructor(supportFragmentManager: FragmentManager)
                : super(supportFragmentManager)

        // returns which item is selected from arraylist of fragments.
        override fun getItem(position: Int): Fragment {
            return fragmentList1.get(position)
        }

        // returns which item is selected from arraylist of titles.

        override fun getPageTitle(position: Int): CharSequence {
            return fragmentTitleList1.get(position)
        }

        // returns the number of items present in arraylist.
        override fun getCount(): Int {
            return fragmentList1.size
        }

        fun addFragment(fragment: Fragment, sweetFragment: String) {
            fragmentList1.add(fragment)
            fragmentTitleList1.add(sweetFragment)
        }

    }


}