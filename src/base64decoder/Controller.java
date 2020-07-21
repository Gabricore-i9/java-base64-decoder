package base64decoder;

import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static base64decoder.Decoder.decode;
import static base64decoder.Opener.OpenerMethod;
import static base64decoder.UrlValid.isValid;

public class Controller implements Initializable {
    public Button decodeButton;
    public Button copyButton;
    public Button openInBroswerButton;
    public TextField textInput;
    public Label textOutput;
    public Label infoLabel;
    public static String downloadLink;
    public static String hashbase64;
    public static String hashbase64decoded;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        textInput.requestFocus();
    }

    public void decodePressed() {
        hashbase64 = textInput.getText();
        if (hashbase64.isEmpty()) {
            infoLabel.setText("Enter a Base64 String first.");
        } else {
            try {
                hashbase64decoded = decode(hashbase64);
                textOutput.setText(hashbase64decoded);
                infoLabel.setText("String Decoded");
                copyButton.setDisable(false);
            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR, String.valueOf(e), ButtonType.OK);
                alert.setHeaderText(null);
                alert.showAndWait();
            }
        }
        openInBroswerButton.setDisable(!isValid(hashbase64decoded));
    }

    public void copyPressed() {
        downloadLink = textOutput.getText();
        StringSelection s = new StringSelection(downloadLink);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(s, null);
        infoLabel.setText("String Copied");
    }

    public void openInBroswerPressed() throws IOException {
        OpenerMethod();
        infoLabel.setText("URL Opened");
    }


}