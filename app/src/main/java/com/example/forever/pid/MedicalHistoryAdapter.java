package com.example.forever.pid;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;



public class MedicalHistoryAdapter extends ArrayAdapter<MedicalHistory>{
    private Context context;
    private ArrayList<MedicalHistory> medicalHistories;

        public MedicalHistoryAdapter(@NonNull Context context,ArrayList<MedicalHistory> medicalHistories ) {
            super(context, R.layout.medical_history_layout, medicalHistories);
            this.context = context;
            this.medicalHistories = medicalHistories;
        }


        class ViewHolder{
            ImageView medicalImageIV;
            TextView doctorNameTV;
        TextView addDateTV;
        Button detailsBtn;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull final ViewGroup parent) {
        LayoutInflater inflater =   (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        final ViewHolder holder;
        if(convertView==null) {
            holder          =   new ViewHolder();

            convertView     = inflater.inflate(R.layout.medical_history_layout, parent, false);
            holder.medicalImageIV = (ImageView) convertView.findViewById(R.id.prescriptionImage);
            holder.doctorNameTV = (TextView) convertView.findViewById(R.id.doctorName);
            holder.addDateTV = (TextView) convertView.findViewById(R.id.addDate);
            holder.detailsBtn  = (Button) convertView.findViewById(R.id.docDetails);

            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        String imagePathName = medicalHistories.get(position).getImageName();
        File imgFile = new  File(imagePathName);

        if(imgFile.exists()){

            Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
            holder.medicalImageIV.setImageBitmap(myBitmap);

        }
        //holder.medicalImageIV.setImageResource(medicalHistories.get(position).getImageName());
        //holder.doctorNameTV.setText(medicalHistories.get(position).getmHistoryId());
        holder.addDateTV.setText(medicalHistories.get(position).getAddDate());

        //final View finalConvertView = convertView;
        holder.detailsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int     rowId     = medicalHistories.get(position).getmHistoryId();
                holder.medicalImageIV.buildDrawingCache();
                Bitmap image= holder.medicalImageIV.getDrawingCache();


                parent.getContext().startActivity(new Intent(parent.getContext(),ShowPrescriptionActivity.class)
                .putExtra("MH_id",rowId)
                .putExtra("prescriptionImage",image));
            }
        });
        return convertView;
    }
}
