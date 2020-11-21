package ru.timsv.fieldcoordinator.model;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;


public class TimeService {

    private long currentTime;
    private long endField;


    public void setCurrentTime(long currentTime) {
        this.currentTime = currentTime;
    }

    public void setEndField(long endField) {
        this.endField = endField;
    }

    public void printEndFieldThrough() {
        System.out.println("Поля закроются через - " + convertDate(endField - currentTime));
    }

    public void printCurrentTime() {
        System.out.println("Текущее время - " + convertDate(currentTime));

    }

    public void printEndFieldIn() {
        System.out.println("Поля закроются в - " + convertDate(endField));
    }

    private static String convertDate(long seconds) {
        LocalDateTime dateTime = LocalDateTime.ofEpochSecond(seconds, 0, ZoneOffset.of("+03"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd, HH:mm:ss");
        String formattedDate = dateTime.format(formatter);

        return formattedDate;

    }

    /**
     * Вычисляет время до открытия провинции
     *
     * @param currentTime - текущее время
     * @param lockedUntil - время до разблокировки
     */
    private static void getTimeToFarm(long currentTime, long lockedUntil) {
        int result = (int) (lockedUntil - currentTime);
        //System.out.println("Сектор разблокируется через " + result + " секунд");
        int hours = result / 3600;
        int minutes = (result - (hours * 3600)) / 60;
        int seconds = result - (hours * 3600 + minutes * 60);
        System.out.println("Сектор откроется через " + hours + ":" + minutes + ":" + seconds + " ч");
    }

    private static void calculateFarmingTime(long seconds) {
        LocalDateTime dateTime = LocalDateTime.ofEpochSecond(seconds, 0, ZoneOffset.of("+03"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String formattedDate = dateTime.format(formatter);
        System.out.println("Фарм начнется в " + formattedDate);
    }
}
