package jettyserver;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SuppressWarnings("serial")
public class SendData extends HttpServlet {

    public  SendData(){

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String responseJsonString = "";
        try {

            Stream<String> body = request.getReader().lines();

             responseJsonString = body
                    .map(line->line.toString()).collect(Collectors.joining());


            response.setStatus(HttpServletResponse.SC_OK);

        } catch (Exception ex) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);

        } finally {
            response.setContentType("application/json");
            response.getWriter().println(responseJsonString);
            response.getWriter().close();
        }





    }
}
