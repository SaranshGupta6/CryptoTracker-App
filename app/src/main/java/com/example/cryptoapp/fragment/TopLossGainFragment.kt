package com.example.cryptoapp.fragment

import MarketAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cryptoapp.R
import com.example.cryptoapp.api.ApiInterface
import com.example.cryptoapp.api.ApiUtilities
import com.example.cryptoapp.databinding.FragmentTopLossGainBinding
import com.example.cryptoapp.modals.CryptoCurrency
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.*
import kotlin.collections.ArrayList


class TopLossGainFragment : Fragment() {

    lateinit var binding:FragemntTopLossGainBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding=FragmentTopLossGainBinding.inflate(LayoutInflater)
        getMarketData()
        return return binding.root
    }

    private fun getMarketData() {
       val position = requireArgument().getInt("position")
        lifecycleScpe.launch(Dispatchers.IO){
            val res= ApiUtilities.getInstance().create(ApiInterface::class.java)

            if(res.body()!=null){
                withContext(Dispatchers.Main){
                    val dataItem=res.body()!!.datacryptoCurrencyList

                    Collections.sort(dataitem){
                        o1,o2->(o2.quotes[0].percentageChange24h).toInt())
                        .compareTo(o1.quotes[0].percentageChange24h).toInt())
                    }

                    val list=ArrayList<CryptoCurrency>()

                    if(position==0)
                    {
                        list.clear()
                        for(i in 0..9)
                            list.add(dataItem[i])

                        binding.topGainLoseRecycler.adapter=MarketAdapter(requireContext(),list)

                    }
                    else
                    {
                        list.clear()
                        for(i in 0..9)
                            list.add(dataItem[dataItem.size-1-i])

                        binding.topGainLoseRecycler.adapter=MarketAdapter(requireContext(),list)
                    }
                }
            }
        }
    }


}