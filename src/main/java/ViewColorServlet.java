import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ViewColorServlet", urlPatterns = "/viewcolor")
public class ViewColorServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String colorInfo = request.getParameter("usercolor");
        System.out.println(colorInfo);
        request.setAttribute("pageColor", colorInfo);
        request.getRequestDispatcher("/viewcolor.jsp").forward(request, response);



    }

}
