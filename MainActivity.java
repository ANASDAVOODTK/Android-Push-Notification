//packge name

public class ActivityDash extends AppCompatActivity {


    String  usertoken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDashBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        FirebaseMessaging.getInstance().subscribeToTopic("all");


                         // fcm settings for perticular user

        FirebaseInstanceId.getInstance().getInstanceId()
                .addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
                    @Override
                    public void onComplete(@NonNull Task<InstanceIdResult> task) {
                        if (task.isSuccessful()) {
                              usertoken = Objects.requireNonNull(task.getResult()).getToken();
                              Log.d("toooo","token= "+usertoken);

                        }

                    }
                });

        



    }

    // call this for send notification to all

    public void noti()
    {
        FcmNotificationsSender notificationsSender = new
                    FcmNotificationsSender("/topics/all" ,"Tilte","admin app",
                    getApplicationContext(),ActivityDash.this);
            notificationsSender.SendNotifications();
    }

    // call this for send notification to specified user

    public void noti2()
    {
        FcmNotificationsSender notificationsSender = new
                    FcmNotificationsSender(usertoken,"Tilte","admin app",
                    getApplicationContext(),ActivityDash.this);
            notificationsSender.SendNotifications();
    }

    
    


  
}