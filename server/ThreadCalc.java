import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.net.Socket;
import util.MsgRequest;
import util.MsgResponse;
import util.Status;

public class ThreadCalc extends Thread {
    private Socket cliente;

    public ThreadCalc(Socket cliente) {
        this.cliente = cliente;
    }

    @Override
    public void run() {
        try {
           // System.out.println("Conect with " + cliente.getInetAddress().getHostAddress());
            
            ObjectInputStream in = new ObjectInputStream(cliente.getInputStream());
            ObjectOutputStream out = new ObjectOutputStream(cliente.getOutputStream());

            MsgRequest request = (MsgRequest) in.readObject();

            char oper = request.getOperation();
            double value1 = request.getValue1();
            double value2 = request.getValue2();
            double resp;
            MsgResponse response;

            switch (oper) {
                case '+':
                    resp = value1 + value2;
                    response = new MsgResponse(Status.SUCESSO, resp);
                    break;
                case '-':
                    resp = value1 - value2;
                    response = new MsgResponse(Status.SUCESSO, resp);
                    break;
                case '*':
                    resp = value1 * value2;
                    response = new MsgResponse(Status.SUCESSO, resp);
                    break;
                case '/':
                    if(request.getValue2() == 0) {
                        response = new MsgResponse(Status.DIVISAO_ZERO, 0);
                    } else {
                        resp = value1 / value2;
                        response = new MsgResponse(Status.SUCESSO, resp);
                    }
                    break;
            
                default:
                    response = new MsgResponse(Status.OPERADOR_INVALIDO, 0);
                    break;
            }

            out.writeObject(response);

            in.close();
            out.close();
            cliente.close();
        } catch (Exception e) {
            System.out.println("Erro on thread: " + e.getMessage());
        }

    }
    

}
