package com.example.minimoneybox

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*


import kotlinx.android.synthetic.main.activity_user.*
import kotlinx.android.synthetic.main.content_user.*


class user : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.setContentView(R.layout.activity_user)
        this.setSupportActionBar(this.toolbar)




        this.isa.setOnClickListener {

                val intent = Intent(this,IndividualAccountLifetime::class.java)
                this.startActivity(intent)
        }

        this.gia.setOnClickListener {

            val intent = Intent(this,IndividualAccountGeneralInvestmentAccount::class.java)
            this.startActivity(intent)
        }

        this.lisa.setOnClickListener {

            val intent = Intent(this,IndividualAccountStockShares::class.java)
            this.startActivity(intent)
        }

    }



}




