package br.com.viniciusmazzutti.trabalho.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.viniciusmazzutti.trabalho.R
import br.com.viniciusmazzutti.trabalho.model.Treino

                        //construtor                                                          //herdando as caracteristicas de um recyclerView, passando um adapter que espera um viewholder, que sao basicamente os nossos itens de lista
class AdapterTreino(private  val context: Context, private val treinos: MutableList<Treino>): RecyclerView.Adapter<AdapterTreino.TreinoViewHolder>() {

//MutableList e uma lista que eu posso mudar os dados a hora que eu quiser

    //Esse metodo e usado para criar os itens da lista
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TreinoViewHolder {
        val itemLista = LayoutInflater.from(context).inflate(R.layout.treino_item,parent,false)
        val holder = TreinoViewHolder(itemLista)
        return holder
    }

    // Esse metodo e responsavel por exibir os itens para o usuario
    override fun onBindViewHolder(holder: TreinoViewHolder, position: Int) {
        holder.foto.setImageResource(treinos[position].foto)
        holder.nome.text = treinos[position].nome
        holder.descricao.text = treinos[position].descricao
    }

    // aqui vamos passar qual e o tamanho da nossa lista para o nosso metodo
    //.size significa que eu estou passando o tamanho da minha lista, se a minha lista tiver 20 itens, o meu adapter ja vai saber quantos itens tem
    //pois ele esta recebendo a lista e o tamanho completo dela
    override fun getItemCount(): Int = treinos.size

    //clase interna
    inner class  TreinoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val foto = itemView.findViewById<ImageView>(R.id.fotoTreino)
        val nome = itemView.findViewById<TextView>(R.id.nomeTreino)
        val descricao = itemView.findViewById<TextView>(R.id.descricaoTreino)
    }
}