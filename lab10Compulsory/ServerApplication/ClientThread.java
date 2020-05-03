import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread implements  Runnable {
    private Socket client;
    private BufferedReader in;
    private PrintWriter out;

    public boolean isServerIsRunning() {
        return serverIsRunning;
    }

    private boolean serverIsRunning;



    public ClientThread(Socket clientSocket) throws IOException {
        this.client=clientSocket;
        in=new BufferedReader(new InputStreamReader(client.getInputStream()));
        out=new PrintWriter(client.getOutputStream(),true);
        this.serverIsRunning=true;

    }


    @Override
    public void run() {
        try {

            while (this.serverIsRunning) {
                String request = in.readLine();
                if(request==null) break;
                if (request.contains("exit")) {
                    out.println("serverul a fost inchis");
                    serverIsRunning=false;
                    System.exit(0);


                } else {
                    out.println("serverul a primit comanda ta");
                }

            }
        }catch (IOException e) {
            System.err.println("Clientul a fost deconectat");

        }finally {

            out.close();
            try {
                in.close();
            } catch (IOException e) {
                System.err.println("e");
            }
        }
    }

}
