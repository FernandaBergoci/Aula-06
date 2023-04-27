package client;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import util.MsgRequest;
import util.MsgResponse;
import util.Status; 
/**
 * Client
 */
public class Client {

    public static void main(String[] args) {
        Socket socket;
        final String HOST = "localhost";
        final int PORT = 12345;
        double value1, value2;
        char oper;
        Scanner entrada = new Scanner(System.in);

        try {
            socket = new Socket(HOST, PORT);
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

            System.out.println("Digite a operação (+, -, *, /)");
            oper = entrada.nextLine().charAt(0);
            System.out.println("Digite o primeiro valor: ");
            value1 = Double.parseDouble(entrada.nextLine());
            System.out.println("Digite o segundo valor: ");
            value2 = Double.parseDouble(entrada.nextLine());

            MsgRequest request = new MsgRequest(value1, value2, oper);
            
            out.writeObject(request);

            MsgResponse response = (MsgResponse) in.readObject();

            if(response.getStatus() == Status.SUCESSO) {
                System.out.println("Resposta: " + response.getValue());
            } else {
                if(response.getStatus() == Status.DIVISAO_ZERO) {
                    System.out.println("Erro. Divisão por zero");
                } else {
                    System.out.println("Operador inválido");
                }
            }


            entrada.close();
            socket.close();
        } catch (Exception e) {
           System.out.println("Error: " + e.getMessage());
           
        }
    }
}