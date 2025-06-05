package br.com.alura.alugames.modelo

// Essa data class, recebe como parametros obrigatorios um titulo e capa, e depois pode ser adicionado uma desc. Depois retorna tudo isso como uma Strring.
data class Jogo(val titulo:String,
                val capa:String) {
    var descricao: String? = null
    override fun toString(): String {
        return "Meu Jogo: \n" +
                "Título: $titulo \n" +
                "Capa: $capa \n" +
                "Descricao: $descricao"

    }


}