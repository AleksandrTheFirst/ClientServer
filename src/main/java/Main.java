public class Main {
    public static void main(String[] args) throws Exception {
        // Сервер — в отдельном потоке
        Thread serverThread = new Thread(() -> {
            try {
                Server.main(null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        serverThread.start();

        // Небольшая пауза, чтобы сервер успел открыть порт
        Thread.sleep(1000);

        // Клиент — в основном потоке
        Client.main(null);

        serverThread.join();
    }
}