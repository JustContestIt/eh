package httpServer;

import io.javalin.Javalin;
import io.javalin.http.Context;

public class HttpServer {
    public static void main(String[] args) {
        Javalin app = Javalin.create().start(8079);

        app.get("/", HttpServer::helloWorld);
        app.get("/status", HttpServer::status);
        app.get("/:action/:first/:second", context -> {
            if(context.pathParam("action").equals("add")) add(context);
            if(context.pathParam("action").equals("sub")) sub(context);
            if(context.pathParam("action").equals("mpy")) mpy(context);
            if(context.pathParam("action").equals("del")) del(context);
            if(context.pathParam("action").equals("power")) power(context);
        });
    }

    public static void helloWorld(Context context){
        System.out.println("Headers from Client: ");
        System.out.println(context.headerMap());

        context.result("Ur connected");
    }

    public static void status(Context context) {
        context.result("Everything is OK");
    }

    public static void add(Context context){
        String first = context.pathParam("first");
        String second = context.pathParam("second");

        int firstVariable = (int)(first.charAt(0) - '0');
        int secondVariable = (int)(second.charAt(0) - '0');
        int sum = firstVariable + secondVariable;
        context.result(String.valueOf(sum));
    }
    public static void sub(Context context){
        String first = context.pathParam("first");
        String second = context.pathParam("second");

        int firstVariable = (int)(first.charAt(0) - '0');
        int secondVariable = (int)(second.charAt(0) - '0');
        int sum = firstVariable - secondVariable;
        context.result(String.valueOf(sum));
    }
    public static void mpy(Context context){
        String first = context.pathParam("first");
        String second = context.pathParam("second");

        int firstVariable = (int)(first.charAt(0) - '0');
        int secondVariable = (int)(second.charAt(0) - '0');
        int sum = firstVariable * secondVariable;
        context.result(String.valueOf(sum));
    }
    public static void del(Context context){
        String first = context.pathParam("first");
        String second = context.pathParam("second");

        int firstVariable = (int)(first.charAt(0) - '0');
        int secondVariable = (int)(second.charAt(0) - '0');
        int sum = firstVariable / secondVariable;
        context.result(String.valueOf(sum));
    }
    public static void power(Context context){
        String first = context.pathParam("first");
        String second = context.pathParam("second");

        int firstVariable = (int)(first.charAt(0) - '0');
        int secondVariable = (int)(second.charAt(0) - '0');
        int sum = firstVariable ^ secondVariable;
        context.result(String.valueOf(sum));
    }
}
