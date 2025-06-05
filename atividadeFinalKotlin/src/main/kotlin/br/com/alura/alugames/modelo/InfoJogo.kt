package br.com.alura.alugames.modelo

// Esta dataclass recebe o json, e pega apenas a chave "info", leva as informacoes de info para dentro de InfoApiShark.
data class InfoJogo(val info: InfoApiShark) {
    override fun toString(): String {
        return info.toString()
    }
}