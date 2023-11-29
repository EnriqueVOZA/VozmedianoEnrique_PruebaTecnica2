/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.hab.javaavanzado.servlet;

import com.hab.javaavanzado.logica.Ciudadano;
import com.hab.javaavanzado.logica.Turno;
import com.hab.javaavanzado.persistencia.ControladoraPersistencia;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "turnoSv", urlPatterns = {"/turnoSv"})
public class turnoSv extends HttpServlet {

    ControladoraPersistencia control = new ControladoraPersistencia();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet turnoSv</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet turnoSv at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

//        List<Turno> listaTurnos = control.listarTurnos();
//
//        request.setAttribute("listarTurnos", listaTurnos);
//
//        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Recuperar los parámetros del formulario
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String dni = request.getParameter("dni");
        String telefonoStr = request.getParameter("telefono");
        String tramite = request.getParameter("tramite");
        String hora = request.getParameter("hora");
        String fecha = request.getParameter("fecha");

        // Validar y convertir el teléfono a entero
        int telefono;
        try {
            telefono = Integer.parseInt(telefonoStr);
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "El teléfono debe ser un número válido.");
            return;
        }

        // Validar datos del ciudadano
        if (nombre == null || nombre.isEmpty()
                || apellido == null || apellido.isEmpty()
                || dni == null || dni.isEmpty()
                || telefonoStr == null || telefonoStr.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Todos los campos son obligatorios.");
            return;
        }

        // Validar y parsear la fecha
        LocalDate fechaPar = null;
        if (fecha != null && !fecha.isEmpty()) {
            try {
                fechaPar = LocalDate.parse(fecha);
            } catch (DateTimeParseException e) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Formato de fecha no válido.");
                return;
            }
        }

        Ciudadano ciudadano = new Ciudadano();
        ciudadano.setNombre(nombre);
        ciudadano.setApellido(apellido);
        ciudadano.setDni(dni);
        ciudadano.setTelefono(telefono);

        control.crearCiudadano(ciudadano);

        Turno turno = new Turno();
        turno.setCiudadano(ciudadano);
        turno.setFecha(fechaPar);
        turno.setHora(hora);
        turno.setTramite(tramite);
        turno.setEstado(false);
        control.crearTurno(turno);

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
