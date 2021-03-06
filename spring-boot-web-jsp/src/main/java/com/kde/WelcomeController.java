package com.kde;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WelcomeController {

	private RemoteJena remote = new RemoteJena();

	// inject via application.properties
	@Value("${welcome.message:test}")
	private String message = "Ireland Sports Query Interface";



	@RequestMapping("/query")
	public String welcome(Map<String, Object> model) {
		model.put("message", this.message);
		return "welcome";
	}


	@RequestMapping("/numOfTrailsPerDistrict")
	public String numOfTrailsPerDistrict(@RequestParam("lat") String lat, @RequestParam("long") String lng, Model model) {

		System.out.println("lat" + lat);
		System.out.println("long" + lng);

		// Get the SPARQL query string
		String queryText = remote.getQueryText("numOfTrailsPerDistrict", new String[] {lng, lat});

		// queryResults is a list of lists, with each inner list containing the results for that row
		ArrayList<ArrayList<String>> queryResults = remote.issueSelectQuery(queryText);

		if(queryResults == null) {
			System.err.println("A query result is not a resource or literal, exiting...");
			return "error";
		}
		
		try {
			String district = queryResults.get(0).get(0);
			System.out.println("District: " + district);
			model.addAttribute("district", district);
			model.addAttribute("results", queryResults);
			System.out.println("Results added to model...");
			return "numOfTrailsPerDistrict";
		}
		catch(Exception e) {
			return "error";
		}

	}

	@RequestMapping("/trailsInYourDistrict")
	public String trailsInYourDistrict(@RequestParam("lat") String lat, @RequestParam("long") String lng, Model model) {

		System.out.println("lat" + lat);
		System.out.println("long" + lng);

		// Get the SPARQL query string
		String queryText = remote.getQueryText("trailsInYourDistrict", new String[] {lng, lat});

		// queryResults is a list of lists, with each inner list containing the results for that row
		ArrayList<ArrayList<String>> queryResults = remote.issueSelectQuery(queryText);
		
		if(queryResults == null) {
			System.err.println("A query result is not a resource or literal, exiting...");
		}
		
		try {
			String district = queryResults.get(0).get(0);
			System.out.println("District: " + district);
			
			model.addAttribute("district", district);
			model.addAttribute("results", queryResults);
			System.out.println("Results added to model...");
			return "trailsInYourDistrict";
		}
		catch(Exception e) {
			return "error";
		}
	}


	@RequestMapping("/trailClimbLessThanXM")
	public String trailClimbLessThanXM(@RequestParam("climb") String climb, Model model) {

		System.out.println("querying climb less than " + climb + "m" );
		
		// Get the SPARQL query string
		String queryText = remote.getQueryText("trailClimbLessThanXM", new String[] {climb});

		//return districtName, trailClimb, trailName

		// queryResults is a list of lists, with each inner list containing the results for that row
		ArrayList<ArrayList<String>> queryResults = remote.issueSelectQuery(queryText);


		for(ArrayList<String> trailList:queryResults) {

			for(String res: trailList) {
				System.out.println(res);
			}
		}

		model.addAttribute("results", queryResults);
		model.addAttribute("climb", climb);

		return "trailClimbLessThanXM";
	}

	@RequestMapping("/trailsLongerThanXKm")
	public String trailsLongerThanXKm(@RequestParam("length") String length, Model model) {

		System.out.println("querying trails longer than " + length + "km");
		
		// Get the SPARQL query string
		String queryText = remote.getQueryText("trailsLongerThanXKm", new String[] {length});

		// queryResults is a list of lists, with each inner list containing the results for that row
		ArrayList<ArrayList<String>> queryResults = remote.issueSelectQuery(queryText);

		for(ArrayList<String> trailList:queryResults) {

			for(String res: trailList) {
				System.out.println(res);
			}
		}

		model.addAttribute("length", length);
		model.addAttribute("results", queryResults);

		return "trailsLongerThanXKm";
	}


	@RequestMapping("/trailQualityGreaterThanX")
	public String trailQualityGreaterThanX(@RequestParam("quality") String quality, Model model) {

		System.out.println("querying trail quality greater than " + quality + " stars");
		
		// Get the SPARQL query string
		String queryText = remote.getQueryText("trailQualityGreaterThanX", new String[] {quality});

		//return districtName, trailClimb, trailName


		// queryResults is a list of lists, with each inner list containing the results for that row
		ArrayList<ArrayList<String>> queryResults = remote.issueSelectQuery(queryText);


		for(ArrayList<String> trailList:queryResults) {

			for(String res: trailList) {
				System.out.println(res);
			}
		}

		model.addAttribute("quality", quality);
		model.addAttribute("results", queryResults);

		return "trailQualityGreaterThanX";
	}


	@RequestMapping("/trailsWithSameStartAndEnd")
	public String trailsWithSameStartAndEnd(Model model) {

		System.out.println("querying trails with same start and end point");
		
		// Get the SPARQL query string
		String queryText = remote.getQueryText("trailsWithSameStartAndEnd", null);
		
		//return ?districtName ?trailName, ?trailStartPoint, ?trailEndPoint

		// queryResults is a list of lists, with each inner list containing the results for that row
		ArrayList<ArrayList<String>> queryResults = remote.issueSelectQuery(queryText);


		for(ArrayList<String> trailList:queryResults) {

			for(String res: trailList) {
				System.out.println(res);
			}
		}	
		
		model.addAttribute("results", queryResults);
		return "trailsWithSameStartAndEnd";
	}


	@RequestMapping("/trailsWithCircularFormat")
	public String trailsWithCircularFormat(@RequestParam("long") String lng,@RequestParam("lat") String lat, Model model) {

		System.out.println("querying trails with circular format with " + lng + "," + lat);
		
		// Get the SPARQL query string
		//parameters: current long and lat, format
		String queryText = remote.getQueryText("trailsWithCircularFormat", new String[] {lng, lat, "Circular"});

		//return ?districtName ?trailName, ?trailStartPoint, ?trailEndPoint

		// queryResults is a list of lists, with each inner list containing the results for that row
		ArrayList<ArrayList<String>> queryResults = remote.issueSelectQuery(queryText);

		// There is only 1 district returned for each call to this query. Get that district
		String district = queryResults.get(0).get(0);
		
		model.addAttribute("district", district);
		model.addAttribute("results", queryResults);

		return "trailsWithCircularFormat";
	}


	@RequestMapping("/trailsRankBasedOnTimeAndDogsAllowed")
	public String trailsRankBasedOnTimeAndDogsAllowed(Model model) {

		// Get the SPARQL query string
		String queryText = remote.getQueryText("trailsRankBasedOnTimeAndDogsAllowed", null);

		//return ?districtName ?trailName, ?trailStartPoint, ?trailEndPoint

		ArrayList<ArrayList<String>> queryResults = remote.issueSelectQuery(queryText);

		System.out.println("dogs results ...");

		for (ArrayList<String> trailList : queryResults) {

			for (String res : trailList) {
				System.out.println(res);
			}
		}

		model.addAttribute("results", queryResults);

		return "trailsRankBasedOnTimeAndDogsAllowed";
	}


	@RequestMapping("/redirectQuery")
	public String redirectQuery(@RequestParam("queryNum") String queryNum, Model model) {

		//read the request parameter from the HTML form
		model.addAttribute("itemNumber", queryNum);

		switch(Integer.parseInt(queryNum)) {

		case 1:
			//call code
			//convert it into Trial list
			return "numOfTrailsPerDistrict_params";
		case 2:
			return "trailsInYourDistrict_params";
		case 3:
			return "trailsLongerThanXkm_params";
		case 4:
			return "trailQualityGreaterThanX_params";
		case 5:
			return "trailClimbLessThanXM_params";
		case 6:
			return "trailsWithCircularFormat_params";
		case 7:
			return "redirect:/trailsWithSameStartAndEnd";
		case 8:
			return "redirect:/trailsRankBasedOnTimeAndDogsAllowed";
		default:
			return "welcome";

		}

	}

}

