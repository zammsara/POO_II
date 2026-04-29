# My Secret Fate

My Secret Fate es una aplicación Android desarrollada con Kotlin y Jetpack Compose que simula una pequeña historia interactiva basada en decisiones.

El usuario encuentra una carta sellada en una antigua mansión y debe elegir entre dos caminos:

- Abrir la carta.
- Alejarse.

Cada elección modifica el desarrollo de la historia y conduce a un final distinto.

## Características

- Navegación entre 3 pantallas usando Jetpack Compose Navigation.
- Paso de argumentos entre rutas.
- Dos finales posibles según la decisión del usuario.
- Interfaz estilo pixel art con estética dark academia.
- Uso de fuentes personalizadas, assets e iconos propios.

## Estructura de pantallas

### Pantalla 1 — Inicio
Presenta la historia inicial y dos decisiones:

- Abrir la carta
- Alejarse

---

### Pantalla 2 — Detalle
Muestra consecuencias distintas según la elección realizada.

---

### Pantalla 3 — Resumen
Presenta el final desbloqueado:

- Guardiana de Secretos  
- Guardiana del Silencio

---

## Tecnologías utilizadas

- Kotlin
- Jetpack Compose
- Navigation Compose
- Material 3
- Android Studio

---

## Cómo ejecutar el proyecto

### Requisitos

- Android Studio (versión reciente recomendada)
- SDK de Android instalado
- Emulador Android o dispositivo físico

---

### Pasos

1. Clonar el repositorio:

```bash
git clone https://github.com/TU-USUARIO/my-secret-fate.git
```

2. Abrir el proyecto en Android Studio.

3. Esperar sincronización de Gradle.

4. Ejecutar la aplicación con:

- Un emulador Android

o

- Un dispositivo físico conectado con depuración USB habilitada.

5. Presionar Run.

---

## Cómo funciona la navegación

El flujo de navegación es:

```text
Inicio
↓
Detalle (según decisión)
↓
Resumen (según destino)
```

Se utilizan rutas con argumentos dinámicos:

```text
detalle/{decision}
resumen/{destino}
```

Ejemplo:

```text
detalle/puerta
resumen/guardiana
```

---

## Recursos gráficos

La aplicación utiliza:

- Fondos ilustrados personalizados
- Sprites pixel art
- Íconos propios
- Fuente Press Start 2P
