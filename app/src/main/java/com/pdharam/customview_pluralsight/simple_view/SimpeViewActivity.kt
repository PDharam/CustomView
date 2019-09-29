package com.pdharam.customview_pluralsight.simple_view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pdharam.customview_pluralsight.R
import kotlinx.android.synthetic.main.activity_simple_view.*

class SimpeViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_view)
        //setVersionName()
    }

    private fun setVersionName() {
        val packageInfo = packageManager.getPackageInfo(packageName, 0)
        tv_version_name.text = packageInfo.versionName
    }
}
