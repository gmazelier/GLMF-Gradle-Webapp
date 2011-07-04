package glmf.gradle;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class HelloGradle extends HttpServlet {

  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
    PrintWriter out = response.getWriter();
    out.println("Hello Gradle!");
  }

}
