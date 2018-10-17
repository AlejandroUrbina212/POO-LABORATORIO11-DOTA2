package narrators

import interfaces.Narrator

class NeilDeGrasseTysonTheScienceGuy : Narrator {
    override var eventType: String = ""


    override fun narrate(eventType: String): String {
        var output: String = ""
        when (eventType) {
            "welcome" -> {
                output = """¡Y en el principio fue el big bang, todos los sucesos a partir de ese instante,
                |nos han traído hasta acá. ¡Bienvenidos Jugadores! ¡Sean Bienvenidos!
                |¡Soy Neil deGrasse Tyson, (si, el tipo de NatGeo) y seré su narrador!
                |Deberán escoger sabiamente... una mala decisión puede llevar a la ruina,
                |Inicia escogiendo el equipo Radiant!
                |Lista de Héroes:
                |
                """.trimMargin()
            }
            "gameStart" -> {
                output = "¡Empieza el juego!"
            }
            "killOccurred" -> {
                output = "¡Ha ocurrido una muerte! Ha ha ha, la materia regresa a su origen en el universo \n"
            }
            "twoOrMoreKillsOccurred" -> {
                output = "¡Vaya vaya, alguien está cenando oponentes, ¡Han ocurrido muertes mútliples! \n"
            }
            "fiveKillsOccurred" -> {
                    output = """Como dato curioso, el sol tiene una vida restante estimada de 5,000 millones de años
                        |¡Increíble, 5, igual que las muertes que acaban de ocurrir HA HA HA!
                        |
                    """.trimMargin()
            }
            "towerHasFallen" -> {
                output = "Una torre ha caído, tal como nostradamus lo predijo, su muerte solo será observada por las estrellas \n"
            }
            "direWins" -> {
                output = """el equipo Dire ha prevalecido igual la energía a lo largo de la historia del universo, indestructible,
                    |incuestionablemente un digno ganador.
                    |
                """.trimMargin()
            }
            "radiantWins" -> {
                output = """el equipo Radiant ha prevalecido igual la energía a lo largo de la historia del universo, indestructible,
                    |incuestionablemente un digno ganador.
                    |
                """.trimMargin()
            }
        }
        return output
    }
}