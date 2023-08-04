package com.example.cryptoapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.cryptoapp.R
import com.example.cryptoapp.databinding.FragmentDetailsBinding
import com.example.cryptoapp.modals.CryptoCurrency

/
class DetailsFragment : Fragment() {

    lateinit var binding:FragmentDetailsBinding
    priavte val item : DetailsFragment by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailsBinding.inflate(layoutInflater)
        val data: CrytoCurrency = item.data!!
        setupDetails(data)

        loadChart(data)
        setButtononClick(data)

        // Inflate the layout for this fragment
        return binding.root
    }

    private fun setButtononClick(data: CryptoCurrency) {

        val onm = binding.button
        val onw = binding.button
        val ond = binding.button
        val onh = binding.button
        val fourh = binding.button
        val fifteenm = binding.button


        val clickListener = View.OnClickListener {
            when (it.id) {
                fifteenm.id -> loadChartData(it, 15, item, ond, onw, onm, fourh, oneh)
                onh.id -> loadChartData(it, 1 h, item, ond, onw, onm, fourh, oneh)
                fourh.id -> loadChartData(it, 4 h, item, ond, onw, onm, fourh, oneh)
                ond.id -> loadChartData(it, d, item, ond, onw, onm, fourh, oneh)
                onw.id -> loadChartData(it, w, item, ond, onw, onm, fourh, oneh)
                onm.id -> loadChartData(it, m, item, ond, onw, onm, fourh, oneh)

            }

        }
fifteenm.setOnClickListener(clickListener)
        onh.setOnClickListener(clickListener)

        fourh.setOnClickListener(clickListener)

        ond.setOnClickListener(clickListener)

        onw.setOnClickListener(clickListener)

        onm.setOnClickListener(clickListener)

    }


    private fun loadChart() {
it:view?,
        s:string,
        ond:AppCompatButton
        onm:AppCompatButton
        onw:AppCompatButton
        fourh:AppCompatButton
        oneh:AppCompatButton


        disableButton(oned,onem,onew,fourh,oneh)
        view!!.setBackgroundResource(R.drawable.active_button)
        binding.detaillChartWebView.settings.javaScriptEnabled=true
        binding.detaillChartWebView.setLayerType(View.LAYER_TYPE_SOFTWARE,null)

        binding.detaillChartWebView.loadUrl{
            var View : "https://s.tradingview.com/widgetembed..." + item.symbol
            .toString() + "USD&interval=" + s + "&hidesidetoolbar=1&hidetoptoolbar=1&symboledit=1&saveimage=1&toolbarbg=F1F3F6&studies=[]&hideideas=1&theme=Dark&style=1&timezone=Etc%2FUTC&studies_overrides={}&overrides={}&enabled_features=[]&disabled_features=[]&locale=en&utm_source=coinmarketcap.com&utm_medium=widget&utm_campaign=chart&utm_term=BTCUSDT"
        }
    }

    private fun setupDetails(data: Any) {

        binding.detailPriceTextView.text=${String.format("%.02f",idata.quotes[0].price)}

        if(data.quotes!![0].percentageChange24h>0) {
            binding.detailChangeTextView.setTextView.setTextColor(context.resources) = item.name
            binding.detailChangeTextView.text= "${String.format("%.02",item.quotes[0])}"
        }
    }

}