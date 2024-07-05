package com.example.engway.ui.init

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.engway.R
import com.example.engway.ui.account.AccountActivity
import com.example.engway.ui.account.login.LoginFragment


class InitActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_init)

        // Simulação de atraso para mostrar o splash
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, AccountActivity::class.java))
            finish() // Finaliza a atividade atual
        }, 2000) // 2 segundos de atraso
    }
}