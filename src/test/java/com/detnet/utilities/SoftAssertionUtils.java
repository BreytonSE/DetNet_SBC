package com.detnet.utilities;

import org.assertj.core.api.SoftAssertions;

import java.util.ArrayList;
import java.util.List;

public class SoftAssertionUtils {
    private static final ThreadLocal<List<String>> assertionErrors = ThreadLocal.withInitial(ArrayList::new);
    private static final ThreadLocal<SoftAssertions> softAssertions = ThreadLocal.withInitial(SoftAssertions::new);

    public static SoftAssertions getSoftAssertions(){
        return softAssertions.get();
    }

    public static void reset(){
        softAssertions.remove();
    }

    public static void assertAll(){
        try{
            softAssertions.get().assertAll();
        }catch (AssertionError e){
            assertionErrors.get().add(e.getMessage());
        }
    }

    public static List<String> getAssertionErrors(){
        return assertionErrors.get();
    }
}