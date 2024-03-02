package resources;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import pojo.AddLocation;
import pojo.LocationDetails;

public class TestDataBuild {
	public AddLocation addPlacetestData(String name , String address , String language ) {
		// create object of main pojo class
				AddLocation location = new AddLocation();

				// location have mested json so need to create the onbject of child class
				LocationDetails details = new LocationDetails();
				details.setLat(38.383494);
				details.setLng(33.427362);

				// need to call the child class details in main pojo class method
				location.setLocation(details);

				// types have array so need to create object of array list and then store the
				// details in list and then need to pass in main pojo class method
				List<String> ty = new ArrayList<String>();
				ty.add("shoe park");
				ty.add("shop");
				// call list class object in main pojo class method

				location.setTypes(ty);
				location.setAccuracy(50);
				location.setAddress(address);
				location.setLanguage(language);
				location.setName(name);
				location.setPhone_number("9604677424");
				location.setWebsite("yogeshnalepatil.com");
				return location ;

	}
	
	
	
}
