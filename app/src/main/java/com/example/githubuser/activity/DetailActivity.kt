package com.example.githubuser.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.githubuser.R
import com.example.githubuser.databinding.ActivityDetailBinding
import com.example.githubuser.model.GithubUserModel

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_GITHUB_USER = "extra_github_user"
    }

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val githubUser =
            intent.getParcelableExtra<GithubUserModel>(EXTRA_GITHUB_USER) as GithubUserModel

        binding.tvUsername.text = getString(R.string.get_username, githubUser.username)
        binding.tvName.text = githubUser.name
        binding.imgAvatar.setImageResource(githubUser.avatar)
        binding.tvCompany.text = githubUser.company
        binding.tvLocation.text = githubUser.location
        binding.tvRepository.text = githubUser.repository
        binding.tvFollowers.text = githubUser.followers
        binding.tvFollowing.text = githubUser.following
    }
}