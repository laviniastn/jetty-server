package jettyserver;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class JettyServer extends Server {

    private static final Gson gson = new GsonBuilder().
            setDateFormat("yyyy-MM-dd HH:mm:ss").create();

    public JettyServer(int port) {
        super(port);

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler
                .NO_SESSIONS);
        context.setContextPath("/jettyserver");
        context.addServlet(new ServletHolder(new GetData(gson)), "/getData/*");
        context.addServlet(new ServletHolder(new SendData()), "/sendData/*");
        this.setHandler(context);
        this.setStopAtShutdown(true);
    }
}
