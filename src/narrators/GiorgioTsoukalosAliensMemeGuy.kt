package narrators

import interfaces.Narrator

class GiorgioTsoukalosAliensMemeGuy: Narrator {
    override var eventType: String = ""


    override fun narrate(eventType: String): String {
        var output: String = ""
        when (eventType) {
            "welcome" -> {
                output = """
                    ¡Bienvenidos Jugadores! ¡Sean Bienvenidos! ¡Soy el tipo de los memes de Aliens (Giorgio Tsoukalos),
                    |(si, el tipo de NatGeo) y seré su narrador! *Grita Aliens en voz de loco*
                    |
                """.trimIndent()
            }
            "gameStart" -> {
                output = """Empieza el juego, Deberán escoger sabiamente... una mala decisión puede llevar a la ruina,
                    |Inicia escogiendo el equipo Radiant! *Grita Aliens en voz de loco*
                    |
                """.trimMargin()
            }
            "killOccurred" -> {
                output = """¡Ha ocurrido una muerte! ¿abducción alienígena? ¿Conspiración gubernamental?
                    |*Grita Aliens en voz de loco*
                    |
                """.trimMargin()
            }
            "twoOrMoreKillsOccurred" -> {
                output = """Estamos hechos de polvo de estrellas, todo nuestro cuerpo consiste en material
                    |que ha estado aquí antes del comienzo de los tiempos. Y A ese polvo hemos de regresar
                    |¡Han ocurrido muertes mútliples!
                    |
                """.trimMargin()
            }
            "fiveKillsOccurred" -> {
                output = """¡Han ocurrido 5 muertes en el campo! ¿abducción alienígena? ¿Conspiración gubernamental?
                    |*Grita Aliens en voz de locura*
                    |
                    """.trimMargin()
            }
            "towerHasFallen" -> {
                output = """Una torre ha caído, su muerte solo será observada por los seres ancestrales
                    |*Grita Aliens en voz de locura*
                    |
                """.trimMargin()
            }
            "direWins" -> {
                output = """El equipo Dire ha prevalecido, ¡Incuestionablemente un digno ganador!
                    *Grita Aliens en voz de locura*

                """.trimMargin()
            }
            "radiantWins" -> {
                output = """El equipo Dire ha prevalecido, ¡Incuestionablemente un digno ganador!
                    |*Grita Aliens en voz de locura*
                    |""".trimMargin()
            }
        }
        return output
    }
}