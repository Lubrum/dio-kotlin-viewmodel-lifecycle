package com.digital.vmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    private lateinit var txtContador: EditText
    private lateinit var btnDados: Button
    private lateinit var btnMostrar: Button

    private lateinit var mViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initDados()
        initClick()
    }

    private fun initDados() {
        mViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        txtContador = findViewById(R.id.txtContador)
        btnDados = findViewById(R.id.btnDados)
        btnMostrar = findViewById(R.id.btnMostrar)

        mViewModel.mContador.observe(this) { valor ->
            txtContador.setText(valor)
        }
    }

    private fun initClick() {
        btnDados.setOnClickListener {
            mViewModel.Contador()
        }

        btnMostrar.setOnClickListener {
            Toast.makeText(applicationContext, "Valor Contador: ${mViewModel.mContador.value}", Toast.LENGTH_SHORT).show()
        }
    }
}