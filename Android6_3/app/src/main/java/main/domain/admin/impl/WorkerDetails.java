package main.domain.admin.impl;

import main.domain.admin.Worker;

/**
 * Created by Anita on 2016/04/16.
 */
public abstract class WorkerDetails {

    WorkerDetails nextType;

    public void setNextWorkerType(WorkerDetails nextType) {
        this.nextType = nextType;
    }
    public abstract Worker handleRequest(String request);
}
