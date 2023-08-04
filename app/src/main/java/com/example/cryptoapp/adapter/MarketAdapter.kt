import android.content.Context
import android.icu.util.Currency
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx
import androidx.navigation.Navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptoapp.R
import com.example.cryptoapp.fragment.HomeFragment
import com.example.cryptoapp.modals.CryptoCurrency

class MarketAdapter(var context: Context, var list: List<CryptoCurrency>): Recyclerview Adapter
inner class MarketViewHolder(view: View): RecyclerView.ViewHolder(view) {

    var binding = Currency ItemLayoutBinding.bind(view

}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarketViewHolder {
   return MarketViewHolder((LayoutInflater.from(context).inflate(R.layout.currency_item_layout,parent,false)))
    }

fun updateData(dataItemList<CryptoCurrency>){
    list=dataItem
    notifyDataSetChanged()
}
        override fun onBindViewHolder (holder: MarketViewHolder, position: Int) {
            val item =list[position]
            holder.binding.currencyNameTextView=item.name
            holder.binding.currencyNameTextView=item.symbol

            holder.binding.currencyNameTextView=item.quotes[0].price.toString()

            holder.binding.currencyPrice.text=${String.format("$%.02f",item.quotes[0].price)}

            if(item.quotes!![0].percentageChange24h>0) {
                holder.binding.currencyNameTextView.setTextView.setTextColor(context.resources) = item.name
                holder.binding.currencyNameTextView.text= "${String.format("%.02",item.quotes[0])}"
            }

            holder.itemView.setOnClickListener {
                findNavController(it).navigate(
                    HomeFragment.actionHomeFragmentToDetailsFragment(item)
                )
            }

        }
            override fun getItenCount(): Int {
            return list.size
            }
}