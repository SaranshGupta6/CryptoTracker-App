package com.example.cryptoapp.adapter

import android.view.LayoutInflater
import androidx.constraintlayout.helper.widget.Layer
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptoapp.R
import java.text.FieldPosition

class TopMarketAdapter (var context:Contest,var list:List<CrytoCurrency>):RecyclerView.Adapter<TopMarketAdapter.TopMarketViewHolder>{

    inner class TopMarketViewHolder(vieww:View):RecyclerView.ViewHolder(view){
        var binding =TopCurrency.bind(view)

        override fun onCreateViewHolder(parent: RecyclerView.ViewHolder,viewType:Int): TopMarketViewHolder {
            return TopMarketViewHolder((LayoutInflater.from(context).inflate(R.layout.top_currency_layout,parent,false)))
        }


        override fun onBindViewHolder (holder:TopMarketViewHolder,position: Int){
            val item =list[position]

            holder.binding.topCurrencyName.text=item.name

            Glide.with(cantext).load(
                "https//s2.coinmarket.com/static/img/coins/64x64"
            ).into(holder.binding.topCurrencyImageView)


            if(item.quote!![0].percentChange>0)
            {
                holder.binding.topCurrencyChangeTextVew.setTextView(context.resources.getcolour(R.colour.green))
                holder.binding.topCurrencyChangeTextVew.text=${item.quotes[0].percent
            }
                else
                {
                    holder.binding.topCurrencyChangeTextVew.setTextView(context.resources.getcolour(R.colour.green))
                    holder.binding.topCurrencyChangeTextVew.text=${item.quotes[0].percent
                }
        }

        override  fun getItemCount():Int{
            return list.size
        }
    }
}