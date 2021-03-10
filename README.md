# Android-Push-Notification
How to send push notification from app to app or app to all apps...

## 1) Add this dependencies to build gradle (App) cate 

      implementation 'com.android.volley:volley:1.1.1'


## 2) Add this  menifest setting

     i) <uses-permission android:name="com.google.android.c2dm.permission.RECEIVE" />

    ii) <service
            android:name=".FirebaseMessagingService"
            android:permission="TODO"
            tools:ignore="ExportedService">
            <intent-filter>
                <action android:name="com.google.firebase.MESSAGING_EVENT" />
            </intent-filter>
        </service>
        
## 3) Then 

   


// for sending notification to all 

        FirebaseMessaging.getInstance().subscribeToTopic("all");





 // fcm settings for perticular user

        FirebaseInstanceId.getInstance().getInstanceId()
                .addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
                    @Override
                    public void onComplete(@NonNull Task<InstanceIdResult> task) {
                        if (task.isSuccessful()) {
                          String  token = Objects.requireNonNull(task.getResult()).getToken();

                        }

                    }
                });



