package pl.ciecierski.sbh.eternalservices;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import java.util.Timer;
import java.util.TimerTask;

import pl.ciecierski.sbh.R;
import pl.ciecierski.sbh.eternalservices.utilities.Notification;

import static pl.ciecierski.sbh.sections.RandomDialogBySections.showRandomDialogBySection;
import static pl.ciecierski.sbh.sections.Sections.BYDGOSZCZ_1920;
import static pl.ciecierski.sbh.sections.Sections.BYDGOSZCZ_1945;
import static pl.ciecierski.sbh.sections.Sections.MARIAN_REJEWSKI;

public class Service extends android.app.Service {
    private static final int NUMBER_OF_CHANNEL_BYDGOSZCZ1945_NOTIFICATION = 1963;
    private static final int NUMBER_OF_CHANNEL_BYDGOSZCZ1920_NOTIFICATION = 1964;
    private static final int NUMBER_OF_CHANNEL_REJEWSKI_NOTIFICATION = 1995;
    private static final int NOTIFICATION_SHORTCUT_ID = 1989;
    private static String TAG = "sbh";
    private static Service mCurrentService;
    private int counter = 0;

    public Service() {
        super();
    }

    @Override
    public void onCreate() {
        super.onCreate();


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            restartForeground();
        }
        mCurrentService = this;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);
        Log.d(TAG, "restarting Service !!");
        counter = 0;

        // it has been killed by Android and now it is restarted. We must make sure to have reinitialised everything
        if (intent == null) {
            ProcessMainClass bck = new ProcessMainClass();
            bck.launchService(this);
        }

        // make sure you call the startForeground on onStartCommand because otherwise
        // when we hide the notification on onScreen it will nto restart in Android 6 and 7
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O) {
            restartForeground();
        }

        startTimer();

        // return start sticky so if it is killed by android, it will be restarted with Intent null
        return START_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    /**
     * it starts the process in foreground. Normally this is done when screen goes off
     * THIS IS REQUIRED IN ANDROID 8 :
     * "The system allows apps to call Context.startForegroundService()
     * even while the app is in the background.
     * However, the app must call that service's startForeground() method within five seconds
     * after the service is created."
     */
    public void restartForeground() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Log.i(TAG, "restarting foreground");
            try {
                Notification notification = new Notification();
                startForeground(NOTIFICATION_SHORTCUT_ID, notification.setNotification(this, "Sekrety Bydgoskiej historii", "Włącz aplikację", R.drawable.ico_herb6));
                Log.i(TAG, "restarting foreground successful");
                startTimer();
            } catch (Exception e) {
                Log.e(TAG, "Error in notification " + e.getMessage());
            }
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy called");
        // restart the never ending service
        Intent broadcastIntent = new Intent(Globals.RESTART_INTENT);
        sendBroadcast(broadcastIntent);
        stoptimertask();
    }

    /**
     * this is called when the process is killed by Android
     *
     * @param rootIntent
     */

    @Override
    public void onTaskRemoved(Intent rootIntent) {
        super.onTaskRemoved(rootIntent);
        Log.i(TAG, "onTaskRemoved called");
        // restart the never ending service
        Intent broadcastIntent = new Intent(Globals.RESTART_INTENT);
        sendBroadcast(broadcastIntent);
        // do not call stoptimertask because on some phones it is called asynchronously
        // after you swipe out the app and therefore sometimes
        // it will stop the timer after it was restarted
        // stoptimertask();
    }

    /**
     * static to avoid multiple timers to be created when the service is called several times
     */
    private static Timer timer;
    private static TimerTask timerTask;
    long oldTime = 0;

    public void startTimer() {
        Log.i(TAG, "Starting timer");

        //set a new Timer - if one is already running, cancel it to avoid two running at the same time
        stoptimertask();
        timer = new Timer();

        //initialize the TimerTask's job
        initializeTimerTask();

        Log.i(TAG, "Scheduling...");
        //schedule the timer, to wake up every 1 second
        timer.schedule(timerTask, 1000, 1000); // co sekundę
    }

    /**
     * it sets the timer to print the counter every x seconds
     */
    public void initializeTimerTask() {
        Log.i(TAG, "initialising TimerTask");

        timerTask = new TimerTask() {
            public void run() {
                counter++;




                /*
                        wybranie losowego komunikatu w kanałach - obecnie są 3
                 */

                if (
                        (counter == 40) |
                                (counter == 800) |
                                (counter % 3600 == 0)) {

//                    Log.i("do 1920: ", showRandomDialogBySection(BYDGOSZCZ_1920));

                    createNotificationChannel(getString(R.string.channel_bydgoszcz1920_name),
                            getString(R.string.channel_bydgoszcz1920_description),
                            "BYDGOSZCZ1920_CHANNEL");

                                    Log.i("in timer ciecierski", "in timer ++++  " + (counter));

                    startNotification(showRandomDialogBySection(BYDGOSZCZ_1920),
                            "BYDGOSZCZ1920_CHANNEL",
                            "Bydgoszcz 1920: czy wiesz, że..",
                            NUMBER_OF_CHANNEL_BYDGOSZCZ1920_NOTIFICATION);
                }

                if (
                        (counter == 20) |
                                (counter == 700) |
                                (counter % 7200 == 0)) {

//                    Log.i("do 1945: ", showRandomDialogBySection(BYDGOSZCZ_1945));

                    createNotificationChannel(getString(R.string.channel_bydgoszcz1945_name),
                            getString(R.string.channel_bydgoszcz1945_description),
                            "BYDGOSZCZ1945_CHANNEL");

                    Log.i("in timer ciecierski", "in timer ++++  " + (counter));

                    startNotification(showRandomDialogBySection(BYDGOSZCZ_1945),
                            "BYDGOSZCZ1945_CHANNEL",
                            "Bydgoszcz 1945: czy wiesz, że..",
                            NUMBER_OF_CHANNEL_BYDGOSZCZ1945_NOTIFICATION);
                }

                if (
                        (counter == 60) |
                                (counter == 900) |
                                (counter % 10800 == 0)) {

//                    Log.i("do Rejewski: ", showRandomDialogBySection(MARIAN_REJEWSKI));

                    createNotificationChannel(getString(R.string.channel_rejewski_name),
                            getString(R.string.channel_rejewski_description),
                            "REJEWSKI_CHANNEL");

                    Log.i("in timer ciecierski", "in timer ++++  " + (counter));

                    startNotification(showRandomDialogBySection(MARIAN_REJEWSKI),
                            "REJEWSKI_CHANNEL",
                            "Marian Rejewski: czy wiesz, że..",
                            NUMBER_OF_CHANNEL_REJEWSKI_NOTIFICATION);
                }
            }
        };
    }

    /**
     * not needed
     */
    public void stoptimertask() {
        //stop the timer, if it's not already null
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
    }

    public static Service getmCurrentService() {
        return mCurrentService;
    }

    public static void setmCurrentService(Service mCurrentService) {
        Service.mCurrentService = mCurrentService;
    }



    private void createNotificationChannel(CharSequence name,
                                           String description,
                                           String idChannel) {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            name = getString(R.string.channel_rejewski_name);
//            description = getString(R.string.channel_rejewski_description);
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(idChannel, name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);

            try {
                notificationManager.createNotificationChannel(channel);
            } catch (NullPointerException e) {
// nothing
            }
        }
    }

    private void startNotification(String ciekawostka,
                                   String idChannel,
                                   String title,
                                   int numberOfChannel) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, idChannel)
                .setSmallIcon(R.drawable.ico_herb6)
                .setContentTitle(title)
                .setContentText(ciekawostka)
                .setStyle(new NotificationCompat.BigTextStyle().bigText(ciekawostka))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.notify(numberOfChannel, builder.build());
    }
//

}
