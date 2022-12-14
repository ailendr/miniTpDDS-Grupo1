package model.server;

import spark.Spark;
import spark.template.handlebars.HandlebarsTemplateEngine;
import model.spark.utils.BooleanHelper;
import model.spark.utils.HandlebarsTemplateEngineBuilder;

public class Router {
    private static HandlebarsTemplateEngine engine;

    private static void initEngine() {
        Router.engine = HandlebarsTemplateEngineBuilder
                .create()
                .withDefaultHelpers()
                .withHelper("isTrue", BooleanHelper.isTrue)
                .build();
    }

    public static void init() {
        Router.initEngine();
        Spark.staticFileLocation("/public");
        Router.configure();
    }

    private static void configure(){
        Spark.get("/", (req, res) -> "Hola");
    }
}