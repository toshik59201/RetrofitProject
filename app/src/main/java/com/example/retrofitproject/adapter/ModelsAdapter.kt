package com.example.retrofitproject.adapter;

import android.content.Context
import android.view.LayoutInflater
import android. view.View
import android. view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

public class ModelsAdapter (context: Context,
    private val dataSource: Array<Character>):BaseAdapter() {
    override fun getCount(): Int {
        return dataSource.size
    }

    private val inflater = context
        .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getItem(position: Int): Any {
        return dataSource[position]
    }

    override fun getItemId(position: Int): Long {
        return (dataSource[position] as Character).id.toLong()
    }

    override fun getView(position: Int, view: View?, parent: ViewGroup?): View {
        val itemView = inflater.inflate(R.layout.list view item, parent, false)

        val imageView:ImageView=itemView.findViewById(R.id.imageViewPhoto)
        val tvName:TextView=itemView.findViewById(R.id.textViewName)
        val tvStatus:TextView=itemView.findViewById(R.id.textViewStatus)
        val tvSpecies:TextView=itemView.findViewById(R.id.textViewSpecies)
        val tvType:TextView=itemView.findViewById(R.id.textViewTupe)
        val tvGender:TextView=itemView.findViewById(R.id.textViewGender)
        val tv0rigin:TextView=itemView.findViewById(R.id.textViewOrigin)
        val tvLocation:TextView=itemView.findViewById(R.id.textViewLocation)
        val tvDate:TextView=itemView.findViewById(R.id.textViewDate)

        var character = getItem(position) as Character

        Picasso.get().load(character.image).into(imageView)
        tvName.text=character.name
        tvStatus.text=character.status
        tvSpecies.text=character.species
        tvType.text=character.type
        tvGender.text=character.gender
        tv0rigin.text=character.origin.name
        tvLocation.text=characterlocation.name
        tvDate.text=character.created

        return itemView
    }
}