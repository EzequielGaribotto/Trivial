package com.example.trivial.model

import androidx.compose.ui.graphics.Color
import com.example.trivial.R

class Preguntas(
    var enunciados: MutableList<String> = mutableListOf(),
    var respuestas: MutableList<Array<String>> = mutableListOf(),
    var colorRespuesta: MutableList<Array<Color>> = mutableListOf(),
    var respuestaCorrecta: MutableList<String> = mutableListOf(),
    var puntos: MutableList<Int> = mutableListOf(),
    var image: MutableList<Int> = mutableListOf()
) {

    init {
        addQuestion(
            "What is the capital of France?",
            arrayOf("Paris", "London", "Berlin", "Madrid"),
            5,
            R.drawable.logo,
            "Paris"
        )
        addQuestion(
            "What is the largest planet in our solar system?",
            arrayOf("Jupiter", "Mars", "Earth", "Venus"),
            3,
            R.drawable.logo,
            "Jupiter"
        )
        addQuestion(
            "Who painted the Mona Lisa?",
            arrayOf("Leonardo da Vinci", "Vincent van Gogh", "Michelangelo", "Rembrandt"),
            4,
            R.drawable.logo,
            "Leonardo da Vinci"
        )
        addQuestion(
            "¿En qué año se descubrió la penicilina?",
            arrayOf("1928", "1945", "1905", "1889"),
            4,
            R.drawable.logo,
            "1928"
        )
        addQuestion(
            "¿En qué año se produjo la caída del Muro de Berlín?",
            arrayOf("1989", "1990", "1991", "1992"),
            4,
            R.drawable.logo,
            "1989"
        )
        addQuestion(
            "¿Cuál es la capital de Australia?",
            arrayOf("Canberra", "Sídney", "Melbourne", "Perth"),
            4,
            R.drawable.logo,
            "Canberra"
        )
        addQuestion(
            "¿Quién escribió la novela 'Don Quijote de la Mancha'?", arrayOf(
                "Miguel de Cervantes",
                "William Shakespeare",
                "Dante Alighieri",
                "Johann Wolfgang von Goethe"
            ), 4, R.drawable.logo, "Miguel de Cervantes"
        )
        addQuestion(
            "¿Cuál es el río más largo del mundo?",
            arrayOf("Amazonas", "Nilo", "Yangtze", "Mississippi"),
            4,
            R.drawable.logo,
            "Amazonas"
        )
        addQuestion(
            "¿En qué año se descubrió América?",
            arrayOf("1492", "1502", "1512", "1522"),
            4,
            R.drawable.logo,
            "1492"
        )
        addQuestion(
            "¿Cuál es el teorema de Pitágoras?", arrayOf(
                "En un triángulo rectángulo, el cuadrado de la hipotenusa es igual a la suma de los cuadrados de los catetos",
                "En un triángulo rectángulo, el cuadrado de la hipotenusa es igual al producto de los catetos",
                "En un triángulo rectángulo, el cuadrado de un cateto es igual a la suma de los cuadrados de la hipotenusa y el otro cateto",
                "En un triángulo rectángulo, el cuadrado de un cateto es igual al producto de la hipotenusa y el otro cateto"
            ), 4, R.drawable.logo, "En un triángulo rectángulo, el cuadrado de la hipotenusa es igual a la suma de los cuadrados de los catetos"
        )
        addQuestion(
            "¿Quién fue el primer hombre en pisar la Luna?",
            arrayOf(
                "Neil Armstrong", "Buzz Aldrin", "Michael Collins", " Yuri Gagarin"),
            4, R.drawable.logo, "Neil Armstrong"
        )
        addQuestion ("¿Cuál es la montaña más alta del mundo?",
            arrayOf("Monte Everest", "K2", "Kangchenjunga", "Lhotse"),
            4,
            R.drawable.logo,
            "Monte Everest"
        )
        addQuestion(
            "¿Cuál es la moneda de Japón?",
            arrayOf("Yen", "Won", "Dólar", "Euro"),
            5,
            R.drawable.logo,
            "Yen"
        )

        addQuestion(
            "¿Cuál es la capital de Canadá?",
            arrayOf("Ottawa", "Toronto", "Vancouver", "Montreal"),
            4,
            R.drawable.logo,
            "Ottawa"
        )

        addQuestion(
            "¿Quién es conocido como el 'Padre de la Informática'?",
            arrayOf("Alan Turing", "Bill Gates", "Steve Jobs", "Mark Zuckerberg"),
            5,
            R.drawable.logo,
            "Alan Turing"
        )

        addQuestion(
            "¿En qué año se fundó la ONU (Organización de las Naciones Unidas)?",
            arrayOf("1945", "1955", "1935", "1965"),
            4,
            R.drawable.logo,
            "1945"
        )

        addQuestion(
            "¿Cuál es la fórmula química del agua?",
            arrayOf("H2O", "CO2", "O2", "N2"),
            3,
            R.drawable.logo,
            "H2O"
        )

        addQuestion(
            "¿Cuál es la capital de Brasil?",
            arrayOf("Brasilia", "Río de Janeiro", "São Paulo", "Buenos Aires"),
            4,
            R.drawable.logo,
            "Brasilia"
        )
        addQuestion(
            "¿Cuál es el río más largo de América del Sur?",
            arrayOf("Amazonas", "Nilo", "Yangtsé", "Misisipi"),
            5,
            R.drawable.logo,
            "Amazonas"
        )

        addQuestion(
            "¿En qué continente se encuentra el desierto del Sahara?",
            arrayOf("África", "Asia", "América del Norte", "Europa"),
            4,
            R.drawable.logo,
            "África"
        )

        addQuestion(
            "¿Cuál es el país más grande del mundo por área terrestre?",
            arrayOf("Rusia", "China", "Estados Unidos", "Canadá"),
            5,
            R.drawable.logo,
            "Rusia"
        )

        addQuestion(
            "¿Cuál es la cadena montañosa más larga del mundo?",
            arrayOf("Los Andes", "Himalaya", "Montañas Rocosas", "Alpes"),
            4,
            R.drawable.logo,
            "Los Andes"
        )

        addQuestion(
            "¿En qué océano se encuentra la Gran Barrera de Coral?",
            arrayOf("Océano Pacífico", "Océano Atlántico", "Océano Índico", "Océano Ártico"),
            5,
            R.drawable.logo,
            "Océano Pacífico"
        )

        addQuestion(
            "¿Cuál es la capital de Argentina?",
            arrayOf("Buenos Aires", "Santiago", "Lima", "Bogotá"),
            4,
            R.drawable.logo,
            "Buenos Aires"
        )

        addQuestion(
            "¿Cuál es la isla más grande del mundo?",
            arrayOf("Groenlandia", "Australia", "Borneo", "Java"),
            5,
            R.drawable.logo,
            "Groenlandia"
        )

        addQuestion(
            "¿En qué país se encuentra el volcán Kilimanjaro?",
            arrayOf("Tanzania", "Kenia", "Etiopía", "Uganda"),
            4,
            R.drawable.logo,
            "Tanzania"
        )

        addQuestion(
            "¿Cuál es el punto más bajo de la Tierra?",
            arrayOf("Mar Muerto", "Cañón del Colorado", "Fosa de las Marianas", "Lago Baikal"),
            5,
            R.drawable.logo,
            "Mar Muerto"
        )

        addQuestion(
            "¿En qué país se encuentra el Monte Fuji?",
            arrayOf("Japón", "China", "Corea del Sur", "Vietnam"),
            4,
            R.drawable.logo,
            "Japón"
        )

        addQuestion(
            "¿En qué deporte se utiliza una raqueta para golpear una pelota sobre una red?",
            arrayOf("Tenis", "Fútbol", "Golf", "Baloncesto"),
            5,
            R.drawable.logo,
            "Tenis"
        )

        addQuestion(
            "¿Cuál es el deporte conocido como el 'rey de los deportes'?",
            arrayOf("Fútbol", "Baloncesto", "Atletismo", "Golf"),
            4,
            R.drawable.logo,
            "Fútbol"
        )

        addQuestion(
            "¿En qué año se celebró la primera edición de los Juegos Olímpicos modernos?",
            arrayOf("1896", "1900", "1920", "1936"),
            5,
            R.drawable.logo,
            "1896"
        )

        addQuestion(
            "¿Cuál es el equipo de fútbol más exitoso en la historia de la Copa Mundial de la FIFA?",
            arrayOf("Brasil", "Alemania", "Italia", "Argentina"),
            4,
            R.drawable.logo,
            "Brasil"
        )

        addQuestion(
            "¿Quién es considerado el mejor jugador de baloncesto de todos los tiempos?",
            arrayOf("Michael Jordan", "LeBron James", "Kobe Bryant", "Magic Johnson"),
            5,
            R.drawable.logo,
            "Michael Jordan"
        )

        addQuestion(
            "¿En qué deporte se utiliza un octógono como espacio de competición?",
            arrayOf("Artes marciales mixtas (MMA)", "Boxeo", "Lucha libre", "Taekwondo"),
            4,
            R.drawable.logo,
            "Artes marciales mixtas (MMA)"
        )

        addQuestion(
            "¿Cuál es el deporte acuático en el que se utiliza una tabla y una vela para deslizarse sobre el agua?",
            arrayOf("Windsurf", "Surf", "Esquí acuático", "Kitesurf"),
            5,
            R.drawable.logo,
            "Windsurf"
        )

        addQuestion(
            "¿En qué deporte se puntúa realizando cestas en un aro?",
            arrayOf("Baloncesto", "Fútbol", "Voleibol", "Rugby"),
            4,
            R.drawable.logo,
            "Baloncesto"
        )

        addQuestion(
            "¿Cuál es el deporte que se juega en un campo con bases y un bate?",
            arrayOf("Béisbol", "Críquet", "Softbol", "Rounders"),
            5,
            R.drawable.logo,
            "Béisbol"
        )

        addQuestion(
            "¿En qué deporte se utiliza un casco y hombreras, y se juega con un balón ovalado?",
            arrayOf("Rugby", "Fútbol americano", "Aussie Rules", "Críquet"),
            4,
            R.drawable.logo,
            "Fútbol americano"
        )

        /**
         * VIDEOJUEGOS
         */

        addQuestion(
            "¿Cuál es el personaje principal en la saga de videojuegos 'The Legend of Zelda' de Nintendo?",
            arrayOf("Link", "Mario", "Sonic", "Kratos"),
            5,
            R.drawable.logo,
            "Link"
        )

        addQuestion(
            "¿En qué año se lanzó el popular juego 'Minecraft'?",
            arrayOf("2011", "2009", "2013", "2010"),
            4,
            R.drawable.logo,
            "2011"
        )

        addQuestion(
            "¿Quién es el creador del juego 'Fortnite'?",
            arrayOf("Epic Games", "Activision", "Ubisoft", "Electronic Arts"),
            5,
            R.drawable.logo,
            "Epic Games"
        )

        addQuestion(
            "¿Cuál es el título del juego de rol que desarrolló CD Projekt Red y se lanzó en 2020?",
            arrayOf("Cyberpunk 2077", "The Witcher 3", "Fallout 4", "Final Fantasy XV"),
            4,
            R.drawable.logo,
            "Cyberpunk 2077"
        )

        addQuestion(
            "¿En qué año se lanzó la consola de videojuegos PlayStation 4 de Sony?",
            arrayOf("2013", "2014", "2012", "2015"),
            5,
            R.drawable.logo,
            "2013"
        )

        addQuestion(
            "¿Cuál es el nombre del fontanero italiano creado por Nintendo?",
            arrayOf("Mario", "Luigi", "Yoshi", "Wario"),
            4,
            R.drawable.logo,
            "Mario"
        )

        addQuestion(
            "¿En qué año debutó la franquicia 'Pokémon' con sus primeros juegos?",
            arrayOf("1996", "1998", "2000", "1994"),
            5,
            R.drawable.logo,
            "1996"
        )

        addQuestion(
            "¿Cuál es el título del juego que popularizó el género 'Battle Royale'?",
            arrayOf("PlayerUnknown's Battlegrounds (PUBG)", "Apex Legends", "Call of Duty: Warzone", "H1Z1"),
            4,
            R.drawable.logo,
            "PlayerUnknown's Battlegrounds (PUBG)"
        )

        addQuestion(
            "¿Qué empresa japonesa es conocida por la creación de la serie de juegos 'Final Fantasy'?",
            arrayOf("Square Enix", "Capcom", "Konami", "Sega"),
            5,
            R.drawable.logo,
            "Square Enix"
        )

        addQuestion(
            "¿En qué año se lanzó el primer juego de la serie 'Assassin's Creed'?",
            arrayOf("2007", "2005", "2009", "2010"),
            4,
            R.drawable.logo,
            "2007"
        )
        addQuestion(
            "¿Cuál es el nombre del protagonista en el juego 'The Witcher 3: Wild Hunt'?",
            arrayOf("Geralt de Rivia", "Ezio Auditore", "Joel", "Aloy"),
            5,
            R.drawable.logo,
            "Geralt de Rivia"
        )

        addQuestion(
            "¿Cuál es el título del juego que presenta al personaje 'Kratos' y está basado en la mitología griega?",
            arrayOf("God of War", "Titan Quest", "Hades", "Athena's Wrath"),
            4,
            R.drawable.logo,
            "God of War"
        )

        addQuestion(
            "¿En qué año se lanzó el juego 'Super Mario Bros.' de Nintendo?",
            arrayOf("1985", "1988", "1990", "1982"),
            5,
            R.drawable.logo,
            "1985"
        )

        addQuestion(
            "¿Cuál es el nombre del estudio de desarrollo detrás de la serie de juegos 'Halo'?",
            arrayOf("Bungie", "343 Industries", "Epic Games", "id Software"),
            4,
            R.drawable.logo,
            "Bungie"
        )

        addQuestion(
            "¿Cuál es el género principal del juego 'League of Legends'?",
            arrayOf("MOBA", "FPS", "RPG", "RTS"),
            5,
            R.drawable.logo,
            "MOBA"
        )

        addQuestion(
            "¿En qué año se lanzó la primera PlayStation de Sony?",
            arrayOf("1994", "1996", "1992", "1998"),
            4,
            R.drawable.logo,
            "1994"
        )

        addQuestion(
            "¿Cuál es el título del juego en el que controlas a un fontanero que viaja a través de tuberías?",
            arrayOf("Super Mario Bros.", "Sonic the Hedgehog", "Megaman", "Metroid"),
            5,
            R.drawable.logo,
            "Super Mario Bros."
        )

        addQuestion(
            "¿Qué personaje icónico de los videojuegos es conocido por recolectar anillos dorados?",
            arrayOf("Sonic the Hedgehog", "Mario", "Crash Bandicoot", "Pac-Man"),
            4,
            R.drawable.logo,
            "Sonic the Hedgehog"
        )

        addQuestion(
            "¿Cuál es el nombre del estudio de desarrollo detrás de la serie de juegos 'The Elder Scrolls'?",
            arrayOf("Bethesda Game Studios", "Bioware", "Rockstar Games", "Ubisoft"),
            5,
            R.drawable.logo,
            "Bethesda Game Studios"
        )

        addQuestion(
            "¿En qué año se lanzó el juego 'Counter-Strike: Global Offensive'?",
            arrayOf("2012", "2010", "2014", "2016"),
            4,
            R.drawable.logo,
            "2012"
        )

        addQuestion(
            "¿Cuál es el título del juego en el que controlas a un marine espacial luchando contra alienígenas?",
            arrayOf("Doom", "Half-Life", "Quake", "Deus Ex"),
            5,
            R.drawable.logo,
            "Doom"
        )

        addQuestion(
            "¿Quién es el creador del juego 'Minecraft'?",
            arrayOf("Markus Persson (Notch)", "Shigeru Miyamoto", "Hideo Kojima", "Todd Howard"),
            4,
            R.drawable.logo,
            "Markus Persson (Notch)"
        )

        addQuestion(
            "¿En qué año se lanzó el juego 'The Legend of Zelda: Breath of the Wild'?",
            arrayOf("2017", "2015", "2018", "2016"),
            5,
            R.drawable.logo,
            "2017"
        )

        addQuestion(
            "¿Cuál es el nombre del protagonista en la serie de juegos 'Assassin's Creed'?",
            arrayOf("Desmond Miles", "Ezio Auditore", "Connor Kenway", "Altair Ibn-La'Ahad"),
            4,
            R.drawable.logo,
            "Desmond Miles"
        )

        addQuestion(
            "¿En qué año se lanzó el juego 'GTA V' de Rockstar Games?",
            arrayOf("2013", "2015", "2012", "2014"),
            5,
            R.drawable.logo,
            "2013"
        )

        addQuestion(
            "¿Cuál es el título del juego que presenta a un fontanero que come setas y crece de tamaño?",
            arrayOf("Super Mario Bros.", "Mega Man", "The Legend of Zelda", "Final Fantasy"),
            4,
            R.drawable.logo,
            "Super Mario Bros."
        )

        addQuestion(
            "¿En qué año se lanzó la consola de videojuegos Xbox 360 de Microsoft?",
            arrayOf("2005", "2008", "2006", "2007"),
            5,
            R.drawable.logo,
            "2005"
        )

        addQuestion(
            "¿Cuál es el nombre del protagonista en el juego 'Metal Gear Solid'?",
            arrayOf("Solid Snake", "Big Boss", "Raiden", "Liquid Snake"),
            4,
            R.drawable.logo,
            "Solid Snake"
        )

        addQuestion(
            "¿En qué año se lanzó el juego 'World of Warcraft'?",
            arrayOf("2004", "2006", "2002", "2008"),
            5,
            R.drawable.logo,
            "2004"
        )

    }

    private fun addQuestion(
        enunciado: String,
        respuestas: Array<String>,
        puntos: Int,
        image: Int,
        respuestaCorrecta: String
    ) {
        respuestas.shuffle()
        this.enunciados.add(enunciado)
        this.respuestas.add(respuestas)
        this.colorRespuesta.add(Array(respuestas.size) { Color.White })
        this.respuestaCorrecta.add(respuestaCorrecta)
        this.image.add(image)
        this.puntos.add(puntos)
    }
}

