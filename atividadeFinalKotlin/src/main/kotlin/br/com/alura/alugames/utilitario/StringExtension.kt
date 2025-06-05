import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter


// Essa função tranforma a String anexada, que tem de ser uma data.
fun String.tranformarEmIdade(): Int {
    val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
    var idade = 0
    val dataNascimento = LocalDate.parse(this, formatter)
    val hoje = LocalDate.now()
    idade = Period.between(dataNascimento, hoje).years
    // "Aqui" pega a data de do dia atual e faz a contagem de anos entre a data atual e a anexada na função e retorna esse valor.
    return idade
}