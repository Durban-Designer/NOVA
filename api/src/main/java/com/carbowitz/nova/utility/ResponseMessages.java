package com.carbowitz.nova.utility;

public class ResponseMessages {
    // Status controller
    public static String statusIsOk = "NOVA is working as expected!";
    // ManagedApi controller
    public static String NoNullManagedApiCreationDto = "The provided ManagedApiCreationDTO or its name cannot be null.";
    public static String NameExistsManagedApiCreation(String name) {
        return "The name '" + name + "' already exists.";
    }
    public static String failedToFindAllServices = "Failed to find all ManagedApi objects, verify the DB connection and try again.";
}