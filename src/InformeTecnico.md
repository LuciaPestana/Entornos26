# 📝 Informe Técnico de Incidencia: BuggyWebApp

## 1. Descripción del problema
He comprobado que la aplicación tiene un fallo de validación importante. Actualmente, permite que se envíen y procesen formularios de contacto aunque no se haya escrito nada en los campos de nombre o email, tratándolos como si fueran datos correctos.

## 2. Cómo se reproduce
Para ver el error, solo hay que seguir estos pasos:
* Abrir la clase `MainApp.java`.
* Ejecutar el programa dejando los parámetros de `submitContactForm` vacíos: `""`, `""`.
* Ver en la consola que el sistema pone "Fin de submitContactForm" sin dar ninguna alerta de error.

## 3. Análisis técnico (qué ocurre internamente)
Al usar el **Debugger**, he analizado qué pasa por dentro del código:
* **Variables:** He confirmado en el panel de control que `name` e `email` llegan al controlador con el valor `""`.
* **Flujo:** Al avanzar con **F8 (Step Over)**, he visto que el programa no encuentra ninguna barrera y salta directamente a la línea donde se procesa el formulario.
* **Resultado:** El sistema crea el objeto `ContactForm` con datos vacíos y lo da por válido.

## 4. Causa raíz
La causa del problema es que en la clase `ContactController.java` no hay ninguna **estructura de control (un if)** que verifique si los campos están vacíos antes de enviarlos al servicio.

## 5. Propuesta de solución
Para arreglarlo, voy a añadir un bloque `if` en el controlador. Este código comprobará si el nombre o el email están vacíos usando `.isEmpty()`. Si lo están, el programa mostrará un error y no dejará que el formulario se envíe.

---
*Realizado por: LuciaPestana*