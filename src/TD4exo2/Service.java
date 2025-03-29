package TD4exo2;

import java.net.Socket;

public abstract class Service implements Runnable {
    private Socket socket;
    public Service(Socket socket) {
        this.socket = socket;
    }

    public Socket getSocket() {
        return socket;
    }

}
