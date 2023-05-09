import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class Client {
    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9896));

        String message = "Hello from client";
        ByteBuffer buffer = ByteBuffer.wrap(message.getBytes());
        socketChannel.write(buffer);
        System.out.println("Sent message: " + message + " from " + socketChannel.getLocalAddress());

        buffer.clear();
        socketChannel.read(buffer);
        message = new String(buffer.array()).trim();
        System.out.println("Received message: " + message);
        socketChannel.close();
    }
}
