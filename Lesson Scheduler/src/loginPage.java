import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
/**
 * 
 * @author Jamie Small
 * This class includes the main of the program, along with all of the GUI elements of the program
 *
 */
public class loginPage extends Application{
	static BorderPane launchRoot = new BorderPane();
	static HBox launchButtonsBox = new HBox();
	static Button loginStudent = new Button("Login Student");
	static Button registerAccount = new Button("Register");
	static Button loginAdmin = new Button("Login Admin");
	static Scene launchScene = new Scene(launchRoot);
	static Stage loginStage = new Stage();
	static BorderPane loginRoot = new BorderPane();
	static VBox loginFields = new VBox();
	static TextField loginUsername = new TextField();
	static PasswordField loginPassword = new PasswordField();
	static Stage registerStage = new Stage();
	static BorderPane registerRoot = new BorderPane();
	static HBox firstName = new HBox();
	static Label firstNameL = new Label("First Name:\t\t");
	static TextField firstNameF = new TextField();
	static HBox lastName = new HBox();
	static Label lastNameL = new Label("Last Name:\t\t");
	static TextField lastNameF = new TextField();
	static HBox loginAll = new HBox();
	static Button login = new Button("Login");
	static Scene loginScene = new Scene(loginRoot);
	static HBox email = new HBox();
	static Label emailL = new Label("Email:\t\t\t");
	static TextField emailF = new TextField();
	static HBox phoneNumber = new HBox();
	static Label phoneNumberL = new Label("Phone Number:\t");
	static TextField phoneNumberF = new TextField();
	static Button register = new Button("Register");
	static VBox registerAll = new VBox();
	static Scene registerScene = new Scene(registerRoot);
	static Stage launchStage = new Stage();
	static HBox registerPassword = new HBox();
	static HBox registerUsername = new HBox();
	static Label registerPasswordLabel = new Label("Password:\t\t\t"); 
	static PasswordField registerPasswordField = new PasswordField();
	static Label registerUserNameLabel = new Label("Username:\t\t");
	static TextField registerUserNameField = new TextField();
	static Stage studentViewStage = new Stage();
	static BorderPane studentViewRoot = new BorderPane();
	static Scene studentViewScene = new Scene(studentViewRoot);
	static DatePicker availableDays = new DatePicker();
	static Button submit = new Button("Submit");
	static VBox studentViewFull = new VBox();
	static Stage adminViewStage = new Stage();
	static BorderPane adminViewRoot = new BorderPane();
	static Scene adminViewScene = new Scene(adminViewRoot);
	static TextField lastNameSearchA = new TextField();
	static TextField firstNameSearchA = new TextField();
	static Button submitAdmin = new Button("Submit");	
	static ArrayList<Student> allStudents = new ArrayList<Student>();
	static ObservableList<Student> test = FXCollections.observableArrayList(allStudents);
	static VBox adminViewFull = new VBox();
	static HBox searchControlsA = new HBox();
	static ArrayList<Student> allAdmins = new ArrayList<Student>();
	static ArrayList<String> studentDays = new ArrayList<String>();
	static ArrayList<Day> fullSchedule = new ArrayList<Day>();

	static VBox fullWeekViewFinal = new VBox();
	static Stage availableTimesStage = new Stage();
	static BorderPane availableTimesRoot = new BorderPane();
	static Scene availableTimesScene = new Scene(availableTimesRoot);
	
	static Label ten = new Label("10:00\t");
	static Label eleven = new Label("11:00\t");
	static Label twelve = new Label("12:00\t");
	static Label thirteen = new Label("13:00\t");
	static Label fourteen = new Label("14:00\t");
	static Label fifteen = new Label("15:00\t");
	static Label sixteen = new Label("16:00\t");
	static Label seventeen = new Label("17:00\t");
	
	static Button tenB = new Button();
	static Button elevenB = new Button();
	static Button twelveB = new Button();
	static Button thirteenB = new Button();
	static Button fourteenB = new Button();
	static Button fifteenB = new Button();
	static Button sixteenB = new Button();
	static Button seventeenB = new Button();
	static Button back = new Button("Back");
	static TextArea adminStudentView = new TextArea();
	static Stage logOutStage = new Stage();
	static BorderPane logOutRoot = new BorderPane();
	static Scene logOutScene = new Scene(logOutRoot);
	static Label message = new Label("Are you sure you'd like to Log Out?");
	static Button yes = new Button("Yes");
	static Button no = new Button("No");
	static VBox all = new VBox();
	static HBox buttonsLogOut = new HBox();
	
	static HBox one = new HBox();
	static HBox two = new HBox();
	static HBox three = new HBox();
	static HBox four = new HBox();
	static HBox five = new HBox();
	static HBox six = new HBox();
	static HBox seven = new HBox();
	static HBox eight = new HBox();
	static VBox timesFinal = new VBox();
	
	static Label errorLogin = new Label();
		
	static String loggedInStudent;
	static String loggedInUsername;
	
	static PrintWriter fout;
	
	private static boolean isAdmin;
	
	static Button logoutStudent = new Button("Log Out");
	static Button logoutAdmin = new Button("Log Out");
	
	/**
	 * 
	 * @param main - the main section of the program
	 */
	public static void main(String[] args) 
	{
		fillResources();
		launch(args);
	}
	
	
	
	/**
	 * 
	 * @param fileName - takes in a file value so it can read in Strings and copy them to their own values within the program
	 * @return 
	 */
	public static Scanner getScanner(String fileName)
	{
		Scanner scan = null;

		while(scan == null)
		{
			try {
				scan = new Scanner(new File(fileName));
			} catch (FileNotFoundException e) {
				try {
					PrintWriter c = new PrintWriter(fileName);
					
				} catch (FileNotFoundException e1) {
					// TODO prompt user for directory file chooser etc
					FileChooser chooser = new FileChooser();
					fileName = chooser.showSaveDialog(null).getName();
				}
			}
		
		}
		
		return scan;
	}
	
	/**
	 * Scans through the list of students, administrative, and schedule files and splits them into separate 
	 * parts for the program to recognize
	 */
	public static void fillResources()
	{
		Scanner scan = getScanner("resources/students.txt");
		
		while(scan.hasNextLine()) {
			String l = scan.nextLine();
			String[] entryParts = l.split("\t");
			String firstName = entryParts[0];
			String lastName = entryParts[1];
			String email = entryParts[2];
			String phoneNumber = entryParts[3];
			String username = entryParts[4];
			String password = entryParts[5];
			
			allStudents.add(new Student(firstName, lastName, email, phoneNumber, username, password));
		}
		scan.close();
		
		
		scan = getScanner("resources/admins.txt");
		
		while(scan.hasNextLine()) {
			String l = scan.nextLine();
			String[] entryParts = l.split("\t");
			String firstName = entryParts[0];
			String lastName = entryParts[1];
			String email = entryParts[2];
			String phoneNumber = entryParts[3];
			String username = entryParts[4];
			String password = entryParts[5];
			
			allAdmins.add(new Student(firstName, lastName, email, phoneNumber, username, password));
		}
		
		
		scan.close();
		
		scan = getScanner("resources/fullSchedule.txt");
		
		while(scan.hasNextLine()) {
			String l = scan.nextLine();
			String[] entryParts = l.split("\t");
			String day = entryParts[0];
			String month = entryParts[1];
			String year = entryParts[2];
			String time = entryParts[3];
			String studentName = entryParts[4];
			
			int days = Integer.parseInt(day);
			int months = Integer.parseInt(month);
			int years = Integer.parseInt(year);
			
			
			
			fullSchedule.add(new Day(days, months, years, time, studentName));
		}
		
		
		scan.close();
	}
	
	
	
	@SuppressWarnings("unchecked")
	@Override
	/**
	 * Starts the GUI of the program
	 */
	public void start(Stage launchStage) throws Exception 
	{
		//launch screen
		this.launchStage = launchStage;
		launchRoot.setMinSize(150, 100);
		
		launchStage.getIcons().add(new Image("goLocator Logo.png"));
		loginStage.getIcons().add(new Image("goLocator Logo.png"));
		registerStage.getIcons().add(new Image("goLocator Logo.png"));
		studentViewStage.getIcons().add(new Image("goLocator Logo.png"));
		adminViewStage.getIcons().add(new Image("goLocator Logo.png"));
		logOutStage.getIcons().add(new Image("goLocator Logo.png"));
		availableTimesStage.getIcons().add(new Image("goLocator Logo.png"));
		
		
		launchButtonsBox.getChildren().addAll(loginStudent, registerAccount,
				loginAdmin);
		
		Image logo = new Image("goLocator Logo.png");
		ImageView logoView = new ImageView(logo);
		logoView.setFitHeight(150);
		logoView.setFitWidth(225);
		
		launchRoot.setCenter(logoView);
		launchRoot.setBottom(launchButtonsBox);
		launchStage.setTitle("goScheduler");
		launchStage.setScene(launchScene);
		
		//login screen
		
		
		
		
		loginUsername.setPromptText("Username");
		
		loginPassword.setPromptText("Password");
		
		loginFields.getChildren().addAll(loginUsername, loginPassword);
		
		
		loginFields.setPadding(new Insets(0,15,0,0));
		
		loginAll.getChildren().addAll(loginFields, login);
		loginRoot.setCenter(loginAll);
		loginRoot.setBottom(errorLogin);
		loginRoot.setRight(back);
		
		loginStage.setScene(loginScene);
		loginRoot.setMinSize(100, 20);
		loginStage.setResizable(false);
		
		//register screen
		
		registerRoot.setMinSize(300, 150);
		registerStage.setResizable(false);
		
		firstName.getChildren().addAll(firstNameL, firstNameF);
		
		lastName.getChildren().addAll(lastNameL, lastNameF);
		
		email.getChildren().addAll(emailL, emailF);
		
		phoneNumber.getChildren().addAll(phoneNumberL, phoneNumberF);
		
		
		registerUsername.getChildren().addAll(registerUserNameLabel, registerUserNameField);
		registerPassword.getChildren().addAll(registerPasswordLabel, registerPasswordField);
		
		
		registerAll.getChildren().addAll(firstName, lastName, email, 
				phoneNumber, registerUsername, registerPassword, register);
		
		availableDays.setPromptText("Select your Lesson Time -->");
		registerRoot.setCenter(registerAll);
		registerStage.setScene(registerScene);
		
		//student-view screen
		final ObservableList<Student> data = FXCollections.observableArrayList(allStudents);
		final ObservableList<Day> dataD = FXCollections.observableArrayList(fullSchedule);
		
		studentViewRoot.setMinSize(400, 400);
		availableDays.setMinWidth(400);
		availableDays.setDayCellFactory(picker -> new DateCell() {
	        public void updateItem(LocalDate date, boolean empty) {
	            super.updateItem(date, empty);
	            LocalDate today = LocalDate.now();
	            setDisable(empty || date.compareTo(today) < 0 );
	        }
	    });
		
		availableDays.setEditable(false);
		
		
		
		
		availableDays.setPromptText("Available Days For Lesson");
		submit.setMinWidth(200);
		studentViewFull.getChildren().addAll(availableDays, submit);
		studentViewRoot.setCenter(studentViewFull);
		studentViewRoot.setBottom(logoutStudent);
		studentViewRoot.setMinSize(150, 50);
		studentViewStage.setResizable(false);
		studentViewStage.setScene(studentViewScene);
		
		//admin-view screen
		
		
		
		lastNameSearchA.setPromptText("Last Name");
		firstNameSearchA.setPromptText("First Name");
		
		searchControlsA.getChildren().addAll(lastNameSearchA, 
				 firstNameSearchA, submitAdmin);
		adminViewFull.getChildren().addAll(searchControlsA, adminStudentView);
		adminViewRoot.setMinSize(150, 50);
		adminViewStage.setResizable(false);
		adminStudentView.setEditable(false);
		adminViewRoot.setCenter(adminViewFull);
		adminViewRoot.setBottom(logoutAdmin);
		adminViewStage.setScene(adminViewScene);
		
		
		//full week schedule view screen
		
		
		
		
		buttonsLogOut.getChildren().addAll(yes, no);
		all.getChildren().addAll(message, buttonsLogOut);
		logOutRoot.setCenter(all);
		logOutStage.setScene(logOutScene);
		
		
	
		
		
		
		one.getChildren().addAll(ten, tenB);
		two.getChildren().addAll(eleven, elevenB);
		three.getChildren().addAll(twelve, twelveB);
		four.getChildren().addAll(thirteen, thirteenB);
		five.getChildren().addAll(fourteen, fourteenB);
		six.getChildren().addAll(fifteen, fifteenB);
		seven.getChildren().addAll(sixteen, sixteenB);
		eight.getChildren().addAll(seventeen, seventeenB);
		
		timesFinal.getChildren().addAll(one, two, three, four, five, six, seven, eight);
		
		availableTimesRoot.setCenter(timesFinal);
		
		availableTimesRoot.setMinSize(160, 180);
		availableTimesStage.setResizable(false);
		availableTimesStage.setScene(availableTimesScene);
		
		
		
		launchStage.show();
		
		buttonActions();
		
	}
	/**
	 * 
	 * @author Jamie Small
	 * Handles the events of an input
	 *
	 */
	private class MyEventHandler implements EventHandler<Event>{
        @Override
        public void handle(Event evt) {
           System.out.println(((Control)evt.getSource()).getId());
        }
    }
	/**
	 * 
	 * @param localDate - takes in a date value and fills specific details for a Monday in the schedule
	 */
	public static void setButtonsMonday(LocalDate localDate)
	{
		String twelve = "TIME NOT OPEN";
		String fourteen = "TIME NOT OPEN";
		String sixteen = "TIME NOT OPEN";
		twelveB.setText(twelve);		twelveB.setDisable(true);
		fourteenB.setText(fourteen);	fourteenB.setDisable(true);
		sixteenB.setText(sixteen);		sixteenB.setDisable(true);
		
		for(Day d : fullSchedule)
		{
			int day = d.getDay();
			if(day == localDate.getDayOfMonth())
			{
				String time = d.getTime();
				int timeF = Integer.parseInt(time);
				if(timeF == 1000)
				{
					tenB.setDisable(true);
					tenB.setText("TIME NOT OPEN");
				}else if(timeF ==1100)
				{
					elevenB.setDisable(true);
					elevenB.setText("TIME NOT OPEN");
				}else if(timeF == 1300)
				{
					thirteenB.setDisable(true);
					thirteenB.setText("TIME NOT OPEN");
				}else if(timeF == 1500)
				{
					fifteenB.setDisable(true);
					fifteenB.setText("TIME NOT OPEN");
				}else if(timeF == 1700)
				{
					seventeenB.setDisable(true);
					seventeenB.setText("TIME NOT OPEN");
				}
				
			}
		}
		
		
	}
	
	/**
	 * 
	 * @param localDate - takes in a date value and fills specific details for a Tuesday in the schedule
	 */
	public static void setButtonsTuesday(LocalDate localDate)
	{
		String twelve = "TIME NOT OPEN";
		String thirteen = "TIME NOT OPEN";
		String fourteen = "TIME NOT OPEN";
		String seventeen = "TIME NOT OPEN";
		twelveB.setText(twelve);		twelveB.setDisable(true);
		thirteenB.setText(thirteen);	thirteenB.setDisable(true);
		fourteenB.setText(fourteen);	fourteenB.setDisable(true);
		seventeenB.setText(seventeen);	seventeenB.setDisable(true);
		
		for(Day d : fullSchedule)
		{
			int day = d.getDay();
			if(day == localDate.getDayOfMonth())
			{
				String time = d.getTime();
				int timeF = Integer.parseInt(time);
				if(timeF == 1000)
				{
					tenB.setDisable(true);
					tenB.setText("TIME NOT OPEN");
				}else if(timeF ==1100)
				{
					elevenB.setDisable(true);
					elevenB.setText("TIME NOT OPEN");
				}else if(timeF == 1500)
				{
					fifteenB.setDisable(true);
					fifteenB.setText("TIME NOT OPEN");
				}else if(timeF == 1600)
				{
					sixteenB.setDisable(true);
					sixteenB.setText("TIME NOT OPEN");
				}
				
			}
		}
		
		
	}
	/**
	 * 
	 * @param localDate - takes in a date value and fills specific details for a Wednesday in the schedule
	 */
	public static void setButtonsWednesday(LocalDate localDate)
	{
		String twelve = "TIME NOT OPEN";
		String thirteen = "TIME NOT OPEN";
		String sixteen = "TIME NOT OPEN";
		twelveB.setText(twelve);		twelveB.setDisable(true);
		thirteenB.setText(thirteen);	thirteenB.setDisable(true);
		sixteenB.setText(sixteen);		sixteenB.setDisable(true);
		
		for(Day d : fullSchedule)
		{
			int day = d.getDay();
			if(day == localDate.getDayOfMonth())
			{
				String time = d.getTime();
				int timeF = Integer.parseInt(time);
				if(timeF == 1000)
				{
					tenB.setDisable(true);
					tenB.setText("TIME NOT OPEN");
				}else if(timeF ==1100)
				{
					elevenB.setDisable(true);
					elevenB.setText("TIME NOT OPEN");
				}else if(timeF == 1400)
				{
					fourteenB.setDisable(true);
					fourteenB.setText("TIME NOT OPEN");
				}else if(timeF == 1500)
				{
					fifteenB.setDisable(true);
					fifteenB.setText("TIME NOT OPEN");
				}else if(timeF == 1700)
				{
					seventeenB.setDisable(true);
					seventeenB.setText("TIME NOT OPEN");
				}
				
			}
		}
		
		
	}
	
	
	
	
	/**
	 * Sets actions to all buttons used within the program
	 */
	@SuppressWarnings("unused")
	public static void buttonActions()
	{
	//first launch screen button on actions
		back.setOnAction(e ->{
			launchStage.show();
			loginStage.close();
		});
		logoutStudent.setOnAction(e ->{
			logOutStage.show();
			yes.setOnAction(new EventHandler<ActionEvent>() {
	            @Override
	            public void handle(ActionEvent event) {
	            	
					loggedInStudent = "";
					loggedInUsername = "";
					studentViewStage.close();
					logOutStage.close();
					
					launchStage.show();
					

	            }
	        });
			
			no.setOnAction(new EventHandler<ActionEvent>() {
	            @Override
	            public void handle(ActionEvent event) {
	            	
	            	logOutStage.close();
					
	            }
	        });
		});
		
		logoutAdmin.setOnAction(e ->{
			logOutStage.show();
			yes.setOnAction(new EventHandler<ActionEvent>() {
	            @Override
	            public void handle(ActionEvent event) {
	            	
					loggedInStudent = "";
					loggedInUsername = "";
					adminViewStage.close();
					logOutStage.close();
					launchStage.show();
	            	
	            }
	        });
			
			no.setOnAction(new EventHandler<ActionEvent>() {
	            @Override
	            public void handle(ActionEvent event) {
	            	
	            	logOutStage.close();
					
	            }
	        });
		});
		
		loginStudent.setOnAction(e->{
			launchStage.close();
			loginRoot.setMinSize(150, 100);
			loginStage.show();
			loginStage.setTitle("Student Login");
			isAdmin = false;
		});
		
		registerAccount.setOnAction(e->{
			launchStage.close();
			registerStage.setTitle("Register New Student User");
			registerStage.show();
		});
		
		loginAdmin.setOnAction(e->{
			launchStage.close();
			loginStage.setTitle("Administrator Login");
			loginRoot.setMinSize(250, 100);
			loginStage.show();
			adminStudentView.requestFocus();
			isAdmin = true;
		});
		
	//register screen button on action
		register.setOnAction(e->{
			File file = new File("resources/students.txt");
			try {
				PrintWriter fout = new PrintWriter(file);
				allStudents.add(new Student(firstNameF.getText(), lastNameF.getText(), emailF.getText(), phoneNumberF.getText(), 
						registerUserNameField.getText(), registerPasswordField.getText()));
				
				for(Student s : allStudents)
				{
					fout.println(s);
				}
				
				
				fout.close();
			}
			catch(FileNotFoundException r) {
				r.printStackTrace();
			}	
			registerStage.close();
			launchStage.show();
		});
	
	//login screen button on action	
		login.setOnAction(e->{
			if(isAdmin)
			{
				for(Student x : allAdmins)
				{
					if(x.getUsername().equals(loginUsername.getText()) && x.getPassword().equals(loginPassword.getText()))
					{
						loggedInUsername = loginUsername.getText();
						loginStage.close();
						adminViewStage.setTitle("goSchedule - " + loggedInUsername + " logged in");
						adminViewStage.show();
						loginUsername.clear();
						loginPassword.clear();
						errorLogin.setText("");
					}else if(x.getUsername() != loginUsername.getText())
					{
						errorLogin.setText("Login Attempt Failed - Try Again");
					}else if(x.getUsername().equals(loginUsername.getText()) && x.getPassword() != loginPassword.getText())
					{
						errorLogin.setText("Login Attempt Failed - Try Again");
					}
				}
				
			}
			
			else{
				for(Student y : allStudents)
				{
					if(y.getUsername().equals(loginUsername.getText()) && y.getPassword().equals(loginPassword.getText()))
					{
						loggedInUsername = loginUsername.getText();
						loginStage.close();
						loggedInStudent = y.getFirstName() + " " + y.getLastName();
						studentViewStage.setTitle("goSchedule - " + loggedInUsername + " logged in");
						studentViewStage.show();
						loginUsername.clear();
						loginPassword.clear();
						errorLogin.setText("");
					}else if(y.getUsername() != loginUsername.getText())
					{
						errorLogin.setText("Login Attempt Failed - Try Again");
					}else if(y.getUsername().equals(loginUsername.getText()) && y.getPassword() != loginPassword.getText())
					{
						errorLogin.setText("Login Attempt Failed - Try Again");
					}
				}
				
			}
		});
		
		
		
		
		
		submit.setOnAction(e ->{
			LocalDate localDate = availableDays.getValue();
			int lastClickedIndex = -1;
			File file = new File("resources/fullSchedule.txt");
			
			Button[] buttons = new Button[8];
			buttons[0] = tenB;
			buttons[1] = elevenB;
			buttons[2] = twelveB;
			buttons[3] = thirteenB;
			buttons[4] = fourteenB;
			buttons[5] = fifteenB;
			buttons[6] = sixteenB;
			buttons[7] = seventeenB;
			
			int i = 0;
			for(i = 0; i < 6; i++) {
                final int buttonInd = i;
                buttons[i] = new Button(Integer.toString(i));
			}  
			for(Button b : buttons)
			{
				if((localDate.getDayOfWeek() != DayOfWeek.MONDAY) && (localDate.getDayOfWeek() != DayOfWeek.TUESDAY) && (localDate.getDayOfWeek() != DayOfWeek.WEDNESDAY))
        			{
        				//TODO make popup error
        			}else
        			{
        				availableTimesStage.show();
        				if(localDate.getDayOfWeek() == DayOfWeek.MONDAY)
        				{
        					tenB.setText("TIME AVAILABLE");
        					elevenB.setText("TIME AVAILABLE");
        					thirteenB.setText("TIME AVAILABLE");
        					fifteenB.setText("TIME AVAILABLE");
        					seventeenB.setText("TIME AVAILABLE");
        					
    						setButtonsMonday(localDate);
    						
    						tenB.setOnAction(new EventHandler<ActionEvent>() {
    				            @Override
    				            public void handle(ActionEvent event) {
    				            
		    						fullSchedule.add(new Day(localDate.getDayOfMonth(), localDate.getMonthValue(), localDate.getYear(), "1000", loggedInStudent));
									try {
										PrintWriter fout1 = new PrintWriter(file);
										
										for(Day s : fullSchedule)
										{
											fout1.println(s);
										}
										fout1.flush();
										availableTimesStage.close();
									} catch (FileNotFoundException e11) {
										System.out.println("ERROR");
									}
    				            }
    				        });
    						
    						elevenB.setOnAction(new EventHandler<ActionEvent>() {
    				            @Override
    				            public void handle(ActionEvent event) {
    				            
		    						fullSchedule.add(new Day(localDate.getDayOfMonth(), localDate.getMonthValue(), localDate.getYear(), "1100", loggedInStudent));
									try {
										PrintWriter fout1 = new PrintWriter(file);
										
										for(Day s : fullSchedule)
										{
											fout1.println(s);
										}
										fout1.flush();
										availableTimesStage.close();
									} catch (FileNotFoundException e11) {
										System.out.println("ERROR");
									}
    				            }
    				        });
    						
    						thirteenB.setOnAction(new EventHandler<ActionEvent>() {
    				            @Override
    				            public void handle(ActionEvent event) {
    				            
		    						fullSchedule.add(new Day(localDate.getDayOfMonth(), localDate.getMonthValue(), localDate.getYear(), "1300", loggedInStudent));
									try {
										PrintWriter fout1 = new PrintWriter(file);
										
										for(Day s : fullSchedule)
										{
											fout1.println(s);
										}
										fout1.flush();
										availableTimesStage.close();
									} catch (FileNotFoundException e11) {
										System.out.println("ERROR");
									}
    				            }
    				        });
    						
    						fifteenB.setOnAction(new EventHandler<ActionEvent>() {
    				            @Override
    				            public void handle(ActionEvent event) {
    				            
		    						fullSchedule.add(new Day(localDate.getDayOfMonth(), localDate.getMonthValue(), localDate.getYear(), "1500", loggedInStudent));
									try {
										PrintWriter fout1 = new PrintWriter(file);
										
										for(Day s : fullSchedule)
										{
											fout1.println(s);
										}
										fout1.flush();
										availableTimesStage.close();
									} catch (FileNotFoundException e11) {
										System.out.println("ERROR");
									}
    				            }
    				        });
        						
    						seventeenB.setOnAction(new EventHandler<ActionEvent>() {
    				            @Override
    				            public void handle(ActionEvent event) {
    				            
		    						fullSchedule.add(new Day(localDate.getDayOfMonth(), localDate.getMonthValue(), localDate.getYear(), "1700", loggedInStudent));
									try {
										PrintWriter fout1 = new PrintWriter(file);
										
										for(Day s : fullSchedule)
										{
											fout1.println(s);
										}
										fout1.flush();
										availableTimesStage.close();
									} catch (FileNotFoundException e11) {
										System.out.println("ERROR");
									}
    				            }
    				        });
    						
    						
        				}else if(localDate.getDayOfWeek() == DayOfWeek.TUESDAY)
        				{
        					tenB.setText("TIME AVAILABLE");
        					elevenB.setText("TIME AVAILABLE");
        					fifteenB.setText("TIME AVAILABLE");
        					sixteenB.setText("TIME AVAILABLE");
        					
    						setButtonsTuesday(localDate);
    						
    						tenB.setOnAction(new EventHandler<ActionEvent>() {
    				            @Override
    				            public void handle(ActionEvent event) {
    				            
		    						fullSchedule.add(new Day(localDate.getDayOfMonth(), localDate.getMonthValue(), localDate.getYear(), "1000", loggedInStudent));
									try {
										PrintWriter fout1 = new PrintWriter(file);
										
										for(Day s : fullSchedule)
										{
											fout1.println(s);
										}
										fout1.flush();
										availableTimesStage.close();
									} catch (FileNotFoundException e11) {
										System.out.println("ERROR");
									}
    				            }
    				        });
    						
    						elevenB.setOnAction(new EventHandler<ActionEvent>() {
    				            @Override
    				            public void handle(ActionEvent event) {
    				            
		    						fullSchedule.add(new Day(localDate.getDayOfMonth(), localDate.getMonthValue(), localDate.getYear(), "1100", loggedInStudent));
									try {
										PrintWriter fout1 = new PrintWriter(file);
										
										for(Day s : fullSchedule)
										{
											fout1.println(s);
										}
										fout1.flush();
										availableTimesStage.close();
									} catch (FileNotFoundException e11) {
										System.out.println("ERROR");
									}
    				            }
    				        });
    						
    						fourteenB.setOnAction(new EventHandler<ActionEvent>() {
    				            @Override
    				            public void handle(ActionEvent event) {
    				            
		    						fullSchedule.add(new Day(localDate.getDayOfMonth(), localDate.getMonthValue(), localDate.getYear(), "1400", loggedInStudent));
									try {
										PrintWriter fout1 = new PrintWriter(file);
										
										for(Day s : fullSchedule)
										{
											fout1.println(s);
										}
										fout1.flush();
										availableTimesStage.close();
									} catch (FileNotFoundException e11) {
										System.out.println("ERROR");
									}
    				            }
    				        });
    						
    						fifteenB.setOnAction(new EventHandler<ActionEvent>() {
    				            @Override
    				            public void handle(ActionEvent event) {
    				            
		    						fullSchedule.add(new Day(localDate.getDayOfMonth(), localDate.getMonthValue(), localDate.getYear(), "1500", loggedInStudent));
									try {
										PrintWriter fout1 = new PrintWriter(file);
										
										for(Day s : fullSchedule)
										{
											fout1.println(s);
										}
										fout1.flush();
										availableTimesStage.close();
									} catch (FileNotFoundException e11) {
										System.out.println("ERROR");
									}
    				            }
    				        });
    						
    						sixteenB.setOnAction(new EventHandler<ActionEvent>() {
    				            @Override
    				            public void handle(ActionEvent event) {
    				            
		    						fullSchedule.add(new Day(localDate.getDayOfMonth(), localDate.getMonthValue(), localDate.getYear(), "1600", loggedInStudent));
									try {
										PrintWriter fout1 = new PrintWriter(file);
										
										for(Day s : fullSchedule)
										{
											fout1.println(s);
										}
										fout1.flush();
										availableTimesStage.close();
									} catch (FileNotFoundException e11) {
										System.out.println("ERROR");
									}
    				            }
    				        });
        						
    						
        				}else if(localDate.getDayOfWeek() == DayOfWeek.WEDNESDAY)
        				{
        					tenB.setText("TIME AVAILABLE");
        					elevenB.setText("TIME AVAILABLE");
        					fourteenB.setText("TIME AVAILABLE");
        					fifteenB.setText("TIME AVAILABLE");
        					seventeenB.setText("TIME AVAILABLE");
        					
    						setButtonsWednesday(localDate);
    						
    						tenB.setOnAction(new EventHandler<ActionEvent>() {
    				            @Override
    				            public void handle(ActionEvent event) {
    				            
		    						fullSchedule.add(new Day(localDate.getDayOfMonth(), localDate.getMonthValue(), localDate.getYear(), "1000", loggedInStudent));
									try {
										PrintWriter fout1 = new PrintWriter(file);
										
										for(Day s : fullSchedule)
										{
											fout1.println(s);
										}
										fout1.flush();
										availableTimesStage.close();
									} catch (FileNotFoundException e11) {
										System.out.println("ERROR");
									}
    				            }
    				        });
    						
    						elevenB.setOnAction(new EventHandler<ActionEvent>() {
    				            @Override
    				            public void handle(ActionEvent event) {
    				            
		    						fullSchedule.add(new Day(localDate.getDayOfMonth(), localDate.getMonthValue(), localDate.getYear(), "1100", loggedInStudent));
									try {
										PrintWriter fout1 = new PrintWriter(file);
										
										for(Day s : fullSchedule)
										{
											fout1.println(s);
										}
										fout1.flush();
										availableTimesStage.close();
									} catch (FileNotFoundException e11) {
										System.out.println("ERROR");
									}
    				            }
    				        });
    						
    						
    						
    						fifteenB.setOnAction(new EventHandler<ActionEvent>() {
    				            @Override
    				            public void handle(ActionEvent event) {
    				            
		    						fullSchedule.add(new Day(localDate.getDayOfMonth(), localDate.getMonthValue(), localDate.getYear(), "1500", loggedInStudent));
									try {
										PrintWriter fout1 = new PrintWriter(file);
										
										for(Day s : fullSchedule)
										{
											fout1.println(s);
										}
										fout1.flush();
										availableTimesStage.close();
									} catch (FileNotFoundException e11) {
										System.out.println("ERROR");
									}
    				            }
    				        });
        						
    						sixteenB.setOnAction(new EventHandler<ActionEvent>() {
    				            @Override
    				            public void handle(ActionEvent event) {
    				            
		    						fullSchedule.add(new Day(localDate.getDayOfMonth(), localDate.getMonthValue(), localDate.getYear(), "1600", loggedInStudent));
									try {
										PrintWriter fout1 = new PrintWriter(file);
										
										for(Day s : fullSchedule)
										{
											fout1.println(s);
										}
										fout1.flush();
										availableTimesStage.close();
									} catch (FileNotFoundException e11) {
										System.out.println("ERROR");
									}
    				            }
    				            
    				        });
        					
        					
        					
        				}
        			}
                };
                
			});
                
                	
                
                
            submitAdmin.setOnAction(e ->{
            	adminStudentView.clear();
            	for(Day s : fullSchedule)
            	{
            		if(s.getStudentName().contains((firstNameSearchA.getText()) + " " + lastNameSearchA.getText()))
            		{
            			adminStudentView.appendText(s.getStudentName() + "\t" + s.getMonth() + "/" + s.getDay() + "/" + s.getYear() + ":\t" + s.getTime() + "\n");
            		}
            	}
            });    
                
                
            
			
			
			
			
			
			
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


}
