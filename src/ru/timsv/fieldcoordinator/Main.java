package ru.timsv.fieldcoordinator;

import ru.timsv.fieldcoordinator.model.MainService;


import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        MainService mainService = new MainService();
        mainService.go();

    }
}
