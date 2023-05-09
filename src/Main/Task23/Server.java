import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Server {
    private static final String BLACKLIST_FILE = "blacklist.txt";
    private static final int BUFFER_SIZE = 1024;

    public static void main(String[] args) throws IOException {
        Set<String> blacklist = readBlacklist();

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(9896));

        Selector selector = Selector.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        WatchService watcher = FileSystems.getDefault().newWatchService();
        Path dir = Paths.get(".");
        dir.register(watcher, StandardWatchEventKinds.ENTRY_MODIFY);

        while (true) {
            selector.select();
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();

            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();

                if (key.isAcceptable()) {
                    ServerSocketChannel channel = (ServerSocketChannel) key.channel();
                    SocketChannel socketChannel = channel.accept();
                    SocketAddress clientAddress = socketChannel.getRemoteAddress();

                    if (blacklist.contains(clientAddress.toString())) {
                        System.out.println("IP address " + clientAddress + " is in the blacklist.");
                        socketChannel.close();
                    } else {
                        System.out.println("Accepted connection from " + clientAddress);
                        ByteBuffer buffer = ByteBuffer.wrap("Welcome".getBytes());
                        socketChannel.write(buffer);
                        socketChannel.configureBlocking(false);
                        socketChannel.register(selector, SelectionKey.OP_READ);
                    }
                } else if (key.isReadable()) {
                    SocketChannel socketChannel = (SocketChannel) key.channel();
                    ByteBuffer buffer = ByteBuffer.allocate(BUFFER_SIZE);
                    int bytesRead = 0;

                    try {
                        bytesRead = socketChannel.read(buffer);
                    } catch (IOException e) {
                        SocketAddress clientAddress = socketChannel.getRemoteAddress();
                        System.out.println("Connection closed by client " + clientAddress);
                        socketChannel.close();
                        break;
                    }

                    if (bytesRead == -1) {
                        SocketAddress clientAddress = socketChannel.getRemoteAddress();
                        System.out.println("Connection closed by client " + clientAddress);
                        socketChannel.close();
                    } else {
                        String message = new String(buffer.array()).trim();
                        System.out.println("Received message: " + message);
                    }
                }

                iterator.remove();
            }
        }
    }

    private static Set<String> readBlacklist() throws IOException {
        Set<String> blacklist = new HashSet<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(BLACKLIST_FILE))) {
            String line;

            while ((line = reader.readLine()) != null) {
                blacklist.add(line.trim());
            }
        }

        return blacklist;
    }
}
