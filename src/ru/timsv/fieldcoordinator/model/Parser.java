package ru.timsv.fieldcoordinator.model;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.timsv.fieldcoordinator.model.response.Response;
import ru.timsv.fieldcoordinator.model.response.ResponseData;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Parser {
    private static final String FILE_NAME = "C:\\Users\\admin\\state.txt";
    private static char[] response;
    private static String[] object;
    private ResponseData responseDataTime;

    public ResponseData getResponseDataMap() {
        return responseDataMap;
    }

    private ResponseData responseDataMap;



    public ResponseData getRd() {
        return responseDataTime;
    }

    public void run() {

        readResponse();
        convertResponse();

        ObjectMapper objectMapper = new ObjectMapper();


        Response responseTime = null;
        //Response responseMap = null;

        try {
            responseTime = objectMapper.readValue(object[1], Response.class);
            //responseMap = objectMapper.readValue(object[2], Response.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        responseDataTime = responseTime.getResponseData();
        //responseDataMap = responseMap.getResponseData();


    }

    public static void iniArrayObject() {
        object = new String[getNumObj()];
        for (int i = 0; i < object.length; i++) {
            object[i] = "";
        }
    }

    /**
     * Метод анализирует массив символов и формирует массив строковых JSON-объектов
     */
    public static void convertResponse() {
        iniArrayObject();
        int index = 0;
        int cntOpen = 0;
        int cntClose = 0;
        for (int i = 1; i < response.length; i++) {
            if (response[i] == '{') {
                cntOpen++;
            } else if (response[i] == '}') {
                cntClose++;
            }

            if (cntOpen != cntClose) {
                object[index] += response[i];
            } else if (response[i] != ',') {
                object[index] += response[i];
            }

            if (cntOpen > 0 && cntOpen == cntClose) {
                if (index < object.length - 1) {
                    index++;
                } else {
                    break;
                }
                cntOpen = 0;
                cntClose = 0;
            }
        }

        for (String str : object) {
            System.out.println(str);
        }

    }

    /**
     * Метод подсчитывает количество JSON-объектов в Response
     *
     * @return Возвращает количество объектов
     */
    public static int getNumObj() {
        int cntObj = 0;
        int cntOpen = 0;
        int cntClose = 0;
        for (int i = 0; i < response.length; i++) {
            if (response[i] == '{') {
                cntOpen++;
            } else if (response[i] == '}') {
                cntClose++;
            }
            if (cntOpen > 0 && cntOpen == cntClose) {
                cntObj++;
                cntOpen = 0;
                cntClose = 0;
            }
        }
        return cntObj;
    }


    /**
     * Метод считывает текст из файла и записывает его в симвльный массив
     */
    public static void readResponse() {
        String str = null;
        try {
            str = Files.readString(Paths.get(FILE_NAME));
        } catch (IOException e) {
            e.printStackTrace();
        }
        response = str.toCharArray();
    }


}


