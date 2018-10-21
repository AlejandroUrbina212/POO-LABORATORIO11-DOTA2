import characters.Heroe
import gameUtils.Match
import gameUtils.Team
import interfaces.Narrator
import narrators.GiorgioTsoukalosAliensMemeGuy
import narrators.NeilDeGrasseTysonTheScienceGuy
fun main(args: Array<String>) {
    val neilDeGrasseTysonTheScienceGuy = NeilDeGrasseTysonTheScienceGuy()
    val newMatch = Match<Narrator>(neilDeGrasseTysonTheScienceGuy, null, null, 0, 0, 2)
    val availableHeroes: ArrayList<Heroe> = newMatch.generateArrayOfHeroes()
    print(newMatch.welcome())
    //Aquí se crean los arrays de heroes para después asignarlos a cada equipo

    val radiantTeamHeroes: ArrayList<Heroe> = ArrayList()
    val direTeamHeroes: ArrayList<Heroe> = ArrayList()

    var radiantSelects = false
    do {
        radiantSelects = !radiantSelects
        availableHeroes.forEachIndexed { index, heroe -> println("${index + 1}. ${heroe.name}, Tipo: ${heroe.type}") }
        print("Selecciona un héroe de la lista \n")
        if (radiantSelects) {
            println("Selección de héroes Radiant \n ------------------------")
        } else {
            println("Selección de héroes Dire \n ---------------------------")
        }
        val heroeSelectedIndex = readLine()!!.toInt()
        if (radiantSelects) {
            radiantTeamHeroes.add(availableHeroes[heroeSelectedIndex - 1])
            availableHeroes.removeAt(heroeSelectedIndex - 1)
        } else {
            direTeamHeroes.add(availableHeroes[heroeSelectedIndex - 1])
            availableHeroes.removeAt(heroeSelectedIndex - 1)
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
        print(newMatch.showMenu(noTowersInOneTeam))
        val menuSelection = readLine()!!.toInt()
        when (menuSelection) {
            1 -> {
                println("¿Fue Radiant quien mató? si/no")
                val radiantKilled = readLine().toString()
                when (radiantKilled) {
                    "si" -> {
                        println("¿Cuántas Muertes? (0-5)")
                        val numberOfKills = readLine()!!.toInt()
                        when (numberOfKills) {
                            1 -> print(newMatch.killOccurred(true))
                            in 2..4 -> print(newMatch.multipleKillsOccurred(true, numberOfKills))
                            5 -> print(newMatch.multipleKillsOccurred(true, 5))
                        }
                    }
                    "no" -> {
                        println("¿Cuántas Muertes? (0-5)")
                        val numberOfKills = readLine()!!.toInt()
                        if (numberOfKills in 1..5 && numberOfKills == 1) {
                            print(newMatch.killOccurred(false))
                        } else if (numberOfKills in 2..4) {
                            print(newMatch.multipleKillsOccurred(false, numberOfKills))
                        } else if (numberOfKills == 5) {
                            print(newMatch.multipleKillsOccurred(false, 5))
                        }
                    }
                }
            }
            2 -> {
                println("¿Fue Radiant quien mató? si/no")
                val radiantKilled = readLine().toString()
                when (radiantKilled) {
                    "si" -> {
                        if (!newMatch.direTeam!!.towers.isEmpty()) {
                            print(newMatch.towerKilled(true))
                        } else {
                            println("Todas las torres de este equipo están muertas!")
                        }

                    }
                    "no" -> {
                        if (!newMatch.radiantTeam!!.towers.isEmpty()) {
                            print(newMatch.towerKilled(false))
                        } else {
                            println("Todas las torres de este equipo están muertas!")
                        }
                    }
                }
                if (newMatch.radiantTeam!!.towers.size == 0 || newMatch.direTeam!!.towers.size == 0) {
                    noTowersInOneTeam = true
                }
            }
            3 -> {
                println("¿Fue Radiant quien mató? si/no")
                val radiantKilled = readLine().toString()
                when (radiantKilled) {

                    "si" -> {
                        if (newMatch.direTeam!!.towers.isEmpty()) {
                            print(newMatch.ancientKilled(true))
                        } else {print("Aún quedan torres de pie en este equipo!")}
                    }
                    "no" -> {
                        if (newMatch.radiantTeam!!.towers.isEmpty()) {
                            print(newMatch.ancientKilled(false))
                        } else {print("Aún quedan torres de pie en este equipo! \n")}
                    }
                }
            }
        }
    } while (newMatch.whoWon == 2)
}


