import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {

    public static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Сервер запущен на порту " + PORT);
            System.out.println("Ожидание подключения...");

            try (Socket clientSocket = serverSocket.accept()) {
                System.out.println("New connection accepted");

                BufferedReader in = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()));

                PrintWriter out = new PrintWriter(
                        clientSocket.getOutputStream(), true);

                final String name = in.readLine();

                System.out.println("Получено от клиента: " + name);
                System.out.println("Порт клиента: " + clientSocket.getPort());

                out.println(String.format(
                        "Hi %s, your port is %d", name, clientSocket.getPort()));
            }
        }
        System.out.println("Сервер завершил работу.");
    }
}
