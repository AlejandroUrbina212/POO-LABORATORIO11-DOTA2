import characters.Heroe
import gameUtils.Match
import gameUtils.Team
import interfaces.Narrator
import narrators.GiorgioTsoukalosAliensMemeGuy
import narrators.NeilDeGrasseTysonTheScienceGuy

fun showMenu(noTowersInOneTeam: Boolean): String{
    return if (noTowersInOneTeam){
        """
        Menú:
        1. Ocurrieron muertes
        2. Matan torres
        3. Matan ancient

    """.trimIndent()
    } else {
        """
        Menú:
        1. Ocurrieron muertes
        2. Matan torres

    """.trimIndent()
    }
}

fun main (args: Array<String>) {
    val neilDeGrasseTysonTheScienceGuy = NeilDeGrasseTysonTheScienceGuy()
    val newMatch = Match<Narrator>(neilDeGrasseTysonTheScienceGuy, null, null, 0,0,2)
    val availableHeroes: ArrayList<Heroe> = newMatch.generateArrayOfHeroes()
    print(newMatch.welcome())
    println("--------------------------------------------------")

    //Aquí se crean los arrays de heroes para después asignarlos a cada equipo

    val radiantTeamHeroes: ArrayList<Heroe> = ArrayList()
    val direTeamHeroes: ArrayList<Heroe> = ArrayList()

    var radiantSelects = false
    do {
        radiantSelects = !radiantSelects
        availableHeroes.forEachIndexed{index, heroe -> println("${index+1}. ${heroe.name}, Tipo: ${heroe.type}")}
        print("Selecciona un héroe de la lista \n")
        if (radiantSelects){
            println("Selección de héroes Radiant \n ------------------------")
        } else {
            println("Selección de héroes Dire \n ---------------------------")}
        val heroeSelectedIndex = readLine()!!.toInt()
        if (radiantSelects){
            radiantTeamHeroes.add(availableHeroes[heroeSelectedIndex-1])
            availableHeroes.removeAt(heroeSelectedIndex-1)
        } else {
            direTeamHeroes.add(availableHeroes[heroeSelectedIndex-1])
            availableHeroes.removeAt(heroeSelectedIndex-1)
        }

    } while (availableHeroes.size != 10)
    //se crean los arrays de héroes, con un anciano incluido
    val radiantTeam = Team(radiantTeamHeroes)
    val direTeam = Team(direTeamHeroes)

    //se asignan los equipos al partido actual
    newMatch.radiantTeam = radiantTeam
    newMatch.direTeam = direTeam

    var noTowersInOneTeam = false
    do {
        print(showMenu(noTowersInOneTeam))
        val menuSelection = readLine()!!.toInt()
        when(menuSelection) {
            1->{
                println("¿Fue Radiant quien mató? si/no")
                val radiantKilled = readLine().toString()
                when (radiantKilled){
                    "si" -> {
                        println("¿Cuántas Muertes? (0-5)")
                        val numberOfKills = readLine()!!.toInt()
                        if (numberOfKills == 1){
                            print(newMatch.killOccurred(true))
                        } else if (numberOfKills in 2..4) {
                            print(newMatch.multipleKillsOccurred(true,numberOfKills))
                        } else if (numberOfKills == 5){
                            print(newMatch.fiveKillsOccurred(true))
                        }
                    }
                    "no" -> {
                        println("¿Cuántas Muertes? (0-5)")
                        val numberOfKills = readLine()!!.toInt()
                        if (numberOfKills in 1..5 && numberOfKills == 1){
                            print(newMatch.killOccurred(false))
                        } else if (numberOfKills in 2..6) {
                            print(newMatch.multipleKillsOccurred(false,numberOfKills))
                        } else if (numberOfKills == 5){
                            print(newMatch.fiveKillsOccurred(false))
                        }
                    }
                }

            }
            2 -> {
                println("¿Fue Radiant quien mató? si/no")
                val radiantKilled = readLine().toString()
                when (radiantKilled){
                    "si" -> {
                        print(newMatch.towerKilled(true))
                    }
                    "no" -> {
                        print(newMatch.towerKilled(false))
                    }
                }
                if (newMatch.radiantTeam!!.towers.size == 0 || newMatch.direTeam!!.towers.size == 0){
                    noTowersInOneTeam = true
                }
            }
            3 -> {
                println("¿Fue Radiant quien mató? si/no")
                val radiantKilled = readLine().toString()
                when(radiantKilled){
                    "si" -> {print(newMatch.ancientKilled(true))}
                    "no" -> {print(newMatch.ancientKilled(false))}
                }
            }
        }
    } while (newMatch.whoWon == 2)
}


