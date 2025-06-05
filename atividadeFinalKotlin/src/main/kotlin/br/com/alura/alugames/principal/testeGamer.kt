package br.com.alura.alugames.principal
import br.com.alura.alugames.modelo.Gamer


// É um teste.

fun main() {
    val gamer1 = Gamer("Celso", "Cel@email.com")
    println(gamer1)

    val gamer2 = Gamer(
        "Brunno",
        "dkp@email.com",
        "19/19/1992",
        "Brunnin")

    println(gamer2)

    gamer1.let {
        it.dataNascimento = "01/09/2000"
        it.usuario = "Celsinho"

    }.also {
        println(gamer1.idInterno)
    }

    println(gamer1)
    gamer1.usuario = "Celso"
    println(gamer1)
}