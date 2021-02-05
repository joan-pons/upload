/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.paucasesnovescifp.swdws.servlets;

import cat.paucasesnovescifp.swdws.dades.Foto;
import cat.paucasesnovescifp.swdws.ejb.FotosSB;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.ejb.EJB;
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
@WebServlet(name = "ServletUploadRest", urlPatterns = {"/uploadRest"})
@MultipartConfig
public class ServletUploadRest extends HttpServlet {

    @EJB
    private FotosSB fotosSB;

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
        response.setContentType("application-json");
        try {
            //Recuperar les altres dades del formulari
            Part id = request.getPart("id");
            int idVal = Integer.parseInt(new String(id.getInputStream().readAllBytes()));
            //Recupera el fitxer del cos de la petició
            Part filePart = request.getPart("file");
            //Obté el nom
            String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
            Foto foto = new Foto(idVal,fileName);
            fotosSB.insertFoto(foto);
            //Obre un stream de bytes per accedir al contingut del fitxer
            InputStream fileContent = filePart.getInputStream();
            //Copia el contingut del fitxer que ha rebut a la ruta i nom 
            //especificat per el segon paràmetre, sobreescrivint-lo si ja existia.
            Files.copy(fileContent, Paths.get("/var/imatges/" + foto.getNom()), StandardCopyOption.REPLACE_EXISTING);
            response.setStatus(200);
            PrintWriter out = response.getWriter();
            out.write("{\"missatge\":\"Imatge guardada correctament " + idVal + "\"}");
        } catch (Exception ex) {
            response.setStatus(500);
            PrintWriter out = response.getWriter();
            out.write("{\"missatge\":\"" + ex.getMessage() + "\"}");
        }
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
