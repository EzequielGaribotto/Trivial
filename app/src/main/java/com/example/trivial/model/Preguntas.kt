package com.example.trivial.model

import com.example.trivial.R

class Preguntas(
    var enunciados: MutableList<String> = mutableListOf(),
    var respuestas: MutableList<Array<String>> = mutableListOf(),
    var respuestaCorrecta: MutableList<String> = mutableListOf(),
    var puntos: MutableList<Int> = mutableListOf(),
    var image: MutableList<Int> = mutableListOf()
) {

    init {
        addQuestion(
            "¿En qué año se produjo la caída del Muro de Berlín?",
            arrayOf("1989", "1990", "1991", "1992"),
            2,
            R.drawable.historia,
            "1989"
        )
        addQuestion(
            "¿Cuál es la capital de Australia?",
            arrayOf("Canberra", "Sídney", "Melbourne", "Perth"),
            3,
            R.drawable.geografia,
            "Canberra"
        )
        addQuestion(
            "¿Quién escribió la novela 'Don Quijote de la Mancha'?", arrayOf(
                "Miguel de Cervantes",
                "William Shakespeare",
                "Dante Alighieri",
                "Johann Wolfgang von Goethe"
            ), 1, R.drawable.historia, "Miguel de Cervantes"
        )
        addQuestion(
            "¿Cuál es el río más largo del mundo?",
            arrayOf("Amazonas", "Nilo", "Yangtze", "Mississippi"),
            1,
            R.drawable.geografia,
            "Amazonas"
        )
        addQuestion(
            "¿En qué año se descubrió América?",
            arrayOf("1492", "1502", "1512", "1522"),
            2,
            R.drawable.historia,
            "1492"
        )
        addQuestion(
            "¿Cuál es el teorema de Pitágoras?", arrayOf(
                "En un triángulo rectángulo, el cuadrado de la hipotenusa es igual a la suma de los cuadrados de los catetos",
                "En un triángulo rectángulo, el cuadrado de la hipotenusa es igual al producto de los catetos",
                "En un triángulo rectángulo, el cuadrado de un cateto es igual a la suma de los cuadrados de la hipotenusa y el otro cateto",
                "En un triángulo rectángulo, el cuadrado de un cateto es igual al producto de la hipotenusa y el otro cateto"
            ), 3, R.drawable.matematicas, "En un triángulo rectángulo, el cuadrado de la hipotenusa es igual a la suma de los cuadrados de los catetos"
        )
        addQuestion(
            "¿Quién fue el primer hombre en pisar la Luna?",
            arrayOf(
                "Neil Armstrong", "Buzz Aldrin", "Michael Collins", " Yuri Gagarin"),
            1, R.drawable.historia, "Neil Armstrong"
        )
        addQuestion ("¿Cuál es la montaña más alta del mundo?",
            arrayOf("Monte Everest", "K2", "Kangchenjunga", "Lhotse"),
            1,
            R.drawable.geografia,
            "Monte Everest"
        )
        addQuestion(
            "¿Cuál es la moneda de Japón?",
            arrayOf("Yen", "Won", "Dólar", "Euro"),
            2,
            R.drawable.geografia,
            "Yen"
        )

        addQuestion(
            "¿Cuál es la capital de Canadá?",
            arrayOf("Ottawa", "Toronto", "Vancouver", "Montreal"),
            2,
            R.drawable.geografia,
            "Ottawa"
        )

        addQuestion(
            "¿Quién es conocido como el 'Padre de la Informática'?",
            arrayOf("Alan Turing", "Bill Gates", "Steve Jobs", "Mark Zuckerberg"),
            1,
            R.drawable.historia,
            "Alan Turing"
        )

        addQuestion(
            "¿En qué año se fundó la ONU (Organización de las Naciones Unidas)?",
            arrayOf("1945", "1955", "1935", "1965"),
            3,
            R.drawable.historia,
            "1945"
        )

        addQuestion(
            "¿Cuál es la fórmula química del agua?",
            arrayOf("H2O", "CO2", "O2", "N2"),
            1,
            R.drawable.quimica,
            "H2O"
        )

        addQuestion(
            "¿Cuál es la capital de Brasil?",
            arrayOf("Brasilia", "Río de Janeiro", "São Paulo", "Buenos Aires"),
            2,
            R.drawable.geografia,
            "Brasilia"
        )
        addQuestion(
            "¿Cuál es el río más largo de América del Sur?",
            arrayOf("Amazonas", "Nilo", "Yangtsé", "Misisipi"),
            1,
            R.drawable.geografia,
            "Amazonas"
        )

        addQuestion(
            "¿En qué continente se encuentra el desierto del Sahara?",
            arrayOf("África", "Asia", "América del Norte", "Europa"),
            1,
            R.drawable.geografia,
            "África"
        )

        addQuestion(
            "¿Cuál es el país más grande del mundo por área terrestre?",
            arrayOf("Rusia", "China", "Estados Unidos", "Canadá"),
            1,
            R.drawable.geografia,
            "Rusia"
        )

        addQuestion(
            "¿Cuál es la cadena montañosa más larga del mundo?",
            arrayOf("Los Andes", "Himalaya", "Montañas Rocosas", "Alpes"),
            2,
            R.drawable.geografia,
            "Los Andes"
        )

        addQuestion(
            "¿En qué océano se encuentra la Gran Barrera de Coral?",
            arrayOf("Océano Pacífico", "Océano Atlántico", "Océano Índico", "Océano Ártico"),
            3,
            R.drawable.geografia,
            "Océano Pacífico"
        )

        addQuestion(
            "¿Cuál es la capital de Argentina?",
            arrayOf("Buenos Aires", "Santiago", "Lima", "Bogotá"),
            1,
            R.drawable.geografia,
            "Buenos Aires"
        )

        addQuestion(
            "¿Cuál es la isla más grande del mundo?",
            arrayOf("Groenlandia", "Australia", "Borneo", "Java"),
            2,
            R.drawable.geografia,
            "Groenlandia"
        )

        addQuestion(
            "¿En qué país se encuentra el volcán Kilimanjaro?",
            arrayOf("Tanzania", "Kenia", "Etiopía", "Uganda"),
            1,
            R.drawable.geografia,
            "Tanzania"
        )

        addQuestion(
            "¿Cuál es el punto más bajo de la Tierra?",
            arrayOf("Mar Muerto", "Cañón del Colorado", "Fosa de las Marianas", "Lago Baikal"),
            3,
            R.drawable.geografia,
            "Mar Muerto"
        )

        addQuestion(
            "¿En qué país se encuentra el Monte Fuji?",
            arrayOf("Japón", "China", "Corea del Sur", "Vietnam"),
            2,
            R.drawable.geografia,
            "Japón"
        )

        /**
         * DEPORTES
         */

        addQuestion(
            "¿En qué deporte se utiliza una raqueta para golpear una pelota sobre una red?",
            arrayOf("Tenis", "Fútbol", "Golf", "Baloncesto"),
            1,
            R.drawable.deportes,
            "Tenis"
        )

        addQuestion(
            "¿Cuál es el deporte conocido como el 'deporte rey'?",
            arrayOf("Fútbol", "Baloncesto", "Atletismo", "Golf"),
            1,
            R.drawable.deportes,
            "Fútbol"
        )

        addQuestion(
            "¿En qué año se celebró la primera edición de los Juegos Olímpicos modernos?",
            arrayOf("1896", "1900", "1920", "1936"),
            3,
            R.drawable.deportes,
            "1896"
        )

        addQuestion(
            "¿Cuál es el equipo de fútbol más exitoso en la historia de la Copa Mundial de la FIFA?",
            arrayOf("Brasil", "Alemania", "Italia", "Argentina"),
            1,
            R.drawable.deportes,
            "Brasil"
        )

        addQuestion(
            "¿Quién es considerado el mejor jugador de baloncesto de todos los tiempos?",
            arrayOf("Michael Jordan", "LeBron James", "Kobe Bryant", "Magic Johnson"),
            2,
            R.drawable.deportes,
            "Michael Jordan"
        )

        addQuestion(
            "¿En qué deporte se utiliza un octógono como espacio de competición?",
            arrayOf("Artes marciales mixtas (MMA)", "Boxeo", "Lucha libre", "Taekwondo"),
            2,
            R.drawable.deportes,
            "Artes marciales mixtas (MMA)"
        )

        addQuestion(
            "¿Cuál es el deporte acuático en el que se utiliza una tabla y una vela para deslizarse sobre el agua?",
            arrayOf("Windsurf", "Surf", "Esquí acuático", "Kitesurf"),
            3,
            R.drawable.deportes,
            "Windsurf"
        )

        addQuestion(
            "¿En qué deporte se puntúa realizando cestas en un aro?",
            arrayOf("Baloncesto", "Fútbol", "Voleibol", "Rugby"),
            1,
            R.drawable.deportes,
            "Baloncesto"
        )

        addQuestion(
            "¿Cuál es el deporte que se juega en un campo con bases y un bate?",
            arrayOf("Béisbol", "Críquet", "Softbol", "Rounders"),
            1,
            R.drawable.deportes,
            "Béisbol"
        )

        addQuestion(
            "¿En qué deporte se utiliza un casco y hombreras, y se juega con un balón ovalado?",
            arrayOf("Rugby", "Fútbol americano", "Aussie Rules", "Críquet"),
            2,
            R.drawable.deportes,
            "Fútbol americano"
        )

        /**
         * VIDEOJUEGOS
         */

        addQuestion(
            "¿Cuál es el personaje principal en la saga de videojuegos 'The Legend of Zelda' de Nintendo?",
            arrayOf("Link", "Mario", "Zelda", "Kratos"),
            1,
            R.drawable.videojuegos,
            "Link"
        )

        addQuestion(
            "¿En qué año se lanzó el popular juego 'Minecraft'?",
            arrayOf("2011", "2009", "2013", "2010"),
            2,
            R.drawable.videojuegos,
            "2011"
        )

        addQuestion(
            "¿Quién es el creador del juego 'Fortnite'?",
            arrayOf("Epic Games", "Activision", "Ubisoft", "Electronic Arts"),
            1,
            R.drawable.videojuegos,
            "Epic Games"
        )

        addQuestion(
            "¿Cuál es el título del juego de rol que desarrolló CD Projekt Red y se lanzó en 2020?",
            arrayOf("Cyberpunk 2077", "The Witcher 3", "Fallout 4", "Final Fantasy XV"),
            2,
            R.drawable.videojuegos,
            "Cyberpunk 2077"
        )

        addQuestion(
            "¿En qué año se lanzó la consola de videojuegos PlayStation 4 de Sony?",
            arrayOf("2013", "2014", "2012", "2015"),
            3,
            R.drawable.videojuegos,
            "2013"
        )

        addQuestion(
            "¿Cuál es el nombre del fontanero italiano creado por Nintendo?",
            arrayOf("Mario", "Luigi", "Yoshi", "Wario"),
            1,
            R.drawable.videojuegos,
            "Mario"
        )

        addQuestion(
            "¿En qué año debutó la franquicia 'Pokémon' con sus primeros juegos?",
            arrayOf("1996", "1998", "2000", "1994"),
            2,
            R.drawable.videojuegos,
            "1996"
        )

        addQuestion(
            "¿Cuál es el título del juego que popularizó el género 'Battle Royale'?",
            arrayOf("PlayerUnknown's Battlegrounds (PUBG)", "Apex Legends", "Call of Duty: Warzone", "H1Z1"),
            2,
            R.drawable.videojuegos,
            "PlayerUnknown's Battlegrounds (PUBG)"
        )

        addQuestion(
            "¿Qué empresa japonesa es conocida por la creación de la serie de juegos 'Final Fantasy'?",
            arrayOf("Square Enix", "Capcom", "Konami", "Sega"),
            2,
            R.drawable.videojuegos,
            "Square Enix"
        )

        addQuestion(
            "¿En qué año se lanzó el primer juego de la serie 'Assassin's Creed'?",
            arrayOf("2007", "2005", "2009", "2010"),
            3,
            R.drawable.videojuegos,
            "2007"
        )
        addQuestion(
            "¿Cuál es el nombre del protagonista en el juego 'The Witcher 3: Wild Hunt'?",
            arrayOf("Geralt de Rivia", "Ezio Auditore", "Joel", "Aloy"),
            2,
            R.drawable.videojuegos,
            "Geralt de Rivia"
        )

        addQuestion(
            "¿Cuál es el título del juego que presenta al personaje 'Kratos' y está basado en la mitología griega?",
            arrayOf("God of War", "Titan Quest", "Hades", "Athena's Wrath"),
            1,
            R.drawable.videojuegos,
            "God of War"
        )

        addQuestion(
            "¿En qué año se lanzó el juego 'Super Mario Bros.' de Nintendo?",
            arrayOf("1985", "1988", "1990", "1982"),
            2,
            R.drawable.videojuegos,
            "1985"
        )

        addQuestion(
            "¿Cuál es el nombre del estudio de desarrollo detrás de la serie de juegos 'Halo'?",
            arrayOf("Bungie", "343 Industries", "Epic Games", "id Software"),
            3,
            R.drawable.videojuegos,
            "Bungie"
        )

        addQuestion(
            "¿Cuál es el género principal del juego 'League of Legends'?",
            arrayOf("MOBA", "FPS", "RPG", "RTS"),
            2,
            R.drawable.videojuegos,
            "MOBA"
        )

        addQuestion(
            "¿Cuál es el título del juego en el que controlas a un fontanero que viaja a través de tuberías?",
            arrayOf("Super Mario Bros.", "Sonic the Hedgehog", "Megaman", "Metroid"),
            1,
            R.drawable.videojuegos,
            "Super Mario Bros."
        )

        addQuestion(
            "¿Qué personaje icónico de los videojuegos es conocido por recolectar anillos dorados?",
            arrayOf("Sonic the Hedgehog", "Mario", "Crash Bandicoot", "Pac-Man"),
            1,
            R.drawable.videojuegos,
            "Sonic the Hedgehog"
        )

        addQuestion(
            "¿Cuál es el nombre del estudio de desarrollo detrás de la serie de juegos 'The Elder Scrolls'?",
            arrayOf("Bethesda Game Studios", "Bioware", "Rockstar Games", "Ubisoft"),
            2,
            R.drawable.videojuegos,
            "Bethesda Game Studios"
        )

        addQuestion(
            "¿En qué año se lanzó el juego 'Counter-Strike: Global Offensive'?",
            arrayOf("2012", "2010", "2014", "2016"),
            3,
            R.drawable.videojuegos,
            "2012"
        )

        addQuestion(
            "¿Cuál es el título del juego en el que controlas a un marine espacial luchando contra alienígenas?",
            arrayOf("Doom", "Half-Life", "Quake", "Deus Ex"),
            3,
            R.drawable.videojuegos,
            "Doom"
        )

        addQuestion(
            "¿Quién es el creador del juego 'Minecraft'?",
            arrayOf("Markus Persson (Notch)", "Shigeru Miyamoto", "Hideo Kojima", "Todd Howard"),
            3,
            R.drawable.videojuegos,
            "Markus Persson (Notch)"
        )

        addQuestion(
            "¿En qué año se lanzó el juego 'The Legend of Zelda: Breath of the Wild'?",
            arrayOf("2017", "2015", "2018", "2016"),
            3,
            R.drawable.videojuegos,
            "2017"
        )

        addQuestion(
            "¿Cuál es el nombre del protagonista en la serie de juegos 'Assassin's Creed'?",
            arrayOf("Desmond Miles", "Ezio Auditore", "Connor Kenway", "Altair Ibn-La'Ahad"),
            3,
            R.drawable.videojuegos,
            "Desmond Miles"
        )

        addQuestion(
            "¿En qué año se lanzó el juego 'GTA V' de Rockstar Games?",
            arrayOf("2013", "2015", "2012", "2014"),
            2,
            R.drawable.videojuegos,
            "2013"
        )

        addQuestion(
            "¿En qué año se lanzó la consola de videojuegos Xbox 360 de Microsoft?",
            arrayOf("2005", "2008", "2006", "2007"),
            2,
            R.drawable.videojuegos,
            "2005"
        )

        addQuestion(
            "¿Cuál es el nombre del protagonista en el juego 'Metal Gear Solid'?",
            arrayOf("Solid Snake", "Big Boss", "Raiden", "Liquid Snake"),
            1,
            R.drawable.videojuegos,
            "Solid Snake"
        )

        addQuestion(
            "¿En qué año se lanzó el juego 'World of Warcraft'?",
            arrayOf("2004", "2006", "2002", "2008"),
            2,
            R.drawable.videojuegos,
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
        this.respuestaCorrecta.add(respuestaCorrecta)
        this.image.add(image)
        this.puntos.add(puntos)
    }
}

