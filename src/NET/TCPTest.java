package NET;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;

public class TCPTest {
    public static void main(String[] args) throws IOException {
        client();
        server();
    }

    public static void client() throws IOException {
        InetAddress inet = InetAddress.getByName("127.0.0.1");
        Socket socket = new Socket(inet,8889);

        OutputStream os = socket.getOutputStream();
        os.write("clent:".getBytes());

        os.close();
        socket.close();
    }

    public static void server() throws IOException {
        ServerSocket ss = new ServerSocket(8889);
        Socket socket = ss.accept();
        InputStream is = socket.getInputStream();
        byte[] buffer = new byte[20];
        int len;
        while ((len = is.read(buffer)) != -1){
            String str = new String(buffer,0,len);
            System.out.println(str);
        }
    }
}
