package br.com.alura.alugames.principal

import br.com.alura.alugames.modelo.Gamer
import br.com.alura.alugames.modelo.Jogo
import br.com.alura.alugames.servicos.ConsumoApi
import java.util.Scanner
import tranformarEmIdade


fun main() {
    val leitura = Scanner(System.`in`)
    val gamer = Gamer.criarGamer(leitura) // Cria um usuário.
    println("Cadastro concluído com sucesso. Dados do gamer:")
    println(gamer)
    println("Idade do gamer: " + gamer.dataNascimento?.tranformarEmIdade())

    do {
        println("Digite um código de jogo para buscar:")
        val busca = leitura.nextLine()

        val buscaApi = ConsumoApi()
        val informacaoJogo = buscaApi.buscaJogo(busca) // Pega a informacao do jogo com base no ID requisitado.


        var meuJogo: Jogo? = null

        val resultado = runCatching {
            meuJogo = Jogo( // Faz uma variavel que é do tipo Jogo e dá como parametros as informaçoes adquiridas pela busca com o ID na API.
                informacaoJogo.info.title,
                informacaoJogo.info.thumb
            )
        }


        resultado.onFailure {
            println("Jogo inexistente. Tente outro id.")
        }

        resultado.onSuccess {
            println("Deseja inserir uma descrição personalizada? S/N")
            val opcao = leitura.nextLine()
            // Adiciona descricao personalizada, caso nao querer, a descrição irá ser o nome do jogo.
            if (opcao.equals("s", true)) {
                println("Insira a descrição personalizado para o jogo:")
                val descricaoPersonalizada = leitura.nextLine()
                meuJogo?.descricao = descricaoPersonalizada
            } else {
                meuJogo?.descricao = meuJogo.titulo

            }

            gamer.jogosBuscados.add(meuJogo) // Adiciona no "historico" o jogo que é uma lista do tipo  Jogo
        }

        println("Deseja buscar um novo jogo? S/N")
        val resposta = leitura.nextLine()

    } while (resposta.equals("s", true)) // Pode buscar o quanto querer até a variavel resposta ser "n"

    println("Jogos buscados:")
    println(gamer.jogosBuscados)

    // filtra os jogos.
    println("\n Jogos ordenados por título: ")
    gamer.jogosBuscados.sortBy {
        it?.titulo
    } // filtra por ordem

    gamer.jogosBuscados.forEach {
        println("Título: " + it?.titulo)
    } // printa todos os titulos dos jogos buscados

    val jogosFiltrados = gamer.jogosBuscados.filter {
        it?.titulo?.contains("batman", true) ?: false
    }
    println("\n Jogos filtrados: ")
    println(jogosFiltrados)

    // Deleta o jogo, com o index como parametro.
    println("Deseja excluir algum jogo da lista original? S/N")
    val opcao = leitura.nextLine()
    if (opcao.equals("s", true)) {
        println(gamer.jogosBuscados)
        println("\nInforme a posição do jogo que deseja excluir: ")
        val posicao =leitura.nextInt()
        gamer.jogosBuscados.removeAt(posicao)
    }

    println("\n Lista atualizada:")
    println(gamer.jogosBuscados)

    println("Busca finalizada com sucesso.")

}