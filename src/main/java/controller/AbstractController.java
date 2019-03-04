package controller;

import model.HttpMethod;
import webserver.HttpRequest;
import webserver.HttpResponse;
import webserver.RequestMapping;

import java.util.HashMap;
import java.util.Map;

public class AbstractController implements Controller{


    public AbstractController() {

    }

    @Override
    public void service(HttpRequest request, HttpResponse response) {
        RequestMapping requestMapping = new RequestMapping();
        AbstractController controller = requestMapping.getController(request.getPath());

        if (request.getMethod() == HttpMethod.GET) {
            controller.doGet(request, response);
        }

        if (request.getMethod() == HttpMethod.POST) {
            controller.doPost(request, response);
        }
    }

    void doPost(HttpRequest request, HttpResponse response) {};
    void doGet(HttpRequest request, HttpResponse response) {};
}
