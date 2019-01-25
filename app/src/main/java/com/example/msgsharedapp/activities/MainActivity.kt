package com.example.msgsharedapp.activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.example.msgsharedapp.Constants
import com.example.msgsharedapp.R
import com.example.msgsharedapp.showToast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        val TAG = MainActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnShowToast.setOnClickListener {

            Log.i(TAG, "Button was clicked !")
            showToast("Button was clicked", Toast.LENGTH_LONG)
        }

        btnSendMessage.setOnClickListener {

            val message: String = etUserMessage.text.toString()

            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra(Constants.USER_MSG_KEY, message)
            startActivity(intent)
        }

        btnShare.setOnClickListener {

            val message: String = etUserMessage.text.toString()
            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT, message)

            startActivity(Intent.createChooser(intent, "Please Select an app: "))
        }

        btnHobbies.setOnClickListener {

            val intent = Intent(this, Hobbies::class.java)
            startActivity(intent)
        }
    }
}
