package com.example.mathapp


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.content.Intent
import android.media.AudioAttributes
import android.media.MediaPlayer
import android.os.Build
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_testing.*


class Testing : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_testing)
        setSupportActionBar(findViewById(R.id.tbar))

        //demonstrate using video player for youtube videos
        video1_button.setOnClickListener{
            startActivity(Intent(this, VideoActivity::class.java))
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }
        video2_button.setOnClickListener{
            startActivity(Intent(this, VideoUrl::class.java))
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }
        btn_course.setOnClickListener {
            startActivity(Intent(this, CourseSelection::class.java))
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }


    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
//        return when (item.itemId) {
//            R.id.action_settings -> true
//            else -> super.onOptionsItemSelected(item)
//        }
        when (item.itemId) {
            R.id.action_settings -> {
//                val intent = Intent(this, SettingsMain::class.java)
//                startActivity(intent)
//                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
                Toast.makeText(this, "will take to settings for app later", Toast.LENGTH_SHORT).show()
            }
            R.id.action_logout ->{
                FirebaseAuth.getInstance().signOut()
                startActivity(Intent(this, LoginActivity::class.java))
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
            }
            R.id.action_about ->{
                Toast.makeText(this, "An application for mathbywilson.com", Toast.LENGTH_LONG).show()
            }
            R.id.action_email ->{
                Toast.makeText(this, "send email to professor. function coming soon", Toast.LENGTH_SHORT).show()
            }
        }
        return super.onOptionsItemSelected(item)

//        video1_button.setOnClickListener{
//            val intent = Intent(this, VideoActivity::class.java)
//            startActivity(intent)
//            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
//        }



    }
}