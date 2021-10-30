package com.example.githubuser.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.githubuser.R
import com.example.githubuser.activity.DetailActivity
import com.example.githubuser.databinding.RvListitemUserBinding
import com.example.githubuser.model.GithubUserModel

class GithubUserAdapter(private val listGithubUser: ArrayList<GithubUserModel>) :
    RecyclerView.Adapter<GithubUserAdapter.ListViewHolder>() {

    class ListViewHolder(var binding: RvListitemUserBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding =
            RvListitemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (username, name, avatar, company, location, repository, follower, following) = listGithubUser[position]
        holder.binding.imgAvatar.setImageResource(avatar)
        holder.binding.tvName.text = name
        holder.binding.tvCompany.text = company
        holder.binding.tvLocation.text = location

        holder.binding.btnFavorite.setOnClickListener {
            val txtFavoriteDesc: String
            val txtButtonValue: String =
                java.lang.String.valueOf(holder.binding.btnFavorite.text)
            if (txtButtonValue == "0") {
                txtFavoriteDesc = "Favorite "
                holder.binding.btnFavorite.text = "1"
                //                    holder.btnFavorite.setIcon(R.drawable.ic_baseline_favorite_24);
                holder.binding.btnFavorite.icon = holder.itemView.context.getDrawable(R.drawable.ic_baseline_favorite_24)
            } else {
                txtFavoriteDesc = "Unfavorite "
                holder.binding.btnFavorite.text = "0"
                holder.binding.btnFavorite.icon = holder.itemView.context.getDrawable(R.drawable.ic_baseline_favorite_border_24)
            }
            Toast.makeText(
                holder.itemView.context, txtFavoriteDesc +
                        listGithubUser.get(holder.adapterPosition).name, Toast.LENGTH_SHORT
            ).show()
        }

        holder.binding.btnShare.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(
                Intent.EXTRA_SUBJECT,
                holder.itemView.context.getString(R.string.app_name)
            )
            intent.putExtra(Intent.EXTRA_TEXT, name)
            startActivity(holder.itemView.context, Intent.createChooser(intent, "Share to :"), null)
        }

        holder.itemView.setOnClickListener {
            val githubUser = GithubUserModel(
                username,
                name,
                avatar,
                company,
                location,
                repository,
                follower,
                following
            )
            val moveWithObjectIntent =
                Intent(holder.itemView.context, DetailActivity::class.java)
            moveWithObjectIntent.putExtra(DetailActivity.EXTRA_GITHUB_USER, githubUser)
            holder.itemView.context.startActivity(moveWithObjectIntent)
        }
    }

    override fun getItemCount(): Int = listGithubUser.size
}