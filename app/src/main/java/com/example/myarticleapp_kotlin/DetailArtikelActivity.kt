package com.example.myarticleapp_kotlin

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.text.HtmlCompat
import com.bumptech.glide.Glide

class DetailArtikelActivity : AppCompatActivity() {

    private var isLiked = false
    private var isDisliked = false

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

    fun toggleLike(view: View) {
        val btnLike = findViewById<ImageView>(R.id.btn_like)
        val btnDislike = findViewById<ImageView>(R.id.btn_dislike)
        isLiked = !isLiked
        if (isLiked) {
            btnLike.setColorFilter(Color.BLUE)
            btnDislike.clearColorFilter()
            isDisliked = false
        } else {
            btnLike.clearColorFilter()
        }
    }

    fun toggleDislike(view: View) {
        val btnLike = findViewById<ImageView>(R.id.btn_like)
        val btnDislike = findViewById<ImageView>(R.id.btn_dislike)
        isDisliked = !isDisliked
        if (isDisliked) {
            btnDislike.setColorFilter(Color.RED)
            btnLike.clearColorFilter()
            isLiked = false
        } else {
            btnDislike.clearColorFilter()
        }
    }
}