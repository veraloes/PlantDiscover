package com.example.plantdiscover

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val plantImage: ImageView = itemView.findViewById(R.id.plant_image)
    val commonName: TextView = itemView.findViewById(R.id.common_name)
    val commonFamilyName: TextView = itemView.findViewById(R.id.common_family_name)
}