package org.italiangrid.remoting.display;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

public class JettyServletContext implements Runnable {

	final Server server;
	final int port = 8080;

	public JettyServletContext() throws Exception {

		server = new Server(port);

		ServletContextHandler context = new ServletContextHandler();
		server.setHandler(context);
	}

	public void run() {
		try {
			server.start();
			server.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
