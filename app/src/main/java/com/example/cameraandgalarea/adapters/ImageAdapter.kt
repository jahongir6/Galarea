package com.example.cameraandgalarea.adapters

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cameraandgalarea.databinding.ItemRvBinding
import com.example.cameraandgalarea.models.MyImage

class ImageAdapter(var list: List<MyImage>) : RecyclerView.Adapter<ImageAdapter.Vh>() {

    inner class Vh(val itemRvBinding: ItemRvBinding) : RecyclerView.ViewHolder(itemRvBinding.root) {
        fun onBind(myImage: MyImage) {
            itemRvBinding.imageItem.setImageURI(Uri.parse(myImage.imagePath))
            itemRvBinding.tvName.text = myImage.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemRvBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size

}