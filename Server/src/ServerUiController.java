import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;

public class ServerUiController {
    public TextArea txtArea;
    public TextField txtMessage;

    static ServerSocket serverSocket;
    static Socket socket;
    static DataOutputStream dataOutputStream;
    static DataInputStream dataInputStream;

    String messageIn ="";

    public void initialize() {
        new Thread(() -> {
            try {
                serverSocket = new ServerSocket(5000);
                System.out.println("Server Started!");
                socket = serverSocket.accept();
                System.out.println("Client Accepted!");

                dataInputStream = new DataInputStream(socket.getInputStream());
                dataOutputStream = new DataOutputStream(socket.getOutputStream());

                while (!messageIn.equals("end")) {
                    messageIn = dataInputStream.readUTF();
                    txtArea.appendText("\n Client :" + messageIn.trim());
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
    public void SendOnAction(MouseEvent mouseEvent) throws IOException {
        dataOutputStream.writeUTF(txtMessage.getText().trim());
        txtMessage.clear();
    }
    public void sendphotos(MouseEvent mouseEvent) throws IOException {
//            byte[] sizeAr = new byte[4];
//        dataInputStream.read(sizeAr);
//                int size = ByteBuffer.wrap(sizeAr).asIntBuffer().get();
//
//                byte[] imageAr = new byte[size];
//                dataInputStream.read(imageAr);
//
//                BufferedImage image = ImageIO.read(new ByteArrayInputStream(imageAr));
//
//                System.out.println("Received " + image.getHeight() + "x" + image.getWidth() + ": " + System.currentTimeMillis());
//                ImageIO.write(image, "jpg", new File("C:\\Users\\Ishu\\Pictures\\project picstudent .jpg"));
//
//                serverSocket.close();
    }


}


