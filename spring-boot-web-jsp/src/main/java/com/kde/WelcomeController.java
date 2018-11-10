package com.kde;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
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
		//String queryText = remote.getQueryText("numOfTrailsPerDistrict", new String[] {lat, lng});
		String queryText = remote.getQueryText("numOfTrailsPerDistrict", null);

		System.out.println(queryText);
		
		// queryResults is a list of lists, with each inner list containing the results for that row
		ArrayList<ArrayList<String>> queryResults = remote.issueSelectQuery(queryText);
		
		if(queryResults == null) {
			System.err.println("A query result is not a resource or literal, exiting...");
			System.exit(2);
		}
		
		model.addAttribute("results", queryResults);

		return "numOfTrailsPerDistrict";
	}


	@RequestMapping("/trailClimbLessThanXM")
	public String trailClimbLessThanXM(@RequestParam("climb") String climb, Model model) {

		System.out.println("climb" + climb);

		model.addAttribute("climbHeight", climb);

		//LinkedHashmap structure


		return "trailClimbLessThanXM";
	}

	//not done

	@RequestMapping("/trailsLongerThanXKm")
	public String trailsLongerThanXKm(@RequestParam("length") String length, Model model) {

		System.out.println("length" + length);
		model.addAttribute("length", length);


		return "trailsLongerThanXKm";
	}


	@RequestMapping("/trailQualityGreaterThanX")
	public String trailQualityGreaterThanX(@RequestParam("quality") String quality, Model model) {

		System.out.println("quality" + quality);
		model.addAttribute("quality", quality);

		return "trailQualityGreaterThanX";
	}


	@RequestMapping("/trailsWithSameStartAndEnd")
	public String trailsWithSameStartAndEnd(Model model) {

		model.addAttribute("lat", 342);

		return "trailQualityGreaterThanX";
	}


	@RequestMapping("/trailsWithCircularFormat")
	public String trailsWithCircularFormat(@RequestParam("long") String lng,@RequestParam("lat") String lat, Model model) {
		System.out.println("long:" + lng);
		System.out.println("lat:" + lat);

		
		return "trailsWithCircularFormat";
	}
	

	@RequestMapping("/redirectQuery")
	public String redirectQuery(@RequestParam("queryNum") String queryNum, Model model) {

		//read the request parameter from the HTML form
		model.addAttribute("itemNumber", queryNum);

		//treeMap --> automagic sort order by key
		//hashMap --> unordered
		//LinkedHashMap --> in order you add

		HashMap<String, String> hmap = new LinkedHashMap<String, String>();
		hmap.put("Cork", "432");
		hmap.put("Dublin", "2442");
		model.addAttribute("hmap", hmap);


		List<Trail> trailList = new ArrayList<>();

		Trail t1 = new Trail();
		t1.setDistrict("Cork");
		t1.setName("Trail1");
		t1.setCompletionTime("150");
		t1.setDogsAllowed(true);
		t1.setStartPoint("-");
		t1.setLength("1442");
		trailList.add(t1);

		Trail t2 = new Trail();
		t2.setDistrict("Dublin");
		t2.setName("Trail2");
		t2.setLength("232");
		t2.setStartPoint("-");
		t2.setCompletionTime("132");
		t2.setDogsAllowed(true);
		t2.setDogsAllowed(true);
		trailList.add(t2);
		
		model.addAttribute("trailList", trailList);

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
			return "trailsWithSameStartAndEnd";
		case 8:
			return "trailsRankBasedOnTimeAndDogsAllowed";
		default:
			return "welcome";

		}

	}


}

