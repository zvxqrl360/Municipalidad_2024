
package Controller;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* Importa tu clase de conexión
import Model.Conexion;

@WebServlet("/GenerarTramiteServlet")
public class Tramite extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String dni = request.getParameter("dni");
        String tipoTramite = request.getParameter("tipo-tramite");

        Conexion Conexion = new Conexion();

        try {
            // Conectar a la base de datos
            Conexion.c(false); // Conectar sin transacción
            Connection connection = Conexion.getConexion();

            String sql = "INSERT INTO tramite (nombre, apellido, dni, tipo_tramite) VALUES (?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, nombre);
                statement.setString(2, apellido);
                statement.setString(3, dni);
                statement.setString(4, tipoTramite);
                statement.executeUpdate();
            }

            // Cerrar la conexión
            Conexion.cerrar(true);

        } catch (Exception e) {
            try {
                // En caso de error, realizar rollback
                Conexion.cerrar(false);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            throw new ServletException("Error al acceder a la base de datos", e);
        }

        // Redirigir a una página de éxito o mostrar un mensaje
        response.sendRedirect("exito.jsp");
    }
}*/
