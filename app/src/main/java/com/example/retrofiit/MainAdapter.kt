package com.example.retrofiit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.retrofiit.utils.GlideLoader
import com.example.retrofiit.utils.User
//Main Adapter class for connecting to main activity
class MainAdapter(private val users: ArrayList<User>) : RecyclerView.Adapter<MainAdapter.DataViewHolder>() {

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(user: User) {
            itemView.apply {
               val  textViewUserName = findViewById<TextView>(R.id.textViewUserName)
                val  imageViewAvatar:ImageView = findViewById<ImageView>(R.id.imageViewAvatar)
                textViewUserName.text = user.author
                 Glide
                    .with(context)
                    .load(user.download_url) // Uri or URL of the image
                    .centerCrop() // Scale type of the image.
                    .into(imageViewAvatar) // the view in which the image will be loaded.


            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder =
        DataViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false))

    override fun getItemCount(): Int = users.size
//for binding the postions in an array
    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(users[position])
    }
//for adding every image of a user
    fun addUsers(users: List<User>) {
        this.users.apply {
            clear()
            addAll(users)
        }

    }
}