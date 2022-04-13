package jettyserver;

public class SimpleJettyServer {

    public static void main(String[] args) throws Throwable {

        final JettyServer jetty = new JettyServer(8081);
        jetty.start();
        Thread.sleep(500);
        if (false == jetty.isStarted()) {
            throw new Exception("Cannot start jetty server");
        }
    }
}
