package com.example.cryptoapp.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.cryptoapp.fragment.TopLossGainFragment
import papayacoders.cryptoapp. fragment. TopLossGainFragment

class TopLossGainPager Adapter (fragment: Fragment): FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int {
        return 2
    }
        override fun createFragment (position: Int): Fragment {
            {
            val fragment = TopLossGainFragment()
            val bundle =Bundle()
            bundle.putInt("position", position)

            fragment.arguments =bundle

            return fragment
            }
        }
