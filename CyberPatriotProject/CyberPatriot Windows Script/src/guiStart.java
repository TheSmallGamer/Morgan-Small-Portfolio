import java.io.IOException;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class guiStart extends Application
{
	
	public void start(Stage primaryStage)
	{
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root, 480, 300);
			primaryStage.setTitle("CyberKey Beta 1.1.07");
			primaryStage.setAlwaysOnTop(true);
			primaryStage.setResizable(false);
			
			
			
		//Setting up Tabs w/ contents
			TabPane tabPane = new TabPane();
			ArrayList<String> tabs = new ArrayList<String>();
			tabs.add("Passwords");
			tabs.add("Firewall");
			tabs.add("Anti-Virus & Anti-Malware");		//TODO
			tabs.add("Account Policies");							//TODO
			tabs.add("Miscellaneous");							//TODO
			
			 for (int i = 0; i < 5; i++) {
		            Tab tab = new Tab();
		            tab.setText(tabs.get(i));
		            if(tabs.get(i).equals("Passwords"))
		            {
		            	HBox totalPWords = new HBox();									//total content box
		            	totalPWords.setAlignment(Pos.CENTER);
		            	VBox leftPWords = new VBox();									//actions on the left side
		            	leftPWords.setAlignment(Pos.CENTER_LEFT);
		            	VBox rightPWords = new VBox();									//actions on the right side
		            	rightPWords.setAlignment(Pos.CENTER_RIGHT);
		            	totalPWords.getChildren().addAll(leftPWords, rightPWords);		
		            	
		            	//TODO change this to actual content
		            	Button passwordPolicies = new Button("Password Policies");
		            	leftPWords.getChildren().add(passwordPolicies);
		            	passwordPolicies.setMinWidth(170);
		            	Button pWordExpire = new Button("Set Passwords to Expire");
		            	rightPWords.getChildren().add(pWordExpire);
		            	pWordExpire.setMinWidth(170);
		            	Button autoLoginOff = new Button("Turn off Auto Login");
		            	leftPWords.getChildren().add(autoLoginOff);
		            	autoLoginOff.setMinWidth(170);
		            	Button cntAltDelReq = new Button("Enable Ctrl+Alt+Del");
		            	rightPWords.getChildren().add(cntAltDelReq);
		            	cntAltDelReq.setMinWidth(170);
		            	rightPWords.setPadding(new Insets(30, 10, 10, 20));				 //(top/right/bottom/left)
		            	leftPWords.setPadding(new Insets(30, 20, 10, 10));				 //(top/right/bottom/left)
		            	rightPWords.setSpacing(15);
		            	leftPWords.setSpacing(15);
		            	
		            	
		            	tab.setContent(totalPWords);
		            	
		            	//Button controls
		            	passwordPolicies.setOnAction(new EventHandler<ActionEvent>() {

							@Override
							public void handle(ActionEvent arg0)
							{
								try {
									Passwords.setPasswordPolicies();
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
		            		
		            	});
		            	
		            	pWordExpire.setOnAction(new EventHandler<ActionEvent>() {
		            		public void handle(ActionEvent arg0)
		            		{
		            			try {
		            				Passwords.setPasswordsToExpire();
		            			} catch (IOException e) {
		            				// TODO Auto-generated catch block
		            				e.printStackTrace();
		            			}
		            		}
		            	});
		            	
		            	
		            	
		            	
		            	
		            	
		            }else if(tabs.get(i).equals("Account Policies"))
		            {
		            	HBox totalAccntPol = new HBox();									//total content box
		            	totalAccntPol.setAlignment(Pos.CENTER);
		            	VBox leftAccntPol = new VBox();									//actions on the left side
		            	leftAccntPol.setAlignment(Pos.CENTER_LEFT);
		            	VBox rightAccntPol = new VBox();									//actions on the right side
		            	rightAccntPol.setAlignment(Pos.CENTER_RIGHT);
		            	totalAccntPol.getChildren().addAll(leftAccntPol, rightAccntPol);		
		            	
		            	//TODO change this to actual content
		            	Button opnUsrsLst = new Button("Open List of Users");
		            	leftAccntPol.getChildren().add(opnUsrsLst);
		            	opnUsrsLst.setMinWidth(170);
		            	Button autoUpdates = new Button("Turn on Auto Updates");
		            	rightAccntPol.getChildren().add(autoUpdates);
		            	autoUpdates.setMinWidth(170);
		            	Button disableGuest = new Button("Disable/Rename Guest/Admin");
		            	leftAccntPol.getChildren().add(disableGuest);
		            	disableGuest.setMinWidth(170);
		            	rightAccntPol.setPadding(new Insets(30, 10, 10, 20));				 //(top/right/bottom/left)
		            	leftAccntPol.setPadding(new Insets(30, 20, 10, 10));				 //(top/right/bottom/left)
		            	rightAccntPol.setSpacing(15);
		            	leftAccntPol.setSpacing(15);
		            	
		            	
		            	tab.setContent(totalAccntPol);
		            	
		            	//Button controls
		            	
		            	opnUsrsLst.setOnAction(new EventHandler<ActionEvent>() {
		            		public void handle(ActionEvent event) {
		            			try {
		            				AccountPolicies.opnUsrsLst();
		            			}catch(IOException e) {
		            				e.printStackTrace();
		            			}
		            		}
		            	});
		            	
		            	disableGuest.setOnAction(new EventHandler<ActionEvent>(){

							@Override
							public void handle(ActionEvent event) {
								// TODO Auto-generated method stub
								try {
									AccountPolicies.disableBIAccounts();
								}catch(IOException e) {
									e.printStackTrace();
								}
							}
		            		
		            	});
		            	
		            	
		            }else if(tabs.get(i).equals("Firewall"))
		            {
		            	HBox totalFirewall = new HBox();									//total content box
		            	totalFirewall.setAlignment(Pos.CENTER);
		            	VBox leftFirewall = new VBox();									//actions on the left side
		            	leftFirewall.setAlignment(Pos.CENTER_LEFT);
		            	VBox rightFirewall = new VBox();									//actions on the right side
		            	rightFirewall.setAlignment(Pos.CENTER_RIGHT);
		            	totalFirewall.getChildren().addAll(leftFirewall, rightFirewall);		
		            	
		            	//TODO change this to actual content
		            	Button turnOn = new Button("Turn On Firewall");
		            	leftFirewall.getChildren().add(turnOn);
		            	turnOn.setMinWidth(170);
		            	Button blckPrts = new Button("Block Ports");
		            	rightFirewall.getChildren().add(blckPrts);
		            	blckPrts.setMinWidth(170);
		            	Button rmotedsktop = new Button("Disable/Enable R.D.");
		            	leftFirewall.getChildren().add(rmotedsktop);
		            	rmotedsktop.setMinWidth(170);
		            	Button features = new Button("Disable Features");
		            	rightFirewall.getChildren().add(features);
		            	features.setMinWidth(170);
		            	Button services = new Button("Disable Services");
		            	leftFirewall.getChildren().add(services);
		            	services.setMinWidth(170);
		            	Button auditPolicies = new Button("Audit Policies");
		            	rightFirewall.getChildren().add(auditPolicies);
		            	auditPolicies.setMinWidth(170);
		            	rightFirewall.setPadding(new Insets(30, 10, 10, 20));				 //(top/right/bottom/left)
		            	leftFirewall.setPadding(new Insets(30, 20, 10, 10));				 //(top/right/bottom/left)
		            	rightFirewall.setSpacing(15);
		            	leftFirewall.setSpacing(15);
		            	
		            	
		            	tab.setContent(totalFirewall);
		            	
		            	//Button controls
		            	
		            	turnOn.setOnAction(new EventHandler<ActionEvent>() {
		            		public void handle(ActionEvent arg0) {
		            			try {
		            				Firewall.activate();
		            			}catch(IOException e) {
		            				e.printStackTrace();
		            			}
		            		}
		            	});
		            	
		            	
		            	rmotedsktop.setOnAction(new EventHandler<ActionEvent>() {

							@Override
							public void handle(ActionEvent arg0) {
								// TODO Auto-generated method stub
								try {
									Firewall.enableDisableRD();
								} catch (IOException e){
									e.printStackTrace();
								}
							}
		            		
		            	});
		            	
		            	auditPolicies.setOnAction(new EventHandler<ActionEvent>() {
		            		public void handle(ActionEvent arg0) {
		            			try {
		            				Firewall.auditPolicies();
		            			}catch(IOException e) {
		            				e.printStackTrace();
		            			}
		            		}
		            	});
		            	
		            	features.setOnAction(new EventHandler<ActionEvent>() {
		            		public void handle(ActionEvent arg0) {
		            			try {
		            				Firewall.disableFeatures();
		            			}catch(IOException e) {
		            				e.printStackTrace();
		            			}
		            		}
		            	});
		            	
		            	services.setOnAction(new EventHandler<ActionEvent>() {
		            		public void handle(ActionEvent arg0) {
		            			try {
		            				Firewall.disableServices();
		            			}catch(IOException e) {
		            				e.printStackTrace();
		            			}
		            		}
		            	});
		            	
		            }else if(tabs.get(i).equals("Anti-Virus & Anti-Malware"))
		            {
		            	HBox totalAnti = new HBox();									//total content box
		            	totalAnti.setAlignment(Pos.CENTER);
		            	VBox leftAnti = new VBox();									//actions on the left side
		            	leftAnti.setAlignment(Pos.CENTER_LEFT);
		            	VBox rightAnti = new VBox();									//actions on the right side
		            	rightAnti.setAlignment(Pos.CENTER_RIGHT);
		            	totalAnti.getChildren().addAll(leftAnti, rightAnti);		
		            	
		            	//TODO change this to actual content
		            	Button malwareBytes = new Button("Install MalwareBytes");
		            	leftAnti.getChildren().add(malwareBytes);
		            	malwareBytes.setMinWidth(170);
		            	Button AVG = new Button("Install AVG");
		            	rightAnti.getChildren().add(AVG);
		            	AVG.setMinWidth(170);
		            	Button mBAnti = new Button("Install MBAnti");
		            	leftAnti.getChildren().add(mBAnti);
		            	mBAnti.setMinWidth(170);
		            	Button mBSA = new Button("Install MBSA");
		            	rightAnti.getChildren().add(mBSA);
		            	mBSA.setMinWidth(170);
		            	Button revo = new Button("Install Revo");
		            	leftAnti.getChildren().add(revo);
		            	revo.setMinWidth(170);
		            	Button superSpy = new Button("Install Super");
		            	rightAnti.getChildren().add(superSpy);
		            	superSpy.setMinWidth(170);
		            	rightAnti.setPadding(new Insets(30, 10, 10, 20));				 //(top/right/bottom/left)
		            	leftAnti.setPadding(new Insets(30, 20, 10, 10));				 //(top/right/bottom/left)
		            	rightAnti.setSpacing(15);
		            	leftAnti.setSpacing(15);
		            	
		            	tab.setContent(totalAnti);
		            	
		            	//Button controls
		            	
		            	
		            }else if(tabs.get(i).equals("Miscellaneous"))
		            {
		            	HBox totalMis = new HBox();									//total content box
		            	totalMis.setAlignment(Pos.CENTER);
		            	VBox leftMis = new VBox();									//actions on the left side
		            	leftMis.setAlignment(Pos.CENTER_LEFT);
		            	VBox rightMis = new VBox();									//actions on the right side
		            	rightMis.setAlignment(Pos.CENTER_RIGHT);
		            	totalMis.getChildren().addAll(leftMis, rightMis);		
		            	
		            	//TODO change this to actual content
		            	Button listProg = new Button("List Programs");
		            	leftMis.getChildren().add(listProg);
		            	listProg.setMinWidth(170);
		            	Button listFiles = new Button("List Files");
		            	rightMis.getChildren().add(listFiles);
		            	listFiles.setMinWidth(170);
		            	Button enHidFiles = new Button("Enable Hidden Files");
		            	leftMis.getChildren().add(enHidFiles);
		            	enHidFiles.setMinWidth(170);
		            	Button updateOS = new Button("Update OS");
		            	rightMis.getChildren().add(updateOS);
		            	updateOS.setMinWidth(170);
		            	Button remShares = new Button("Remove Shares");
		            	leftMis.getChildren().add(remShares);
		            	remShares.setMinWidth(170);
		            	Button emptyBin = new Button("Empty Recycling Bin");
		            	rightMis.getChildren().add(emptyBin);
		            	emptyBin.setMinWidth(170);
		            	rightMis.setPadding(new Insets(30, 10, 10, 20));				 //(top/right/bottom/left)
		            	leftMis.setPadding(new Insets(30, 20, 10, 10));				 //(top/right/bottom/left)
		            	rightMis.setSpacing(15);
		            	leftMis.setSpacing(15);
		            	
		            	tab.setContent(totalMis);
		            	
		            	//Button controls
		            	
		            	
		            }
		            
		            tabPane.getTabs().add(tab);
		            tabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
		        }
			
			root.setTop(tabPane);
			
			
			
			//Menu bar
			MenuBar menu = new MenuBar();
			Menu file = new Menu("File");
			Menu view = new Menu("View");
			Menu help = new Menu("Help");
			menu.getMenus().addAll(file, view, help);
			
			MenuItem about = new MenuItem("About");
			help.getItems().add(about);
			Stage secondaryStage = new Stage();
			
			about.setOnAction(new EventHandler<ActionEvent>() {
	            public void handle(ActionEvent t) {
	            	boolean activated = false;
	            	activated = true;
	            	guiStart.aboutMenu(secondaryStage, activated);
	            }
	        });   
			
			root.setTop(menu);
			VBox main = new VBox();
			main.getChildren().addAll(menu, tabPane);

			root.setTop(main);
			
			primaryStage.setScene(scene);
			primaryStage.show();
		}catch(Exception e)	{
			e.printStackTrace();
		}
		
	}
	
	public static void aboutMenu(Stage secondaryStage, boolean activated) {
		HBox root = new HBox();
		Scene scene = new Scene(root, 620, 180);
		secondaryStage.setScene(scene);
		secondaryStage.setAlwaysOnTop(true);
		secondaryStage.setResizable(false);
		Label summary = new Label("CyberKey is a program created by Cadet Captain Morgan Small in 2019. This program is meant "
				+ "to be used \nduring CyberPatriot competitions to quickly and effectively complete common and uncommon issues\n"
				+ "hidden on the system. This program coveres everything dealing with account policies all the way to \ndisabling"
				+ " unnecessary services that one wouldn't think of looking for to begin with. With this program, you \nand your "
				+ "CyberPatriot team can easily complete many of the issues you can find in a CyberPatriot \ncompetition. For "
				+ "technical support regarding this program, click the 'help' tab and select 'contact' to get \nSmall's email "
				+ "address for your support and concerns");
		summary.setPadding(new Insets(20, 20, 20, 20));				 //(top/right/bottom/left)
		root.getChildren().add(summary);
		
		if(activated == true) {
			secondaryStage.show();
		}
	}
	
	public static void main(String[] args)
	{
		launch(args);
	}
}
