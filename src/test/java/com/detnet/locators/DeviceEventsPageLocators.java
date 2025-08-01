package com.detnet.locators;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DeviceEventsPageLocators {
    private static String today = LocalDate.now().format(DateTimeFormatter.ofPattern("MMM d, yyyy"));
    public static final String eventsDate = String.format("(//p[contains(text(),'%s')])[1]",today);
    private static String partialTime = LocalTime.now().format(DateTimeFormatter.ofPattern("a")).toUpperCase();
    public static final String eventTime = String.format("(//p[contains(text(),'%s')])[1]",partialTime);
}