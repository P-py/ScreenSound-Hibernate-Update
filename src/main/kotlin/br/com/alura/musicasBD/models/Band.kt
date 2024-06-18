package br.com.alura.musicasBD.models

class Band(
    val name: String = "N/A Name",
    val description: String = "N/A Description",
    val id: Int = 0,
) {
    override fun toString(): String {
        return "$name ($id)"
    }
}