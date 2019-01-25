package com.example.msgsharedapp.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.msgsharedapp.Constants
import com.example.msgsharedapp.R
import com.example.msgsharedapp.showToast
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    companion object {
        val TAG = SecondActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val bundle: Bundle? = intent.extras

        bundle?.let {
            val msg = bundle.getString(Constants.USER_MSG_KEY)
            showToast(msg)
            tvMessage.text = msg
        }

        btnGoBack.setOnClickListener {

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
