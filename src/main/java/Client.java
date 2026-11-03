import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws IOException {
        try (Socket socket = new Socket("localhost", Server.PORT)) {
            System.out.println("Клиент подключился, локальный порт: "
                    + socket.getLocalPort());

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            String name = "Alice";
            out.println(name);
            System.out.println("Отправлено серверу: " + name);

            String response = in.readLine();
            System.out.println("Ответ сервера: " + response);
        }
    }
}