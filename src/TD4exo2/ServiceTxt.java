package TD4exo2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServiceTxt extends Service {
    public ServiceTxt(Socket socket) {
        super(socket);
    }

    @Override
    public void run() {
        try {
            PrintWriter out = new PrintWriter(getSocket().getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(getSocket().getInputStream()));


            String chaineInverse = in.readLine();

            StringBuilder sb = new StringBuilder();

            chaineInverse = sb.append(chaineInverse).reverse().toString();

            out.println(chaineInverse);

            out.close();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
