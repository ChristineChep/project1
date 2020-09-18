package myapp.user.example.com.sikika;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import myapp.user.example.com.sikika.ui.gallery.AccountFragment;

import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MyUploads extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_uploads);



    }
    public static class Post{
        public String author;
        public String title;

        public Post(String author,String title){

            final FirebaseDatabase database = FirebaseDatabase.getInstance();
          //  DatabaseReference ref = database.getReference("server/saving-data/fireblog/posts");

            //Attach a listener to read data
           // ref.addValueEventListener(new ValueEventListener() {
//                @Override
//                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                    Post post = dataSnapshot.getValue(Post.class);
//                    System.out.println(post);
//                }
//
//                @Override
//                public void onCancelled(@NonNull DatabaseError databaseError) {
//
//                    System.out.println("The read failed");
//                }
//            });
        }
    }
}
