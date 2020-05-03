import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GameServer {
    private  static final int PORT=9090;
    private static boolean ServerIsRunning=true;
    private static String cmd="exit";

    private static ArrayList<ClientThread> clients=new ArrayList<>();
    private static ExecutorService pool= Executors.newFixedThreadPool(4);

    public static void main(String[] args) throws IOException {
        ServerSocket listener = null;

            listener=new ServerSocket(PORT);
            while (ServerIsRunning) {
                System.out.println("[SERVER] waiting for client connection...");
                Socket client = listener.accept();
                System.out.println("[SERVER] Connected to client!");
                ClientThread clientThread = new ClientThread(client);
                clients.add(clientThread);
                pool.execute(clientThread);





        }

    }

}
