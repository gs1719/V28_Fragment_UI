package com.example.v28_fragment_ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()

        setContentView(R.layout.activity_main)
//        this is set as default Home() fragment
       replaceWithFragment(Home())

        val bottomView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomView.setOnItemSelectedListener {
            when(it.itemId)
            {
                R.id.item1 -> replaceWithFragment(Search())
                R.id.item2 -> replaceWithFragment(Categories())
                R.id.item3 -> replaceWithFragment(Home())
                R.id.item4 -> replaceWithFragment(Account())
                R.id.item5 -> replaceWithFragment(Cart())

            }
            true
        }

    }



    private fun replaceWithFragment(frag:Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout,frag)
        fragmentTransaction.commit()
    }
}