import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        ServerSocket server;
        final int PORTA = 12345;

        try {
            server = new ServerSocket(PORTA);
            while(true){
                System.out.println("Aguardando um cliente...");
                Socket client = server.accept();
                ThreadCalc calc = new ThreadCalc(client);
                calc.start();
            }


        } catch (Exception e) {
            System.out.println("Erro..." + e.getMessage());
        }
    }
}
