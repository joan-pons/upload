/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.paucasesnovescifp.swdws.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author alumne
 */
@WebServlet(name = "ServletUpload", urlPatterns = {"/upload"})
@MultipartConfig
public class ServletUpload extends HttpServlet {

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String missatge;
        try {
            String id=request.getParameter("id");
            //Recupera el fitxer del cos de la petició
            Part filePart = request.getPart("file");
            //Obté el nom
            String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
            //Obre un stream de bytes per accedir al contingut del fitxer
            InputStream fileContent = filePart.getInputStream();
            //Copia el contingut del fitxer que ha rebut a la ruta i nom 
            //especificat per el segon paràmetre, sobreescrivint-lo si ja existia.
            Files.copy(fileContent, Paths.get("/var/imatges/" + fileName), StandardCopyOption.REPLACE_EXISTING);
            missatge="Imatge guardada correctament "+id;
        } catch (Exception ex) {
            missatge="Error: "+ex.getMessage();
        }
        request.getRequestDispatcher("resultat.jsp").forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
