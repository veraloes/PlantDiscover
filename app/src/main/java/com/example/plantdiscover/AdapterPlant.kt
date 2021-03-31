package com.example.plantdiscover

import android.content.Intent
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.plantdiscover.feature.main.DetailViewActivity
import com.example.plantdiscover.model.Data.DataValue
import com.squareup.picasso.Picasso


class AdapterPlant(private val plants: List<DataValue>) :
        RecyclerView.Adapter<AdapterPlant.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
                LayoutInflater.from(parent.context).inflate(R.layout.plant_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val plant = plants[position]
        Picasso.get().load(plants[position].imageUrl).into(holder.plantImage)
        holder.commonFamilyName.text = plant.familyCommonName
        holder.commonName.text = plant.commonName
        holder.scientificName.text = plant.scientificName
        holder.itemView.tag = position
        holder.itemView.setOnClickListener {
            val context = holder.itemView.context

            Toast.makeText(
                    context,
                    "Clicked item number $position",
                    Toast.LENGTH_LONG
            ).show()

            Handler().postDelayed(
                    {
                        val intent = Intent(context, DetailViewActivity::class.java)
                        context.startActivity(intent)
                    },
                    5000
            )
        }
    }

    override fun getItemCount(): Int {
        return plants.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        override fun onClick(v: View?) {
            val position = v!!.tag as Int
            if (v == itemView) {
                Toast.makeText(
                        v.context,
                        "Clicked item number $position",
                        Toast.LENGTH_LONG
                ).show()
            }
        }

        init {
            itemView.setOnClickListener(this)
        }

        val plantImage: ImageView = itemView.findViewById(R.id.plant_image)
        val commonName: TextView = itemView.findViewById(R.id.common_name)
        val commonFamilyName: TextView = itemView.findViewById(R.id.common_family_name)
        val scientificName: TextView = itemView.findViewById(R.id.scientific_name)
    }
}