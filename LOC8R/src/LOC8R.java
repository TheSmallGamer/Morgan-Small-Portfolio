import java.util.ArrayList;
import java.util.Scanner;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.stage.Stage;

public class LOC8R extends Application{
	private static ArrayList<Location> allLocations = new ArrayList<Location>();
	private static ArrayList<Location> eightPlaces = new ArrayList<Location>();
	static Stage error = new Stage();
	static BorderPane errorPane = new BorderPane();
	static Scene errorScene = new Scene(errorPane, 320, 250);
	static Label errorLabel = new Label("");
	
	public static void main(String[] args) {
//		new LOC8R();
//	}
	
//	public LOC8R()
//	{
		Scanner scan;

		scan = new Scanner(new LOC8R().getClass().getResourceAsStream("locations.txt"));
		
		while(scan.hasNextLine()) {
			String l = scan.nextLine();
			String[] entryParts = l.split("\t");
			String names = entryParts[0];
			String addresses = entryParts[1];
			String businessTypes = entryParts[2];
			String longitudes = entryParts[3];
			String latitudes = entryParts[4];
			
			allLocations.add(new Location(names, addresses, businessTypes, Double.parseDouble(longitudes), Double.parseDouble(latitudes), -1, false, false));
		}
		scan.close();
	
		
		launch(args);
	}

	public static void searchFor(ArrayList<Location> locations, String keyword, String businessType, double latitude, double longitude)
	{
		eightPlaces.removeAll(eightPlaces);
		
			//searches for all locations containing the keyword and the business type
			ArrayList<Location> foundLocations = new ArrayList<Location>();
			ArrayList<Double> distances=new ArrayList<>();
			for(int i = 0; i < locations.size(); i++){
				Location place = locations.get(i);
				if(place.getName().toLowerCase().contains(keyword.toLowerCase()) && place.getBusinessType().toLowerCase().equals(businessType.toLowerCase())){
					foundLocations.add(place);
				}
			}
			//finds how far away each location is from the user
			for(int i = 0; i < foundLocations.size(); i++){
				Location place = foundLocations.get(i);
				double lat=Math.abs(place.getLatitude()-latitude);
				double lon=Math.abs(place.getLongitude()-longitude);
				double d=Math.sqrt(Math.pow(lat, 2)+Math.pow(lon, 2));
				distances.add(d);
			}
			//sorts the distances away and the locations from closest to farthest in the arrayList
			for (int i = 0; i < distances.size()-1; i++)        
			       for (int j = 0; j < distances.size()-i-1; j++)  
			           if (distances.get(j) > distances.get(j+1)) {
			        	   double d2=distances.get(i);
			        	   Location p2=foundLocations.get(i);
			        	   distances.set(i, distances.get(j));
			        	   distances.set(j, d2);
			        	   foundLocations.set(i, foundLocations.get(j));
			        	   foundLocations.set(j, p2);
			           }
			              
			//takes the first 8 locations from the arranged list
			eightPlaces.add(foundLocations.get(0));
			eightPlaces.add(foundLocations.get(1));
			eightPlaces.add(foundLocations.get(2));
			eightPlaces.add(foundLocations.get(3));
			eightPlaces.add(foundLocations.get(4));
			eightPlaces.add(foundLocations.get(5));
			eightPlaces.add(foundLocations.get(6));
			eightPlaces.add(foundLocations.get(7));
		
	}
	public static void searchFor(ArrayList<Location> locations, String keyword, double latitude, double longitude)
	{
		eightPlaces.removeAll(eightPlaces);
		
		//searches for all locations containing the keyword and the business type
		ArrayList<Location> foundLocations = new ArrayList<Location>();
		ArrayList<Double> distances=new ArrayList<>();
		for(int i = 0; i < locations.size(); i++){
			Location place = locations.get(i);
			if(place.getName().toLowerCase().contains(keyword.toLowerCase())){
				foundLocations.add(place);
			}
		}
		//finds how far away each location is from the user
		for(int i = 0; i < foundLocations.size(); i++){
			Location place = foundLocations.get(i);
			double lat=Math.abs(place.getLatitude()-latitude);
			double lon=Math.abs(place.getLongitude()-longitude);
			double d=Math.sqrt(Math.pow(lat, 2)+Math.pow(lon, 2));
			distances.add(d);
		}
		//sorts the distances away and the locations from closest to farthest in the arrayList
		for (int i = 0; i < distances.size()-1; i++)        
		       for (int j = 0; j < distances.size()-i-1; j++)  
		           if (distances.get(j) > distances.get(j+1)) {
		        	   double d2=distances.get(i);
		        	   Location p2=foundLocations.get(i);
		        	   distances.set(i, distances.get(j));
		        	   distances.set(j, d2);
		        	   foundLocations.set(i, foundLocations.get(j));
		        	   foundLocations.set(j, p2);
		           }
		              
		//takes the first 8 locations from the arranged list
		eightPlaces.add(foundLocations.get(0));
		eightPlaces.add(foundLocations.get(1));
		eightPlaces.add(foundLocations.get(2));
		eightPlaces.add(foundLocations.get(3));
		eightPlaces.add(foundLocations.get(4));
		eightPlaces.add(foundLocations.get(5));
		eightPlaces.add(foundLocations.get(6));
		eightPlaces.add(foundLocations.get(7));
	
	}
	public void start(Stage stage) throws Exception {
		
        // set icon
        stage.setTitle("LOC8R");
        stage.getIcons().add(new Image("LOC8R_ICON.png"));
	
      //Error screen
		
		errorLabel.setStyle("-fx-font: 24 ariel;");
		errorPane.setCenter(errorLabel);			
							
						
		//root section
			VBox root = new VBox(80);
			//background image
				root.setBackground(new Background(new BackgroundFill(
						new ImagePattern(new Image(this.getClass().getClassLoader().getResource(
								"90a3cb17e0d2b54e31e7e94a843d9c3d.png").toString())), CornerRadii.EMPTY, Insets.EMPTY)));
			//scenes	
				Scene scene = new Scene(root, 800, 520);
				stage.setResizable(false);
				//scene VBox
					VBox main = new VBox();
					main.setPadding(new Insets(20,20,20,20));
					//main control box
						HBox controls = new HBox();
						controls.setSpacing(15);
						
						//keyword HBox	
							HBox keyword = new HBox();
							Label keywordL = new Label("Keyword:\t");
							TextField keywordF = new TextField();
							//adding aspects above
								keyword.getChildren().addAll(keywordL, keywordF);
								keyword.setSpacing(15);
								keyword.setPadding(new Insets(5,5,5,5));
								
						//businessType HBox
							HBox businessType = new HBox();
							Label businessTypeL = new Label("Business Type:\t");
							ComboBox<String> businessTypeB = new ComboBox<String>();
							//adding options to combo box
								for(Location l : allLocations)
								{
									String type = l.getBusinessType();
									if(businessTypeB.getItems().contains(type)) {
										
									}else {
										businessTypeB.getItems().add(type);
									}
								}
								businessTypeB.setMinWidth(150);
							//adding aspects above	
								businessType.getChildren().addAll(businessTypeL, businessTypeB);
								businessType.setSpacing(15);
								
						
								
								
						//submit button
							Button submit = new Button("Submit");
							submit.setMinWidth(100);
					controls.getChildren().addAll(keyword, businessType, submit);
					controls.setSpacing(15);
					
					//latitude and longitude fields
						HBox userLoc = new HBox();
						userLoc.setSpacing(15);
						//HBox latitude
							HBox lat = new HBox();
							lat.setSpacing(15);
							//aspects
								Label latL = new Label("Latitude\t");
								TextField latF = new TextField();
							lat.getChildren().addAll(latL, latF);
						//HBox longitude
							HBox lon = new HBox();
							lon.setSpacing(15);
							//aspects
								Label lonL = new Label("Longitude:\t");
								TextField lonF = new TextField();
							lon.getChildren().addAll(lonL, lonF);
						//add HBoxes
						userLoc.getChildren().addAll(lat, lon);
						userLoc.setPadding(new Insets(5,5,5,5));
					
					//location list box
						VBox locations = new VBox();
						//location 1 HBox
							HBox one = new HBox();
							//controls
								Label oneL = new Label();
								Button oneB = new Button("Expand Details");
								Label nameOne = new Label("Name #1:\t");
							one.getChildren().addAll(nameOne, oneL, oneB);
							one.setSpacing(15);
							one.setPadding(new Insets(5,5,5,5));
						//location 2 HBox
							HBox two = new HBox();
							//controls
								Label twoL = new Label();
								Button twoB = new Button("Expand Details");
								Label nameTwo = new Label("Name #2:\t");
							two.getChildren().addAll(nameTwo, twoL, twoB);
							two.setSpacing(15);
							two.setPadding(new Insets(5,5,5,5));
						//location 3 HBox
							HBox three = new HBox();
							//controls
								Label threeL = new Label();
								Button threeB = new Button("Expand Details");
								Label nameThree = new Label("Name #3:\t");
							three.getChildren().addAll(nameThree, threeL, threeB);
							three.setSpacing(15);
							three.setPadding(new Insets(5,5,5,5));
						//location 4 HBox
							HBox four = new HBox();
							//controls
								Label fourL = new Label();
								Button fourB = new Button("Expand Details");
								Label nameFour = new Label("Name #4:\t");
							four.getChildren().addAll(nameFour, fourL, fourB);
							four.setSpacing(15);
							four.setPadding(new Insets(5,5,5,5));
						//location 5 HBox
							HBox five = new HBox();
							//controls
								Label fiveL = new Label();
								Button fiveB = new Button("Expand Details");
								Label nameFive = new Label("Name #5:\t");
							five.getChildren().addAll(nameFive, fiveL, fiveB);
							five.setSpacing(15);
							five.setPadding(new Insets(5,5,5,5));
						//location 6 HBox
							HBox six = new HBox();
							//controls
								Label sixL = new Label();
								Button sixB = new Button("Expand Details");
								Label nameSix = new Label("Name #6:\t");
							six.getChildren().addAll(nameSix, sixL, sixB);
							six.setSpacing(15);
							six.setPadding(new Insets(5,5,5,5));
						//location 7 HBox
							HBox seven = new HBox();
							//controls
								Label sevenL = new Label();
								Button sevenB = new Button("Expand Details");
								Label nameSeven = new Label("Name #7:\t");
							seven.getChildren().addAll(nameSeven, sevenL, sevenB);
							seven.setSpacing(15);
							seven.setPadding(new Insets(5,5,5,5));
						//location 8 HBox
							HBox eight = new HBox();
							//controls
								Label eightL = new Label();
								Button eightB = new Button("Expand Details");
								Label nameEight = new Label("Name #8:\t");
								
							eight.getChildren().addAll(nameEight, eightL, eightB);
							eight.setSpacing(15);
							eight.setPadding(new Insets(5,5,5,5));
						
						locations.getChildren().addAll(one, two , three, four, five, six, seven, eight);
				//detail stage
					Stage stageD = new Stage();
					//detail window section
						VBox rootD = new VBox();
						stageD.setTitle("Details");
						rootD.setBackground(new Background(new BackgroundFill(
								new ImagePattern(new Image(getClass().getClassLoader().getResource(
										"90a3cb17e0d2b54e31e7e94a843d9c3d.png").toString())), CornerRadii.EMPTY, Insets.EMPTY)));
						//Scene
							Scene detailScene = new Scene(rootD, 350, 200);
							//scene VBox
								VBox mainD = new VBox();
								stageD.setScene(detailScene);
								//aspects of the details window
									HBox names = new HBox();
									Label nameE = new Label();
									nameE.setStyle("-fx-text-fill: white; -fx-font: 24 ariel;");
										names.getChildren().addAll(nameE);
										names.setAlignment(Pos.TOP_CENTER);
									HBox addresses = new HBox();
									Label address = new Label("Address:\t");
									Label addressE = new Label();
										addresses.getChildren().addAll(address, addressE);
										addresses.setPadding(new Insets(80,0,0,5));
									HBox latitudeB = new HBox();
									Label latitudeL = new Label("Latitude:\t");
									Label latitudeE = new Label();
										latitudeB.getChildren().addAll(latitudeL, latitudeE);
										latitudeB.setPadding(new Insets(0,0,0,5));
									HBox longitudeB = new HBox();
									Label longitudeL = new Label("Longitude:\t");
									Label longitudeE = new Label();
										longitudeB.getChildren().addAll(longitudeL, longitudeE);
										longitudeB.setPadding(new Insets(0,0,5,5));
									Button map = new Button("Open maps");
									
									//add aspects to VBox mainD
										mainD.getChildren().addAll(names, addresses, latitudeB, longitudeB, map);
										rootD.getChildren().addAll(mainD);
										stageD.setResizable(false);
		
										
					Image logo = new Image("LOC8R_Logo.png");
					ImageView logoView = new ImageView(logo);
					logoView.setFitHeight(150);
					logoView.setFitWidth(250);
										
					main.getChildren().addAll(logoView, controls, userLoc, locations);
					main.setAlignment(Pos.TOP_CENTER);
					root.getChildren().add(main);
					root.setAlignment(Pos.TOP_CENTER);
					
					
				//Event Handlers
					//Expand Options Window
						oneB.setOnAction(e->{
							nameE.setText(eightPlaces.get(0).getName());
							addressE.setText(eightPlaces.get(0).getAddress());
							String x = eightPlaces.get(0).getLatitude()+"";
							latitudeE.setText(x);
							String y = eightPlaces.get(0).getLongitude()+"";
							longitudeE.setText(y);
							stageD.show();
						});
						twoB.setOnAction(e->{
							nameE.setText(eightPlaces.get(1).getName());
							addressE.setText(eightPlaces.get(1).getAddress());
							String x = eightPlaces.get(1).getLatitude()+"";
							latitudeE.setText(x);
							String y = eightPlaces.get(1).getLongitude()+"";
							longitudeE.setText(y);
							stageD.show();
						});
						threeB.setOnAction(e->{
							nameE.setText(eightPlaces.get(2).getName());
							addressE.setText(eightPlaces.get(2).getAddress());
							String x = eightPlaces.get(2).getLatitude()+"";
							latitudeE.setText(x);
							String y = eightPlaces.get(2).getLongitude()+"";
							longitudeE.setText(y);
							stageD.show();
						});
						fourB.setOnAction(e->{
							nameE.setText(eightPlaces.get(3).getName());
							addressE.setText(eightPlaces.get(3).getAddress());
							String x = eightPlaces.get(3).getLatitude()+"";
							latitudeE.setText(x);
							String y = eightPlaces.get(3).getLongitude()+"";
							longitudeE.setText(y);
							stageD.show();
						});
						fiveB.setOnAction(e->{
							nameE.setText(eightPlaces.get(4).getName());
							addressE.setText(eightPlaces.get(4).getAddress());
							String x = eightPlaces.get(4).getLatitude()+"";
							latitudeE.setText(x);
							String y = eightPlaces.get(4).getLongitude()+"";
							longitudeE.setText(y);
							stageD.show();
						});
						sixB.setOnAction(e->{
							nameE.setText(eightPlaces.get(5).getName());
							addressE.setText(eightPlaces.get(5).getAddress());
							String x = eightPlaces.get(5).getLatitude()+"";
							latitudeE.setText(x);
							String y = eightPlaces.get(5).getLongitude()+"";
							longitudeE.setText(y);
							stageD.show();
						});
						sevenB.setOnAction(e->{
							nameE.setText(eightPlaces.get(6).getName());
							addressE.setText(eightPlaces.get(6).getAddress());
							String x = eightPlaces.get(6).getLatitude()+"";
							latitudeE.setText(x);
							String y = eightPlaces.get(6).getLongitude()+"";
							longitudeE.setText(y);
							stageD.show();
						});
						eightB.setOnAction(e->{
							nameE.setText(eightPlaces.get(7).getName());
							addressE.setText(eightPlaces.get(7).getAddress());
							String x = eightPlaces.get(7).getLatitude()+"";
							latitudeE.setText(x);
							String y = eightPlaces.get(7).getLongitude()+"";
							longitudeE.setText(y);
							stageD.show();
						});
						
						
						map.setOnAction(e->{
							for(int n = 0; n < eightPlaces.size(); n++)
							{
								if(addressE.getText() != eightPlaces.get(n).getAddress()){
								}else {
									String question = eightPlaces.get(n).getAddress();
							        question = question.replace(' ', '+');

							        try {
							            Runtime.getRuntime().exec(new String[]{"cmd", "/c","start chrome https://www.google.com/search?q="+question});
							        } catch (Exception e1) {

							        }
								}
							}
						});
						
					
						
					//Submit button
						submit.setOnAction(e->{

							double latitude;
							double longitude;
							if(keywordF.getText().equals(""))
							{
								errorLabel.setText("<ERROR>\n\nPlease enter in a valid\nkeyword for the program to\nsearch properly");
								error.setScene(errorScene);
								error.show();
							}else {
								if(latF.getText().equals(""))
								{
									latitude = 0;
								}else {
									latitude = Double.parseDouble(latF.getText());
								}
								
								if(lonF.getText().equals(""))
								{
									longitude = 0;
								}else {
									longitude = Double.parseDouble(lonF.getText());
								}
								
								
								if(businessTypeB.getValue() == null)
								{
									searchFor(allLocations, keywordF.getText(), latitude, longitude);
								}else {
									searchFor(allLocations, keywordF.getText(), businessTypeB.getValue().toString(), latitude, longitude);
								}
								
								oneL.setText(eightPlaces.get(0).getName());
								twoL.setText(eightPlaces.get(1).getName());
								threeL.setText(eightPlaces.get(2).getName());
								fourL.setText(eightPlaces.get(3).getName());
								fiveL.setText(eightPlaces.get(4).getName());
								sixL.setText(eightPlaces.get(5).getName());
								sevenL.setText(eightPlaces.get(6).getName());
								eightL.setText(eightPlaces.get(7).getName());
							}
						});
						
						
		
        stage.setScene(scene); 
		stage.show();
	}

}
