/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jeanpandini.monstraodeliver;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;

/**
 *
 * @author carlo
 */
@WebServlet(name = "ContatoServlet", urlPatterns = {"/contatoServlet"})
public class ContatoServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        boolean save = salvaContato(request.getParameter("name"), request.getParameter("email"), request.getParameter("telefone"));
        if (save) {
            response.sendRedirect(request.getContextPath() + "/sucesso.html");
        } else {
            response.sendRedirect(request.getContextPath() + "/erro.html");
        }
    }

    private boolean salvaContato(@NotNull String nome, @NotNull String email, @NotNull String telefone) {
        if (nome.isEmpty() || email.isEmpty() || telefone.isEmpty()) {
            return false;
        }
        try {
            File file = new File(Constants.FILE_NAME);
            JsonArray array = new JsonArray();
            if (file.exists()) {
                JsonElement element = new JsonParser().parse(new FileReader(file));
                if (!element.isJsonNull()) {
                    array = element.getAsJsonArray();
                }
            }

            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("nome", nome);
            jsonObject.addProperty("email", email);
            jsonObject.addProperty("telefone", telefone);
            array.add(jsonObject);
            FileWriter writer = new FileWriter(file);
            writer.write(array.toString());
            writer.close();
            return true;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ContatoServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ContatoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
