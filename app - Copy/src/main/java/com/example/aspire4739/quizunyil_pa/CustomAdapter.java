package com.example.aspire4739.quizunyil_pa;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aspire4739.quizunyil_pa.kuliner.Soal1Kuliner;
import com.example.aspire4739.quizunyil_pa.pakaian.Soal1Pakaian;
import com.example.aspire4739.quizunyil_pa.rumah.Soal1Rumah;
import com.example.aspire4739.quizunyil_pa.tarian.Soal1Tarian;

import java.util.ArrayList;

import static android.content.Context.NOTIFICATION_SERVICE;

/**
 * Created by Aspire 4739 on 07/11/2017.
 */

public class CustomAdapter extends RecyclerView.Adapter
    <CustomAdapter.CustomViewHolder>{

    LayoutInflater mInflater;
    ArrayList<Sisop> sisop;

    private final Context mContext;
    private NotificationManager mNotifyManager;
    /*Constants for the notification id, the web url for a button in the notification, and the
    custom notification actions for buttons in the notification*/
    private static final int NOTIFICATION_ID = 0;
    private static final String NOTIFICATION_GUIDE_URL =
            "https://developer.android.com/design/patterns/notifications.html";
    private static final
    String ACTION_UPDATE_NOTIFICATION =
            "com.example.android.notifyme.ACTION_UPDATE_NOTIFICATION";
    private static final String ACTION_CANCEL_NOTIFICATION =
            "com.example.android.notifyme.ACTION_CANCEL_NOTIFICATION";

    public CustomAdapter(Context context, ArrayList<Sisop> sisop){
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
        this.sisop = sisop;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView namaItemGambar;
        CustomAdapter mAdapter;

        private FragmentManager fragmentManager;
        private FragmentTransaction fragmentTransaction;


        public CustomViewHolder(View itemView, CustomAdapter adapter) {
            super(itemView);
            //Get layout
            namaItemGambar = (ImageView) itemView.findViewById(R.id.logo);

            //Associate with this adapter
            this.mAdapter = adapter;
            namaItemGambar.setOnClickListener(this);

        }

        public void onClick(View v) {
            // do your action here with imageView
        }
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.rowview, parent, false);

        return new CustomViewHolder(itemView, this);
    }

    @Override
    public void onBindViewHolder(final CustomViewHolder holder, final int position) {

        mNotifyManager = (NotificationManager) mContext.getSystemService(NOTIFICATION_SERVICE);

        //Retrieve the data for that position
        Sisop current = sisop.get(position);
        //Add the data to the view
       // Log.d("ini", sisop.get(position));
        holder.namaItemGambar.setImageResource(current.gambar);

            holder.namaItemGambar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    sendNotification();
                    Intent intent = new Intent(holder.namaItemGambar.getContext(),SoalActivity.class);
                    intent.putExtra("gambar",String.valueOf(sisop.get(position).gambar));
                    holder.namaItemGambar.getContext().startActivity(intent);

                }
            });


       /* holder.namaItemGambar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               sisop.remove(position);
               notifyDataSetChanged();
            }
        });*/
    }

    @Override
    public int getItemCount(){
        return sisop.size();
    }

    public void sendNotification() {

        //Sets up the pending intent that is delivered when the notification is clicked
        Intent notificationIntent = new Intent(mContext, SoalActivity.class);
        PendingIntent notificationPendingIntent = PendingIntent.getActivity
                (mContext, NOTIFICATION_ID, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);


        // Sets up the pending intent to cancel the notification,
        // delivered when the user dismisses the notification
        Intent cancelIntent = new Intent(ACTION_CANCEL_NOTIFICATION);
        PendingIntent cancelPendingIntent = PendingIntent.getBroadcast
                (mContext, NOTIFICATION_ID, cancelIntent, PendingIntent.FLAG_ONE_SHOT);

        //Sets up the pending intent associated with the Learn More notification action,
        //uses an implicit intent to go to the web.
        Intent learnMoreIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(NOTIFICATION_GUIDE_URL));
        PendingIntent learnMorePendingIntent = PendingIntent.getActivity
                (mContext, NOTIFICATION_ID, learnMoreIntent, PendingIntent.FLAG_ONE_SHOT);

        //Sets up the pending intent to update the notification. Corresponds to a press of the
        //Update Me! button
        Intent updateIntent = new Intent(ACTION_UPDATE_NOTIFICATION);
        PendingIntent updatePendingIntent = PendingIntent.getBroadcast
                (mContext, NOTIFICATION_ID, updateIntent, PendingIntent.FLAG_ONE_SHOT);

        //Builds the notification with all of the parameters
        NotificationCompat.Builder notifyBuilder = (NotificationCompat.Builder) new NotificationCompat.Builder(mContext)
                .setContentTitle("Notifikasi baru")
                .setContentText("Anda sedang memutar ")
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentIntent(notificationPendingIntent)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setDefaults(NotificationCompat.DEFAULT_ALL);

        //Delivers the notification
        mNotifyManager.notify(NOTIFICATION_ID, notifyBuilder.build());
    }
}




