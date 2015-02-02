package com.ca.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static spark.Spark.*;


public class App 
{
    private static Logger log = LoggerFactory.getLogger(App.class);
    private static final String IP_ADDRESS = System.getenv("OPENSHIFT_DIY_IP") != null ? System.getenv("OPENSHIFT_DIY_IP") : "localhost";
    private static final int PORT = System.getenv("OPENSHIFT_DIY_PORT") != null ? Integer.parseInt(System.getenv("OPENSHIFT_DIY_PORT")) : 8080;
    public static void main(String[] args) {
        log.info("Starting Web App...");
        ipAddress(IP_ADDRESS);
        port(PORT);
        staticFileLocation("/webapp");

        get("/api/", (request, response) -> "api root");
    }
}
