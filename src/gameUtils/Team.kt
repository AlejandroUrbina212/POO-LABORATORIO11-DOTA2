package gameUtils

import characters.Ancient
import characters.Heroe
import characters.Tower

class Team(var heroes: ArrayList<Heroe>) {
    val ancient: Ancient = Ancient()
    val towers: ArrayList<Tower> = ArrayList()

    init {
        val tower = Tower()
        for (i in 1..6){
            towers.add(tower)
        }
    }

}