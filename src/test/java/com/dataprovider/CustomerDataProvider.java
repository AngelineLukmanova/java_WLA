package com.dataprovider;

import org.testng.annotations.DataProvider;

public class CustomerDataProvider {
    @DataProvider(name = "CreateCustomer")
        public static Object[][] CreateCustomer(){
            return new Object[][] {
                    {"Auburn", "admin", "alukmanova1209", "John", "Smith", ""},
                    {"Auburn", "admin", "alukmanova1209", "", "", "Mandatory field 'First Name' is empty"},
                    {"Auburn", "admin", "alukmanova1209", "", "Lock", "Mandatory field 'First Name' is empty"},
                    {"Auburn", "admin", "alukmanova1209", "Mark", "", "Mandatory field 'Last Name' is empty"},
            };
        }

}
