package servlets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Note;

/**
 *
 * @author pusit
 */
public class NoteServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response)
        throws ServletException, IOException {
        
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        // to read files
        BufferedReader br = new BufferedReader(new FileReader(new File(path)));
       
        String title = br.readLine();
        String content = br.readLine();
        
        br.close();
        
        Note note = new Note(title, content);
        request.setAttribute("note", note);
        
        if(request.getParameter("edit")!=null){
            getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp")
                   .forward(request, response);
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp")
                   .forward(request, response);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response)
        throws ServletException, IOException {
        
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        // to write to a file
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path, false))); 
        
        pw.println(title);
        pw.print(content);
        
        pw.close();
        
        Note note = new Note(title,content);
        request.setAttribute("note",note);
        
        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp")
                   .forward(request, response);
    }
}
