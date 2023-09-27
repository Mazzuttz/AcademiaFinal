package br.com.viniciusmazzutti.trabalho

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.viniciusmazzutti.trabalho.Adapter.AdapterTreino
import br.com.viniciusmazzutti.trabalho.model.Treino

class TelaPrincipal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_principal)
        
        val recyclerView_treinos = findViewById<RecyclerView>(R.id.recycleView_treinos)
        recyclerView_treinos.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false)
        recyclerView_treinos.setHasFixedSize(true) //este metodo dará mais desempenho para a nossa lista de treinos


        //configurar o adapter
        // criaçao de uma lista
        val listaTreinos: MutableList<Treino> = mutableListOf()
        //variavel recebendo a classe adapter de produto
        val adapterTreino = AdapterTreino(this,listaTreinos) // variavel recebendo o adapter configurado com o contexto e a lista de profutos
        recyclerView_treinos.adapter = adapterTreino

        val treino1 = Treino(
            R.drawable.crucifixo,
            "Crucifixo",
            "Deite-se no banco reto com os pés apoiados no chão ou no banco, Erga os pesos acima do peitoral, com uma palma da mão virada para a outra, Abra os braços em um movimento contínuo, sem mudar o ângulo dos cotovelos, até os antebraços chegarem na altura dos ombros."
        )
        listaTreinos.add(treino1)

        val treino2 = Treino(
            R.drawable.agaxamento,
            "Agachamento",
            "Alinhe os pés com o quadril, imagine que você está se sentando em uma cadeira: dobre os joelhos, empine levemente o bumbum e faça o movimento de descida"
        )
        listaTreinos.add(treino2)

        val treino3 = Treino(
            R.drawable.lagpres,
            "Lag Press",
            "Deite no aparelho, mantenha a coluna apoiada no encosto, mantendo a curvatura fisiológica da coluna preservada, Apoie os pés na plataforma e mantenha-os alinhados com os joelhos e quadril,E destrave o aparelho, flexionando os joelhos"
        )
        listaTreinos.add(treino3)

        val treino4 = Treino(
            R.drawable.smith,
            "Smith",
            "Deixa a barra da maquina na altura dos ombros. Em seguida, trave a barra novamente e adicione a carga desejada, Segure a barra com as palmas das mãos para a frente Afaste, os pés na mesma largura dos ombros e deixe os calcanhares firmes no chão."
        )
        listaTreinos.add(treino4)

        val treino5 = Treino(
            R.drawable.supino_incli,
            "Supino Inclinado",
            "O movimento inicial acontece em cima com o peso distante do tronco as escápulas devem estar unidas, o abdômen contraído, apoiando no banco o quadril, A pegada deve ser ligeiramente superior à largura dos ombros, desça com o peso, até que a barra aproxime-se do peito"
        )
        listaTreinos.add(treino5)

        val treino6 = Treino(
            R.drawable.supino_reto,
            "Supino Reto",
            "As escapulas devem estar em neutro e proximas uma da outra, retire a barra e aproxime ela proxima do peito até chegar em um angulo um pouco mais de 90° de cotovelo e leve o peso para cima novamente"
        )
        listaTreinos.add(treino6)
    }
}