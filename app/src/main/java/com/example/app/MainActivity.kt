package com.example.app

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import com.alibaba.android.arouter.launcher.ARouter
import com.example.app.databinding.ActivityMainBinding
import com.example.chat.MyFragmentActivity
import com.example.chat.fragment.ChatFragment
import com.example.common.arouter.ARouterConstant
import com.example.common.base.BaseActivity
import com.example.contact.bean.Person
import com.example.contact.fragment.ContactFragment
import com.example.find.fragment.FindFragment
import com.example.me.fragment.MeFragment

class MainActivity : BaseActivity() {
    private lateinit var viewBinding: ActivityMainBinding
    private val fragmentList by lazy {
        ArrayList<Fragment>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        initFragments()
        initVp()
        viewBinding.rgBottom.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.rbChat -> switchFragment(0)
                R.id.rbContact -> switchFragment(1)
                R.id.rbFind -> switchFragment(2)
                R.id.rbMe -> switchFragment(3)
            }
        }
    }

    private fun initFragments() {
        fragmentList.add(ChatFragment.newInstance())
        fragmentList.add(ContactFragment.newInstance())
        fragmentList.add(FindFragment.newInstance())
        fragmentList.add(MeFragment.newInstance())
    }

    private fun initVp() {
        viewBinding.vpContainer.adapter = object : FragmentPagerAdapter(supportFragmentManager) {
            override fun getCount(): Int = fragmentList.size

            override fun getItem(position: Int): Fragment = fragmentList[position]
        }
    }

    private fun switchFragment(index: Int) {
        viewBinding.vpContainer.currentItem = index
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_chat ->
                ARouter.getInstance().build(ARouterConstant.PATH_CHAT_RUN).navigation()
            R.id.menu_contact ->
                ARouter.getInstance().build(ARouterConstant.PATH_CONTACT_RUN).navigation();
            R.id.menu_find ->
                ARouter.getInstance().build(ARouterConstant.PATH_FIND_RUN).navigation();
            R.id.menu_me ->
                ARouter.getInstance().build(ARouterConstant.PATH_ME_RUN).navigation();
            R.id.menu_my_activity ->
                ARouter.getInstance().build(ARouterConstant.PATH_CONTACT_MY_ACTIVITY)
                    .withString("name", "小明")
                    .withInt("age", 18)
                    .withString("address", "北京市")
                    .withSerializable("person", Person("小白", 28, "广州市"))
                    .navigation()
            R.id.menu_my_fragment ->
                MyFragmentActivity.start(this)
        }
        return super.onOptionsItemSelected(item)
    }
}