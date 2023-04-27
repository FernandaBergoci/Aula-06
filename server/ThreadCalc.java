import java.net.Socket;

public class ThreadCalc extends Thread {
    private Socket cliente;

    public ThreadCalc(Socket cliente) {
        this.cliente = cliente;
    }

    @Override
    public void run() {
        try {
            System.out.println("Conect with " + cliente.getInetAddress().getHostAddress());
            
            cliente.close();
        } catch (Exception e) {
            System.out.println("Erro on thread: " + e.getMessage());
        }

    }
    

}
