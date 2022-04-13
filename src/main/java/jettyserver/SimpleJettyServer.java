package jettyserver;

public class SimpleJettyServer {

    public static void main(String[] args) throws Throwable {

        JettyServer jetty = new JettyServer(8081);

        jetty.start();
        Thread.sleep(200);

        if (!jetty.isStarted()) {
            throw new Exception("Jetty server cannot start!");
        }
    }
}
