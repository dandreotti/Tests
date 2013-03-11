package org.italiangrid.remoting.display;

import org.italiangrid.remoting.greetings.Message;

public class ShowGreetings {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void show() throws Exception {

		new Thread(new JettyServletContext()).start();

		while (true) {
			System.out.println(Message.MSG.getMessage());
			Thread.sleep(5000);
		}

	}

}
