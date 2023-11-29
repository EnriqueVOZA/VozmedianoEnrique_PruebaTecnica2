
package com.hab.javaavanzado.servlet;

import com.hab.javaavanzado.logica.Controladora;
import com.hab.javaavanzado.logica.Turno;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CambiarEstadoSv", urlPatterns = {"/CambiarEstadoSv"})
public class CambiarEstadoSv extends HttpServlet {

    Controladora control = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CambiarEstadoSv</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CambiarEstadoSv at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String fechaStr = request.getParameter("fechaInicio");
        String estadoStr = request.getParameter("estado");

        //Parseo de datos
        LocalDate fecha = LocalDate.parse(fechaStr);
        boolean estado = Boolean.parseBoolean(estadoStr);

        //Obtener datos de BBDD
        List<Turno> turnosFiltradoEstado = control.buscarFechaEstado(fecha, estado);

        request.setAttribute("listarTurnos2", turnosFiltradoEstado);

        request.getRequestDispatcher("index.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String turnoId = request.getParameter("turnoId");
        if (turnoId != null && !turnoId.isEmpty()) {
            try {
                Long id = Long.valueOf(turnoId);

                //Recargamos lista antes de cambiar estado
                Turno turno = control.turnoId(id);

                //Verificar si el turno ya ha sido atendido
                if (turno.isEstado()) {
                    //Si ya ha sido atendido, cambiar a "En espera"
                    turno.setEstado(false); // Cambiar a "En espera"
                    control.cambiarEstado(turno);
                } else {
                    // Si no ha sido atendido, cambiar a "Atendido"
                    turno.setEstado(true);
                    control.cambiarEstado(turno);
                }

                //Mostrar lista modificada
                List<Turno> turnosModificados = control.buscarFecha(turno.getFecha());

                request.setAttribute("listarTurnos2", turnosModificados);
                request.getRequestDispatcher("index.jsp").forward(request, response);

            } catch (Exception e) {
                Logger.getLogger(CambiarEstadoSv.class.getName()).log(Level.SEVERE, null, e);
            }
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
