

/**
 *
 * @author George
 */
import javafx.application.Application;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Login extends Application {

    private TextField userField;
    private PasswordField passField;
    private Text actiontarget;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        GridPane grid = grid();

        Text scenetitle = new Text("Welcome");
        scenetitle.setId("welcome-text");
        grid.add(scenetitle, 0, 0, 2, 1);

        Label userName = new Label("User Name:");
        grid.add(userName, 0, 1);

        userField = new TextField();
        grid.add(userField, 1, 1);

        Label pw = new Label("Password:");
        grid.add(pw, 0, 2);

        passField = new PasswordField();
        grid.add(passField, 1, 2);

        Button signin = new Button("Sign in");
        Button clear = new Button("Clear");
        HBox hbBtn = new HBox(10, signin, clear);
        grid.add(hbBtn, 1, 4);

        actiontarget = new Text();
        actiontarget.setId("actiontarget");
        grid.add(actiontarget, 0, 6);
        GridPane.setColumnSpan(actiontarget, 2);

        signin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                login();
            }
        });

        clear.setOnAction(event ->  clear());

        Scene scene = new Scene(grid, 400, 300);
        scene.getStylesheets().add(Login.class.getResource("Login.css").toExternalForm());
        stage.setTitle("Sign In");
        stage.setScene(scene);
        stage.show();
    }

    private GridPane grid() {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        return grid;
    }

    private String loginAction(String user, String password) {
        return (user.equals("Georges") && password.equals("tutor")) ? user + " has successfully signed in" : "unknown user!";
    }

    private void login() {
        String user = userField.getText();
        String password = passField.getText();
        actiontarget.setText(loginAction(user, password));
    }

    private void clear() {
        actiontarget.setText("");
        userField.setText("");
        passField.setText("");
    }
}
