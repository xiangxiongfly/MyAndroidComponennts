package com.example.contact

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.example.common.arouter.ARouterConstant
import com.example.common.base.BaseActivity
import com.example.contact.bean.Person
import com.example.contact.databinding.ActivityMyBinding

@Route(path = ARouterConstant.PATH_CONTACT_MY_ACTIVITY)
class MyActivity : BaseActivity() {

    @JvmField
    @Autowired(name = "name")
    var uname: String = ""

    @JvmField
    @Autowired(name = "age")
    var age = -1

    @JvmField
    @Autowired(name = "address")
    var address = ""

    @JvmField
    @Autowired(name = "person")
    var person: Person? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewBinding = ActivityMyBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        ARouter.getInstance().inject(this)

        viewBinding.name.text = uname
        viewBinding.age.text = age.toString()
        viewBinding.address.text = address
        viewBinding.person.text = person.toString()
    }
}