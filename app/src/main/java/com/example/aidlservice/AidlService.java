package com.example.aidlservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

public class AidlService extends Service {

    @Override
    public IBinder onBind(Intent intent) {
        Log.d("binderOnBind", "onBind: trying to bind...");
        return new IAidlService.Stub() {
            @Override
            public String sendCommand(String command) throws RemoteException {
                Log.d("commandReceived", "Command: "+ command);
                return processCommand(command);
            }
        };
    }

    private String processCommand(String command) {
        switch (command){
            case "start":
                return "Command was started.";
            case "stop":
                return "Command was stopped.";
            case "hi":
            case "hello":
                return "Hello!";
            default:
                return "Command not found.";
        }
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d("binderOnUnbind", "onUnbind: ");
        return super.onUnbind(intent);
    }
}
