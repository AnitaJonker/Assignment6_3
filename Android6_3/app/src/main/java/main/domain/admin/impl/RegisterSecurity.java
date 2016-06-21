package main.domain.admin.impl;

import main.domain.admin.RegisterWorker;
import main.domain.admin.Worker;

/**
 * Created by Anita on 2016/04/16.
 */
public class RegisterSecurity extends WorkerDetails implements RegisterWorker {

    public Worker registerWorker()
    {
        Worker security = new Worker.Builder()
                .name("Sam")
                .surname("Smith")
                .address("London")
                .build();
        return security;
    }

    public Worker handleRequest(String request) {
        if(request.equalsIgnoreCase("Security")){
            return registerWorker();
        }else{
            if (request!=null) {
                return nextType.handleRequest(request);
            }
            return null;
        }
    }




}
