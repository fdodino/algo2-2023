## Preguntas

- Repasamos la planificación
- La materia tiene que ver con el diseño avanzado en objetos: design patterns, 
## Crear Proyecto, dependencias, JDK (40 minutos)

- Crear proyecto Kotlin - Gradle KTS - dependencias de ejemplo en el [build.gradle.kts](https://wiki.uqbar.org/wiki/articles/algo2.build.gradle.kts) de la wiki
- Qué es una dependencia. Cómo se descarga en [Gradle](https://wiki.uqbar.org/wiki/articles/gradle.html). Versionado semántico. Hablamos de la página hasta plugins inclusive.
- [JDK / JRE](http://wiki.uqbar.org/wiki/articles/jdkVsJre.html), hacemos el diagrama y comparamos contra Algo1.

## El ejercicio en sí: TDD (40 minutos)

- Veamos el [enunciado de seguros de vehículos](../enunciados/seguros-vehiculos.md)
- Analizamos alternativas de por dónde arrancar
- Intro a **TDD**, escribimos el primer test en Kotest: src/test/kotlin. Formato de los tests. Cuál es el test más sencillo?
- Escribimos el test, obvio que se rompe porque creé las clases de dominio: Alt + Enter. En src/main/kotlin.
- Hablamos un poco de Kotlin: referencias val/var, `fun` como método y sobre todo, su nuevo amigue es []
- Volvemos a ejecutar los tests, ahora pasan.
- Repetimos el proceso, hablamos de clase de equivalencia.

## Técnicas de testeo: clases de equivalencia (30 minutos)

- **Clase de equivalencia** como una forma de tener calidad de test: una flota con 6 autos ó con 10 da lo mismo
- **Valor límite**: dado que la cantidad de autos es discreta (entera), 5 es nuestro valor límite para distinguir flota
- Qué herramienta me puede ayudar a descubrir qué clases de equivalencia faltan: code coverage desde el IDE (qué bueno es tener un IDE piola)
- AAA: Arrange / Act / Assert
- Evitar la repetición: "Una flota con 5 autos" es una flota que tiene muchos autos porque el 5 se repite
- Evitar ejemplos que no expliciten la clase de equivalencia: juanPerez vs. flotaConMuchosAutos
- El test tiene que decir qué clase de equivalencia testea, más que cómo testea o qué resultado espera
- Los tests tienen que ser lo más zonzos posible, no poner lógica de testeo porque tendríamos que testear el test (y mucho menos repetir la lógica de dominio)
- One assert per test

## Resto de los tests (30 minutos)

- Vamos viendo la resolución con el resto

## Integración continua (CI) (20 minutos)

- Integración continua: copiamos el archivo build.yml en .github/workflows. Qué es GH Actions. Vemos que pasa.
- Metemos un cambio que falle adrede, sin correr los tests. Push y falla, y nos manda un mail. Ejecutamos los tests locales y fallaban.
- Creamos el status badge de yapa y lo ponemos en el README

## BONUS (20 minutos)

- Si hay tiempo podemos ver code coverage en la nube para la segunda clase
