package com.echain.odane.echain.Adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.echain.odane.echain.Models.Place
import com.echain.odane.echain.R



/**
 * Created by ksteere on 3/15/2018.
 */

class PlaceAdapter(var items: ArrayList<Place>, val listener: (Place) -> Unit): RecyclerView.Adapter<PlaceAdapter.ViewHolder>(){

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position], listener)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun getItemViewType(position: Int): Int{
        return items[position].type
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder{
        var itemView: ViewHolder = when(viewType) {
            1 -> ViewHolder(LayoutInflater.from(parent?.context)
                    .inflate(R.layout.place_list_row, parent, false))
            else -> ViewHolder(LayoutInflater.from(parent?.context)
                .inflate(R.layout.address_list_row, parent, false))
        }

        return itemView
    }

    class ViewHolder(row: View): RecyclerView.ViewHolder(row){
        var placeName: TextView? = null
        var placeAddress: TextView? = null

        init{
            this.placeName = row?.findViewById<TextView>(R.id.place_name)
            this.placeAddress = row?.findViewById<TextView>(R.id.place_address)
        }

        open fun bind(item: Place, listener: (Place) -> Unit) {
            placeName?.setText(item.name)
            placeAddress?.setText(item.address)
            itemView.setOnClickListener { listener(item) }
        }
    }

}