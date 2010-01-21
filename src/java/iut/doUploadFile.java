/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package iut;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author vincentb
 */
public class doUploadFile extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException, FileUploadException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {

            boolean isMultipart = ServletFileUpload.isMultipartContent(request);
            
            if(isMultipart)
            {
                // Create a factory for disk-based file items
                DiskFileItemFactory factory = new DiskFileItemFactory();
                File f = new File("/home/vincentb/Bureau");

                // Set factory constraints
                //factory.setSizeThreshold(5000000);
                factory.setRepository(f);
                // Create a new file upload handler
                ServletFileUpload upload = new ServletFileUpload(factory);
                out.print(request);
                // Parse the request
                List /* FileItem */ items = upload.parseRequest(request);

                
                // Set overall request size constraint
                //upload.setFileSizeMax(5000000);
                
                Iterator iter = items.iterator();
                while (iter.hasNext()) {
                    FileItem item = (FileItem) iter.next();

                    if (item.isFormField()) {
                        out.print("COUCOU LE FICHIER VA PAS ETRE ECRIT SUR LE DISKEUH");
                        String name = item.getFieldName();
                        String value = item.getString();;
                    } else {
                        out.print("COUCOU LE FICHIER VA ETRE ECRIT SUR LE DISKEUH");
                        String fieldName = item.getFieldName();
                        String fileName = item.getName();
                        String contentType = item.getContentType();
                        boolean isInMemory = item.isInMemory();
                        long sizeInBytes = item.getSize();
                        File uploadedFile = new File("/home/vincentb/Bureau/"+fileName+"_"+sizeInBytes);
                        try {
                            item.write(uploadedFile);
                        } catch (Exception ex) {
                            Logger.getLogger(doUploadFile.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
            
        } finally { 
            out.close();
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (FileUploadException ex) {
            Logger.getLogger(doUploadFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (FileUploadException ex) {
            Logger.getLogger(doUploadFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void processFormField(FileItem item) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private void processUploadedFile(FileItem item) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

}
