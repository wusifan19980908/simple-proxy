package com.jilin.simpleproxy;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

//@SpringBootTest
class SimpleProxyApplicationTests {

    @Test
    void contextLoads() throws IOException {
        Socket socket = new Socket("localhost",8081);
        OutputStream outputStream = socket.getOutputStream();
        String s = "123123123123123";
        outputStream.write(s.getBytes(StandardCharsets.UTF_8));
    }

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost",10040);
        OutputStream outputStream = socket.getOutputStream();
        String s = "123123123123123";
        outputStream.write(s.getBytes(StandardCharsets.UTF_8));
        socket.close();

    }

}
