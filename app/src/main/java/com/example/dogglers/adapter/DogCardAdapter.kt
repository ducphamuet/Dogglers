package com.example.dogglers.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.dogglers.R
import com.example.dogglers.const.Layout
import com.example.dogglers.data.DataResource
import com.example.dogglers.model.Dog

class DogCardAdapter(
    private val mContext: Context,
    private val mLayout: Int,
) : Adapter<DogCardAdapter.DogCardViewHolder>() {

    class DogCardViewHolder(view : View?) : ViewHolder(view!!) {
        val image: ImageView = view!!.findViewById(R.id.image)
        val name: TextView = view!!.findViewById(R.id.name)
        val age: TextView = view!!.findViewById(R.id.age)
        val hobbies: TextView = view!!.findViewById(R.id.hobbies)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogCardViewHolder {
        var layoutRes: Int = when (mLayout) {
            Layout.VERTICAL -> R.layout.vertical_horizontal_list_item
            Layout.HORIZONTAL -> R.layout.vertical_horizontal_list_item
            else -> R.layout.grid_list_item
        }
        val adapterLayout = LayoutInflater.from(parent.context).inflate(layoutRes, parent, false)
        return DogCardViewHolder(adapterLayout)
    }

    override fun getItemCount(): Int = DataResource.dogs.size

    override fun onBindViewHolder(holder: DogCardViewHolder, position: Int) {
        val dog = DataResource.dogs[position]
        holder.image.setImageResource(dog.imageResourceId)
        holder.name.text = dog.name
        holder.age.text = dog.age
        holder.hobbies.text = dog.hobbies
    }
}