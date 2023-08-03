package com.example.registerapp.presenter

import android.content.Context
import android.view.View

interface Contract {

    interface view{
        fun getContext():Context
    }

    interface presenter{
        fun login()
        fun register()
    }
}