import javax.swing.*;
import java.io.*;
import java.net.Socket;

public class GameClient {

    private static final String SERVER_IP = "127.0.0.1";
    private static final int SERVER_PORT = 9090;
    private static boolean ClientIsRunning=true;

    public static void main(String[] args) throws IOException {
        Socket socket=new Socket(SERVER_IP,SERVER_PORT);

        BufferedReader input=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedReader keyboard=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out =new PrintWriter(socket.getOutputStream(),true);

        while (ClientIsRunning) {
            System.out.println("> ");
            String command = keyboard.readLine();

            if(command.equals("stop")){
                ClientIsRunning=false;
                System.out.println("ati fost deconectat");
                break;

            }
            else if(command.equals("exit")){
                ClientIsRunning=false;

            }

                out.println(command);

                String serverResponse = input.readLine();
                if ("serverul a fost inchis".equals(serverResponse)) {
                    break;
                }
                System.out.println(serverResponse);

        }
        socket.close();
        System.exit(0);

    }
}
