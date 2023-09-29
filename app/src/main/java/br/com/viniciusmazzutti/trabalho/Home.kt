package br.com.viniciusmazzutti.trabalho

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setSupportActionBar(findViewById(R.id.my_toolbar))
    }
    //trazendo o 'main_menu" para a nossa tela inicial
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }

    //função para quando o usuario selecionar o menu1, ele vai navegar para a Lista de exercicios
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu1 -> {
                navegarTelaPrincipal()
                true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }

    private var doubleBack = false
    // função para garantir que o usuario presione voltar duas vezes para sair do app
    override fun onBackPressed() {

        if(doubleBack) {
            super.onBackPressed()
        }
        this.doubleBack = true
        Toast.makeText(this, "Pressione 2 vezes para sair.", Toast.LENGTH_SHORT).show()
        Handler(Looper.getMainLooper()).postDelayed(Runnable { doubleBack = false }, 1000)
    }

    //navegaçao para a tela Home
    private fun navegarTelaPrincipal(){
        val intent = Intent(this@Home,TelaPrincipal::class.java)
        startActivity(intent)
        //finish()
    }


}