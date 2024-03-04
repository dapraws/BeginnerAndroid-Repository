package com.example.myarticleapp_kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvArticle: RecyclerView
    private val list = ArrayList<Article>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvArticle = findViewById(R.id.rv_articles)
        rvArticle.setHasFixedSize(true)

        list.addAll(getListArticles())
        showRecyclerList()

    }

    private fun getListArticles(): ArrayList<Article> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataLongDescription = resources.getStringArray(R.array.data_longdescription)
        val dataPhoto = resources.getStringArray(R.array.data_photo)
        val listArticle = ArrayList<Article>()
        for (i in dataName.indices) {
            val artikel = Article(dataName[i], dataDescription[i], dataLongDescription[i], dataPhoto[i])
            listArticle.add(artikel)
        }
        return listArticle
    }

    private fun showSelectedArticle(article: Article) {
        val intent = Intent(this, DetailArtikelActivity::class.java)
        intent.putExtra("ARTICLE_NAME", article.name)
        intent.putExtra("ARTICLE_DESCRIPTION", article.description)
        intent.putExtra("ARTICLE_LONGDESCRIPTION", article.longDescription)
        intent.putExtra("ARTICLE_PHOTO", article.photo)
        startActivity(intent)
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_profil, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_profil -> {
                val intent = Intent(this, ProfilActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}