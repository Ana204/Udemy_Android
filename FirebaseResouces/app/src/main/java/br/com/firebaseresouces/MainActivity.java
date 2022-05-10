package br.com.firebaseresouces;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private DatabaseReference reference;
    private Users user;
    private Product product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        reference = FirebaseDatabase.getInstance().getReference();
        addUsers();
        addProduct();
    }

    public void addUsers(){
        user = new Users();

        /*user.setFirstName("Maria");
        user.setSecondName("Ferreira");
        user.setAge(25);*/

        DatabaseReference users = reference.child("Users");
       //users.child("001").setValue(user);

        users.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Log.i("FIREBASEONDATA", "firebase" + snapshot.getValue());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void addProduct(){
        product = new Product();

       /* product.setDescription("Nexus");
        product.setBrand("Samsung");
        product.setPrice(999.0);*/

        DatabaseReference products = reference.child("Product");
        //products.child("003").setValue(product);

        products.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Log.i("FirebaseProduct", "PRODUCT: " + snapshot.getValue());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}