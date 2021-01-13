package com.example.mathapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_college_algebra.*

class CollegeAlgebra : AppCompatActivity() {
    private var COURSE_SELECT = 0
    private val ACTIVITY_NUM = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_college_algebra)
        setSupportActionBar(findViewById(R.id.tbar))

        eqs_lin.setOnClickListener {
            COURSE_SELECT = 1
            val intent = Intent(this, VideoUrl::class.java)
            intent.putExtra("urlCode", COURSE_SELECT)
            intent.putExtra("activity", ACTIVITY_NUM)
            startActivity(intent)
        }
        com_num.setOnClickListener {
            COURSE_SELECT = 2
            val intent = Intent(this, VideoUrl::class.java)
            intent.putExtra("urlCode", COURSE_SELECT)
            intent.putExtra("activity", ACTIVITY_NUM)
            startActivity(intent)
        }
        eqs_quad.setOnClickListener {
            COURSE_SELECT = 3
            val intent = Intent(this, VideoUrl::class.java)
            intent.putExtra("urlCode", COURSE_SELECT)
            intent.putExtra("activity", ACTIVITY_NUM)
            startActivity(intent)
        }
        app_quad.setOnClickListener {
            COURSE_SELECT = 4
            val intent = Intent(this, VideoUrl::class.java)
            intent.putExtra("urlCode", COURSE_SELECT)
            intent.putExtra("activity", ACTIVITY_NUM)
            startActivity(intent)
        }
        eqs_quad_inform.setOnClickListener {
            COURSE_SELECT = 5
            val intent = Intent(this, VideoUrl::class.java)
            intent.putExtra("urlCode", COURSE_SELECT)
            intent.putExtra("activity", ACTIVITY_NUM)
            startActivity(intent)
        }
        eqs_rat.setOnClickListener {
            COURSE_SELECT = 6
            val intent = Intent(this, VideoUrl::class.java)
            intent.putExtra("urlCode", COURSE_SELECT)
            intent.putExtra("activity", ACTIVITY_NUM)
            startActivity(intent)
        }
        eqs_rad.setOnClickListener {
            COURSE_SELECT = 7
            val intent = Intent(this, VideoUrl::class.java)
            intent.putExtra("urlCode", COURSE_SELECT)
            intent.putExtra("activity", ACTIVITY_NUM)
            startActivity(intent)
        }
        eqs_abs.setOnClickListener {
            COURSE_SELECT = 8
            val intent = Intent(this, VideoUrl::class.java)
            intent.putExtra("urlCode", COURSE_SELECT)
            intent.putExtra("activity", ACTIVITY_NUM)
            startActivity(intent)
        }
        ineq_abs.setOnClickListener {
            COURSE_SELECT = 10
            val intent = Intent(this, VideoUrl::class.java)
            intent.putExtra("urlCode", COURSE_SELECT)
            intent.putExtra("activity", ACTIVITY_NUM)
            startActivity(intent)
        }
        ineq_over.setOnClickListener {
            COURSE_SELECT = 9
            val intent = Intent(this, VideoUrl::class.java)
            intent.putExtra("urlCode", COURSE_SELECT)
            intent.putExtra("activity", ACTIVITY_NUM)
            startActivity(intent)
        }
        rec_coor.setOnClickListener {
            COURSE_SELECT = 11
            val intent = Intent(this, VideoUrl::class.java)
            intent.putExtra("urlCode", COURSE_SELECT)
            intent.putExtra("activity", ACTIVITY_NUM)
            startActivity(intent)
        }
        circles.setOnClickListener {
            COURSE_SELECT = 12
            val intent = Intent(this, VideoUrl::class.java)
            intent.putExtra("urlCode", COURSE_SELECT)
            intent.putExtra("activity", ACTIVITY_NUM)
            startActivity(intent)
        }
        fun_dom.setOnClickListener {
            COURSE_SELECT = 13
            val intent = Intent(this, VideoUrl::class.java)
            intent.putExtra("urlCode", COURSE_SELECT)
            intent.putExtra("activity", ACTIVITY_NUM)
            startActivity(intent)
        }
        fun_ran.setOnClickListener {
            COURSE_SELECT = 14
            val intent = Intent(this, VideoUrl::class.java)
            intent.putExtra("urlCode", COURSE_SELECT)
            intent.putExtra("activity", ACTIVITY_NUM)
            startActivity(intent)
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
            }
            R.id.action_about ->{
                Toast.makeText(this, "An application for mathbywilson.com", Toast.LENGTH_LONG).show()
            }
            R.id.action_email ->{
                Toast.makeText(this, "send email to professor. function coming soon", Toast.LENGTH_SHORT).show()
            }
            R.id.action_exit -> {
                finishAffinity()
            }
        }
        return super.onOptionsItemSelected(item)

    }
}