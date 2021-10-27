package com.example.githubuser.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.githubuser.databinding.RvListitemUserBinding
import com.example.githubuser.model.GithubUserModel

class GithubUserAdapter(private val listGithubUser: ArrayList<GithubUserModel>) : RecyclerView.Adapter<GithubUserAdapter.ListViewHolder>() {
    class ListViewHolder(var binding: RvListitemUserBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = RvListitemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (username, name, avatar, company, location, repository, follower, following) = listGithubUser[position]
        holder.binding.imgAvatar.setImageResource(avatar)
        holder.binding.tvName.text = name
        holder.binding.tvCompany.text = company
        holder.binding.tvLocation.text = location
    }

    override fun getItemCount(): Int = listGithubUser.size
}