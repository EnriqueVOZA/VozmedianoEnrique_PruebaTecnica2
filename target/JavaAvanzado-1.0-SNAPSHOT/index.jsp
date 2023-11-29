<%-- 
    Document   : index
    Created on : 26 nov 2023, 14:44:20
    Author     : enriquevz
--%>

<%@page import="java.util.List"%>
<%@page import="com.hab.javaavanzado.logica.Turno"%>
<%@page contentType="text/html charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" type="text/css" href="./styles.css">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Formulario Turno</h2>
        <form action="turnoSv" method="POST">

            <label for="nombre">Nombre:</label>
            <input type="text" id="nombre" name="nombre" required>
            <br>

            <label for="apellido">Apellido:</label>
            <input type="text" id="apellido" name="apellido" required>
            <br>

            <label for="dni">DNI:</label>
            <input type="text" id="dni" name="dni" required>
            <br>

            <label for="telefono">Teléfono:</label>
            <input type="tel" id="telefono" name="telefono" required>
            <br>

            <label for="tramite">Trámite:</label>
            <input type="text" id="tramite" name="tramite" required>
            <br>

            <input type="date" id="fecha" name="fecha" required>
            <br>



            <label for="hora">Hora:</label>
            <input type="text" id="hora" name="hora" required>
            <br>

            <input type="submit" value="Enviar">
        </form>

        <br>
        <br>
        <br>
        <br>
        <form action="BuscarTurnoSv" method="GET">
            <div>
                <div>
                    <label for="fechaInicio">Fecha de Inicio</label>
                    <input type="date" id="fechaInicio" name="fechaInicio">
                </div>
                <div>
                    <label for="estado">Estado</label>
                    <select name="estado">
                        <option value="false" selected>En espera</option>
                        <option value="true">Ya atendido</option>
                    </select>
                </div>
            </div>
            <button type="submit" name="action" value="filtrarFecha" class="btn btn-primary mt-3">Filtra por fecha</button>
            <button type="submit" name="action" value="filtrarEstado" class="btn btn-primary mt-3 ml-3">Filtrar por estado</button>
        </form>



        <% if (request.getAttribute("listarTurnos2") != null) { %>
        <h3>Resultados:</h3>
        <table class="table">
            <thead>
                <tr>
                    <th>Nº Turno</th>
                    <th>Nombre</th>    
                    <th>Apellido</th> 
                    <th>Tramite</th>
                    <th>Estado</th>
                </tr>
            </thead>
            <tbody>
                <% for (Turno turno : (List<Turno>) request.getAttribute("listarTurnos2")) {%>
                <tr>
                    <td><%= turno.getId()%></td>
                    <td><%= turno.getCiudadano().getNombre()%></td>
                    <td><%= turno.getCiudadano().getApellido()%></td>
                    <td><%= turno.getTramite()%></td>    
                    <td><%= (turno.isEstado()) ? "Ya atendido" : "En espera"%></td>    
                    <td>
                        <form action="CambiarEstadoSv" method="Post">
                            <input type="hidden" name="turnoId" value="<%= turno.getId()%>">
                            <button type="submit">Cambiar estado</button>
                        </form>
                    </td>
                </tr>
                <% } %>
            </tbody>
        </table>
        <% }%>

    </body>


</html>
