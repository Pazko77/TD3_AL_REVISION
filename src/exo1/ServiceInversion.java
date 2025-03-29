package exo1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServiceInversion implements Runnable {
    private Socket client;

    public ServiceInversion() {}

    public ServiceInversion(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try {
        PrintWriter out = new PrintWriter(client.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));

        String chaineInverse = in.readLine();

        StringBuilder sb = new StringBuilder();

        chaineInverse = sb.append(chaineInverse).reverse().toString();

        out.println(chaineInverse);

        out.close();
        in.close();

    }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
