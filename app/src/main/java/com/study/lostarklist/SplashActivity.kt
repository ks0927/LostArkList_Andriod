package com.study.lostarklist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SplashActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        auth = Firebase.auth

        if((auth.currentUser?.uid ==null)){
            //회원가입이 안되어있으므로 joinActivity로 보낸다
            Handler().postDelayed({
                startActivity(Intent(this,JoinActivity::class.java))
                finish()
            },3000)
        }
        else{
            Toast.makeText(this,"유저 확인 자동로그인",Toast.LENGTH_SHORT).show()
            Handler().postDelayed({
                startActivity(Intent(this,MainActivity::class.java))
                finish()
            },3000)

        }

    }
}