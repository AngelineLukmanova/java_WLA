package com.dataprovider;

import org.testng.annotations.DataProvider;

public class UserDataProvider {
    @DataProvider (name = "CreateUser")
    public static Object[][] CreateUser() {
        return new Object[][] {
                {"Auburn", "admin", "alukmanova1209", "jsmith", "password"}
        };
    }
}
