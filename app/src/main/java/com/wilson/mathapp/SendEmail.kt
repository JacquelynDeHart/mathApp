package com.wilson.mathapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_send_email.*
import java.lang.Exception

class SendEmail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_send_email)
        setSupportActionBar(findViewById(R.id.tbar))

        btn_send_email.setOnClickListener {
            val recipient = recipient_et.text.toString().trim()
            val subject = subject_et.text.toString().trim()
            val message = message_et.text.toString().trim()

            //method for creating intent with input information
            sendEmail(recipient, subject, message)
        }
        returnToCourseSelection.setOnClickListener {
            returnToCourseSelection()
        }
    }

    private fun sendEmail(recipient: String, subject: String, message: String) {
        //Action: send email using already installed mail client app
        val intent = Intent(Intent.ACTION_SEND)
        /*To send an email you need to specify mailto: as URI using setData() method
        and data type will be to text/plain using setType() method*/
        intent.data = Uri.parse("mailto:")
        intent.type = "text/plain"
        //put recipient email in intent
        /* recipient is put as array because you may wanna send email to multiple emails
           so enter comma(,) separated emails, it will be stored in array*/
        intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(recipient))
        //put subject and message in intent
        intent.putExtra(Intent.EXTRA_SUBJECT, subject)
        intent.putExtra(Intent.EXTRA_TEXT, message)

        try{
            startActivity(Intent.createChooser(intent, "Select Email Client"))
        }
        catch (e: Exception){
            //get and show error message if exception is thrown
            Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
        }

    }

    private fun returnToCourseSelection() {
        startActivity(Intent(this, CourseSelection::class.java))
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
    }

    /* methods for inflating the menu in the task bar */
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