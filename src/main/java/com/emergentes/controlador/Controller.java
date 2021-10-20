
package com.emergentes.controlador;

import com.emergentes.modelo.GestorLibros;
import com.emergentes.modelo.Libros;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "Controller", urlPatterns = {"/Controller"})
public class Controller extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Libros objLibro = new Libros();
        int id ;
        int pos;
        String opcion = request.getParameter("op");
        String op = (opcion !=null)? request.getParameter("op"):"view";
        
        if(op.equals("nuevo")){
            HttpSession ses = request.getSession();
            GestorLibros biblio = (GestorLibros) ses.getAttribute("biblio");
            objLibro.setId(biblio.obtieneId());
            request.setAttribute("op", op);
            request.setAttribute("miLibro", objLibro);
            request.getRequestDispatcher("editar.jsp").forward(request, response);
            
        }
        if(op.equals("modificar")){
            id=Integer.parseInt(request.getParameter("id"));
            HttpSession ses = request.getSession();
            GestorLibros biblio = (GestorLibros) ses.getAttribute("biblio");
            pos = biblio.ubicarLibro(id);
            objLibro = biblio.getLista().get(pos);
            request.setAttribute("op", op);
            request.setAttribute("miLibro", objLibro);
            request.getRequestDispatcher("editar.jsp").forward(request, response);
        }
        if(op.equals("eliminar")) {
            id=Integer.parseInt(request.getParameter("id"));
            HttpSession ses = request.getSession();
            GestorLibros agenda = (GestorLibros) ses.getAttribute("biblio");
            pos = agenda.ubicarLibro(id);
            agenda.eliminarLibro(pos);
            request.setAttribute("op", op);
            request.setAttribute("miLibro", objLibro);
            request.getRequestDispatcher("editar.jsp").forward(request, response);
        }
        if(op.equals("view")){
            response.sendRedirect("index.jsp");
        }
    }
    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Libros objLibro = new Libros();
        int pos;
        String op = request.getParameter("op");

        if (op.equals("grabar")) {
            objLibro.setId(Integer.parseInt(request.getParameter("id")));
            objLibro.setAutor(request.getParameter("autor"));
            objLibro.setTitulo(request.getParameter("titulo"));
            objLibro.setResumen(request.getParameter("resumen"));
            objLibro.setMedio(request.getParameter("medio"));

            HttpSession ses = request.getSession();
            GestorLibros biblio = (GestorLibros) ses.getAttribute("biblio");

            String opg = request.getParameter("opg");
            if (opg.equals("nuevo")) {
                biblio.insertarLibro(objLibro);
            } else {
                pos = biblio.ubicarLibro(objLibro.getId());
                biblio.modificarLibro(pos, objLibro);
            }

            ses.setAttribute("biblio", biblio);
            response.sendRedirect("index.jsp");
        }
    }
}
