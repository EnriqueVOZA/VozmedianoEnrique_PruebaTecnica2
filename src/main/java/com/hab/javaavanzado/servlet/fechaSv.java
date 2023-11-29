/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.hab.javaavanzado.servlet;

import com.hab.javaavanzado.logica.Turno;
import com.hab.javaavanzado.persistencia.ControladoraPersistencia;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "fechaSv", urlPatterns = {"/fechaSv"})
public class fechaSv extends HttpServlet {    
    
        ControladoraPersistencia control = new ControladoraPersistencia();
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet fechaSv</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet fechaSv at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        // Obtener los parámetros de fecha de inicio y fecha de fin desde la solicitud
        String fechaInicioStr = request.getParameter("fechaInicio");
        String fechaFinStr = request.getParameter("fechaFin");
        
        LocalDate fechaInicio = null;
        LocalDate fechaFin = null;

        // Validar y parsear las fechas
        if (fechaInicioStr != null && !fechaInicioStr.isEmpty()) {
            fechaInicio = LocalDate.parse(fechaInicioStr);
        }

        if (fechaFinStr != null && !fechaFinStr.isEmpty()) {
            fechaFin = LocalDate.parse(fechaFinStr);
        }

        // Obtener la lista de turnos filtrada por fecha
        List<Turno> listaTurnos2 = control.listarTurnosPorFecha(fechaInicio, fechaFin);

        request.setAttribute("listarTurnos2", listaTurnos2);

        request.getRequestDispatcher("index.jsp").forward(request, response);
       
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
