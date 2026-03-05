# 🛠️ Reporte de Mantenimiento: BuggyWebApp

Este repositorio contiene la solución a una incidencia técnica reportada en la aplicación **BuggyWebApp**. He trabajado este proyecto como un caso real de soporte técnico para mejorar la fiabilidad del sistema de contactos.

## 📋 Situación Recibida
El "cliente" nos avisó de que su formulario de contacto estaba fallando: la aplicación permitía enviar mensajes sin nombre y sin email, lo que llenaba su base de datos de información vacía. Mi objetivo ha sido localizar el error y aplicar un parche de seguridad.

---

## 🔍 Pasos realizados en el proyecto

### 1. Comprobación del error
Primero ejecuté la aplicación tal cual venía (`MainApp.java`) y confirmé que, efectivamente, al dejar los campos vacíos con `""`, el programa no protestaba y terminaba el proceso como si todo estuviera bien.

### 2. Investigación con el Debugger
Para ver qué pasaba por dentro, usé el **Debugger de IntelliJ**:
* Puse un **punto de interrupción** en la línea 17.
* Vi en el panel de **Variables** que los datos vacíos avanzaban por el código sin que nada los frenara.
* Entré en el controlador y vi que no había ningún `if` que revisara los datos.

### 3. Documentación Técnica
Antes de tocar el código, redacté un informe con los hallazgos:
* **Causa raíz:** Falta de filtros de validación en el controlador.
* Puedes leer el análisis completo aquí: **[InformeTecnico.md](./InformeTecnico.md)**.

### 4. Solución Aplicada
Modifiqué la clase `ContactController.java` para añadir una validación manual. Ahora, si el usuario no rellena los campos, el sistema muestra un mensaje de ERROR y corta el envío inmediatamente.

---

## ⚙️ Herramientas utilizadas
* **IDE:** IntelliJ IDEA.
* **Control de versiones:** Git y GitHub.
* **Técnica:** Depuración paso a paso (Step Into / Step Over).

---
**Realizado por:** Lucia Hdez Pestana 