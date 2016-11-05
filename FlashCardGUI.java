
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.shape.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.geometry.*;

public class FlashCardGUI extends Application {

	public static final int WINDOW_WIDTH=800;
	public static final int WINDOW_HEIGHT=500;
	public static final int TOP_SPACING=10;
	public static final int TOP_SPACING2=30;
	public static final int BOTTOM_SPACING=50;
	public static final int BOTTOM_MARGIN=20;
	public static final int TOP_MARGIN=20;
	public static final int LEFT_SPACING=20;
	public static final int LEFT_MARGIN=20;
	public static final int RIGHT_MARGIN=30;
	public static final int RIGHT_SPACING=20;
    private Stage window;
    private HBox topBox;
    private Rectangle cardRect;
    private HBox bottomBox;
    private VBox leftBox;
    private VBox rightBox;
    

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("FlashCard");
        BorderPane sceneLayout = new BorderPane();
        
        createTop();
        sceneLayout.setTop(topBox);
        sceneLayout.setMargin(topBox, new Insets(TOP_MARGIN));
        
        createFlashCard();
        sceneLayout.setCenter(cardRect);
        
        createBottom();
        sceneLayout.setBottom(bottomBox);
        sceneLayout.setMargin(bottomBox, new Insets(BOTTOM_MARGIN));
        
        createLeft();
        sceneLayout.setLeft(leftBox);
        sceneLayout.setMargin(leftBox, new Insets(LEFT_MARGIN));
        
        createRight();
        sceneLayout.setRight(rightBox);
        sceneLayout.setMargin(rightBox,new Insets(RIGHT_MARGIN));
        
        Scene scene = new Scene(sceneLayout, WINDOW_WIDTH, WINDOW_HEIGHT);
        window.setScene(scene);
        window.show();
    }
    
    public void createTop(){
    	
    	HBox wordBox=new HBox();
    	Label wordLabel=new Label("Word");
    	TextField wordTextField=new TextField();
    	wordBox.getChildren().addAll(wordLabel,wordTextField);
    	wordBox.setSpacing(TOP_SPACING);
    	
    	HBox defBox=new HBox();
    	Label defLabel=new Label("Definition");
    	TextField defTextField=new TextField();
    	defBox.getChildren().addAll(defLabel,defTextField);
    	defBox.setSpacing(TOP_SPACING);
    	
    	HBox catBox=new HBox();
    	Label catLabel=new Label("Category");
    	ComboBox catComboBox=new ComboBox();
    	catBox.getChildren().addAll(catLabel,catComboBox);
    	catBox.setSpacing(TOP_SPACING);
    	
    	Button createButton=new Button("Create");
    	
    	topBox=new HBox();
    	topBox.getChildren().addAll(wordBox,defBox,catBox, createButton);
    	topBox.setAlignment(Pos.CENTER);
    	topBox.setSpacing(TOP_SPACING2);

    }
    
    public void createFlashCard(){
    	cardRect=new Rectangle(400,300);
    	cardRect.setFill(Color.WHITE);
    	cardRect.setStroke(Color.BLACK);
    }
    
    public void createBottom(){
    	Button deleteButton=new Button("Delete");
    	
    	Button prevButton=new Button("Previous");
    	
    	Button nextButton=new Button("Next");
    	
    	bottomBox=new HBox();
    	bottomBox.getChildren().addAll(deleteButton, prevButton, nextButton);
    	bottomBox.setSpacing(BOTTOM_SPACING);
    	bottomBox.setAlignment(Pos.CENTER);

    }
    
    public void createLeft(){
        leftBox=new VBox();
    	
    	Label addCatLabel=new Label("New Category");
    	TextField addCatTextField=new TextField();
    	addCatTextField.setMaxWidth(100);
    	Button addCatButton=new Button("Add");
    	leftBox.getChildren().addAll(addCatLabel,addCatTextField,addCatButton);
    	leftBox.setSpacing(LEFT_SPACING);
    	leftBox.setAlignment(Pos.CENTER);
    	
    }
    
    public void createRight(){
    	rightBox=new VBox();
    	
    	Label catLabel=new Label("Categories");
        ListView catList=new ListView();
        catList.setMaxWidth(170);
        rightBox.getChildren().addAll(catLabel,catList);
        rightBox.setAlignment(Pos.CENTER_LEFT);
        rightBox.setSpacing(RIGHT_SPACING);
    }
    
    
    public ComboBox createComboBox(){
    	//ObservableList<E> list=new ObservableList<E>();
    	
    	return new ComboBox();
    }
}