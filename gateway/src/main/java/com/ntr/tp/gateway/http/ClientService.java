package com.ntr.tp.gateway.http;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.Scanner;

@Data
@Service
public class ClientService {
    private URL url;
    private HttpURLConnection con;

    public <T> T sendGET(Map payload, Class<T> clazz) throws IOException, ParseException {
        con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.connect();
        if(!(con.getResponseCode() < 300 && con.getResponseCode() >= 200)){
            throw new RuntimeException("can not connect subscribe api call");
        }
        else {
            StringBuilder stringBuilder = new StringBuilder();
            Scanner scanner = new Scanner(url.openStream());
            while (scanner.hasNext()){
                stringBuilder.append(scanner.nextLine());
            }
            JSONParser jsonParser = new JSONParser();
         //   JSONArray dataObject = (JSONArray) jsonParser.parse(String.valueOf(stringBuilder));
            ObjectMapper objectMapper = new ObjectMapper();

            return objectMapper.readValue(String.valueOf(stringBuilder),clazz);
        }
    }
}
