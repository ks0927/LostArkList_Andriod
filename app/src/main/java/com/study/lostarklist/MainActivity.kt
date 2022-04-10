package com.study.lostarklist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private val items = mutableListOf<ContentsModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bookmarkButton = findViewById<TextView>(R.id.bookmarkBtn)
        bookmarkButton.setOnClickListener {
            val intent = Intent(this,BookmarkActivity::class.java)
            startActivity(intent)
        }
        items.add(
            ContentsModel(
                "https://m-lostark.game.onstove.com/Profile/Character/노인정지팡이스틸러장지환",
            "https://cdn-lostark.game.onstove.com/2018/obt/assets/images/pc/profile/devilhunter.png",
                "노인정지팡이스틸러장지환"
            )
        )
        items.add(
            ContentsModel(
                "https://m-lostark.game.onstove.com/Profile/Character/노인정홍삼캔디도둑장지환",
                "https://cdn-lostark.game.onstove.com/2018/obt/assets/images/pc/profile/lancemaster.png",
                "노인정홍삼캔디도둑장지환"
            )
        )
        items.add(
            ContentsModel(
                "https://m-lostark.game.onstove.com/Profile/Character/onlyonegem ",
                "https://cdn-lostark.game.onstove.com/2018/obt/assets/images/pc/profile/blade.png",
                "onlyonegem  "
            )
        )
        items.add(
            ContentsModel(
                "https://m-lostark.game.onstove.com/Profile/Character/마라탕별점테러하는김찬호 ",
                "https://cdn-lostark.game.onstove.com/2018/obt/assets/images/pc/profile/berserker.png",
                "마라탕별점테러하는김찬호 "
            )
        )
        items.add(
            ContentsModel(
                "https://m-lostark.game.onstove.com/Profile/Character/고양이탈속초특급미인 ",
                "https://cdn-lostark.game.onstove.com/2018/obt/assets/images/pc/profile/infighter.png",
                "고양이탈속초특급미인 "
            )
        )
        items.add(
            ContentsModel(
                "https://m-lostark.game.onstove.com/Profile/Character/도리옥바드 ",
                "https://cdn-lostark.game.onstove.com/2018/obt/assets/images/pc/profile/bard.png",
                "도리옥바드 "
            )
        )
        items.add(
            ContentsModel(
                "https://m-lostark.game.onstove.com/Profile/Character/도리옥아티스트 ",
                "https://cdn-lostark.game.onstove.com/2018/obt/assets/images/pc/profile/artist.png",
                "도리옥아티스트 "
            )
        )
        items.add(
            ContentsModel(
                "https://m-lostark.game.onstove.com/Profile/Character/Alca0927 ",
                "https://cdn-lostark.game.onstove.com/2018/obt/assets/images/pc/profile/reaper.png",
                "Alca0927 "
            )
        )
        items.add(
            ContentsModel(
                "https://m-lostark.game.onstove.com/Profile/Character/ArmyInBlack ",
                "https://cdn-lostark.game.onstove.com/2018/obt/assets/images/pc/profile/warlord.png",
                "ArmyInBlack "
            )
        )
        items.add(
            ContentsModel(
                "https://m-lostark.game.onstove.com/Profile/Character/DerFreishutz ",
                "https://cdn-lostark.game.onstove.com/2018/obt/assets/images/pc/profile/blaster.png",
                "DerFreishutz "
            )
        )
        val recyclerview = findViewById<RecyclerView>(R.id.rv)
        val rvAdapter = RVAdapter(baseContext,items)
        recyclerview.adapter = rvAdapter

        rvAdapter.itemClick =object : RVAdapter.ItemClick{
            override fun onClick(view: View, position: Int) {
                val intent = Intent(baseContext,ViewActivity::class.java)
                intent.putExtra("url",items[position].url)
                intent.putExtra("title",items[position].titletext)
                intent.putExtra("imageurl",items[position].imageUrl)
                startActivity(intent)
            }

        }

        recyclerview.layoutManager = GridLayoutManager(this,2)
    }
}