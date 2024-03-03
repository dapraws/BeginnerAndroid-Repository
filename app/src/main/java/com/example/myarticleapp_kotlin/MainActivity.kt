package com.example.myarticleapp_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvArticle: RecyclerView
    private val list = ArrayList<Article>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvArticle = findViewById(R.id.rv_article)
        rvArticle.setHasFixedSize(true)

        list.addAll(getListArticles())
        showRecyclerList()

    }

    private fun getListArticles(): ArrayList<Article> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listHero = ArrayList<Article>()
        for (i in dataName.indices) {
            val hero = Article(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listHero.add(hero)
        }
        return listHero
    }

    private fun showSelectedArticle(hero: Article) {
//        Perpindahan page main ke detail
    }


    private fun showRecyclerList() {
        rvArticle.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = ListArticleAdapter(list)
        rvArticle.adapter = listHeroAdapter

        listHeroAdapter.setOnItemClickCallback(object : ListArticleAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Article) {
                showSelectedArticle(data)
            }
        })
    }
}