package com.example.registerapp.ui

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.registerapp.databinding.ActivityLoginBinding
import com.example.registerapp.presenter.Contract
import com.example.registerapp.presenter.Presenter

class LoginActivity : AppCompatActivity(), Contract.view {
    lateinit var binding: ActivityLoginBinding
    lateinit var presenter: Presenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter = Presenter(this)
        presenter.viewHolder(this)
          presenter.login()
          presenter.register()

        supportActionBar?.hide()

    }

    override fun getContext():Context{
        return this
    }


}