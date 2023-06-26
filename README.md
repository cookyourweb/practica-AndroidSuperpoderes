# Práctica Android Superpoderes

##  Introducción
Durante el módulo de Android Superpoderes se han visto muchos de los componentes
actuales de Jetpack Compose junto con el principal método de programación reactiva
usando corrutinas (Kotlin Flow).
## Objetivo
Crear una aplicación nueva desde cero, con una fuente de datos distinta a la usada durante
las clases y conseguir replicar la estructura aprendida junto con las herramientas utilizadas.
Se deberá utilizar la api de Marvel con un usuario propio para cada alumno.
- La aplicación consistirá en un clásico listado-detalle.
- Listado: muestra el conjunto de superhéroes con una información reducida
que permita identificar correctamente a cada uno. Al hacer click en un
elemento se mostrará la pantalla de detalle.
- Detalle: muestra la información completa de un superhéroe.
## Requisitos
Estudiar la API de Marvel (https://developer.marvel.com/) para obtener la información
necesaria de los superhéroes.
 En el detalle se deberá mostrar información más completa del superhéroe además
de hacer uso de otros dos endpoints relacionados con él. Toda la información deberá
mostrarse de forma reactiva.
- El listado de superheroes se deberá cachear usando Room y deberá ser accesible
usando Flow.
-  Se permitirá marcar los superheroes como favoritos y dicho cambio se deberá ver
reflejado de alguna forma en el listado general mediante Flow.
-  Toda el interfaz visual tiene que ser desarrollado en Jetpack Compose. Si por algún
motivo se necesitase usar una vista propia de XML, se deberá incluir un comentario
en el código explicando los motivos y los usos.
  - Es necesario incluir un Scaffold en alguna parte del código junto con los
subcomponentes que se consideren pertinentes.
- Se deberá incluir algún componente de Jetpack Compose nuevo que no se haya
visto en clase. Se deberá buscar información sobre él y explicarla en un comentario.
No es válido la creación de un componente que sólo sea una agrupación de
componentes básicos.
- Se valorará la estructura y atomización de los componentes para su reutilización.
- Todas las prácticas deberán contenter tests unitarios usando test reales, mocks y
fakes, justificando el uso de cada uno en cada caso.
