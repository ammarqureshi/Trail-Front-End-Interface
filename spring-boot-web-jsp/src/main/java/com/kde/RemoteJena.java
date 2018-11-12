package com.kde;

// IO
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

// Util
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

// Jena
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.RDFNode;

public class RemoteJena {
	
	private final static String PARLIAMENT_SERVER_URL = "http://localhost:8089/parliament/sparql";
	private final static String queryDir = "query";
	private static HashMap<String, Integer> queryMap = new HashMap<String, Integer>();
	
	
	public RemoteJena() {
		queryMap.put("numOfTrailsPerDistrict", 1);
		queryMap.put("trailsInYourDistrict", 2);
		queryMap.put("trailsLongerThanXKm", 3);
		queryMap.put("trailQualityGreaterThanX", 4);
		queryMap.put("trailClimbLessThanXM", 5);
		queryMap.put("trailsWithCircularFormat", 6);
		queryMap.put("trailsWithSameStartAndEnd", 7);
		queryMap.put("trailsRankBasedOnTimeAndDogsAllowed", 8);
	}
	
	
	public String getQueryText(String queryName, String params[]) {
		String query = queryDir + "//" + queryMap.get(queryName) + ".sparql";
		final Path queryPath = Paths.get(query);
		if (!Files.isReadable(queryPath)) {
			System.out.println(queryPath.toAbsolutePath() + " does not exist or is not readable, please check the path");
			System.exit(1);
		}

		byte[] fileBytes = null;
		try {
			fileBytes = Files.readAllBytes(queryPath);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		String ret = new String(fileBytes);

		if(params != null) {
			// do the parameter replacement
			for(int i = 0; i < params.length; i++) {
				ret = ret.replace("%PARAM_"+i+"%", params[i]);
			}
		}
		
		return  ret;
	}
	
	public ArrayList<ArrayList<String>> issueSelectQuery(String query) {
		// Execute the SPARQL query and get the set of results
		QueryExecution exec = QueryExecutionFactory.sparqlService(PARLIAMENT_SERVER_URL, query);
		ResultSet rs = exec.execSelect();
		
		// List of lists to store the results
		// Each inner list represents a row, containing the results for that row
		ArrayList<ArrayList<String>> results = new ArrayList<ArrayList<String>>(); 
		
		while(rs.hasNext()) {
			// Get current query result set
		    QuerySolution qs = rs.next() ;

		    // Get column names from SPARQL SELECT
	    	Iterator<String> columns = qs.varNames();

	    	// Create a new list for the current result row 
	    	ArrayList<String> result = new ArrayList<String>();
	    	
	    	// Get the value at each column (resource or literal) for the current row
	    	while(columns.hasNext()) {
		    	String column = columns.next();
		    	RDFNode node = qs.get(column);
		    	
		    	if(node.isLiteral()) {
		    		result.add(qs.getLiteral(column).toString());
		    	} else if(node.isResource()){
		    		result.add(qs.getResource(column).toString());
		    	} else {
		    		return null;
		    	}
	    	}
	    	
	    	// Add the row's results to the total list of results
	    	results.add(result);
		}
		exec.close() ;

		return results;
	}

}
