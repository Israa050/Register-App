package com.example.registerapp.presenter

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import com.example.registerapp.R
import com.example.registerapp.model.DatabaseHelper
import com.example.registerapp.model.User
import com.example.registerapp.ui.LoginActivity
import com.example.registerapp.ui.MainActivity


class Presenter(val view: Contract.view): Contract.presenter {

    private val context = view.getContext()
    lateinit var btnlogin : Button
    lateinit var btnRegister : Button
    lateinit var txtUsername : TextView
    lateinit var txtPassword : TextView

    private val databaseHelper = DatabaseHelper(context)

    fun viewHolder(view: LoginActivity) {
         btnlogin = view.findViewById(R.id.btnLogin)
         btnRegister = view.findViewById(R.id.btnRegister)
         txtUsername = view.findViewById(R.id.txtUsername)
         txtPassword = view.findViewById(R.id.txtPassword)
    }

     override fun login() {
         btnlogin.setOnClickListener {
             if (databaseHelper.checkUser(
                     txtUsername.text.toString().trim(),
                     txtPassword.text.toString().trim()
                 )
             ) {
                 val name = txtUsername.text.toString()
                 val bundle = Bundle()
                 val intent = Intent(context, MainActivity::class.java).apply {
                     putExtra("NAME", name)
                     startActivity(context, this, Bundle())
                 }
                 Toast.makeText(context, "Login successfully", Toast.LENGTH_SHORT).show()
             } else {
                 Toast.makeText(
                     context,
                     "Username or password is wrong, please try again",
                     Toast.LENGTH_SHORT
                 ).show()
             }
         }
     }

    override fun register() {
        btnRegister.setOnClickListener {
            if (txtUsername.text.isNotEmpty() && txtPassword.text.isNotEmpty()) {
                if (!databaseHelper.checkUser(txtUsername.text.toString().trim())) {
                    val username = txtUsername.text.toString().trim()
                    val password = txtPassword.text.toString().trim()
                    val user = User(username, password)
                    databaseHelper.addUser(user)
                    Toast.makeText(context, "User created successfully", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(context, "User is already exists", Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(context,"Error, username or password field is empty",Toast.LENGTH_SHORT).show()
            }
        }
        }

}