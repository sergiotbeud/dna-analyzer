## Objetivo

Con este proyecto se está evaluando el conocimiento de Sergio Andrés Tobón abarcando el tema devops, implementacion de microservicios en java con springboot.

## Problema a resolver:

Magneto quiere reclutar la mayor cantidad de mutantes para poder luchar
contra los X-Men.
Por lo que se requiere desarrollar una API REST capaz de detectar secuencias de ADN con ADN entregado como parámetro array de string  que representa una tabla de NXN con la consecuencia del ADN. Los únicos caracteres permitidos son: A,T,G y C, representando así las bases nitrogenadas del ADN.

## Estado de entrega del proyecto.

Nivel 3: Completado.

  - Api rest deployada en AWS con el objetivo de detectar ADN mutante.
  - Servicio expuesto para las consultas de las estadísticas.
  - Cobertura de código: 86,8%

## Instrucciones de pruebas.

**Para realizar dichas pruebas es necesario importar el archivo _DNA analyzer.postman_collection.json_ en postman, alojado en la ruta src/test/java/com/dna/analyzer**

### Servicio que detecta si un humano es mutante:

  - Method: Post
  - endpoint:http://dna-analyzer-lb-0de34cff4891e104.elb.us-east-1.amazonaws.com:8089/mutant
  - Ejemplo request:
`{
"dna":[
"ATGCGA",
"CAGTGC",
"TTATGT",
"AGAAGG",
"CCCCTA",
"TCACTG"]
}`

  - Respuestas: 
    - HTTP 200 OK: En caso de que sea mutante
    - HTTP 403 FORBIDDEN: En caso de que no sea mutante.

### Servicio que consulta las estadísticas de las verificaciones de ADN

  - Method: GET
  - endpoint: http://dna-analyzer-lb-0de34cff4891e104.elb.us-east-1.amazonaws.com:8089/stats
  - Ejemplo respuesta:
      
    `{
        "countMutantDna": 3.0,
        "countHumanDna": 2.0,
        "ratio": 0.67
    }`
      
 


## Repositorio

El proyecto está realizado con maven, deberá ser descargado e instalado para que el mismo maven descargue las librerías que requiere el proyecto.

### Instrucciones de descarga
  - Crear directorio donde se alojará el proyecto
  - Ubicarse en el directorio y abrir una consola de comandos sea CMD (windows) o Terminal (Mac)
  - Ejecute el siguiente comando: 
    `git clone https://github.com/sergiotbeud/dna-analyzer.git`
    
