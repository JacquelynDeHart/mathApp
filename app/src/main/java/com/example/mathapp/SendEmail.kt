package com.example.mathapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
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
}