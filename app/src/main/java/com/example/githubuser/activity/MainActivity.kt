package com.example.githubuser.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.githubuser.R
import com.example.githubuser.adapter.GithubUserAdapter
import com.example.githubuser.databinding.ActivityMainBinding
import com.example.githubuser.model.GithubUserModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val list = ArrayList<GithubUserModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvGithubUser.setHasFixedSize(true)

        list.addAll(listGithubUsers)
        showRecyclerList()
    }

    private val listGithubUsers: ArrayList<GithubUserModel>
        get() {
            val dataUsername = resources.getStringArray(R.array.username)
            val dataName = resources.getStringArray(R.array.name)
            val dataLocation = resources.getStringArray(R.array.name)
            val dataRepository = resources.getStringArray(R.array.repository)
            val dataCompany = resources.getStringArray(R.array.company)
            val dataFollowers = resources.getStringArray(R.array.followers)
            val dataFollowing = resources.getStringArray(R.array.following)
            val dataAvatar = resources.obtainTypedArray(R.array.avatar)
            val listGithubUser = ArrayList<GithubUserModel>()
            for (i in dataUsername.indices) {
                val githubUser = GithubUserModel(
                    dataUsername[i], dataName[i], dataAvatar.getResourceId(i, -1), dataCompany[i], dataLocation[i], dataRepository[i],  dataFollowers[i], dataFollowing[i])
                listGithubUser.add(githubUser)
            }
            return  listGithubUser
        }

    private fun showRecyclerList() {
        binding.rvGithubUser.layoutManager = LinearLayoutManager(this)
        val listGithubUserAdapter = GithubUserAdapter(list)
        binding.rvGithubUser.adapter = listGithubUserAdapter
    }


}