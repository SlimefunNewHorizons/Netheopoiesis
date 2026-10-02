<p align="center"><img src="https://raw.githubusercontent.com/DrakesCraft-Labs/Netheopoiesis/main/banner.svg" alt="Netheopoiesis" width="100%"></p>

# Netheopoiesis

> ### 🏰 ¡Únete a la Comunidad Oficial de DrakesCraft!
> 
> * 🎮 **IP del Servidor**: `play.drakescraft.net` *(Java 1.21.11 & Bedrock)*
> * 💬 **Discord Oficial**: [discord.gg/drakescraft](https://discord.gg/rv3vtXZTk7)
> * 🌐 **Web & Guía**: [drakescraft.net](https://drakescraft.net) — 🛒 **Tienda**: [tienda.drakescraft.net](https://tienda.drakescraft.net)
> 
> *¡Juega con este addon y más de 80 expansiones optimizadas en vivo en nuestra network de supervivencia técnica!*

---

Terraformar el Nether, adaptado al ecosistema Slimefun de **DrakesCraft**
(Paper/Purpur 1.21.11, Java 21).

## Qué añade

La idea es convertir el Nether en un sitio habitable. Se purifica la piedra base, y según sube
la pureza de la zona se desbloquean plantas nuevas, aparecen criaturas y el terreno cambia.

En números: **118 objetos**, de los cuales **73 son semillas**, más 35 variedades de fruto
Netheo con sus sabores, cristales elementales, herramientas de recolección y aparatos para medir
la pureza de una zona.

## Ojo con esto

**Ya estuvo instalado en DrakesCraft.** Sus identificadores siguen en el `Items.yml` del
servidor, así que lo que alguien dejara colocado en su día se reconoce al volver a activarlo, en
vez de quedarse huérfano.

**La integración con CrystamaeHistoria está desactivada** en nuestro port de aquel addon. Ambos
son del mismo autor y Crystamae trae una clase `NetheoPlants` con nueve semillas que enlazan los
dos, pero en nuestra versión están puestas a `null` y el `setup()` está vacío — se desactivó
porque Netheopoiesis no estaba portado y sin él no compilaba. Ahora que sí lo está, se podría
recuperar; es un trabajo aparte.

## Qué cambiamos

Este repositorio **no es un fork**: es el código original integrado en el ecosistema de
DrakesCraft. Los cambios son los habituales de nuestros ports.

**Los paquetes de Slimefun**, remapeados al core repaquetado de DrakesCraft. Y el build pasa de
`spigot-api` 1.19 a **paper-api 1.21.11**, la misma versión que corre el servidor: compilar
contra una anterior deja pasar el fallo al arranque, no al build.

**La telemetría, fuera.** bStats abría una conexión a bstats.org cada pocos minutos con datos
del servidor.

**El autoactualizador, desarmado.** Este jar está recompilado contra nuestro Slimefun; si se
bajara el de upstream encima, dejaría de cargar. Su condición exigía una versión que empezara
por `DEV` y la nuestra no, pero eso es una coincidencia que se rompe en cuanto alguien toque la
cadena de versión, así que el método se vació.

**El rastreador de fallos apunta aquí**, no al repositorio original.

## Créditos

Addon original de **Sefiraat** y **J3fftw**, escrito para la Addon Jam de 2022. Este repositorio
solo lo adapta.

---

## 📄 License & Upstream Attribution

This project is a sovereign fork maintained by [**JackStar6677-1**](https://github.com/JackStar6677-1) under [**DrakesCraft Labs**](https://github.com/DrakesCraft-Labs).

- **Original Project:** Created by the upstream authors and the open-source community.
- **DrakesCraft Optimizations:** Modernized for Paper/Purpur 1.21.11+, Java 21, high concurrency, asynchronous safety, and exploit/duplication prevention.
- **License:** Distributed under the original **GNU General Public License v3.0 (GPLv3)** (or original upstream license). See the [LICENSE](LICENSE) file for complete terms.
