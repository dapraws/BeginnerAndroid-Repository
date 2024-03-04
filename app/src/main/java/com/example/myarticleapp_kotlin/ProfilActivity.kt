package com.example.myarticleapp_kotlin

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.ImageView

class ProfilActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profil)

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

    fun openLinkedInProfile(view: View) {
        val linkedinUrl = "https://www.linkedin.com/in/dapraws"
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(linkedinUrl))
        startActivity(intent)
    }

    fun openGitHubProfile(view: View) {
        val githubUrl = "https://github.com/dapraws"
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(githubUrl))
        startActivity(intent)
    }
    fun openInstagramProfile(view: View) {
        val instagramUrl = "https://www.instagram.com/dapraws"
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(instagramUrl))
        startActivity(intent)
    }
}
