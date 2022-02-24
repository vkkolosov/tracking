package com.example.tracking.service;

import com.example.tracking.model.Prefix;
import com.example.tracking.model.ResultData;
import com.example.tracking.repository.PrefixRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

//не понятно, где сохранилось
import org.json.JSONException;
import org.json.JSONObject;

//тут всякий код для парсинга и тд.
@RequiredArgsConstructor
@Service
public class PrefixService {

    private final PrefixRepository prefixRepository;

    private static String line;

    //парсер запроса
    public String getPrefixFromRequest(String request) {
        String data = request.substring(0, 4); //начальный индекс и длина выражения
        return data;
    }

    /*
    public Integer getIdObjectPrefixFromRequest(String request) { //просто для теста. работает.

        String value = getPrefixFromRequest(request);
        Integer id = prefixRepository.findPrefixByPrefix(value).getId();
        return id;

    }
    */

    public String getURLforSearch(String request) {

        String value = getPrefixFromRequest(request);
        Prefix prefix = prefixRepository.findPrefixByPrefix(value);

        if (prefix == null) {
            return null;
        }

        if (prefix.getLine().getLine().equals("Maersk")) {
            line = "Maersk"; //наша статическая переменная
            String url = prefix.getLine().getUrl() + request + prefix.getLine().getUrlendof();
            System.out.println("request URL: " + url);
            return url;
        }

        return null;

    }

    public String getTextFormRequest(String request) {

        HttpURLConnection connection = null;
        BufferedReader reader = null;
        String urlstring = getURLforSearch(request);

        if (urlstring == null) {
            return null;
        }

        try {
            URL url = new URL(urlstring);
            connection = (HttpURLConnection) url.openConnection(); //открываем соединение
            connection.connect(); //соединяем

            InputStream inputStream = connection.getInputStream(); //получаем инфу с адреса
            reader = new BufferedReader(new InputStreamReader(inputStream)); //читаем в текст

            StringBuffer buffer = new StringBuffer();
            String line = null;

            while ((line = reader.readLine()) != null) {
                buffer.append(line).append("\n");
            }

            return buffer.toString(); //если не будет ошибок, то вернет это

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            return "not found";
        } finally {
            if (connection != null)
                connection.disconnect();
            try {
                if (reader != null)
                    reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    //получить JSON
    public JSONObject toJSON(String request) {

        String input = getTextFormRequest(request);

        if (input == null) {
            return null;
        }

        try {
            JSONObject jsonObject = new JSONObject(input);
            System.out.println("origin country is:" + jsonObject.getJSONObject("origin").getString("country"));
            return jsonObject;
        } catch (JSONException e) {
            System.out.println(request);
        }
        return null;
    }

    public ResultData getCommonResult(String request) {

        JSONObject jsonObject = toJSON(request);
        //System.out.println(jsonObject.toString());

        if (jsonObject == null) {

            ResultData output = new ResultData();
            output.setContainerNumber("probably it's not exist");

            output.setLine("not found");
            output.setContainerData("not found");

            output.setTerminalDeparture("not found");
            output.setPortDeparture("not found");
            output.setCountryDeparture("not found");
            output.setDateOfLoading("not found");

            output.setTerminalArrival("not found");
            output.setPortArrival("not found");
            output.setCountryArrival("not found");
            output.setDateOfArrival("not found");

            output.setVessel("not found");

            return output;

        } else if (line == "Maersk") {

            ResultData output = new ResultData();
            output.setLine(line);
            try {
                output.setContainerNumber(request);
                output.setContainerData(jsonObject.getJSONArray("containers").getJSONObject(0).getString("container_size") + " " + jsonObject.getJSONArray("containers").getJSONObject(0).getString("container_type"));

                output.setTerminalDeparture(jsonObject.getJSONObject("origin").getString("terminal"));
                output.setPortDeparture(jsonObject.getJSONObject("origin").getString("city"));
                output.setCountryDeparture(jsonObject.getJSONObject("origin").getString("country"));
                //сначала порожняк выдают
                try {
                    output.setDateOfLoading(jsonObject.getJSONArray("containers").getJSONObject(0).getJSONArray("locations").getJSONObject(1).getJSONArray("events").getJSONObject(1).getString("actual_time"));
                } catch (JSONException e) {
                    output.setDateOfLoading("not loaded yet");
                }
                output.setTerminalArrival(jsonObject.getJSONObject("destination").getString("terminal"));
                output.setPortArrival(jsonObject.getJSONObject("destination").getString("city"));
                output.setCountryArrival(jsonObject.getJSONObject("destination").getString("country"));
                output.setDateOfArrival(jsonObject.getJSONArray("containers").getJSONObject(0).getString("eta_final_delivery"));
                //пока букинг только есть, а судно не определено
                try {
                    output.setVessel(jsonObject.getJSONArray("containers").getJSONObject(0).getJSONArray("locations").getJSONObject(0).getJSONArray("events").getJSONObject(0).getString("vessel_name"));
                } catch (JSONException e) {
                    output.setDateOfLoading("not loaded yet");
                }
                return output;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}
