package com.quickcall.res.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.biometric.auth.AuthPromptHost
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.quickcall.res.R
import com.quickcall.res.helpers.PROTECTION_FINGERPRINT
import com.quickcall.res.helpers.PROTECTION_PATTERN
import com.quickcall.res.helpers.PROTECTION_PIN
import com.quickcall.res.helpers.isRPlus
import com.quickcall.res.interfaces.HashListener
import com.quickcall.res.interfaces.SecurityTab

class AppLockAdapter(
    private val context: Context,
    private val requiredHash: String,
    private val hashListener: HashListener,
    private val viewPager: ViewPager2,
    private val biometricPromptHost: AuthPromptHost,
    private val showBiometricIdTab: Boolean,
    private val showBiometricAuthentication: Boolean
) : RecyclerView.Adapter<AppLockAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(layoutSelection(viewType), parent, false)
        view.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind()

    override fun getItemCount(): Int = if (showBiometricIdTab) 3 else 2

    override fun getItemViewType(position: Int) = position

    private fun layoutSelection(position: Int): Int = when (position) {
        PROTECTION_PATTERN -> R.layout.tab_pattern
        PROTECTION_PIN -> R.layout.tab_pin
        PROTECTION_FINGERPRINT -> R.layout.tab_biometric_id
        else -> throw RuntimeException("Only 3 tabs allowed")
    }

    fun isTabVisible(position: Int, isVisible: Boolean) {
        val viewHolder = (viewPager.getChildAt(0) as? RecyclerView)?.findViewHolderForAdapterPosition(position) as? ViewHolder
        viewHolder?.itemView?.let {
            (it as SecurityTab).visibilityChanged(isVisible)
        }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind() {
            (itemView as SecurityTab).initTab(
                requiredHash = requiredHash,
                listener = hashListener,
                scrollView = null,
                biometricPromptHost = biometricPromptHost,
                showBiometricAuthentication = showBiometricAuthentication
            )
        }
    }
}
