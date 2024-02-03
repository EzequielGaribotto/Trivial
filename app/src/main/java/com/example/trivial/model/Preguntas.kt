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

        // Preguntas de historia
        addQuestion(
            "¿Quién pintó la Mona Lisa?",
            arrayOf("Leonardo da Vinci", "Vincent van Gogh", "Pablo Picasso", "Claude Monet"),
            2,
            R.drawable.historia,
            "Leonardo da Vinci"
        )

        addQuestion(
            "¿En qué año se celebró la primera edición de los premios Oscar?",
            arrayOf("1929", "1935", "1940", "1950"),
            1,
            R.drawable.historia,
            "1929"
        )

        addQuestion(
            "¿Quién escribió la obra 'Romeo y Julieta'?",
            arrayOf("William Shakespeare", "Miguel de Cervantes", "Jane Austen", "Charles Dickens"),
            2,
            R.drawable.historia,
            "William Shakespeare"
        )

        addQuestion(
            "¿Cuál es el período conocido como el Renacimiento?",
            arrayOf("Siglo XIV - Siglo XVI", "Siglo X - Siglo XII", "Siglo XVII - Siglo XIX", "Siglo V - Siglo IX"),
            3,
            R.drawable.historia,
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
            arrayOf("Francio", "Potasio", "Litio", "Rubidio"),
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

        // Añadir 10 preguntas fáciles de geografía

        addQuestion(
            "¿Cuál es el río más largo de Europa?",
            arrayOf("Volga", "Danubio", "Loira", "Támesis"),
            1,
            R.drawable.geografia,
            "Volga"
        )

        addQuestion(
            "¿En qué continente se encuentra el Polo Sur?",
            arrayOf("Antártida", "África", "Asia", "Oceanía"),
            1,
            R.drawable.geografia,
            "Antártida"
        )

        addQuestion(
            "¿Cuál es el país más poblado del mundo?",
            arrayOf("China", "India", "Estados Unidos", "Brasil"),
            1,
            R.drawable.geografia,
            "China"
        )

        addQuestion(
            "¿Cuál es el océano más grande?",
            arrayOf("Pacífico", "Atlántico", "Índico", "Ártico"),
            1,
            R.drawable.geografia,
            "Pacífico"
        )

        addQuestion(
            "¿En qué país se encuentra la Gran Muralla China?",
            arrayOf("China", "Japón", "Corea del Sur", "India"),
            1,
            R.drawable.geografia,
            "China"
        )

        addQuestion(
            "¿Cuál es la cadena montañosa que separa Europa de Asia?",
            arrayOf("Montes Urales", "Alpes", "Himalaya", "Andes"),
            1,
            R.drawable.geografia,
            "Montes Urales"
        )

        addQuestion(
            "¿Cuál es la capital de Francia?",
            arrayOf("París", "Londres", "Roma", "Berlín"),
            1,
            R.drawable.geografia,
            "París"
        )

        addQuestion(
            "¿En qué país se encuentra el desierto del Kalahari?",
            arrayOf("Sudáfrica", "Namibia", "Botswana", "Zimbabwe"),
            1,
            R.drawable.geografia,
            "Botswana"
        )

        addQuestion(
            "¿Cuál es el lago más profundo del mundo?",
            arrayOf("Lago Baikal", "Lago Superior", "Lago Titicaca", "Lago Victoria"),
            1,
            R.drawable.geografia,
            "Lago Baikal"
        )

        addQuestion(
            "¿En qué país se encuentra la ciudad de Machu Picchu?",
            arrayOf("Perú", "México", "Ecuador", "Colombia"),
            1,
            R.drawable.geografia,
            "Perú"
        )
// Añadir 10 preguntas normales de geografía

        addQuestion(
            "¿Cuál es el punto más alto de África?",
            arrayOf("Monte Kilimanjaro", "Monte Everest", "Monte Elbrús", "Monte McKinley"),
            2,
            R.drawable.geografia,
            "Monte Kilimanjaro"
        )

        addQuestion(
            "¿En qué país se encuentra la ciudad de Bangkok?",
            arrayOf("Tailandia", "Indonesia", "Vietnam", "Malasia"),
            2,
            R.drawable.geografia,
            "Tailandia"
        )

        addQuestion(
            "¿Cuál es la capital de Canadá?",
            arrayOf("Ottawa", "Toronto", "Vancouver", "Montreal"),
            2,
            R.drawable.geografia,
            "Ottawa"
        )

        addQuestion(
            "¿En qué país se encuentra el lago Titicaca?",
            arrayOf("Perú", "Bolivia", "Chile", "Argentina"),
            2,
            R.drawable.geografia,
            "Perú"
        )

        addQuestion(
            "¿Cuál es el país más grande de América Latina?",
            arrayOf("Brasil", "Argentina", "México", "Colombia"),
            2,
            R.drawable.geografia,
            "Brasil"
        )

        addQuestion(
            "¿En qué continente se encuentra el río Congo?",
            arrayOf("África", "Asia", "América del Norte", "Europa"),
            2,
            R.drawable.geografia,
            "África"
        )

        addQuestion(
            "¿Cuál es la capital de Noruega?",
            arrayOf("Oslo", "Estocolmo", "Copenhague", "Helsinki"),
            2,
            R.drawable.geografia,
            "Oslo"
        )

        addQuestion(
            "¿En qué país se encuentra la Gran Barrera de Coral?",
            arrayOf("Australia", "Indonesia", "Filipinas", "Tailandia"),
            2,
            R.drawable.geografia,
            "Australia"
        )

        addQuestion(
            "¿Cuál es el país más pequeño del mundo?",
            arrayOf("Vaticano", "Mónaco", "San Marino", "Liechtenstein"),
            2,
            R.drawable.geografia,
            "Vaticano"
        )

        addQuestion(
            "¿En qué país se encuentra el río Misisipi?",
            arrayOf("Estados Unidos", "Canadá", "México", "Brasil"),
            2,
            R.drawable.geografia,
            "Estados Unidos"
        )

// Añadir 15 preguntas difíciles de geografía

        addQuestion(
            "¿Cuál es la capital de Lesoto?",
            arrayOf("Maseru", "Lusaka", "Maputo", "Libreville"),
            3,
            R.drawable.geografia,
            "Maseru"
        )

        addQuestion(
            "¿En qué país se encuentra el monte Fitz Roy?",
            arrayOf("Argentina", "Chile", "Perú", "Bolivia"),
            3,
            R.drawable.geografia,
            "Argentina"
        )

        addQuestion(
            "¿Cuál es el país más poblado de África?",
            arrayOf("Nigeria", "Etiopía", "Egipto", "Sudáfrica"),
            3,
            R.drawable.geografia,
            "Nigeria"
        )

        addQuestion(
            "¿En qué continente se encuentra el río Lena?",
            arrayOf("Asia", "Europa", "África", "Oceanía"),
            3,
            R.drawable.geografia,
            "Asia"
        )

        addQuestion(
            "¿Cuál es la capital de Malí?",
            arrayOf("Bamako", "Dakar", "Abiyán", "Lagos"),
            3,
            R.drawable.geografia,
            "Bamako"
        )

        addQuestion(
            "¿En qué país se encuentra la isla de Borneo?",
            arrayOf("Indonesia", "Malasia", "Filipinas", "Singapur"),
            3,
            R.drawable.geografia,
            "Indonesia"
        )

        addQuestion(
            "¿Cuál es el país más pequeño de América Central?",
            arrayOf("El Salvador", "Belice", "Honduras", "Nicaragua"),
            3,
            R.drawable.geografia,
            "Belice"
        )

        addQuestion(
            "¿En qué océano se encuentra la isla de Madagascar?",
            arrayOf("Océano Índico", "Océano Atlántico", "Océano Pacífico", "Océano Ártico"),
            3,
            R.drawable.geografia,
            "Océano Índico"
        )

        addQuestion(
            "¿Cuál es el país más extenso de África?",
            arrayOf("Argelia", "República Democrática del Congo", "Sudán", "Libia"),
            3,
            R.drawable.geografia,
            "Argelia"
        )

        addQuestion(
            "¿En qué país se encuentra el río Paraná?",
            arrayOf("Argentina", "Brasil", "Paraguay", "Uruguay"),
            3,
            R.drawable.geografia,
            "Argentina"
        )

        addQuestion(
            "¿Cuál es la capital de Mongolia?",
            arrayOf("Ulán Bator", "Pekín", "Seúl", "Astana"),
            3,
            R.drawable.geografia,
            "Ulán Bator"
        )

        addQuestion(
            "¿En qué país se encuentra el lago Baljash?",
            arrayOf("Kazajistán", "Rusia", "Turkmenistán", "Uzbekistán"),
            3,
            R.drawable.geografia,
            "Kazajistán"
        )

        addQuestion(
            "¿Cuál es la capital de Etiopía?",
            arrayOf("Adís Abeba", "Nairobi", "Yamena", "Djibouti"),
            3,
            R.drawable.geografia,
            "Adís Abeba"
        )

        addQuestion(
            "¿En qué país se encuentra el cabo de Buena Esperanza?",
            arrayOf("Sudáfrica", "Argentina", "Australia", "Canadá"),
            3,
            R.drawable.geografia,
            "Sudáfrica"
        )

        addQuestion(
            "¿Cuál es la isla más grande del archipiélago de Hawái?",
            arrayOf("Hawái Grande", "Maui", "Oahu", "Kauai"),
            3,
            R.drawable.geografia,
            "Hawái Grande"
        )

        // Añadir 5 preguntas normales de deportes

        addQuestion(
            "¿En qué deporte se utiliza una red y una pelota ligera con plumas?",
            arrayOf("Bádminton", "Tenis de mesa", "Vóley playa", "Pádel"),
            2,
            R.drawable.deportes,
            "Bádminton"
        )

        addQuestion(
            "¿Cuál es el equipo de fútbol más antiguo del mundo?",
            arrayOf("Sheffield FC", "Manchester United", "Real Madrid", "AC Milan"),
            2,
            R.drawable.deportes,
            "Sheffield FC"
        )

        addQuestion(
            "¿En qué año se celebró la primera edición de la Copa Mundial de la FIFA?",
            arrayOf("1930", "1950", "1960", "1980"),
            2,
            R.drawable.deportes,
            "1930"
        )

        addQuestion(
            "¿Cuál es el jugador de tenis con más títulos de Grand Slam en la historia?",
            arrayOf("Roger Federer", "Rafael Nadal", "Novak Djokovic", "Pete Sampras"),
            2,
            R.drawable.deportes,
            "Roger Federer"
        )

        addQuestion(
            "¿En qué deporte se compite en la categoría de peso pluma?",
            arrayOf("Boxeo", "Lucha libre", "Judo", "Halterofilia"),
            2,
            R.drawable.deportes,
            "Boxeo"
        )

        // Añadir 10 preguntas difíciles de deportes

        addQuestion(
            "¿Cuál es el único país que ha participado en todos los Juegos Olímpicos de Verano desde su inicio en 1896?",
            arrayOf("Grecia", "Estados Unidos", "Reino Unido", "Francia"),
            3,
            R.drawable.deportes,
            "Grecia"
        )

        addQuestion(
            "¿En qué año se introdujo el rugby en los Juegos Olímpicos modernos?",
            arrayOf("1900", "1920", "1936", "1960"),
            3,
            R.drawable.deportes,
            "1900"
        )

        addQuestion(
            "¿Cuántos jugadores forman un equipo de waterpolo durante un partido?",
            arrayOf("6", "7", "8", "9"),
            3,
            R.drawable.deportes,
            "7"
        )

        addQuestion(
            "¿Cuál es el deporte nacional de Canadá?",
            arrayOf("Hockey sobre hielo", "Lacrosse", "Fútbol", "Béisbol"),
            3,
            R.drawable.deportes,
            "Hockey sobre hielo"
        )

        addQuestion(
            "¿Cuál es el récord de más puntos anotados en un solo juego de la NBA?",
            arrayOf("100 puntos", "81 puntos", "70 puntos", "63 puntos"),
            3,
            R.drawable.deportes,
            "100 puntos"
        )

        addQuestion(
            "¿En qué país se originó el cricket?",
            arrayOf("Inglaterra", "India", "Australia", "Sudáfrica"),
            3,
            R.drawable.deportes,
            "Inglaterra"
        )

        addQuestion(
            "¿Cuál es la distancia oficial de una maratón?",
            arrayOf("42.195 kilómetros", "38.5 kilómetros", "50 kilómetros", "35 kilómetros"),
            3,
            R.drawable.deportes,
            "42.195 kilómetros"
        )

        addQuestion(
            "¿Cuántas medallas de oro olímpicas ha ganado Usain Bolt en carreras de velocidad?",
            arrayOf("8", "9", "7", "6"),
            3,
            R.drawable.deportes,
            "8"
        )

        addQuestion(
            "¿En qué deporte se utiliza un bate de hurling?",
            arrayOf("Hurling", "Críquet", "Béisbol", "Softbol"),
            3,
            R.drawable.deportes,
            "Hurling"
        )

        addQuestion(
            "¿Quién es considerado el mejor jugador de fútbol americano de todos los tiempos?",
            arrayOf("Tom Brady", "Peyton Manning", "Jerry Rice", "Jim Brown"),
            3,
            R.drawable.deportes,
            "Jerry Rice"
        )

        // Añadir 15 preguntas fáciles de historia

        addQuestion(
            "¿En qué año se firmó la Declaración de Independencia de Estados Unidos?",
            arrayOf("1776", "1789", "1792", "1801"),
            1,
            R.drawable.historia,
            "1776"
        )

        addQuestion(
            "¿Quién fue el primer presidente de Estados Unidos?",
            arrayOf("George Washington", "Thomas Jefferson", "John Adams", "James Madison"),
            1,
            R.drawable.historia,
            "George Washington"
        )

        addQuestion(
            "¿En qué año comenzó la Primera Guerra Mundial?",
            arrayOf("1914", "1917", "1920", "1919"),
            1,
            R.drawable.historia,
            "1914"
        )

        addQuestion(
            "¿Cuál fue la primera civilización antigua en Mesopotamia?",
            arrayOf("Sumeria", "Babilonia", "Asiria", "Acadia"),
            1,
            R.drawable.historia,
            "Sumeria"
        )

        addQuestion(
            "¿Quién fue el líder de la Revolución Rusa en 1917?",
            arrayOf("Vladimir Lenin", "Joseph Stalin", "Leon Trotsky", "Nicholas II"),
            1,
            R.drawable.historia,
            "Vladimir Lenin"
        )

        addQuestion(
            "¿En qué año se firmó el Tratado de Versalles que puso fin a la Primera Guerra Mundial?",
            arrayOf("1919", "1921", "1923", "1925"),
            1,
            R.drawable.historia,
            "1919"
        )

        addQuestion(
            "¿Cuál fue el evento que marcó el inicio de la Revolución Francesa en 1789?",
            arrayOf("Toma de la Bastilla", "Declaración de los Derechos del Hombre", "Asamblea Nacional Constituyente", "Rey Luis XVI ejecutado"),
            1,
            R.drawable.historia,
            "Toma de la Bastilla"
        )

        addQuestion(
            "¿Quién fue el líder de la Revolución Cubana en 1959?",
            arrayOf("Fidel Castro", "Che Guevara", "Batista", "Camilo Cienfuegos"),
            1,
            R.drawable.historia,
            "Fidel Castro"
        )

        addQuestion(
            "¿En qué año finalizó la Segunda Guerra Mundial?",
            arrayOf("1945", "1942", "1947", "1950"),
            1,
            R.drawable.historia,
            "1945"
        )

        addQuestion(
            "¿Cuál fue la batalla que puso fin a la Guerra Civil Estadounidense?",
            arrayOf("Batalla de Gettysburg", "Batalla de Antietam", "Batalla de Appomattox", "Batalla de Bull Run"),
            1,
            R.drawable.historia,
            "Batalla de Appomattox"
        )

        addQuestion(
            "¿En qué año se fundó la Liga de Naciones?",
            arrayOf("1920", "1918", "1930", "1915"),
            1,
            R.drawable.historia,
            "1920"
        )

        addQuestion(
            "¿Quién fue el líder de la Revolución China y fundador de la República Popular China?",
            arrayOf("Mao Zedong", "Chiang Kai-shek", "Sun Yat-sen", "Deng Xiaoping"),
            1,
            R.drawable.historia,
            "Mao Zedong"
        )

        addQuestion(
            "¿En qué año se produjo la Revolución Industrial en Inglaterra?",
            arrayOf("Siglo XVIII", "Siglo XIX", "Siglo XVII", "Siglo XX"),
            1,
            R.drawable.historia,
            "Siglo XVIII"
        )

        addQuestion(
            "¿Quién fue el líder de la Unión Soviética durante la Segunda Guerra Mundial?",
            arrayOf("Joseph Stalin", "Vladimir Lenin", "Nikita Jrushchov", "Mikhail Gorbachev"),
            1,
            R.drawable.historia,
            "Joseph Stalin"
        )

        addQuestion(
            "¿En qué año llegó Cristóbal Colón a América?",
            arrayOf("1492", "1500", "1488", "1510"),
            1,
            R.drawable.historia,
            "1492"
        )

        // Añadir 15 preguntas normales de historia

        addQuestion(
            "¿En qué año se firmó el Tratado de Tordesillas?",
            arrayOf("1494", "1500", "1488", "1510"),
            2,
            R.drawable.historia,
            "1494"
        )

        addQuestion(
            "¿Cuál fue la dinastía gobernante en China durante la construcción de la Gran Muralla?",
            arrayOf("Dinastía Qin", "Dinastía Ming", "Dinastía Tang", "Dinastía Song"),
            2,
            R.drawable.historia,
            "Dinastía Qin"
        )

        addQuestion(
            "¿Quién fue el presidente de Estados Unidos durante la Guerra Civil?",
            arrayOf("Abraham Lincoln", "Andrew Johnson", "Ulysses S. Grant", "James Buchanan"),
            2,
            R.drawable.historia,
            "Abraham Lincoln"
        )

        addQuestion(
            "¿En qué año se firmó el Acta de Independencia de México?",
            arrayOf("1821", "1810", "1836", "1848"),
            2,
            R.drawable.historia,
            "1821"
        )

        addQuestion(
            "¿Cuál fue la batalla que marcó la derrota de Napoleón en 1815?",
            arrayOf("Batalla de Waterloo", "Batalla de Leipzig", "Batalla de Austerlitz", "Batalla de Borodinó"),
            2,
            R.drawable.historia,
            "Batalla de Waterloo"
        )

        addQuestion(
            "¿Quién fue el líder de la Revolución Mexicana?",
            arrayOf("Emiliano Zapata", "Francisco Villa", "Venustiano Carranza", "Porfirio Díaz"),
            2,
            R.drawable.historia,
            "Emiliano Zapata"
        )

        addQuestion(
            "¿En qué año se fundó la Liga de las Naciones?",
            arrayOf("1920", "1919", "1925", "1930"),
            2,
            R.drawable.historia,
            "1920"
        )

        addQuestion(
            "¿Cuál fue la causa principal de la Revolución Rusa de 1917?",
            arrayOf("Descontento popular", "Participación en la Primera Guerra Mundial", "Crisis económica", "Influencia extranjera"),
            2,
            R.drawable.historia,
            "Participación en la Primera Guerra Mundial"
        )

        addQuestion(
            "¿En qué año se produjo la Revolución Francesa?",
            arrayOf("1789", "1792", "1776", "1801"),
            2,
            R.drawable.historia,
            "1789"
        )

        addQuestion(
            "¿Cuál fue la famosa expedición de Lewis y Clark?",
            arrayOf("Exploración del oeste de América del Norte", "Exploración del Polo Norte", "Exploración del Amazonas", "Exploración de Australia"),
            2,
            R.drawable.historia,
            "Exploración del oeste de América del Norte"
        )

        addQuestion(
            "¿Quién fue el líder de la Revolución Industrial en Inglaterra?",
            arrayOf("James Watt", "Adam Smith", "Richard Arkwright", "George Stephenson"),
            2,
            R.drawable.historia,
            "Richard Arkwright"
        )

        addQuestion(
            "¿En qué año se proclamó la independencia de Brasil?",
            arrayOf("1822", "1808", "1836", "1845"),
            2,
            R.drawable.historia,
            "1822"
        )

        addQuestion(
            "¿Cuál fue el evento que desencadenó la entrada de Estados Unidos en la Segunda Guerra Mundial?",
            arrayOf("Ataque a Pearl Harbor", "Batalla de Normandía", "Bombardeo de Hiroshima", "Invasión de Polonia"),
            2,
            R.drawable.historia,
            "Ataque a Pearl Harbor"
        )

        addQuestion(
            "¿Quién fue el líder de la Revolución Bolchevique en Rusia?",
            arrayOf("Vladimir Lenin", "Leon Trotsky", "Joseph Stalin", "Nicholas II"),
            2,
            R.drawable.historia,
            "Vladimir Lenin"
        )

        addQuestion(
            "¿En qué año se firmó el Tratado de París que puso fin a la Guerra de Independencia de Estados Unidos?",
            arrayOf("1783", "1776", "1792", "1801"),
            2,
            R.drawable.historia,
            "1783"
        )
// Añadir 15 preguntas difíciles de historia

        addQuestion(
            "¿En qué año se fundó la dinastía Ming en China?",
            arrayOf("1368", "1420", "1297", "1455"),
            3,
            R.drawable.historia,
            "1368"
        )

        addQuestion(
            "¿Cuál fue la batalla que marcó el fin del Imperio Romano de Occidente en el año 476 d.C.?",
            arrayOf("Batalla de Adrianópolis", "Batalla de Gaugamela", "Batalla de Cannae", "Batalla de Útica"),
            3,
            R.drawable.historia,
            "Batalla de Útica"
        )

        addQuestion(
            "¿Quién fue el faraón que construyó la Gran Pirámide de Giza en Egipto?",
            arrayOf("Keops", "Kefrén", "Micerino", "Hatshepsut"),
            3,
            R.drawable.historia,
            "Keops"
        )

        addQuestion(
            "¿En qué año se firmó el Tratado de Nankín, poniendo fin a la Primera Guerra del Opio?",
            arrayOf("1842", "1850", "1836", "1865"),
            3,
            R.drawable.historia,
            "1842"
        )

        addQuestion(
            "¿Cuál fue la batalla decisiva de las Guerras Púnicas en la que Aníbal fue derrotado por las legiones romanas?",
            arrayOf("Batalla de Cannae", "Batalla de Zama", "Batalla de Trebia", "Batalla de Metauro"),
            3,
            R.drawable.historia,
            "Batalla de Zama"
        )

        addQuestion(
            "¿Quién fue el emperador romano conocido por su persecución a los cristianos y su fundación de Constantinopla?",
            arrayOf("Constantino el Grande", "Diocleciano", "Nerón", "Marco Aurelio"),
            3,
            R.drawable.historia,
            "Constantino el Grande"
        )

        addQuestion(
            "¿Cuál fue la principal causa de la Revuelta Taiping en China durante el siglo XIX?",
            arrayOf("Desigualdad social", "Guerra de Opio", "Corrupción gubernamental", "Persecución religiosa"),
            3,
            R.drawable.historia,
            "Desigualdad social"
        )

        addQuestion(
            "¿En qué año se inició la Revuelta de los Boxers en China?",
            arrayOf("1899", "1905", "1888", "1912"),
            3,
            R.drawable.historia,
            "1899"
        )

        addQuestion(
            "¿Cuál fue la batalla que marcó el fin de la Reconquista en España en 1492?",
            arrayOf("Batalla de Las Navas de Tolosa", "Batalla de Granada", "Batalla de Guadalete", "Batalla de Covadonga"),
            3,
            R.drawable.historia,
            "Batalla de Granada"
        )

        addQuestion(
            "¿Quién fue el líder de la Revolución Haitiana que llevó a la independencia de Haití?",
            arrayOf("Toussaint Louverture", "Jean-Jacques Dessalines", "Henri Christophe", "Alexandre Pétion"),
            3,
            R.drawable.historia,
            "Jean-Jacques Dessalines"
        )

        addQuestion(
            "¿Cuál fue el evento que marcó el inicio de la Revolución Industrial en Inglaterra?",
            arrayOf("Invención de la máquina de vapor", "Descubrimiento de la electricidad", "Construcción del ferrocarril", "Desarrollo de la imprenta"),
            3,
            R.drawable.historia,
            "Invención de la máquina de vapor"
        )

        addQuestion(
            "¿En qué año se produjo la Revolución Mexicana?",
            arrayOf("1910", "1920", "1899", "1935"),
            3,
            R.drawable.historia,
            "1910"
        )

        addQuestion(
            "¿Quién fue el líder de la Revuelta de los Comuneros en Colombia durante el siglo XVI?",
            arrayOf("Gonzalo Jiménez de Quesada", "Antonio Nariño", "Juan de la Cruz", "Simón Bolívar"),
            3,
            R.drawable.historia,
            "Gonzalo Jiménez de Quesada"
        )

        addQuestion(
            "¿En qué año se inició la Guerra de los Treinta Años en Europa?",
            arrayOf("1618", "1648", "1587", "1635"),
            3,
            R.drawable.historia,
            "1618"
        )

        addQuestion(
            "¿Cuál fue la expedición que llevó a la independencia de las colonias hispanoamericanas liderada por Simón Bolívar?",
            arrayOf("Campaña del Sur", "Campaña Admirable", "Campaña del Pacífico", "Campaña de Quito"),
            3,
            R.drawable.historia,
            "Campaña Admirable"
        )
// Añadir 15 preguntas fáciles de matemáticas

        addQuestion(
            "¿Cuál es el resultado de sumar 5 + 7?",
            arrayOf("12", "10", "14", "8"),
            1,
            R.drawable.matematicas,
            "12"
        )

        addQuestion(
            "¿Cuál es la raíz cuadrada de 25?",
            arrayOf("5", "4", "6", "7"),
            1,
            R.drawable.matematicas,
            "5"
        )

        addQuestion(
            "¿Cuánto es 8 multiplicado por 3?",
            arrayOf("24", "18", "21", "27"),
            1,
            R.drawable.matematicas,
            "24"
        )

        addQuestion(
            "¿Cuál es el resultado de restar 9 a 15?",
            arrayOf("6", "8", "10", "12"),
            1,
            R.drawable.matematicas,
            "6"
        )

        addQuestion(
            "¿Cuánto es 3 elevado a la potencia de 2?",
            arrayOf("9", "6", "5", "12"),
            1,
            R.drawable.matematicas,
            "9"
        )

        addQuestion(
            "¿Cuánto es 20 dividido por 4?",
            arrayOf("5", "4", "6", "3"),
            1,
            R.drawable.matematicas,
            "5"
        )

        addQuestion(
            "¿Cuál es el resultado de sumar 2.5 + 3.2?",
            arrayOf("5.7", "6.2", "5.0", "4.8"),
            1,
            R.drawable.matematicas,
            "5.7"
        )

        addQuestion(
            "¿Cuánto es la mitad de 16?",
            arrayOf("8", "6", "4", "10"),
            1,
            R.drawable.matematicas,
            "8"
        )

        addQuestion(
            "¿Cuál es el área de un cuadrado con lado de longitud 6 unidades?",
            arrayOf("36", "24", "30", "18"),
            1,
            R.drawable.matematicas,
            "36"
        )

        addQuestion(
            "¿Cuánto es 15 porcentualmente de 60?",
            arrayOf("9", "12", "15", "18"),
            1,
            R.drawable.matematicas,
            "9"
        )

        addQuestion(
            "¿Cuál es el resultado de sumar todos los números del 1 al 10?",
            arrayOf("55", "45", "50", "60"),
            1,
            R.drawable.matematicas,
            "55"
        )

        addQuestion(
            "¿Cuál es el resultado de multiplicar 5 por la suma de 3 y 4?",
            arrayOf("35", "30", "25", "20"),
            1,
            R.drawable.matematicas,
            "35"
        )

        addQuestion(
            "¿Cuánto es la tercera parte de 27?",
            arrayOf("9", "6", "8", "12"),
            1,
            R.drawable.matematicas,
            "9"
        )

        addQuestion(
            "¿Cuánto es 2 elevado a la potencia de 4?",
            arrayOf("16", "8", "32", "64"),
            1,
            R.drawable.matematicas,
            "16"
        )

        addQuestion(
            "¿Cuánto es la raíz cuadrada de 16?",
            arrayOf("4", "5", "3", "6"),
            1,
            R.drawable.matematicas,
            "4"
        )

// Añadir 15 preguntas normales de matemáticas

        addQuestion(
            "¿Cuánto es 3/4 como decimal?",
            arrayOf("0.75", "0.5", "0.25", "1.0"),
            2,
            R.drawable.matematicas,
            "0.75"
        )

        addQuestion(
            "¿Cuál es el resultado de la siguiente expresión: 2 + 3 * 4?",
            arrayOf("14", "20", "18", "25"),
            2,
            R.drawable.matematicas,
            "14"
        )

        addQuestion(
            "Si a = 4 y b = 7, ¿cuál es el valor de a + b?",
            arrayOf("11", "12", "9", "15"),
            2,
            R.drawable.matematicas,
            "11"
        )

        addQuestion(
            "¿Cuánto es la raíz cuadrada de 49?",
            arrayOf("7", "6", "8", "5"),
            2,
            R.drawable.matematicas,
            "7"
        )

        addQuestion(
            "¿Cuánto es 15% de 80?",
            arrayOf("12", "10", "8", "6"),
            2,
            R.drawable.matematicas,
            "12"
        )

        addQuestion(
            "¿Cuál es el resultado de la siguiente ecuación: 2x - 5 = 11?",
            arrayOf("8", "9", "10", "12"),
            2,
            R.drawable.matematicas,
            "8"
        )

        addQuestion(
            "Si a = 6 y b = 2, ¿cuál es el valor de a * b?",
            arrayOf("12", "8", "14", "10"),
            2,
            R.drawable.matematicas,
            "12"
        )

        addQuestion(
            "¿Cuánto es la suma de los ángulos internos de un triángulo?",
            arrayOf("180 grados", "90 grados", "270 grados", "360 grados"),
            2,
            R.drawable.matematicas,
            "180 grados"
        )

        addQuestion(
            "¿Cuál es el resultado de la siguiente operación: (8 + 2) * 3 / 2?",
            arrayOf("15", "20", "12", "10"),
            2,
            R.drawable.matematicas,
            "15"
        )

        addQuestion(
            "Si x = 5 y y = 3, ¿cuánto es x^2 + y^2?",
            arrayOf("34", "28", "29", "26"),
            2,
            R.drawable.matematicas,
            "34"
        )

        addQuestion(
            "¿Cuánto es 2/3 como porcentaje?",
            arrayOf("66.67%", "50%", "33.33%", "25%"),
            2,
            R.drawable.matematicas,
            "66.67%"
        )

        addQuestion(
            "¿Cuántos lados tiene un hexágono?",
            arrayOf("6", "5", "7", "8"),
            2,
            R.drawable.matematicas,
            "6"
        )

        addQuestion(
            "¿Cuál es el resultado de la siguiente expresión: 4^3?",
            arrayOf("64", "16", "32", "128"),
            2,
            R.drawable.matematicas,
            "64"
        )

        addQuestion(
            "¿Cuánto es 9 dividido por 3?",
            arrayOf("3", "4", "2", "5"),
            2,
            R.drawable.matematicas,
            "3")
// Añadir 10 preguntas difíciles de matemáticas

        addQuestion(
            "¿Cuál es el valor de la constante matemática 'e' elevada a la potencia de 0?",
            arrayOf("1", "0", "e", "∞"),
            3,
            R.drawable.matematicas,
            "1"
        )

        addQuestion(
            "¿Cuántos divisores tiene el número 360?",
            arrayOf("24", "20", "16", "30"),
            3,
            R.drawable.matematicas,
            "24"
        )

        addQuestion(
            "¿Cuál es el valor de la suma infinita: 1 + 1/2 + 1/4 + 1/8 + ...?",
            arrayOf("2", "1", "∞", "0"),
            3,
            R.drawable.matematicas,
            "2"
        )

        addQuestion(
            "¿Cuál es la solución de la ecuación cuadrática: x^2 - 5x + 6 = 0?",
            arrayOf("3 y 2", "2 y 4", "1 y 5", "6 y 1"),
            3,
            R.drawable.matematicas,
            "3 y 2"
        )

        addQuestion(
            "¿Cuál es el área de un círculo con radio 5 unidades?",
            arrayOf("78.54", "31.42", "50.27", "25.13"),
            3,
            R.drawable.matematicas,
            "78.54"
        )

        addQuestion(
            "¿Cuál es el resultado de la siguiente serie geométrica: 3 + 6 + 12 + 24 + ...?",
            arrayOf("48", "36", "72", "60"),
            3,
            R.drawable.matematicas,
            "48"
        )

        addQuestion(
            "¿Cuál es el logaritmo base 2 de 64?",
            arrayOf("6", "4", "3", "5"),
            3,
            R.drawable.matematicas,
            "6"
        )

        addQuestion(
            "¿Cuál es la probabilidad de obtener dos caras al lanzar una moneda dos veces?",
            arrayOf("1/4", "1/2", "3/4", "1/3"),
            3,
            R.drawable.matematicas,
            "1/4"
        )

        addQuestion(
            "¿Cuántos números primos hay entre 1 y 50?",
            arrayOf("15", "12", "10", "14"),
            3,
            R.drawable.matematicas,
            "15"
        )

        addQuestion(
            "Si a = 3 y b = 4, ¿cuál es el valor de la hipotenusa en un triángulo rectángulo con catetos a y b?",
            arrayOf("5", "7", "8", "6"),
            3,
            R.drawable.matematicas,
            "5"
        )

// Añadir 5 preguntas fáciles de química

        addQuestion(
            "¿Cuál es el símbolo químico del oxígeno?",
            arrayOf("O", "O2", "H2O", "CO2"),
            1,
            R.drawable.quimica,
            "O"
        )

        addQuestion(
            "¿Cuántos electrones tiene un átomo de hidrógeno?",
            arrayOf("1", "2", "0", "3"),
            1,
            R.drawable.quimica,
            "1"
        )

        addQuestion(
            "¿Cuál es el pH neutro?",
            arrayOf("7", "5", "10", "3"),
            1,
            R.drawable.quimica,
            "7"
        )

        addQuestion(
            "¿Cuál es el componente principal del aire?",
            arrayOf("Nitrógeno", "Oxígeno", "Dióxido de carbono", "Argón"),
            1,
            R.drawable.quimica,
            "Nitrógeno"
        )

        addQuestion(
            "¿Cuál es el elemento más abundante en la corteza terrestre?",
            arrayOf("Oxígeno", "Hierro", "Silicio", "Aluminio"),
            1,
            R.drawable.quimica,
            "Oxígeno"
        )

        // Añadir 10 preguntas normales de química

        addQuestion(
            "¿Cuál es la fórmula química del agua oxigenada?",
            arrayOf("H2O2", "HO2", "H2O", "H2O3"),
            2,
            R.drawable.quimica,
            "H2O2"
        )

        addQuestion(
            "¿Cuál es el símbolo químico del sodio?",
            arrayOf("Na", "So", "Sn", "Si"),
            2,
            R.drawable.quimica,
            "Na"
        )

        addQuestion(
            "¿Cuál es el proceso de conversión de un gas a líquido?",
            arrayOf("Condensación", "Evaporación", "Solidificación", "Sublimación"),
            2,
            R.drawable.quimica,
            "Condensación"
        )

        addQuestion(
            "¿Cuál es la masa molar del oxígeno?",
            arrayOf("16 g/mol", "18 g/mol", "20 g/mol", "14 g/mol"),
            2,
            R.drawable.quimica,
            "16 g/mol"
        )

        addQuestion(
            "¿Cuál es el símbolo químico del cloro?",
            arrayOf("Cl", "Co", "Cr", "Ca"),
            2,
            R.drawable.quimica,
            "Cl"
        )

        addQuestion(
            "¿Cuál es la reacción química básica de la fotosíntesis?",
            arrayOf("6 CO2 + 6 H2O -> C6H12O6 + 6 O2", "C6H12O6 + 6 O2 -> 6 CO2 + 6 H2O", "H2O + O2 -> H2O2", "2 H2O -> 2 H2 + O2"),
            2,
            R.drawable.quimica,
            "6 CO2 + 6 H2O -> C6H12O6 + 6 O2"
        )

        addQuestion(
            "¿Cuál es la unidad básica de la estructura de los compuestos orgánicos?",
            arrayOf("Átomo", "Molécula", "Célula", "Elemento"),
            2,
            R.drawable.quimica,
            "Molécula"
        )

        addQuestion(
            "¿Cuál es el componente principal del gas natural?",
            arrayOf("Metano", "Etano", "Propano", "Butano"),
            2,
            R.drawable.quimica,
            "Metano"
        )

        addQuestion(
            "¿Qué tipo de enlace químico se forma cuando dos átomos comparten electrones?",
            arrayOf("Enlace covalente", "Enlace iónico", "Enlace metálico", "Enlace de hidrógeno"),
            2,
            R.drawable.quimica,
            "Enlace covalente"
        )

        addQuestion(
            "¿Cuál es el elemento químico presente en todos los aminoácidos?",
            arrayOf("Carbono", "Hidrógeno", "Nitrógeno", "Oxígeno"),
            2,
            R.drawable.quimica,
            "Nitrógeno"
        )
// Añadir 10 preguntas difíciles de química

        addQuestion(
            "¿Cuál es la constante de Avogadro?",
            arrayOf("6.02 x 10^23 mol^-1", "4.56 x 10^22 mol^-1", "8.34 x 10^-23 mol^-1", "1.23 x 10^24 mol^-1"),
            3,
            R.drawable.quimica,
            "6.02 x 10^23 mol^-1"
        )

        addQuestion(
            "¿Cuántos elementos tiene la tabla periódica actualmente?",
            arrayOf("118", "92", "110", "103"),
            3,
            R.drawable.quimica,
            "118"
        )

        addQuestion(
            "¿Cuál es el proceso de descomposición de un compuesto mediante el paso de una corriente eléctrica?",
            arrayOf("Electrólisis", "Fotólisis", "Termólisis", "Hidrólisis"),
            3,
            R.drawable.quimica,
            "Electrólisis"
        )

        addQuestion(
            "¿Cuál es la ecuación química balanceada para la reacción de combustión completa del metano?",
            arrayOf("CH4 + 2O2 -> CO2 + 2H2O", "C2H6 + O2 -> CO2 + H2O", "CH4 + O2 -> CO + 2H2O", "C3H8 + 3O2 -> CO2 + 4H2O"),
            3,
            R.drawable.quimica,
            "CH4 + 2O2 -> CO2 + 2H2O"
        )

        addQuestion(
            "¿Cuál es la estructura molecular del dióxido de carbono (CO2)?",
            arrayOf("Lineal", "Angular", "Tetraédrica", "Trigonal plana"),
            3,
            R.drawable.quimica,
            "Lineal"
        )

        addQuestion(
            "¿Cuál es el nombre del proceso mediante el cual un sólido pasa directamente al estado gaseoso sin pasar por el estado líquido?",
            arrayOf("Sublimación", "Evaporación", "Fusión", "Condensación"),
            3,
            R.drawable.quimica,
            "Sublimación"
        )

        addQuestion(
            "¿Cuántos enlaces covalentes hay en una molécula de metano (CH4)?",
            arrayOf("4", "2", "3", "5"),
            3,
            R.drawable.quimica,
            "4"
        )

        addQuestion(
            "¿Cuál es la ecuación química que representa la neutralización completa entre ácido clorhídrico (HCl) y hidróxido de sodio (NaOH)?",
            arrayOf("HCl + NaOH -> NaCl + H2O", "HCl + NaOH -> H2O + NaCl", "2HCl + NaOH -> 2NaCl + H2", "H2O + NaCl -> HCl + NaOH"),
            3,
            R.drawable.quimica,
            "HCl + NaOH -> NaCl + H2O"
        )

        addQuestion(
            "¿Cuál es el nombre de la sustancia que actúa como catalizador en una reacción química sin ser consumida en la misma?",
            arrayOf("Catalizador", "Reactivo", "Inhibidor", "Producto"),
            3,
            R.drawable.quimica,
            "Catalizador"
        )

        addQuestion(
            "¿Cuál es la fórmula química del ácido sulfúrico?",
            arrayOf("H2SO4", "HCl", "HNO3", "H3PO4"),
            3,
            R.drawable.quimica,
            "H2SO4"
        )
// Añadir 15 preguntas fáciles de videojuegos

        addQuestion(
            "¿En qué año fue lanzado el juego 'Super Mario Bros.' para la consola NES?",
            arrayOf("1985", "1990", "1980", "1995"),
            1,
            R.drawable.videojuegos,
            "1985"
        )

        addQuestion(
            "¿Cuál es el nombre del personaje principal en la saga 'The Legend of Zelda'?",
            arrayOf("Link", "Mario", "Ganondorf", "Zelda"),
            1,
            R.drawable.videojuegos,
            "Link"
        )

        addQuestion(
            "¿Quién es el creador del juego 'Minecraft'?",
            arrayOf("Markus Persson", "Notch", "Shigeru Miyamoto", "Hideo Kojima"),
            1,
            R.drawable.videojuegos,
            "Markus Persson"
        )

        addQuestion(
            "¿En qué año se lanzó el juego 'Fortnite'?",
            arrayOf("2017", "2018", "2016", "2015"),
            1,
            R.drawable.videojuegos,
            "2017"
        )

        addQuestion(
            "¿Cuál es el título completo del juego 'GTA V'?",
            arrayOf("Grand Theft Auto V", "Grove Street Auto V", "Great Theft Auto V", "Game Time Adventure V"),
            1,
            R.drawable.videojuegos,
            "Grand Theft Auto V"
        )

        addQuestion(
            "¿Qué compañía desarrolladora creó la serie de juegos 'Assassin's Creed'?",
            arrayOf("Ubisoft", "EA Sports", "Activision", "Rockstar Games"),
            1,
            R.drawable.videojuegos,
            "Ubisoft"
        )

        addQuestion(
            "¿Cuál es el nombre del fontanero italiano creado por Nintendo?",
            arrayOf("Mario", "Luigi", "Wario", "Yoshi"),
            1,
            R.drawable.videojuegos,
            "Mario"
        )

        addQuestion(
            "¿En qué género de juegos se enmarca 'The Elder Scrolls V: Skyrim'?",
            arrayOf("Rol (RPG)", "Acción", "Aventura", "Estrategia"),
            1,
            R.drawable.videojuegos,
            "Rol (RPG)"
        )

        addQuestion(
            "¿Cuál es el título del primer juego de la serie 'Final Fantasy'?",
            arrayOf("Final Fantasy", "Final Fantasy VII", "Final Fantasy X", "Final Fantasy IX"),
            1,
            R.drawable.videojuegos,
            "Final Fantasy"
        )

        addQuestion(
            "¿En qué plataforma de juego se lanzó inicialmente 'The Legend of Zelda: Breath of the Wild'?",
            arrayOf("Nintendo Switch", "PlayStation 4", "Xbox One", "PC"),
            1,
            R.drawable.videojuegos,
            "Nintendo Switch"
        )

        addQuestion(
            "¿Cuál es el título del juego que popularizó el género 'battle royale'?",
            arrayOf("PlayerUnknown's Battlegrounds (PUBG)", "Fortnite", "Apex Legends", "Call of Duty: Warzone"),
            1,
            R.drawable.videojuegos,
            "PlayerUnknown's Battlegrounds (PUBG)"
        )

        addQuestion(
            "¿En qué año se lanzó 'World of Warcraft'?",
            arrayOf("2004", "2006", "2008", "2010"),
            1,
            R.drawable.videojuegos,
            "2004"
        )

        addQuestion(
            "¿Cuál es el nombre del personaje principal en la serie 'Metal Gear Solid'?",
            arrayOf("Solid Snake", "Liquid Snake", "Big Boss", "Revolver Ocelot"),
            1,
            R.drawable.videojuegos,
            "Solid Snake"
        )

        addQuestion(
            "¿Qué juego de plataformas presenta a un marsupial llamado Crash?",
            arrayOf("Crash Bandicoot", "Spyro the Dragon", "Banjo-Kazooie", "Super Mario 64"),
            1,
            R.drawable.videojuegos,
            "Crash Bandicoot"
        )

        addQuestion(
            "¿Cuál es el título del juego en el que los jugadores controlan a un fontanero que debe rescatar a la princesa Peach?",
            arrayOf("Super Mario Bros.", "The Legend of Zelda", "Sonic the Hedgehog", "Donkey Kong"),
            1,
            R.drawable.videojuegos,
            "Super Mario Bros."
        )
// Añadir 10 preguntas normales de videojuegos

        addQuestion(
            "¿Cuál es el personaje principal en la serie de juegos 'Uncharted'?",
            arrayOf("Nathan Drake", "Solid Snake", "Master Chief", "Ezio Auditore"),
            2,
            R.drawable.videojuegos,
            "Nathan Drake"
        )

        addQuestion(
            "¿En qué año se lanzó el juego 'The Witcher 3: Wild Hunt'?",
            arrayOf("2015", "2016", "2014", "2017"),
            2,
            R.drawable.videojuegos,
            "2015"
        )

        addQuestion(
            "¿Cuál es el título del primer juego de la serie 'BioShock'?",
            arrayOf("BioShock", "BioShock Infinite", "BioShock 2", "BioShock: Rapture"),
            2,
            R.drawable.videojuegos,
            "BioShock"
        )

        addQuestion(
            "¿Qué juego de aventuras presenta a Kratos, el dios de la guerra griega?",
            arrayOf("God of War", "Darksiders", "Gears of War", "Warhammer 40,000: Dawn of War"),
            2,
            R.drawable.videojuegos,
            "God of War"
        )

        addQuestion(
            "¿Cuál es el título del juego de mundo abierto desarrollado por Rockstar Games, ambientado en el viejo oeste?",
            arrayOf("Red Dead Redemption", "GTA V", "L.A. Noire", "Max Payne 3"),
            2,
            R.drawable.videojuegos,
            "Red Dead Redemption"
        )

        addQuestion(
            "¿En qué año fue lanzado el juego 'Overwatch'?",
            arrayOf("2016", "2015", "2017", "2018"),
            2,
            R.drawable.videojuegos,
            "2016"
        )

        addQuestion(
            "¿Cuál es el título del juego de rol japonés desarrollado por Square Enix, lanzado en 1997 para la PlayStation?",
            arrayOf("Final Fantasy VII", "Chrono Trigger", "Kingdom Hearts", "Dragon Quest"),
            2,
            R.drawable.videojuegos,
            "Final Fantasy VII"
        )

        addQuestion(
            "¿Cuál es el nombre del personaje principal en la serie de juegos 'Halo'?",
            arrayOf("Master Chief", "Sgt. Johnson", "Cortana", "Arbiter"),
            2,
            R.drawable.videojuegos,
            "Master Chief"
        )

        addQuestion(
            "¿En qué año se lanzó el juego 'Counter-Strike: Global Offensive'?",
            arrayOf("2012", "2010", "2013", "2011"),
            2,
            R.drawable.videojuegos,
            "2012"
        )

        addQuestion(
            "¿Cuál es el título del juego que presenta a Geralt de Rivia, un cazador de monstruos conocido como 'El Brujo'?",
            arrayOf("The Witcher 3: Wild Hunt", "The Witcher 2: Assassins of Kings", "The Witcher", "The Witcher: Enhanced Edition"),
            2,
            R.drawable.videojuegos,
            "The Witcher 3: Wild Hunt"
        )

        // Añadir 5 preguntas normales de geografía

        addQuestion(
            "¿Cuál es la capital de Francia?",
            arrayOf("París", "Londres", "Roma", "Madrid"),
            2,
            R.drawable.geografia,
            "París"
        )

        addQuestion(
            "¿En qué continente se encuentra el río Nilo?",
            arrayOf("África", "Asia", "Europa", "América"),
            2,
            R.drawable.geografia,
            "África"
        )

        addQuestion(
            "¿Cuál es el país más grande de América del Sur?",
            arrayOf("Brasil", "Argentina", "Colombia", "Perú"),
            2,
            R.drawable.geografia,
            "Brasil"
        )

        addQuestion(
            "¿En qué océano se encuentra la isla de Madagascar?",
            arrayOf("Océano Índico", "Océano Atlántico", "Océano Pacífico", "Mar Mediterráneo"),
            2,
            R.drawable.geografia,
            "Océano Índico"
        )

        addQuestion(
            "¿Cuál es la cadena montañosa que separa Europa de Asia?",
            arrayOf("Montes Urales", "Himalaya", "Alpes", "Andes"),
            2,
            R.drawable.geografia,
            "Montes Urales"
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

