package br.com.viniciusmazzutti.trabalho

import android.content.Intent
import android.graphics.Color
import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.Toast
import br.com.viniciusmazzutti.trabalho.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        auth = Firebase.auth
        window.statusBarColor = Color.parseColor("#FFFFFF")

        binding?.btEntrar?.setOnClickListener {
            val email: String = binding?.editEmail?.text.toString()
            val senha: String = binding?.editSenha?.text.toString()

            if(email.isNotEmpty() && senha.isNotEmpty()){
                singinUserWithEmailAndPassoword(email, senha)
            }else{
                Toast.makeText(this@MainActivity, "Por favor preencha os campos vazios ", Toast.LENGTH_SHORT).show()
            }
            }
            binding?.TelaCadastro?.setOnClickListener {
            val intent = Intent(this@MainActivity, Cadastro:: class.java)
            startActivity(intent)
        }
    }

    private fun singinUserWithEmailAndPassoword(email: String, senha:String) {
        auth.signInWithEmailAndPassword(email, senha).addOnCompleteListener { task ->
            if (task.isSuccessful){
                Log.d(TAG,"Autenticação feita com sucesso:Siccess")
                navegarTelaPrincipal()
                //val user = auth.currentUser
            }else{
                Log.w(TAG,"LoginFalha:Failure", task.exception)
                Toast.makeText(this@MainActivity, "Erro de autenticação", Toast.LENGTH_SHORT).show()
            }
        }
    }

    companion object{
        private  var TAG = "EmailAndPassword"
    }

    private fun navegarTelaPrincipal(){
        val intent = Intent(this@MainActivity, Home::class.java)
        startActivity(intent)
        finish()
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}
