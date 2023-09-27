package br.com.viniciusmazzutti.trabalho

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import br.com.viniciusmazzutti.trabalho.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.statusBarColor = Color.parseColor("#FFFFFF")

        binding.btEntrar.setOnClickListener {

            val email = binding.editEmail.text.toString()
            val senha = binding.editSenha.text.toString()

            when{
                email.isEmpty() ->{
                    binding.editEmail.error = "Preencha o E-mail!"
                }
                senha.isEmpty() ->{
                    binding.editSenha.error = "Preencha a Senha"
                }
                !email.contains("@gmail.com.br") ->{
                    val snackbar = Snackbar.make(it,"E-mail inválido!", Snackbar.LENGTH_SHORT)
                    snackbar.show()
                }
                senha.length <= 5 ->{
                    val snackbar = Snackbar.make(it,"A senha precisa ter pelo menos 6 caracteres!", Snackbar.LENGTH_SHORT)
                    snackbar.show()
                }
                else -> {
                    //aqui vamos fazer o login de usuário
                    login(it)

                }
            }
        }
    }
    private fun login(view: View){
        binding.btEntrar.isEnabled = false
        binding.btEntrar.setTextColor(resources.getColor(R.color.white))
        Handler(Looper.getMainLooper()).postDelayed({
            navegarTelaPrincipal()
            val snackbar = Snackbar.make(view,"Login feito!", Snackbar.LENGTH_SHORT)
            snackbar.show()
        },500)
    }

    private fun navegarTelaPrincipal(){
        val intent = Intent(this@MainActivity, Home::class.java)
        startActivity(intent)
        //finish()
    }
}
