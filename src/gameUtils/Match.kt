package gameUtils

import characters.Heroe
import characters.Tower
import interfaces.Narrator
import narrators.NeilDeGrasseTysonTheScienceGuy

class Match <T>(val narrador: T, var radiantTeam: Team?, var direTeam: Team?,
                var deathsByRadiant: Int, var deathsByDire: Int, var whoWon: Int) where T: Narrator {
    //Who won (0 for radiant, 1 for dire)

    fun generateArrayOfHeroes(): ArrayList<Heroe>
    {
        val antimage = Heroe("Antimage", "strenght")
        val axe = Heroe("Axe", "strength")
        val bane = Heroe("Bane", "strength")
        val bloodSeeker = Heroe("BloodSeeker", "strength")
        val crystalMaiden = Heroe("Crystal Maiden", "strength")
        val drowRanger = Heroe("Drow Ranger", "strength")
        val earthShaker = Heroe("Earth Shaker", "strength")
        val juggernaut = Heroe("juggernaut", "strength")
        // all the Heroes of Intelligence type
        val mirana = Heroe("Mirana", "intelligence")
        val nevermore = Heroe("Shadow Friend", "intelligence")
        val morphling = Heroe("Morphling", "intelligence")
        val phantomLancer = Heroe("Phantom Lancer", "intelligence")
        val puck = Heroe("Puck", "intelligence")
        val pudge = Heroe("Pudge", "intelligence")
        val razor = Heroe("Razor", "intelligence")
        //all the heroes of agility
        val sandKing = Heroe("Sand King", "agility")
        val stormSpirit = Heroe("Storm Spirit", "agility")
        val sven = Heroe("Sven", "agility")
        val tiny = Heroe("Tiny", "agility")
        val vengefulspirit = Heroe("Vengeful Spirit", "agility")
        val array = arrayListOf<Heroe>(
                antimage, axe, bane, bloodSeeker, crystalMaiden, drowRanger,earthShaker,
                juggernaut, mirana, nevermore, morphling, phantomLancer, puck, pudge,
                razor, sandKing, stormSpirit, sven, tiny, vengefulspirit
        )

        return array
    }
    fun welcome(): String{
        return narrateSomething(narrador, "welcome")
    }
    fun gameStart(): String{
        return narrateSomething(narrador,"gameStart")
    }
    fun killOccurred(isRadiant: Boolean): String{
        if (isRadiant){
            this.direTeam!!.heroes.removeAt(0)
            this.deathsByRadiant += 1
        } else {
            this.radiantTeam!!.heroes.removeAt(0)
            this.deathsByDire += 1
        }
        return narrateSomething(narrador, "killOccurred")
    }
    fun multipleKillsOccurred(isRadiant: Boolean, numberOfKills:Int): String{
        if(isRadiant){
            for (i in 0..(numberOfKills-1)){
                this.direTeam!!.heroes.removeAt(0)
            }
            this.deathsByRadiant += numberOfKills
        }else {
            for (i in 0..(numberOfKills-1)){
                this.radiantTeam!!.heroes.removeAt(0)
            }
            this.deathsByDire += numberOfKills
        }
        if (numberOfKills == 5){
            return narrateSomething(narrador,"fiveKillsOccurred")
        }
        return narrateSomething(narrador,"twoOrMoreKillsOccurred")
    }
    fun towerKilled(isRadiant: Boolean): String{
        if (isRadiant){
            this.direTeam!!.towers.removeAt(0)
            this.deathsByRadiant += 1
        } else {
            this.radiantTeam!!.towers.removeAt(0)
            this.deathsByDire += 1
        }
        return narrateSomething(narrador,"towerHasFallen")
    }
    fun ancientKilled(isRadiant: Boolean): String{
        if (isRadiant){
            this.direTeam!!.ancient.isDead = true
            this.deathsByRadiant += 1
            this.whoWon = 0
            return narrateSomething(narrador,"radiantWins")
        }
        this.radiantTeam!!.ancient.isDead = true
        this.deathsByDire += 1
        this.whoWon = 1
        return narrateSomething(narrador,"direWins")

    }
    private fun narrateSomething(narrator: Narrator, eventType: String): String{
        return narrator.narrate(eventType)
    }
    fun showMenu(noTowersInOneTeam: Boolean): String {
        return if (noTowersInOneTeam) {
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

}