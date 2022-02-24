package com.example.tracking.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class ResultData {

    String line;

    String containerNumber;
    String containerData;

    String terminalDeparture;
    String portDeparture;
    String countryDeparture;
    String dateOfLoading;

    String terminalArrival;
    String portArrival;
    String countryArrival;
    String dateOfArrival;

    String vessel;

}
