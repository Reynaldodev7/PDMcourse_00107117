package com.example.taller1_00107117.data

val quizQuestions = listOf(
    Question(
        id = 1,
        question = "¿Cuales son las dos arquitecturas fundamentales que a utilizado Android?",
        options = listOf("PVE Y EWT", "DALVIK Y ART", "LDR Y RMQ", "HTC Y PWD"),
        correctAnswer = "DALVIK Y ART",
        funFact = "Desde la versión 1.0 hasta la 4.4 (KitKat), Android utilizó la máquina virtual Dalvik"
    ),
    Question(
        id = 2,
        question = "¿Cual es una de la desventajas de utilizar la arquitectura de Dalvik?",
        options = listOf("Explotaba", "Calentaba", "Virus", "Lentitud"),
        correctAnswer = "Lentitud",
        funFact = "La lentitud ocurria ya que el procesador debía trabajar intensamente cada vez que se ejecutaba una acción dentro de la app, aumentando también el consumo de batería"
    ),
    Question(
        id = 3,
        question = "¿Cual fue uno de los incovenientes que trajo al inicio la arquitectura ART?",
        options = listOf("UI fea", "Lentitud", "Papadeo de pantalla", "Espacio de las apps"),
        correctAnswer = "Espacio de las apps",
        funFact = "Las apps ocupaban un poco más de espacio en la memoria interna y tardaban más en instalarse."
    )
)