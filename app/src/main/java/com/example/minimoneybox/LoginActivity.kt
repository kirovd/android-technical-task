package com.example.minimoneybox

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.os.AsyncTask
import android.os.Build.ID
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TextInputLayout
import android.telecom.Call
import android.view.textclassifier.TextLinks
import android.widget.Button
import android.widget.EditText
import android.widget.ListAdapter
import android.widget.Toast
import com.airbnb.lottie.LottieAnimationView
import org.json.JSONArray
import java.io.IOException
import java.util.regex.Pattern
import java.net.HttpURLConnection
import java.net.URL
import javax.security.auth.callback.Callback


/**
 * A login screen that offers login via email/password.
 */
class LoginActivity : AppCompatActivity()  {

    lateinit var btn_sign_in : Button
    lateinit var til_email : TextInputLayout
    lateinit var et_email : EditText
    lateinit var til_password : TextInputLayout
    lateinit var et_password : EditText
    lateinit var til_name : TextInputLayout
    lateinit var et_name : EditText
    lateinit var pigAnimation : LottieAnimationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setupViews()
//        val url = "https://api-test01.moneyboxapp.com/"
//        AsyncTaskHandleJson().execute(url)
//        sendGet()
        sendGetRequest()
        checkConnectivity()
    }

//    inner class AsyncTaskHandleJson : AsyncTask<String, String, String>(){
//        override fun doInBackground (vararg url: String?): String{
//            var text: String
//            val connection = URL(url[0]).openConnection() as HttpURLConnection
//            try{
//                connection.connect()
//                text = connection.inputStream.use { it.read().use{reader -> reader.readText()} }
//            }finally {
//                connection.disconnect()
//            }
//            return text
//        }
//
//        override fun onPostExecute(result: String?) {
//            super.onPostExecute(result)
//            handleJson(result)
//        }
//    }
//
//    private fun handleJson(JsonString: String?){
//        val jsonArray = JSONArray(JsonString)
//        val list = ArrayList<user>
//
//        var x = 0
//        while (x < jsonArray.length()){
//            var jsonObject = jsonArray.getJSONObject(x)
//
//            list.add(user(
//                jsonObject.getInt("id"),
//                jsonObject.getString("nm"),
//                jsonObject.getString("pp"),
//                jsonObject.getString("tm")
//
//            ))
//            x++
//        }
//        val adapter = ListAdapter(this,list)
//        user_list.adapter = adapter
//    }

    private fun checkConnectivity(){
        val cm = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = cm.activeNetworkInfo
        val isConnected = activeNetwork != null &&activeNetwork.isConnectedOrConnecting
        if (!isConnected){
            Toast.makeText(this,"check network connection", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onStart() {
        super.onStart()
        setupAnimation()
    }

    private fun setupViews() {

        btn_sign_in = findViewById(R.id.btn_sign_in)
        til_email = findViewById(R.id.til_email)
        et_email = findViewById(R.id.et_email)
        til_password = findViewById(R.id.til_password)
        et_password = findViewById(R.id.et_password)
        til_name = findViewById(R.id.til_name)
        et_name = findViewById(R.id.e_name)
        pigAnimation = findViewById(R.id.animation)

        val btnOpenActivity : Button = findViewById(R.id.btn_sign_in)
        btn_sign_in.setOnClickListener {
            if (allFieldsValid()) {


                val intent = Intent(this, user::class.java)
                this.startActivity(intent)

            }

        }
    }
//    fun sendGet() {
//
//        val userName = "androidtest@moneybox.com"
//        val password = "P455word12"
//        val appId = "3a97b932a9d449c981b595"
//        val contentType = "application/json"
//        val appVersion = "5.10.0"
//        val apiVersion = "3.0.0"
//
//        val url = URL("https://api-test01.moneyboxapp.com/")
//        var reqParam =  URLEncoder.encode(userName, "UTF-8")
//        reqParam += "&" + URLEncoder.encode(password, "UTF-8") + "=" + URLEncoder.encode(appId, "UTF-8") + "=" + URLEncoder.encode(contentType, "UTF-8") + "=" + URLEncoder.encode(appVersion, "UTF-8") + "=" + URLEncoder.encode(apiVersion, "UTF-8")
//
//        with(url.openConnection() as HttpURLConnection) {
//            requestMethod = "GET"  // optional default is GET
//
//            println("Response Code : $apiVersion")
//
//            }
//        }


fun sendGetRequest() {

        val mURL = URL("https://api-test01.moneyboxapp.com/")
        val BearerToken = "TsMWRkbrcu3NGrpf84gi2+pg0iOMVymyKklmkY0oI84="
        val appID = "3a97b932a9d449c981b595"
        val contentType = "application/json"
        val appVersion = "5.10.0"
        val apiVersion = "3.0.0"
        val userName = ""
        val password = ""
        val Idfa = ""
        val defaultRedirect="https://api-test01.moneyboxapp.com/"
    //    var reqParam = URLEncoder.encode("androidtest@moneyboxapp.com", "UTF-8") + "=" + URLEncoder.encode(userName, "UTF-8")
    //    reqParam += "&" + URLEncoder.encode("P455word12", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8")


        with(mURL.openConnection() as HttpURLConnection) {
            // optional default is GET
            requestMethod = "GET"

            println("https://api-test01.moneyboxapp.com/ : $url" + "https://api-test01.moneyboxapp.com/ : $defaultRedirect" + "TsMWRkbrcu3NGrpf84gi2+pg0iOMVymyKklmkY0oI84= : $BearerToken" + "3a97b932a9d449c981b595 : $appID" + "application/json : $contentType" + "5.10.0 : $appVersion" + "3.0.0 : $apiVersion" + "username : $userName" + "password : $password" + "idfa : $Idfa")

        }
}






    private fun allFieldsValid() : Boolean {
        var allValid = false

        if (Pattern.matches(EMAIL_REGEX, et_email.text.toString())) {
            allValid = true
        } else {
            til_email.error = getString(R.string.email_address_error)
        }

        if (Pattern.matches(PASSWORD_REGEX, et_password.text.toString())) {
            allValid = true
        } else {
            til_password.error = getString(R.string.password_error)
        }

        if (Pattern.matches(NAME_REGEX, et_name.text.toString())) {
            allValid = true
        }
//         else {
//            til_name.error = getString(R.string.name)
//        }
//        if (Pattern.matches(NAME_REGEX, name.text.toString())) {
//            name.setText("Hello " + e_name.getText().toString() + "!")

//
//        }

        return allValid
    }


    private fun setupAnimation() {
        pigAnimation.playAnimation()
    }

    companion object {
        val EMAIL_REGEX = "[^@]+@[^.]+\\..+"
        val NAME_REGEX = "[a-zA-Z]{6,30}"
        val PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[A-Z]).{10,50}$"
        val firstAnim = 0 to 109
        val secondAnim = 131 to 158
    }


}
