package com.example.controller;

import com.example.model.ContactForm;
import com.example.service.ContactService;
import com.example.util.Logger;

public class ContactController {

    private ContactService service;

    public ContactController() {
        service = new ContactService();
    }

    public void submitContactForm(String name, String email) {
        Logger.log("Recibiendo formulario de contacto...");

        // --- NUEVA VALIDACIÓN (PARTE 6) ---
        if (name == null || name.isEmpty() || email == null || email.isEmpty()) {
            Logger.log("ERROR: El nombre y el email son campos obligatorios.");
            return; // Esto detiene la ejecución y evita que se procese el formulario
        }
        // ----------------------------------

        ContactForm form = new ContactForm(name, email);
        service.processForm(form);

        Logger.log("Fin de submitContactForm");
    }
}