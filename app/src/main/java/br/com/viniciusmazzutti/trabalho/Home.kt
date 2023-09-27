package br.com.viniciusmazzutti.trabalho

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem

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
    private fun navegarTelaPrincipal(){
        val intent = Intent(this@Home,TelaPrincipal::class.java)
        startActivity(intent)
        //finish()
    }
}