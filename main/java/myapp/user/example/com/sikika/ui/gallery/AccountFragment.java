package myapp.user.example.com.sikika.ui.gallery;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserInfo;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import myapp.user.example.com.sikika.MyUploads;
import myapp.user.example.com.sikika.R;

import static com.firebase.ui.auth.AuthUI.TAG;

public class AccountFragment extends Fragment {

    private ImageView imageView;
    private TextView textView1;
    private ListView l1;
    ArrayList<String> myArrayList = new ArrayList<>();

    private ArrayAdapter<String>adapter;
    String[]default_items = new String[]{"Name","Email"};
    UserInfo info;

    private List<String> itemlist;
    private String uid;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_account, container, false);
       // textView1 = v.findViewById(R.id.myUploads);

        l1=(ListView)v.findViewById(R.id.listView1);
        FirebaseUser user1 = FirebaseAuth.getInstance().getCurrentUser();
        if( user1 != null) {
            uid = user1.getUid();
            itemlist = new ArrayList<>();

        }
        //DatabaseReference mref;
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                itemlist.clear();
                String user_name = dataSnapshot.child(uid).child("name").getValue(String.class);
                String user_email = dataSnapshot.child(uid).child("email").getValue(String.class);

                itemlist.add(user_name);
                itemlist.add(user_email);

                adapter = new ArrayAdapter<>(getActivity(),android.R.layout.simple_list_item_1,itemlist);
                l1.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getActivity().getApplicationContext(),"Network Error,Please check your network connection",Toast.LENGTH_SHORT).show();
            }
        });


         FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();

        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                final ContactsContract.Profile p = dataSnapshot.getValue(ContactsContract.Profile.class);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        GalleryViewModel galleryViewModel = ViewModelProviders.of(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_account, container, false);
        final TextView textView = root.findViewById(R.id.text_gallery);

        galleryViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);

//                textView1.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Intent intent = new Intent(getActivity(), MyUploads.class);
//                        startActivity(intent);
//                    }
//                });



            }
        });
        return v;
    }

//    private static class  Post{
//
//        public String user;
//        public String email;
//
//        public Post(String user,String email){
//
//        }
//    }
//    final FirebaseDatabase database = FirebaseDatabase.getInstance();
//    DatabaseReference ref = database.getReference("server/saving-data");

//    ref.addValueEventListener(new ValueEventListener(){
//        @Override
//                public void onDataChange(DataSnapshot dataSnapshot){
//            Post post = dataSnapshot.getValue(Post.class);
//            System.out.println(post);
//        }
//        @Override
//                public void onCancelled(DatabaseError databaseError){
//            System.out.println("The read failed:" +databaseError.getCode());
//        }
//    });
}

