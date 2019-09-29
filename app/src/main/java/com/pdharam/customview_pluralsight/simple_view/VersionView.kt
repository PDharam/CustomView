package com.pdharam.customview_pluralsight.simple_view

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.widget.TextView

class VersionView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : TextView(context, attrs, defStyleAttr) {
    init {
        setVersionName()
    }

    private fun setVersionName() {
        val packageInfo = context.packageManager.getPackageInfo(context.packageName, 0)

        text = packageInfo.versionName
        setBackgroundColor(Color.RED)
    }
}