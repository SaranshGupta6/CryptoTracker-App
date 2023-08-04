package com.example.cryptoapp.fragment

import MarketAdapter
import android.os.Bundle
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.example.cryptoapp.R
import com.example.cryptoapp.api.ApiInterface
import com.example.cryptoapp.api.ApiUtilities
import com.example.cryptoapp.databinding.FragmentMarketBinding
import com.example.cryptoapp.modals.CryptoCurrency
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*
import kotlin.collections.ArrayList

class MarketFragment : Fragment() {

     private lateinit var binding:FragmentMarketBinding
     private lateinit varlist:List<CryptoCurrecy>
    private lateinit var adapter:MarketAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding =FragmentMarketBinding.inflate(layoutInflater)

        list=listOf()

        adapter=MarketAdapter(requireContext(),list)
        binding.currencyRecyclerView.adapter=adapter

        lifecycleScope.launch(Dispatchers.IO){
            val res=ApiUtilities.getInstance().create(ApiInterface::class.java).getMarketData()

            if(res.body()!=null){
                withContext()
                {
                    adapter.updateData(list)
                    binding.spinKitView.visibility=GONE
                }            }

        }
        searchCoin()

        return binding.root
    }

    private fun searchCoin() {
binding.searchEditText.addTextChangedListener(object: TextWatcher)    }

private fun updateRecyclerView(){

    val data=ArrayList<CryptoCurrency>()

    for(item in list){
        val coinName=item.name.lowercase(Locale.getDefault())
        val coinsymbol=item.symbol.lowercase(Locale.getDefault())

        if(coinName.contains(searchText)|| coinsymbol.contains(searchtext)){
            data.add(item)
        }
    }
    adapter.updateData(data)
}
}