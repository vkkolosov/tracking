package com.example.tracking;

import com.example.tracking.model.Prefix;
import com.example.tracking.repository.PrefixRepository;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
public class Main {

    public static void main(String[] args) {

        String API = "{\"isContainerSearch\":true,\"origin\":{\"terminal\":\"LAEM CHABANG PORT B1\",\"geo_site\":\"17TABFY4GWNWS\",\"city\":\"Laem Chabang\",\"state\":\"\",\"country\":\"Thailand\",\"country_code\":\"TH\",\"geoid_city\":\"0NTCCB4ENSFX8\",\"site_type\":\"TERMINAL\"},\"destination\":{\"terminal\":\"\",\"geo_site\":\"Unknown\",\"city\":\"Bethel\",\"state\":\"Pennsylvania\",\"country\":\"United States\",\"country_code\":\"US\",\"geoid_city\":\"0RXCBLQXS2W0S\",\"site_type\":\"\"},\"containers\":[{\"container_num\":\"MRKU2352642\",\"container_size\":\"40\",\"container_type\":\"Dry\",\"iso_code\":\"42G0\",\"operator\":\"MAEU\",\"locations\":[{\"terminal\":\"TIPS Container Depot\",\"geo_site\":\"WXCPJBTJILTJQ\",\"city\":\"Laem Chabang\",\"state\":\"\",\"country\":\"Thailand\",\"country_code\":\"TH\",\"geoid_city\":\"0NTCCB4ENSFX8\",\"site_type\":\"CUSTOMER LOCATION\",\"events\":[{\"activity\":\"GATE-OUT-EMPTY\",\"stempty\":true,\"actfor\":\"EXP\",\"vessel_name\":\"RIO CADIZ\",\"voyage_num\":\"205E\",\"vessel_num\":\"F48\",\"actual_time\":\"2022-01-27T20:26:00.000\",\"rkem_move\":\"GATE-OUT\",\"is_cancelled\":false,\"is_current\":false}]},{\"terminal\":\"LAEM CHABANG PORT B1\",\"geo_site\":\"17TABFY4GWNWS\",\"city\":\"Laem Chabang\",\"state\":\"\",\"country\":\"Thailand\",\"country_code\":\"TH\",\"geoid_city\":\"0NTCCB4ENSFX8\",\"site_type\":\"TERMINAL\",\"events\":[{\"activity\":\"GATE-IN\",\"stempty\":false,\"actfor\":\"EXP\",\"vessel_name\":\"RIO CADIZ\",\"voyage_num\":\"205E\",\"vessel_num\":\"F48\",\"expected_time\":\"2022-02-10T03:00:00.000\",\"actual_time\":\"2022-01-30T23:28:00.000\",\"rkem_move\":\"GATE-IN\",\"is_cancelled\":false,\"is_current\":false},{\"activity\":\"LOAD\",\"stempty\":false,\"actfor\":\"\",\"vessel_name\":\"RIO CADIZ\",\"voyage_num\":\"205E\",\"vessel_num\":\"F48\",\"expected_time\":\"2022-02-10T03:00:00.000\",\"actual_time\":\"2022-02-09T09:53:00.000\",\"rkem_move\":\"LOAD\",\"is_cancelled\":false,\"is_current\":true}]},{\"terminal\":\"Apm Terminal - Berth 88 E425\",\"geo_site\":\"1RINR75KNLJSV\",\"city\":\"Newark\",\"state\":\"New Jersey\",\"country\":\"United States\",\"country_code\":\"US\",\"geoid_city\":\"02R2IYUF20M7Z\",\"site_type\":\"TERMINAL\",\"events\":[{\"activity\":\"DISCHARG\",\"stempty\":false,\"actfor\":\"EXP\",\"vessel_name\":\"RIO CADIZ\",\"voyage_num\":\"205E\",\"vessel_num\":\"F48\",\"expected_time\":\"2022-03-18T08:00:00.000\",\"is_current\":false},{\"activity\":\"GATE-OUT\",\"stempty\":false,\"actfor\":\"IMP\",\"vessel_name\":\"\",\"voyage_num\":\"\",\"vessel_num\":\"\",\"expected_time\":\"2022-03-20T08:00:00.000\",\"is_current\":false}]}],\"eta_final_delivery\":\"2022-03-18T08:00:00.000\",\"latest\":{\"actual_time\":\"2022-02-09T09:53:00.000\",\"activity\":\"LOAD\",\"stempty\":false,\"actfor\":\"\",\"geo_site\":\"17TABFY4GWNWS\",\"city\":\"Laem Chabang\",\"state\":\"\",\"country\":\"Thailand\",\"country_code\":\"TH\"},\"status\":\"IN-PROGRESS\"}]}";
        try {
            JSONObject jsonObject = new JSONObject(API);
            System.out.println(jsonObject.getJSONArray("containers").getJSONObject(0).getString("container_size"));
            System.out.println(jsonObject.getJSONArray("containers").getJSONObject(0).getString("container_type"));
            //System.out.println(jsonObject.getJSONArray("containers").getJSONObject(0).toString(0));
            //System.out.println(jsonObject.getJSONArray("containers").getJSONObject(0).getJSONArray("locations").getJSONObject(0).getJSONArray("events").getJSONObject(0).getString("actual_time"));
            //System.out.println(jsonObject.getJSONObject("eta_final_delivery").toString());
            //System.out.println("actual time of loading: " + jsonObject.getJSONArray("containers").getJSONObject(0).getJSONArray("locations").getJSONObject(1).getJSONArray("events").getJSONObject(1).getString("actual_time"));
            System.out.println(jsonObject.getJSONArray("containers").getJSONObject(0).getString("eta_final_delivery"));
            System.out.println(jsonObject.getJSONArray("containers").getJSONObject(0).getJSONArray("locations").getJSONObject(0).getJSONArray("events").getJSONObject(0).getString("vessel_name"));


        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
}
