package com.study.lostarklist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class BookmarkActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private val contentsModel = mutableListOf<ContentsModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bookmark)

        auth = Firebase.auth

        val database = Firebase.database
        val mybookmarkRef = database.getReference("bookmark_ref")

        val recyclerview = findViewById<RecyclerView>(R.id.rv)
        val rvAdapter = RVAdapter(baseContext,contentsModel)
        recyclerview.adapter = rvAdapter

        recyclerview.layoutManager = GridLayoutManager(this,2)

        mybookmarkRef
            .child(auth.currentUser!!.uid)
            .addValueEventListener(object : ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    for(dataModel in snapshot.children){
                        contentsModel.add(dataModel.getValue(ContentsModel::class.java)!!)
                    }
                    rvAdapter.notifyDataSetChanged()
                }

                override fun onCancelled(error: DatabaseError) {
                    Log.e("Bookmark","dbError")
                }

            })


    }
}