package com.digi.uniprr.serviceImpl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Service;

import com.digi.uniprr.service.OrcidService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

@Service
public class OrcidServiceImpl implements OrcidService {

	@Override
	public String getOrcidDetail(String id) {

		String test = "";
		try {
			XmlMapper xmlMapper = new XmlMapper();

			String url = "https://pub.orcid.org/v3.0/" + id;
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();

			con.setRequestMethod("GET");

			con.setRequestProperty("User-Agent", "Mozilla/5.0");

			int responseCode = con.getResponseCode();

			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			
			test = response.toString();
			
			
			JsonNode jsonNode = xmlMapper.readTree(test.getBytes());
			ObjectMapper objectMapper = new ObjectMapper();

			// Get JSON as a string
			String value = objectMapper.writeValueAsString(jsonNode);
			test = value;
			
		} catch (Exception e) {
			System.out.println(e);
			return "Something went wrong";
		}
		return test;
	}

}
