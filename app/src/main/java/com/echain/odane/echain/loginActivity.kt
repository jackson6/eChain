package com.echain.odane.echain

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.echain.odane.echain.Models.User
import com.echain.odane.echain.Services.Auth.AuthProvider
import com.facebook.*
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_login.*
import java.util.*

class loginActivity : AppCompatActivity() {

    private val callbackManager = CallbackManager.Factory.create()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        FacebookSdk.sdkInitialize(applicationContext)

        faceBookInitialize()

        facebook_login.setOnClickListener {
            LoginManager.getInstance().logInWithReadPermissions(this@loginActivity, Arrays.asList("email", "user_photos", "public_profile"))
        }
    }

    fun mainView(){
        val mainIntent = Intent(this, MainActivity::class.java)
        mainIntent.putExtra("LOGGED_IN", true)
        startActivity(mainIntent)
    }

    fun faceBookInitialize() {
        LoginManager.getInstance().registerCallback(callbackManager!!, object : FacebookCallback<LoginResult> {
            override fun onSuccess(result: LoginResult) {
                val accessToken = AccessToken.getCurrentAccessToken()
                val request = GraphRequest.newMeRequest(accessToken) { `object`, response ->

                    var SfacebookID = ""
                    var Sname = ""
                    var Semail = ""
                    var Sgender = ""
                    var Surl = ""
                    val Sphone = ""

                    try {

                        if (`object`.has("id")) {
                            SfacebookID = `object`.getString("id")
                        }

                        if (`object`.has("name")) {
                            Sname = `object`.getString("name")
                        }

                        if (`object`.has("email")) {
                            Semail = `object`.getString("email")
                        }

                        if (`object`.has("gender")) {
                            Sgender = `object`.getString("gender")
                        }

                        if (`object`.has("picture")) {
                            Surl = `object`.getJSONObject("picture").getJSONObject("data").getString("url")
                        }


                    } catch (e: Exception) {
                        e.printStackTrace()
                    }

                    var user = User(SfacebookID, Sname.split(" ")[0], Sname.split(" ")[1], "facebook", Sphone, Surl)
                    val auth = AuthProvider.provideAuthServices()
                    auth.registerUsers(user)
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribeOn(Schedulers.io())
                            .subscribe ({
                                result ->
                                when(result.isRegisterd){
                                   true -> mainView()
                                    else -> mainView()
                                }
                                Log.d("Result", "User ${result.status} registered")
                            }, { error ->
                                error.printStackTrace()
                            })


                }
                val parameters = Bundle()
                parameters.putString("fields", "id,name,link,email,picture,gender, birthday")
                request.parameters = parameters
                request.executeAsync()

            }

            override fun onCancel() {
                println("=========================onCancel")
                Toast.makeText(this@loginActivity, "Cancel", Toast.LENGTH_LONG).show()
            }

            override fun onError(error: FacebookException) {
                println("=========================onError" + error.toString())
                Toast.makeText(this@loginActivity, "onError", Toast.LENGTH_LONG).show()
            }
        })
    }

    override fun onActivityResult(requestCode: Int, responseCode: Int, intent: Intent) {
        callbackManager!!.onActivityResult(requestCode, responseCode, intent)
    }
}
