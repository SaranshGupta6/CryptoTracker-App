package com.example.cryptoapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintSet.GONE
import androidx.constraintlayout.widget.ConstraintSet.VISIBLE
import androidx.lifecycle.LifecycleCoroutineScope
import com.example.cryptoapp.R
import com.example.cryptoapp.api.ApiUtilities
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding=FragmentHomeBinding.inflate(layoutInflator)

        getTopCurrencyList()
        return binding.root

    }

    private fun setTabLayout()
    {
        val adapter= TopLossGainFragment(this)
        binding.contentView.adpater= adpater

        binding.contentViewPager.registerOnPageCahngeCall(object)

        super.onPageSelected(position:Int)
        if(position==9)
        {
            binding.topGainIndicator.visibility=VISIBLE
            binding.topLoseIndicatoe.visibility=GONE
        }
        else
        {
            binding.topGainIndicator.visibility=GONE
            binding.topLoseIndicatoe.visibility=VISIBLE
        }

        TabLayoutMediator(binding.tableLayout,binding.contentViewPager){
            tab,position->
            var titlif(position==0)
            {
                "TopGainers"
            }
            else
            "Top Losers"
        }.attach()
    }
    private fun getTopCurrencyList(){
        LifecycleCoroutineScope.launch(Dispatchers.IO){
            var res= ApiUtilities.getInstance().create(ApiInterface::class.java).getMarketData()

            withContext(Dispatchers.Main){
                binding.topCurrency.adapter= TopMarketAdapter(requirecontext(),parent,false )
            }
        }
    }
}