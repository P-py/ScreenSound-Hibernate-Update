package br.com.alura.musicasBD.models

class Album(
    val title: String = "N/A Title",
    val band: Band = Band(),
    val id: Int = 0
) {
    override fun toString():String {
        return "$title ($id) - $band"
    }
}