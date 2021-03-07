package com.example.plantdiscover

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.plantdiscover.model.DataValue
import com.squareup.picasso.Picasso

class AdapterPlant(private val plants: List<DataValue>) :
    RecyclerView.Adapter<MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.plant_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val plant = plants[position]
        Picasso.get().load(plants[position].imageUrl).into(holder.plantImage)
        holder.commonFamilyName.text = plant.family
        holder.commonName.text = plant.commonName
    }

    override fun getItemCount(): Int {
        return plants.size
    }
}