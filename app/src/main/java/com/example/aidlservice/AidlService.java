package com.example.aidlservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

public class AidlService extends Service {


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new IAidlService.Stub() {
            @Override
            public void sendCommand(String command) throws RemoteException {
                Log.d("onBind", "sendCommand: sent "+ command);
            }
        };
    }
}
