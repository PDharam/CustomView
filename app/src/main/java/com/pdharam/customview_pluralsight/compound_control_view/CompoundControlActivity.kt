package com.pdharam.customview_pluralsight.compound_control_view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pdharam.customview_pluralsight.R
import kotlinx.android.synthetic.main.activity_compound_control.*

class CompoundControlActivity : AppCompatActivity(), LengthPickerView.OnChangeListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_compound_control)
        setListeners()
    }

    private fun setListeners() {
        lp_width.setOnChangeListener(this)
        lp_height.setOnChangeListener(this)
    }

    override fun onChange(length: Int) {
        updateControl()
    }

    private fun updateControl() {
        val area = lp_width.mNumCount * lp_height.mNumCount
        tv_total_area.text = "$area sq in"
    }

    override fun onResume() {
        super.onResume()
        updateControl()
    }


}
