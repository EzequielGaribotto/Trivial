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
            2,
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

        // Preguntas de Cultura
        addQuestion(
            "¿Quién pintó la Mona Lisa?",
            arrayOf("Leonardo da Vinci", "Vincent van Gogh", "Pablo Picasso", "Claude Monet"),
            2,
            R.drawable.cultura,
            "Leonardo da Vinci"
        )

        addQuestion(
            "¿En qué año se celebró la primera edición de los premios Oscar?",
            arrayOf("1929", "1935", "1940", "1950"),
            1,
            R.drawable.cultura,
            "1929"
        )

        addQuestion(
            "¿Quién escribió la obra 'Romeo y Julieta'?",
            arrayOf("William Shakespeare", "Miguel de Cervantes", "Jane Austen", "Charles Dickens"),
            2,
            R.drawable.cultura,
            "William Shakespeare"
        )

        addQuestion(
            "¿Cuál es el período conocido como el Renacimiento?",
            arrayOf("Siglo XIV - Siglo XVI", "Siglo X - Siglo XII", "Siglo XVII - Siglo XIX", "Siglo V - Siglo IX"),
            3,
            R.drawable.cultura,
            "Siglo XIV - Siglo XVI"
        )

// Preguntas de Matemáticas
        addQuestion(
            "¿Cuál es el número Pi?",
            arrayOf("3.14", "2.71", "1.61", "4.16"),
            2,
            R.drawable.matematicas,
            "3.14"
        )

        addQuestion(
            "¿Qué es el teorema de Fermat?",
            arrayOf("Un principio de la óptica", "Una conjetura matemática", "Una ley de los gases", "Un postulado geométrico"),
            3,
            R.drawable.matematicas,
            "Una conjetura matemática"
        )

        addQuestion(
            "¿Cuál es el resultado de sumar los ángulos internos de un triángulo?",
            arrayOf("180 grados", "90 grados", "270 grados", "360 grados"),
            1,
            R.drawable.matematicas,
            "180 grados"
        )

// Preguntas de Química
        addQuestion(
            "¿Cuál es el símbolo químico del oro?",
            arrayOf("Au", "Ag", "Fe", "Hg"),
            2,
            R.drawable.quimica,
            "Au"
        )

        addQuestion(
            "¿Cuál es el componente principal del aire?",
            arrayOf("Nitrógeno", "Oxígeno", "Dióxido de carbono", "Argón"),
            1,
            R.drawable.quimica,
            "Nitrógeno"
        )

        addQuestion(
            "¿Qué gas es conocido como el gas de la risa?",
            arrayOf("Óxido de nitrógeno", "Dióxido de carbono", "Metano", "Hidrógeno"),
            3,
            R.drawable.quimica,
            "Óxido de nitrógeno"
        )

        addQuestion(
            "¿Cuál es el equipo de fútbol más antiguo del mundo?",
            arrayOf("Sheffield FC", "Manchester United", "Real Madrid", "FC Barcelona"),
            2,
            R.drawable.deportes,
            "Sheffield FC"
        )

        addQuestion(
            "¿En qué deporte se utiliza una pala para golpear una pelota sobre una mesa dividida por una red?",
            arrayOf("Tenis de mesa", "Badminton", "Ping Pong", "Paddle"),
            1,
            R.drawable.deportes,
            "Tenis de mesa"
        )

        addQuestion(
            "¿Cuál es el récord mundial de velocidad en los 100 metros lisos masculinos?",
            arrayOf("9.58 segundos", "10.12 segundos", "9.81 segundos", "10.55 segundos"),
            3,
            R.drawable.deportes,
            "9.58 segundos"
        )
// Preguntas adicionales de Matemáticas
        addQuestion(
            "¿Cuál es el resultado de la siguiente operación matemática: 25 * 4 / 2?",
            arrayOf("50", "75", "100", "125"),
            2,
            R.drawable.matematicas,
            "50"
        )

        addQuestion(
            "¿Cuál es el valor de la raíz cuadrada de 144?",
            arrayOf("11", "12", "13", "14"),
            1,
            R.drawable.matematicas,
            "12"
        )

        addQuestion(
            "¿Cuál es la fórmula del área de un triángulo?",
            arrayOf("A = bh", "A = (b * h) / 2", "A = πr^2", "A = l * w"),
            2,
            R.drawable.matematicas,
            "A = (b * h) / 2"
        )

        addQuestion(
            "¿Cuál es el resultado de la siguiente operación matemática: (8 + 3) * 2 - 5?",
            arrayOf("15", "16", "17", "18"),
            3,
            R.drawable.matematicas,
            "16"
        )

        addQuestion(
            "¿Cuántos grados tiene la suma de los ángulos internos de un cuadrilátero?",
            arrayOf("180 grados", "270 grados", "360 grados", "450 grados"),
            3,
            R.drawable.matematicas,
            "360 grados"
        )

        addQuestion(
            "¿Cuál es el resultado de la siguiente operación matemática: 3^4 (3 elevado a la 4ta potencia)?",
            arrayOf("81", "64", "27", "243"),
            2,
            R.drawable.matematicas,
            "81"
        )

        addQuestion(
            "¿Cuántos lados tiene un heptágono?",
            arrayOf("5", "6", "7", "8"),
            1,
            R.drawable.matematicas,
            "7"
        )

        addQuestion(
            "¿Cuál es la fórmula del volumen de un cilindro?",
            arrayOf("V = πr^2h", "V = lwh", "V = (1/3)πr^2h", "V = 4/3πr^3"),
            3,
            R.drawable.matematicas,
            "V = πr^2h"
        )

        addQuestion(
            "¿Cuánto es la raíz cuadrada de 169?",
            arrayOf("11", "12", "13", "14"),
            2,
            R.drawable.matematicas,
            "13"
        )

        addQuestion(
            "¿Cuál es el resultado de la siguiente operación matemática: 7! (7 factorial)?",
            arrayOf("5040", "720", "120", "40320"),
            3,
            R.drawable.matematicas,
            "5040"
        )

        // Preguntas complejas de Deportes
        addQuestion(
            "En el deporte del curling, ¿cuál es el nombre del objeto que se utiliza para deslizar las piedras sobre el hielo?",
            arrayOf("Broom", "Slider", "Sweeper", "Curler"),
            3,
            R.drawable.deportes,
            "Slider"
        )

        addQuestion(
            "¿Cuál es el evento de atletismo en el que los competidores deben lanzar un martillo metálico?",
            arrayOf("Lanzamiento de martillo", "Lanzamiento de disco", "Lanzamiento de jabalina", "Lanzamiento de peso"),
            3,
            R.drawable.deportes,
            "Lanzamiento de martillo"
        )

        addQuestion(
            "En el golf, ¿qué término se utiliza para describir la puntuación de un hoyo completado en un golpe por debajo del par?",
            arrayOf("Bogey", "Eagle", "Birdie", "Albatros"),
            3,
            R.drawable.deportes,
            "Albatros"
        )

        addQuestion(
            "¿Quién es considerado el mejor jugador de tenis de todos los tiempos?",
            arrayOf("Roger Federer", "Rafael Nadal", "Novak Djokovic", "Serena Williams"),
            3,
            R.drawable.deportes,
            "Roger Federer"
        )

        addQuestion(
            "En el ciclismo, ¿cuál es el nombre de la competición que abarca tres grandes vueltas: Tour de Francia, Giro de Italia y Vuelta a España?",
            arrayOf("Triple Corona", "Grand Slam", "Triple Tour", "Triple Corona de Ciclismo"),
            3,
            R.drawable.deportes,
            "Triple Corona de Ciclismo"
        )

        addQuestion(
            "¿Cuál es el único equipo de fútbol que ha ganado seis veces consecutivas la Serie A italiana?",
            arrayOf("AC Milan", "Inter de Milán", "Juventus", "AS Roma"),
            3,
            R.drawable.deportes,
            "Juventus"
        )

        addQuestion(
            "En el rugby, ¿cuántos puntos otorga una conversión después de un ensayo?",
            arrayOf("2 puntos", "3 puntos", "4 puntos", "5 puntos"),
            3,
            R.drawable.deportes,
            "2 puntos"
        )

        addQuestion(
            "¿Cuál es el país de origen del esgrima?",
            arrayOf("Italia", "Francia", "España", "Rusia"),
            3,
            R.drawable.deportes,
            "Italia"
        )

        addQuestion(
            "En el béisbol, ¿cuál es el récord de más jonrones en una temporada de las Grandes Ligas?",
            arrayOf("60", "61", "70", "73"),
            3,
            R.drawable.deportes,
            "73"
        )

        addQuestion(
            "¿Cuál es el equipo de baloncesto más exitoso en la historia de la NBA en términos de campeonatos ganados?",
            arrayOf("Los Angeles Lakers", "Boston Celtics", "Chicago Bulls", "Golden State Warriors"),
            3,
            R.drawable.deportes,
            "Boston Celtics"
        )
// Preguntas fáciles de Deportes
        addQuestion(
            "¿En qué deporte se lanzan discos y se compite en carreras de velocidad, salto en largo y lanzamiento de jabalina?",
            arrayOf("Atletismo", "Natación", "Tenis", "Esquí"),
            1,
            R.drawable.deportes,
            "Atletismo"
        )

        addQuestion(
            "¿Cuál es el nombre del deporte en el que dos equipos compiten para anotar puntos al pasar un balón por un aro elevado?",
            arrayOf("Baloncesto", "Fútbol", "Voleibol", "Golf"),
            1,
            R.drawable.deportes,
            "Baloncesto"
        )

        addQuestion(
            "¿Cuántos jugadores hay en un equipo de fútbol durante un partido?",
            arrayOf("10", "11", "12", "9"),
            1,
            R.drawable.deportes,
            "11"
        )

        addQuestion(
            "¿Qué deporte se juega en un campo con bases y un bate?",
            arrayOf("Béisbol", "Fútbol", "Baloncesto", "Golf"),
            1,
            R.drawable.deportes,
            "Béisbol"
        )

        addQuestion(
            "¿En qué deporte se utiliza una red dividida por una cuerda y una pelota para golpearla de un lado a otro?",
            arrayOf("Tenis de mesa", "Badminton", "Squash", "Golf"),
            1,
            R.drawable.deportes,
            "Tenis de mesa"
        )

        addQuestion(
            "¿Cuál es el objeto que se utiliza para golpear la pelota en un juego de golf?",
            arrayOf("Pala", "Raqueta", "Bate", "Palos de golf"),
            1,
            R.drawable.deportes,
            "Palos de golf"
        )

        addQuestion(
            "¿En qué deporte se compite en un ring y se utilizan guantes para golpear al oponente?",
            arrayOf("Boxeo", "Lucha libre", "Karate", "Judo"),
            1,
            R.drawable.deportes,
            "Boxeo"
        )

        addQuestion(
            "¿Cuál es el nombre del torneo de tenis más prestigioso del mundo?",
            arrayOf("Abierto de Estados Unidos", "Roland Garros", "Wimbledon", "Abierto de Australia"),
            1,
            R.drawable.deportes,
            "Wimbledon"
        )

        addQuestion(
            "¿En qué deporte los jugadores compiten para atrapar una pelota lanzada y lanzarla de vuelta al oponente?",
            arrayOf("Tenis", "Béisbol", "Críquet", "Voleibol"),
            1,
            R.drawable.deportes,
            "Béisbol"
        )

        addQuestion(
            "¿Cuál es el nombre del evento deportivo internacional que se celebra cada cuatro años y reúne a atletas de todo el mundo?",
            arrayOf("Copa Mundial de la FIFA", "Juegos Olímpicos", "Copa América", "Campeonato Mundial de Atletismo"),
            1,
            R.drawable.deportes,
            "Juegos Olímpicos"
        )

        // Preguntas de nivel medio de Deportes
        addQuestion(
            "¿En qué deporte se utiliza un palo largo llamado 'putter' para golpear una pelota hacia un agujero en el menor número de golpes posible?",
            arrayOf("Golf", "Hockey sobre césped", "Críquet", "Béisbol"),
            2,
            R.drawable.deportes,
            "Golf"
        )

        addQuestion(
            "¿Cuál es el deporte que se juega con una pelota pequeña y varios jugadores que intentan lanzarla a un círculo marcado en el suelo?",
            arrayOf("Bolos", "Croquet", "Bocce", "Petanca"),
            2,
            R.drawable.deportes,
            "Bocce"
        )

        addQuestion(
            "¿Cuántos jugadores hay en un equipo de voleibol en la cancha al mismo tiempo?",
            arrayOf("4", "5", "6", "7"),
            2,
            R.drawable.deportes,
            "6"
        )

        addQuestion(
            "¿Cuál es el único deporte que se juega en una pista ovalada y utiliza patines?",
            arrayOf("Hockey sobre hielo", "Patinaje artístico", "Patinaje de velocidad", "Roller Derby"),
            2,
            R.drawable.deportes,
            "Roller Derby"
        )

        addQuestion(
            "¿En qué deporte se compite en eventos llamados 'Slalom' y 'Descenso'?",
            arrayOf("Esquí alpino", "Snowboard", "Esquí acuático", "Salto de trampolín"),
            2,
            R.drawable.deportes,
            "Esquí alpino"
        )

        addQuestion(
            "¿En qué deporte se utiliza un guante llamado 'mitt' para atrapar y lanzar una pelota?",
            arrayOf("Críquet", "Fútbol americano", "Béisbol", "Softbol"),
            2,
            R.drawable.deportes,
            "Béisbol"
        )

        addQuestion(
            "¿Cuál es el nombre del juego en el que los jugadores lanzan discos de plástico hacia una serie de cestas metálicas?",
            arrayOf("Ultimate Frisbee", "Frisbee golf", "Disco volador", "Disc golf"),
            2,
            R.drawable.deportes,
            "Frisbee golf"
        )

        addQuestion(
            "¿En qué deporte los jugadores compiten para colocar una bola en un hoyo utilizando la menor cantidad de golpes?",
            arrayOf("Golf", "Críquet", "Bolos", "Polo"),
            2,
            R.drawable.deportes,
            "Golf"
        )

        addQuestion(
            "¿Cuál es el nombre del juego de equipo en el que los jugadores intentan llevar un balón al otro lado del campo y anotar puntos al cruzar una línea?",
            arrayOf("Rugby", "Fútbol americano", "Hockey sobre césped", "Lacrosse"),
            2,
            R.drawable.deportes,
            "Lacrosse"
        )

        addQuestion(
            "¿En qué deporte se compite para lograr la mayor distancia en lanzamiento de una pesa esférica de metal llamada 'martillo'?",
            arrayOf("Lanzamiento de martillo", "Lanzamiento de peso", "Lanzamiento de disco", "Lanzamiento de jabalina"),
            2,
            R.drawable.deportes,
            "Lanzamiento de martillo"
        )

        // Preguntas difíciles de Química
        addQuestion(
            "¿Cuál es el número atómico del elemento químico con símbolo 'Au'?",
            arrayOf("78", "79", "80", "81"),
            3,
            R.drawable.quimica,
            "79"
        )

        addQuestion(
            "¿Cuál es el nombre del proceso químico mediante el cual una sustancia pasa del estado gaseoso al estado sólido sin pasar por el estado líquido?",
            arrayOf("Sublimación", "Condensación", "Solidificación", "Vaporización"),
            3,
            R.drawable.quimica,
            "Sublimación"
        )

        addQuestion(
            "¿Cuál es la fórmula química del ácido sulfúrico?",
            arrayOf("H2SO3", "H2SO4", "HCl", "HNO3"),
            3,
            R.drawable.quimica,
            "H2SO4"
        )

        addQuestion(
            "¿Cuál es el proceso químico en el cual un átomo o una molécula gana electrones?",
            arrayOf("Oxidación", "Reducción", "Ionización", "Disociación"),
            3,
            R.drawable.quimica,
            "Reducción"
        )

        addQuestion(
            "¿Cuál es el nombre del compuesto químico formado por carbono, hidrógeno y oxígeno en la proporción 12:1:16?",
            arrayOf("Metano", "Eter", "Formaldehído", "Ácido fórmico"),
            3,
            R.drawable.quimica,
            "Formaldehído"
        )

        addQuestion(
            "¿Cuál es el nombre del proceso químico que implica la ruptura de una molécula de agua en oxígeno e hidrógeno?",
            arrayOf("Electrólisis", "Fotosíntesis", "Respiración celular", "Descomposición"),
            3,
            R.drawable.quimica,
            "Electrólisis"
        )

        addQuestion(
            "¿Cuál es el nombre del modelo propuesto por Niels Bohr para describir la estructura del átomo?",
            arrayOf("Modelo de Dalton", "Modelo de Thomson", "Modelo de Rutherford", "Modelo de Bohr"),
            3,
            R.drawable.quimica,
            "Modelo de Bohr"
        )

        addQuestion(
            "¿Cuál es el nombre del compuesto químico que se forma cuando se combina hidrógeno y oxígeno en una proporción 2:1?",
            arrayOf("Agua", "Dióxido de carbono", "Metano", "Ácido sulfúrico"),
            3,
            R.drawable.quimica,
            "Agua"
        )

        addQuestion(
            "¿Cuál es el elemento químico más reactivo y se encuentra en el grupo 1 de la tabla periódica?",
            arrayOf("Sodio", "Potasio", "Litio", "Rubidio"),
            3,
            R.drawable.quimica,
            "Francio"
        )

        addQuestion(
            "¿Cuál es el nombre del proceso químico en el cual un compuesto se descompone en elementos más simples debido a la aplicación de calor?",
            arrayOf("Descomposición térmica", "Reacción de síntesis", "Descomposición electrolítica", "Desplazamiento"),
            3,
            R.drawable.quimica,
            "Descomposición térmica"
        )

        // Preguntas de nivel medio de Química
        addQuestion(
            "¿Cuál es el número atómico del oxígeno?",
            arrayOf("6", "8", "14", "16"),
            2,
            R.drawable.quimica,
            "8"
        )

        addQuestion(
            "¿Cuál es el símbolo químico del sodio?",
            arrayOf("S", "Na", "K", "Mg"),
            2,
            R.drawable.quimica,
            "Na"
        )

        addQuestion(
            "¿Cuál es el nombre del proceso químico en el cual una sustancia se transforma en otra mediante la combinación de elementos?",
            arrayOf("Descomposición", "Reacción de síntesis", "Desplazamiento", "Oxidación"),
            2,
            R.drawable.quimica,
            "Reacción de síntesis"
        )

        addQuestion(
            "¿Cuál es el nombre del gas presente en mayor proporción en la atmósfera terrestre?",
            arrayOf("Oxígeno", "Dióxido de carbono", "Nitrógeno", "Argón"),
            2,
            R.drawable.quimica,
            "Nitrógeno"
        )

        addQuestion(
            "¿Cuál es el nombre del ácido presente en el jugo de limón?",
            arrayOf("Ácido clorhídrico", "Ácido acético", "Ácido cítrico", "Ácido sulfúrico"),
            2,
            R.drawable.quimica,
            "Ácido cítrico"
        )

        addQuestion(
            "¿Cuál es el símbolo químico del carbono?",
            arrayOf("C", "Ca", "Co", "Cu"),
            2,
            R.drawable.quimica,
            "C"
        )

        addQuestion(
            "¿Cuál es el nombre del proceso químico en el cual una sustancia pierde electrones?",
            arrayOf("Oxidación", "Reducción", "Ionización", "Neutralización"),
            2,
            R.drawable.quimica,
            "Oxidación"
        )

        addQuestion(
            "¿Cuál es el nombre del compuesto químico formado por sodio y cloro?",
            arrayOf("Cloruro de sodio", "Sulfato de sodio", "Carbonato de sodio", "Óxido de sodio"),
            2,
            R.drawable.quimica,
            "Cloruro de sodio"
        )

        addQuestion(
            "¿Cuál es el símbolo químico del oro?",
            arrayOf("O", "Au", "Ag", "Fe"),
            2,
            R.drawable.quimica,
            "Au"
        )

        addQuestion(
            "¿Cuál es el nombre del proceso químico en el cual una sustancia gana electrones?",
            arrayOf("Oxidación", "Reducción", "Ionización", "Neutralización"),
            2,
            R.drawable.quimica,
            "Reducción"
        )
// Preguntas fáciles de Química
        addQuestion(
            "¿Cuál es el número atómico del hidrógeno?",
            arrayOf("1", "2", "3", "4"),
            1,
            R.drawable.quimica,
            "1"
        )

        addQuestion(
            "¿Cuál es el símbolo químico del agua?",
            arrayOf("A", "H2O", "O2", "CO2"),
            1,
            R.drawable.quimica,
            "H2O"
        )

        addQuestion(
            "¿Cuál es el nombre del gas necesario para la combustión?",
            arrayOf("Oxígeno", "Nitrógeno", "Dióxido de carbono", "Hidrógeno"),
            1,
            R.drawable.quimica,
            "Oxígeno"
        )

        addQuestion(
            "¿Cuál es el símbolo químico del carbonato de sodio?",
            arrayOf("NaCO3", "NaCl", "NaOH", "Na2CO3"),
            1,
            R.drawable.quimica,
            "Na2CO3"
        )

        addQuestion(
            "¿Cuál es el nombre del gas que forma la capa que protege la Tierra de los rayos ultravioleta?",
            arrayOf("Ozono", "Nitrógeno", "Oxígeno", "Dióxido de carbono"),
            1,
            R.drawable.quimica,
            "Ozono"
        )

        addQuestion(
            "¿Cuál es el símbolo químico del hierro?",
            arrayOf("H", "He", "Fe", "Au"),
            1,
            R.drawable.quimica,
            "Fe"
        )

        addQuestion(
            "¿Cuál es el nombre del ácido presente en el estómago humano?",
            arrayOf("Ácido clorhídrico", "Ácido sulfúrico", "Ácido acético", "Ácido cítrico"),
            1,
            R.drawable.quimica,
            "Ácido clorhídrico"
        )

        addQuestion(
            "¿Cuál es el símbolo químico del helio?",
            arrayOf("He", "H", "Ho", "Hu"),
            1,
            R.drawable.quimica,
            "He"
        )

        addQuestion(
            "¿Cuál es el nombre del compuesto químico formado por oxígeno y carbono?",
            arrayOf("Dióxido de carbono", "Monóxido de carbono", "Óxido de carbono", "Carbonato de oxígeno"),
            1,
            R.drawable.quimica,
            "Dióxido de carbono"
        )

        addQuestion(
            "¿Cuál es el símbolo químico del sodio?",
            arrayOf("S", "Na", "So", "Sn"),
            1,
            R.drawable.quimica,
            "Na"
        )
// Preguntas específicas y complejas de Videojuegos
        addQuestion(
            "En el juego 'The Elder Scrolls V: Skyrim', ¿cuál es el nombre del protagonista controlado por el jugador?",
            arrayOf("Dovahkiin", "Alduin", "Fus Ro Dah", "Paarthurnax"),
            3,
            R.drawable.videojuegos,
            "Dovahkiin"
        )

        addQuestion(
            "¿Cuál es el título del juego que presentó la primera aparición del personaje 'Solid Snake'?",
            arrayOf("Metal Gear Solid", "Metal Gear", "Metal Gear Solid 2: Sons of Liberty", "Metal Gear Solid 3: Snake Eater"),
            3,
            R.drawable.videojuegos,
            "Metal Gear"
        )

        addQuestion(
            "En el juego 'The Legend of Zelda: Ocarina of Time', ¿cuál es el nombre del caballo de Link?",
            arrayOf("Epona", "Navi", "Ganondorf", "Impa"),
            3,
            R.drawable.videojuegos,
            "Epona"
        )

        addQuestion(
            "¿Cuál es el título del juego que introdujo el concepto de 'Bullet Time' y protagonizó Max Payne?",
            arrayOf("Max Payne", "Max Payne 2: The Fall of Max Payne", "Max Payne 3", "Alan Wake"),
            3,
            R.drawable.videojuegos,
            "Max Payne"
        )

        addQuestion(
            "En la saga 'Final Fantasy', ¿cuál es el número de la entrega que introdujo el sistema de esferas?",
            arrayOf("Final Fantasy VII", "Final Fantasy X", "Final Fantasy XIII", "Final Fantasy IX"),
            3,
            R.drawable.videojuegos,
            "Final Fantasy X"
        )

        addQuestion(
            "¿Cuál es el título del juego en el que el personaje principal, Geralt de Rivia, es conocido como el 'Lobo Blanco'?",
            arrayOf("The Witcher", "The Witcher 2: Assassins of Kings", "The Witcher 3: Wild Hunt", "The Witcher: Enhanced Edition"),
            3,
            R.drawable.videojuegos,
            "The Witcher 3: Wild Hunt"
        )

        addQuestion(
            "En el juego 'Dark Souls', ¿cuál es el nombre del rey que gobierna en Anor Londo?",
            arrayOf("Gwyn", "Nito", "Seath", "Artorias"),
            3,
            R.drawable.videojuegos,
            "Gwyn"
        )

        addQuestion(
            "¿Cuál es el título del juego que llevó a cabo el evento conocido como 'La Noche en la que Cayeron Estrellas'?",
            arrayOf("Final Fantasy VII", "Kingdom Hearts", "Nier: Automata", "Lost Odyssey"),
            3,
            R.drawable.videojuegos,
            "Nier: Automata"
        )

        addQuestion(
            "En el juego 'BioShock Infinite', ¿cuál es el nombre de la ciudad flotante donde se desarrolla la historia?",
            arrayOf("Rapture", "Columbia", "New York", "Elysium"),
            3,
            R.drawable.videojuegos,
            "Columbia"
        )

        addQuestion(
            "¿Cuál es el título del juego en el que el personaje principal, Joel, intenta llevar a Ellie a un lugar seguro en un mundo postapocalíptico?",
            arrayOf("The Last of Us", "Days Gone", "Metro Exodus", "State of Decay"),
            3,
            R.drawable.videojuegos,
            "The Last of Us"
        )
// Preguntas específicas y complejas de Videojuegos
        addQuestion(
            "En el juego 'The Elder Scrolls V: Skyrim', ¿cuál es el nombre del protagonista controlado por el jugador?",
            arrayOf("Dovahkiin", "Alduin", "Fus Ro Dah", "Paarthurnax"),
            3,
            R.drawable.videojuegos,
            "Dovahkiin"
        )

        addQuestion(
            "¿Cuál es el título del juego que presentó la primera aparición del personaje 'Solid Snake'?",
            arrayOf("Metal Gear Solid", "Metal Gear", "Metal Gear Solid 2: Sons of Liberty", "Metal Gear Solid 3: Snake Eater"),
            3,
            R.drawable.videojuegos,
            "Metal Gear"
        )

        addQuestion(
            "En el juego 'The Legend of Zelda: Ocarina of Time', ¿cuál es el nombre del caballo de Link?",
            arrayOf("Epona", "Navi", "Ganondorf", "Impa"),
            3,
            R.drawable.videojuegos,
            "Epona"
        )

        addQuestion(
            "¿Cuál es el título del juego que introdujo el concepto de 'Bullet Time' y protagonizó Max Payne?",
            arrayOf("Max Payne", "Max Payne 2: The Fall of Max Payne", "Max Payne 3", "Alan Wake"),
            3,
            R.drawable.videojuegos,
            "Max Payne"
        )

        addQuestion(
            "En la saga 'Final Fantasy', ¿cuál es el número de la entrega que introdujo el sistema de esferas?",
            arrayOf("Final Fantasy VII", "Final Fantasy X", "Final Fantasy XIII", "Final Fantasy IX"),
            3,
            R.drawable.videojuegos,
            "Final Fantasy X"
        )

        addQuestion(
            "¿Cuál es el título del juego en el que el personaje principal, Geralt de Rivia, es conocido como el 'Lobo Blanco'?",
            arrayOf("The Witcher", "The Witcher 2: Assassins of Kings", "The Witcher 3: Wild Hunt", "The Witcher: Enhanced Edition"),
            3,
            R.drawable.videojuegos,
            "The Witcher 3: Wild Hunt"
        )

        addQuestion(
            "En el juego 'Dark Souls', ¿cuál es el nombre del rey que gobierna en Anor Londo?",
            arrayOf("Gwyn", "Nito", "Seath", "Artorias"),
            3,
            R.drawable.videojuegos,
            "Gwyn"
        )

        addQuestion(
            "¿Cuál es el título del juego que llevó a cabo el evento conocido como 'La Noche en la que Cayeron Estrellas'?",
            arrayOf("Final Fantasy VII", "Kingdom Hearts", "Nier: Automata", "Lost Odyssey"),
            3,
            R.drawable.videojuegos,
            "Nier: Automata"
        )

        addQuestion(
            "En el juego 'BioShock Infinite', ¿cuál es el nombre de la ciudad flotante donde se desarrolla la historia?",
            arrayOf("Rapture", "Columbia", "New York", "Elysium"),
            3,
            R.drawable.videojuegos,
            "Columbia"
        )

        addQuestion(
            "¿Cuál es el título del juego en el que el personaje principal, Joel, intenta llevar a Ellie a un lugar seguro en un mundo postapocalíptico?",
            arrayOf("The Last of Us", "Days Gone", "Metro Exodus", "State of Decay"),
            3,
            R.drawable.videojuegos,
            "The Last of Us"
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

