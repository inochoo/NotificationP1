package com.sibaamap.notificationp1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private static final String TITLE_PUSH_NOTIFICATION = "Thông báo tình hình COVID-19";
    private static final String CONTENT_PUSH_NOTIFICATION = "Mỹ sở hữu ngành công nghiệp dầu mỏ đầy tự hào, được cho là biểu tượng của tinh thần đổi mới Mỹ\", Jim Krane, chuyên gia năng lượng tại Đại học Rice, Texas, cho biết. \"Nhưng họ giờ thận trọng đến bất ngờ trước nhiệm vụ cấp thiết là bơm thêm dầu cho thế giới";
    private static final int NOTIFICATION_ID = 1;
    private Button btnSendNotification,btnSendNotification2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSendNotification = findViewById(R.id.btn_send_notification);
        btnSendNotification2 = findViewById(R.id.btn_send_notification_2);
        btnSendNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendNotification();
            }
        });
        btnSendNotification2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendNotification2();
            }
        });
    }

    private void sendNotification() {

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);

        Notification notification = new NotificationCompat.Builder(this,MyApplication.CHANNEL_ID)
                .setContentTitle(TITLE_PUSH_NOTIFICATION )
                .setContentText(CONTENT_PUSH_NOTIFICATION)
                .setSmallIcon(R.drawable.bell)
                .setStyle(new NotificationCompat.BigTextStyle().bigText(CONTENT_PUSH_NOTIFICATION))//big description
                .setLargeIcon(bitmap)
                .build();
        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);
        notificationManagerCompat.notify(getNotificationId(),notification);


//        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//        if(notificationManager != null){
//            notificationManager.notify(getNotificationId(), notification);
//        }
    }
    private void sendNotification2() {
        // custom sound
        Uri sound = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.fingerlickingtone);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.breakfast);

        Notification notification = new NotificationCompat.Builder(this,MyApplication.CHANNEL_ID_2)
                .setContentTitle("Title push notification channel 2")
                .setContentText("Message push notification channel 2")
                .setSmallIcon(R.drawable.bell)
                .setStyle(new NotificationCompat.BigPictureStyle().bigPicture(bitmap).bigLargeIcon(null))//big image
                .setLargeIcon(bitmap)
                .setSound(sound)
                .build();
        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);
        notificationManagerCompat.notify(getNotificationId(),notification);

    }
    private int getNotificationId(){
        return (int) new Date().getTime();
    }
}