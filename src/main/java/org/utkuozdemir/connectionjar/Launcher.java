package org.utkuozdemir.connectionjar;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Created by Utku on 17.9.2014.
 */
public class Launcher {
	public static void main(String[] args) throws Exception {
		if (args.length != 1) {
			System.out.println("Give 1 argument, the website URL!");
			return;
		}

		String urlString = args[0].contains("://") ? args[0] : "http://" + args[0];
		URL url = new URL(urlString);
		String line;
		try (InputStream is = url.openStream()) {
			try (InputStreamReader isr = new InputStreamReader(is)) {
				try (BufferedReader br = new BufferedReader(isr)) {
					while ((line = br.readLine()) != null) {
						System.out.println(line);
					}
				}
			}
		}
	}
}
