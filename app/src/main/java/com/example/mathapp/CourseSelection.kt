package com.example.mathapp

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_course_selection.*


class CourseSelection : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course_selection)
        setSupportActionBar(findViewById(R.id.tbar))

        course_colAlg.setOnClickListener {
            startActivity(Intent(this, CollegeAlgebra::class.java))
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }
        course_cal1.setOnClickListener {
            startActivity(Intent(this, Calculus1::class.java))
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }
        course_cal2.setOnClickListener {
            startActivity(Intent(this, Calculus2::class.java))
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

        when (item.itemId) {
           /* R.id.action_settings -> {
                val intent = Intent(this, SettingsMain::class.java)
                startActivity(intent)
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
                Toast.makeText(this, "will take to settings for app later", Toast.LENGTH_SHORT).show()
            }*/
            R.id.action_logout ->{
                FirebaseAuth.getInstance().signOut()
                startActivity(Intent(this, LoginActivity::class.java))
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
                finish()
            }
            R.id.action_about ->{
                Toast.makeText(this, "An application for mathbywilson.com", Toast.LENGTH_LONG).show()
            }
            R.id.action_email ->{
                startActivity(Intent(this, SendEmail::class.java))
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
            }
            R.id.action_exit -> {
                finishAffinity()
            }
        }
        return super.onOptionsItemSelected(item)

    }
}

