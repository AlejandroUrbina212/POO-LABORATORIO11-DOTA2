package gameUtils

import characters.Heroe
import interfaces.Narrator
import narrators.NeilDeGrasseTysonTheScienceGuy

class Match <T>(val narrador: T, var radiantTeam: Team?, var direTeam: Team?,
                var deathsByRadiant: Int, var deathsByDire: Int, var whoWon: Int) where T: Narrator {
    //Who won (0 for radiant, 1 for dire)

    fun generateArrayOfHeroes(): ArrayList<Heroe>
    {
        val newArrayListOfHeroes: ArrayList<Heroe> = ArrayList()
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
        val tiny = Heroe("Sven", "agility")
        val vengefulspirit = Heroe("Vengeful Spirit", "agility")
        newArrayListOfHeroes.add(antimage)
        newArrayListOfHeroes.add(axe)
        newArrayListOfHeroes.add(bane)
        newArrayListOfHeroes.add(bloodSeeker)
        newArrayListOfHeroes.add(crystalMaiden)
        newArrayListOfHeroes.add(drowRanger)
        newArrayListOfHeroes.add(earthShaker)
        newArrayListOfHeroes.add(juggernaut)
        newArrayListOfHeroes.add(mirana)
        newArrayListOfHeroes.add(nevermore)
        newArrayListOfHeroes.add(morphling)
        newArrayListOfHeroes.add(phantomLancer)
        newArrayListOfHeroes.add(puck)
        newArrayListOfHeroes.add(pudge)
        newArrayListOfHeroes.add(razor)
        newArrayListOfHeroes.add(sandKing)
        newArrayListOfHeroes.add(stormSpirit)
        newArrayListOfHeroes.add(sven)
        newArrayListOfHeroes.add(tiny)
        newArrayListOfHeroes.add(vengefulspirit)

        return newArrayListOfHeroes
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
        return narrateSomething(narrador,"twoOrMoreKillsOccurred")
    }

    fun fiveKillsOccurred(isRadiant: Boolean) :String{
        if(isRadiant){
            for (i in 0..5){
                this.direTeam!!.heroes.removeAt(0)

            }
            this.deathsByRadiant += 5
        }else {
            for (i in 0..5){
                this.radiantTeam!!.heroes.removeAt(0)
            }
            this.deathsByDire += 5
        }
        return narrateSomething(narrador,"fiveKillsOccurred")
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
            this.deathsByRadiant += 1
            this.whoWon = 0
            return narrateSomething(narrador,"radiantWins")

        }
        this.deathsByDire += 1
        this.whoWon = 1
        return narrateSomething(narrador,"direWins")

    }



    private fun narrateSomething(narrator: Narrator, eventType: String): String{
        return narrator.narrate(eventType)
    }

}