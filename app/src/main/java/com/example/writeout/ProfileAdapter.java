package com.example.writeout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.textfield.TextInputEditText;

import de.hdodenhof.circleimageview.CircleImageView;


public class ProfileAdapter extends FirebaseRecyclerAdapter<UserHelperClass,ProfileAdapter.myViewHolder> {

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public ProfileAdapter(@NonNull FirebaseRecyclerOptions<UserHelperClass> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, int position, @NonNull UserHelperClass model) {
        holder.fullName.setText(model.getName());
        holder.email.setText(model.getEmail());
        holder.phoneNo.setText(model.getPhoneNo());
        holder.password.setText(model.getPassword());
        holder.fullNameField.setText(model.getName());
        holder.usernameField.setText(model.getUsername());

//        Glide.with(holder.img.getContext())
//                .load(model.getImage())
//                .placeholder(com.firebase.ui.database.R.drawable.common_google_signin_btn_icon_dark)
//                .circleCrop()
//                .error(R.drawable.logo)
//                .into(holder.img);

    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_item,parent,false);
        return new myViewHolder(view);
    }

    class myViewHolder extends RecyclerView.ViewHolder{

        ImageView img;
        TextView fullNameField, usernameField;
        TextInputEditText fullName, email, phoneNo, password;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            img = (ImageView)itemView.findViewById(R.id.profile_Img);
            fullNameField = (TextView)itemView.findViewById(R.id.fullname_field);
            usernameField = (TextView)itemView.findViewById(R.id.username_field);
            fullName = (TextInputEditText)itemView.findViewById(R.id.full_name_profile);
            email = (TextInputEditText)itemView.findViewById(R.id.email_profile);
            phoneNo = (TextInputEditText)itemView.findViewById(R.id.phone_no_profile);
            password = (TextInputEditText)itemView.findViewById(R.id.password_profile);
        }
    }

}