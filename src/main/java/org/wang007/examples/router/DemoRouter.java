package org.wang007.examples.router;

import io.vertx.core.Vertx;
import io.vertx.core.eventbus.Message;
import io.vertx.core.http.HttpClient;
import io.vertx.core.json.Json;
import io.vertx.ext.web.Router;
import org.wang007.annotation.Inject;
import org.wang007.annotation.Route;
import org.wang007.examples.component.DataComponent;
import org.wang007.examples.verticle.HttpServer;
import org.wang007.json.JsonSend;
import org.wang007.router.LoadRouter;

/**
 * created by wang007 on 2018/9/10
 */
@Route(value = "/ttt", mountPath = "/demo")
public class DemoRouter implements LoadRouter {

    @Inject
    private DataComponent data;

    @Inject("httpClient")
    private HttpClient client;

    @Inject
    private HttpServer server;

    @Override
    public void start(Router router, Vertx vertx) {



        router.route("/test1").handler(rc -> {

            vertx.eventBus().<JsonSend>send("json", new JsonSend().put("fuck", "fuck you"), JsonSend.options(), ar -> {
                Message<JsonSend> result = ar.result();
                rc.response().end(result.body().encode());
            });

            //rc.response().end("hello world");

        });

        router.route("/data").handler(rc -> {
            System.out.println(client);
            rc.response().end(Json.encode(data));
        });

        router.route("/test2").handler(rc -> {
            rc.response().end("test2");
        });

        router.route("/test3").handler(rc -> {
            rc.response().end("test2");
        });

        router.route("/test3").handler(rc -> {
            rc.response().end("test2");
        });

        router.route("/test4").handler(rc -> {
            rc.response().end("test2");
        });

        router.route("/test5").handler(rc -> {
            rc.response().end("test2");
        });

        router.route("/test6").handler(rc -> {
            rc.response().end("test2");
        });

        router.route("/test7").handler(rc -> {
            rc.response().end("test2");
        });

        router.route("/test8").handler(rc -> {
            rc.response().end("test2");
        });

        router.route("/test9").handler(rc -> {
            rc.response().end("test2");
        });

    }
}
