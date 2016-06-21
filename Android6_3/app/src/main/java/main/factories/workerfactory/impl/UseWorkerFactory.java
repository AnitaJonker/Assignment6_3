package main.factories.workerfactory.impl;

import main.domain.admin.Worker;
import main.domain.admin.impl.RegisterCleaner;
import main.domain.admin.impl.RegisterLibrarian;
import main.domain.admin.impl.RegisterSecurity;
import main.domain.admin.impl.WorkerDetails;
import main.factories.workerfactory.WorkerFactory;

/**
 * Created by Anita on 2016/04/16.
 */
public class UseWorkerFactory implements WorkerFactory {
    Worker worker;

    public Worker getWorker(String workerType) {
        WorkerDetails chain = setUpChain();
        return chain.handleRequest(workerType);
    }

    public static WorkerDetails setUpChain(){
        WorkerDetails cleaner = new RegisterCleaner();
        WorkerDetails librarian = new RegisterLibrarian();
        WorkerDetails security = new RegisterSecurity();
        cleaner.setNextWorkerType(librarian);
        librarian.setNextWorkerType(security);
        return cleaner;
    }



}
