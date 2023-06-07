package com.example.sustentacao

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase


class MainActivity {

    private lateinit var binding :ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding - ActivityMainBiding.inflate(layoutInflater)
        setContentView(binding.root)
        setContentView(R.layout.activity_main)

        val edNome = binding.edUsuario
        val btLogin = binding.btLogin

        btLogin.setOnClickListener{
            if(ed.nome.text.toString()=="Admin"){
                val inten = Intent(this, TelaADM::javaClass)
                startActivity(inten)
            }
            else{
                val inten = inten(this,TelaClient::javaClass)
            }
        }
        setContentView(R.layout.activity_main)
    }
}
