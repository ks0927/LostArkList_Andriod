package com.study.lostarklist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class ViewActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)

        auth = Firebase.auth
        val webView = findViewById<WebView>(R.id.webview)
        webView.loadUrl(intent.getStringExtra("url").toString())

        val database = Firebase.database
        val mybookmarkRef = database.getReference("bookmark_ref")

        val url = intent.getStringExtra("url").toString()
        val title = intent.getStringExtra("title").toString()
        val imageurl = intent.getStringExtra("imageurl").toString()

        val saveText = findViewById<TextView>(R.id.saveText)
        saveText.setOnClickListener{
            mybookmarkRef
                .child(auth.currentUser!!.uid)
                .push()
                .setValue(ContentsModel(url,imageurl,title))
            Toast.makeText(this,"북마크에 저장되었습니다",Toast.LENGTH_SHORT).show()
        }

    }
}