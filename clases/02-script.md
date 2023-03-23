
## Temario

- Integración continua + repaso github
- Cobertura en la nube
- Badges en el README
- Cómo corregir un error
- Intro a manejo de proyectos

## Integración continua + repaso github

- Agarramos el proyecto de Seguros
- Generamos el [`build.yml`](https://wiki.uqbar.org/wiki/articles/algo2.build.gradle.kts) en base al archivo de la wiki o de cualquier ejemplo
- Creamos la carpeta `.github/workflows` y ubicamos aquí el archivo `build.yml` (vemos qué hace)
- También inicializamos el repo `git init`
- Revisamos el archivo `.gitignore` de algún ejemplo
- Creamos un repo remoto para que vean cómo se hace
- Primer commit y push, vemos que dispara en la solapa Actions el build del CI (Integración continua)
- Primera vez pasan los test ok, introducir algo que rompa los tests => nos manda mail
- Revisar configuración de notificaciones (https://github.com/settings/notifications)

## Cobertura en la nube

- los tests de flota están comentados a propósito, podemos ver en codecov la cobertura
- eso mismo lo tienen en IntelliJ => Run with coverage
- vemos el % de cobertura, la línea en verde está totalmente testeada, en rojo no está testeada y en amarillo está parcialmente testeada
- no tiene sentido testear todo, sí está buena la métrica
- eliminamos el código comentado de los tests y vemos que sube el %

## Badges en el README

- Vamos a GH Actions y les mostramos el link Create Status Badge: dentro de la solapa Actions, elegimos cualquier build y en los `...` está la opción. En [esta página](http://wiki.uqbar.org/wiki/articles/kotlin-ci.html) están las instrucciones.
- Lo mismo para codecov: un dato importante es que hay que seleccionar master como branch default en lugar de main (salvo que tengan main)

## Cómo corregir un error

- Seguir el script que está [en el README del repo de seguros](https://github.com/uqbar-project/eg-seguros-kotlin)

## Manejo de proyectos

Va a ser difícil que lleguemos, pero lo podemos acomodar la semana que viene.
