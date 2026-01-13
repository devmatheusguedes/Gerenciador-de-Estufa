package br.com.gerenciadordeestufa;

import android.app.Application;

import br.com.gerenciadordeestufa.data.database.AppDatabase;

public class GerenciadorEstufaApp extends Application {
    private static AppDatabase appDatabase;
    @Override
    public void onCreate() {
        super.onCreate();
        appDatabase = AppDatabase.getDatabase(this);
    }

    public static AppDatabase getAppDatabase() {
        return appDatabase;
    }
}
