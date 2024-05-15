package com.example.interveiwtask


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Login : AppCompatActivity() {

    private lateinit var editTextUsername: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var buttonLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        editTextUsername = findViewById(R.id.editTextUsername)
        editTextPassword = findViewById(R.id.editTextPassword)
        buttonLogin = findViewById(R.id.buttonLogin)

        // Check if the user is already logged in
        if (isUserLoggedIn()) {
            navigateToHomeScreen()
            return // Exit onCreate since the user is already logged in
        }

        buttonLogin.setOnClickListener {
            val username = editTextUsername.text.toString()
            val password = editTextPassword.text.toString()
            // Make a network request to the login API endpoint
            login(username, password)
        }
    }



    private fun login(username: String, password: String) {
        val loginRequest = LoginRequest(username, password)
        // Make a network request using Retrofit
        val call = ApiClient.apiService.login(loginRequest)

        call.enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                if (response.isSuccessful) {
                    val token = response.body()?.token
                    saveUserLoginState(token)
                    // Login successful, handle token
                    Toast.makeText(this@Login, "Login successful. Token: $token", Toast.LENGTH_SHORT).show()
                    navigateToHomeScreen()
                } else {
                    // Login failed, handle error
                    Toast.makeText(this@Login, "Login failed. Please try again.", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                // Network request failed, handle error
                Toast.makeText(this@Login, "Network error. Please try again later.", Toast.LENGTH_SHORT).show()
            }
        })
    }

        private fun isUserLoggedIn(): Boolean {
            val sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
            return sharedPreferences.getBoolean("isLoggedIn", false)
        }



    private fun navigateToHomeScreen() {
        val intent =Intent(this@Login,MainActivity::class.java)
        startActivity(intent)
        finish()
    }
     private
      fun saveUserLoginState(token:String?){
         val sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
         val editor = sharedPreferences.edit()
         editor.putString("token", token)
         editor.putBoolean("isLoggedIn", true)
         editor.apply()

    }

}