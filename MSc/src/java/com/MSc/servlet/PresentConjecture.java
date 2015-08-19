/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MSc.servlet;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
public class PresentConjecture extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            BNProcessor processor = new BNProcessor();

            processor.Population1Name = request.getParameter("pop1Name");
            processor.Sample1Mean = Double.parseDouble(request.getParameter("sample1Mean"));
            processor.Sample1Size = Integer.parseInt(request.getParameter("sample1Size"));
            processor.Sample1Variance = Double.parseDouble(request.getParameter("sample1Variance"));
            processor.Population2Name = request.getParameter("pop2Name");
            processor.Sample2Mean = Double.parseDouble(request.getParameter("sample2Mean"));
            processor.Sample2Size = Integer.parseInt(request.getParameter("sample2Size"));
            processor.Sample2Variance = Double.parseDouble(request.getParameter("sample2Variance"));

            System.out.println("Test");
            AgenaResultMapper[] result = processor.process();
            Gson gson = new Gson();
            String jsonString = gson.toJson(result);
            
            out.println(jsonString);
//          
//            out.println("<h1>Servlet PresentConjecture at " + request.getContextPath() + "</h1>");
//            out.println("This is the conjecture for pop1Name:   :   :   " + request.getParameter("pop1Name"));
            
        }
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
