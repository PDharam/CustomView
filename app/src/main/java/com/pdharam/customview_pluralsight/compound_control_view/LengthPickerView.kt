package com.pdharam.customview_pluralsight.compound_control_view

import android.content.Context
import android.os.Bundle
import android.os.Parcelable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import androidx.core.view.setPadding
import com.pdharam.customview_pluralsight.R
import kotlinx.android.synthetic.main.length_picker.view.*

class LengthPickerView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr), View.OnClickListener {
    private lateinit var mListener: OnChangeListener
    private val KEY_SUPER_STATE = "key_super_state"
    private val KEY_NUM_INT = "key_num_int"
    var mNumCount = 0


    init {
        LayoutInflater.from(context).inflate(R.layout.length_picker, this)
        setListeners()
        orientation = HORIZONTAL
        setPadding(22)
        updateControls()
    }

    private fun setListeners() {

        btn_minus.setOnClickListener(this)
        btn_plus.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_minus -> {
                if (mNumCount > 0) {
                    mNumCount--
                    updateControls()
                    if (mListener != null) {
                        mListener.onChange(mNumCount)
                    }
                }
            }
            R.id.btn_plus -> {
                mNumCount++
                updateControls()
                if (mListener != null) {
                    mListener.onChange(mNumCount)
                }
            }

        }
    }

    private fun updateControls() {
        val feet = mNumCount / 12
        val inches = mNumCount % 12

        var result = "$feet' $inches"

        if (feet == 0) {
            result = "$inches"
        } else if (inches == 0) {
            result = "$feet"
        }

        tv_number.text = result

        btn_minus.isEnabled = mNumCount > 0
        btn_minus.setBackgroundColor(
            if (mNumCount > 0) resources.getColor(R.color.colorMinus) else resources.getColor(
                R.color.colorDisable
            )
        )

    }

    override fun onSaveInstanceState(): Parcelable? {
        val bundle = Bundle()
        bundle.putParcelable(KEY_SUPER_STATE, super.onSaveInstanceState())
        bundle.putInt(KEY_NUM_INT, mNumCount)
        return bundle
    }

    override fun onRestoreInstanceState(state: Parcelable?) {
        if (state is Bundle) {
            mNumCount = state.getInt(KEY_NUM_INT)
            super.onRestoreInstanceState(state.getParcelable<Parcelable>(KEY_SUPER_STATE))
            updateControls()
        } else
            super.onRestoreInstanceState(state)
    }

    fun setOnChangeListener(onChangeListener: OnChangeListener) {
        mListener = onChangeListener
    }

    interface OnChangeListener {
        fun onChange(length: Int)
    }
}