import com.sun.deploy.nativesandbox.NativeSandboxOutputStream;
import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;

public class ClientUiController {
    public TextArea txtArea;
    public TextField txtMessege;

    static Socket socket;
    static DataInputStream dataInputStream;
    static DataOutputStream dataOutputStream;


    public void initialize() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    socket = new Socket("localhost", 5000);
                    dataInputStream = new DataInputStream(socket.getInputStream());
                    dataOutputStream = new DataOutputStream(socket.getOutputStream());

                    String messageIn = "";
                    while (!messageIn.equals("exit")) {
                        messageIn = dataInputStream.readUTF();
                        txtArea.appendText("\n Server :" + messageIn.trim());
                    }

                } catch (Exception e) {
                    e.printStackTrace();

                }
            }
        }).start();
    }
//

public void SendOnAction(MouseEvent mouseEvent) throws IOException {
    String messageOut="";
    messageOut=txtMessege.getText();
    dataOutputStream.writeUTF(messageOut);
    txtArea.appendText("\n \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t Me:"+ messageOut.trim());
    txtMessege.clear();
}

    public void sendPhoto(MouseEvent mouseEvent) throws IOException, InterruptedException {
//        BufferedImage image = ImageIO.read(new File("C:\\Users\\Ishu\\Pictures\\project pic\\student .jpg"));
//
//
//        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//        ImageIO.write(image, "jpg", byteArrayOutputStream);
//
//        byte[] size = ByteBuffer.allocate(4).putInt(byteArrayOutputStream.size()).array();
//        dataOutputStream.write(size);
//        dataOutputStream.write(byteArrayOutputStream.toByteArray());
//        dataOutputStream.flush();
//        System.out.println("Flushed: " + System.currentTimeMillis());
//
//        Thread.sleep(120000);
//        System.out.println("Closing: " + System.currentTimeMillis());
//        socket.close();

    }

    public void ExitOnActions(ActionEvent actionEvent) {
        System.exit(0);
    }

}

