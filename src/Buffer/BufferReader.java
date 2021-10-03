package Buffer;

import java.io.*;

public class BufferReader {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\HJQ\\Desktop\\zabbix.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\HJQ\\Desktop\\zabbix1.txt"));

        String str;

        while ((str = br.readLine()) != null){
            bw.write(str);
            bw.newLine();
        }

        bw.close();
        br.close();
    }
}
