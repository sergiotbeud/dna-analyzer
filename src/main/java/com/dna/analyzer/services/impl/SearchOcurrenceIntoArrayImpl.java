package com.dna.analyzer.services.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dna.analyzer.services.SearchOcurrenceIntoArray;



@Service
public class SearchOcurrenceIntoArrayImpl implements SearchOcurrenceIntoArray{

	@Override
	public int searchOcurrence(String[] dnaArray, String ocurrence) {

		int timesFound = 0;
		List<String> dnaList = Arrays.asList(dnaArray);
		int index = 0;
		int differenceSize = dnaList.size() - ocurrence.length();
		
        timesFound = getVerticalsAndHorizontalsOcurrences(ocurrence, timesFound, dnaList, index) 
        		+ getDiagonalOcurrences(ocurrence, timesFound, dnaList, differenceSize);

		return timesFound;
	}
	
	private int getVerticalsAndHorizontalsOcurrences(String ocurrence, int timesFound, List<String> dnaList, int index) {
		for (String dna : dnaList) {
			timesFound += (dna.contains(ocurrence)) ? 1 : 0;
			
			String ocurrenceToAnalyze = "";
            for (int j = 0; j < dnaList.size() - 1; j++) {
            	ocurrenceToAnalyze += dnaList.get(j).charAt(index);
            }
            
            timesFound += (ocurrenceToAnalyze.contains(ocurrence)) ? 1 : 0;
            index++;
		}
		return timesFound;
	}
	
	private int getDiagonalOcurrences(String ocurrence, int timesFound, List<String> dnaList, int differenceSize) {
		for (int i = differenceSize; i >= 0; i--) {
            String ocurrenceToAnalyze = "";
            
            for (int j = 0; j < dnaList.size() - i; j++) {
                ocurrenceToAnalyze += dnaList.get(i+j).charAt(j);
            }
            if (ocurrenceToAnalyze.contains(ocurrence))
            	timesFound++;
        }
        
        for (int i = 1; i <= differenceSize; i++) {
            String ocurrenceToAnalyze = "";
            for (int j = 0; j < dnaList.size() - i; j++) {
                ocurrenceToAnalyze += dnaList.get(j).charAt(i + j);
            }
            if (ocurrenceToAnalyze.contains(ocurrence))
            	timesFound++;
        }
        
		return timesFound;
	}

}
