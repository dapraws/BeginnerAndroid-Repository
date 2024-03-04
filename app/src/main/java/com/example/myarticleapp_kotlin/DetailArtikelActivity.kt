package com.example.myarticleapp_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.core.text.HtmlCompat
import com.bumptech.glide.Glide

class DetailArtikelActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_artikel)

        val articlePhoto = intent.getStringExtra("ARTICLE_PHOTO")
        val articleName = intent.getStringExtra("ARTICLE_NAME")
        val articleLongDescription = intent.getStringExtra("ARTICLE_LONGDESCRIPTION")

        val imgPhoto = findViewById<ImageView>(R.id.img_article_photo)
        val tvName = findViewById<TextView>(R.id.tv_article_name)
        val tvLongDescription = findViewById<TextView>(R.id.tv_article_longdescription)

        Glide.with(this)
            .load(articlePhoto)
            .into(imgPhoto)
        tvName.text = articleName
        tvLongDescription.text = HtmlCompat.fromHtml(articleLongDescription ?: "", HtmlCompat.FROM_HTML_MODE_LEGACY)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}