package jettyserver;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GetData extends HttpServlet {

    private final Gson gson;

    public GetData(Gson gson) {
        this.gson = gson;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String responseJsonString="";

        try {

            final JsonObject retVal = new JsonObject();
            Stream<String> body = request.getReader().lines();

            responseJsonString = body
                    .map(line->line.toString()).collect(Collectors.joining());


            System.out.println("get data"+responseJsonString);

            response.setStatus(HttpServletResponse.SC_OK);

        } catch (Exception ex) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);

        } finally {
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().println("Response:"+ responseJsonString);
            response.getWriter().close();
        }

    }
}
