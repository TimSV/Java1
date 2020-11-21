package ru.timsv.fieldcoordinator.model;


import ru.timsv.fieldcoordinator.model.response.ResponseData;
import ru.timsv.fieldcoordinator.model.response.Time;

public class MainService {

    public void go() {

        Parser parser = new Parser();
        parser.run();

        TimeService timeService = new TimeService();

        ResponseData responseData = parser.getRd();
        ResponseData responseDataMap = parser.getResponseDataMap();


        timeService.printCurrentTime();


       // timeService.setEndField(responseDataMap.getEndsAt());
        timeService.printEndFieldIn();
       // timeService.printEndFieldThrough();





    }

}
