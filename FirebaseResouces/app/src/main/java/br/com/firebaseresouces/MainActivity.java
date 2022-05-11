package br.com.firebaseresouces;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private DatabaseReference reference;
    private Users user;
    private Product product;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        reference = FirebaseDatabase.getInstance().getReference();
        firebaseAuth = FirebaseAuth.getInstance();

        //checking if the user is logged out

/*        firebaseAuth.signInWithEmailAndPassword("analucia@gmail.com", "ana123")
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful())
                            Log.i("loginUser", "Usuario logado com sucesso !!");
                        else
                            Log.i("loginUser", "Erro ao tentar fazer login !!");
                    }
                });

         //firebaseAuth.signOut();
        if (firebaseAuth.getCurrentUser() != null)
            Log.i("CreateUser", "Usuario logado !");
        else
            Log.i("CreateUser", "Usuario não logado");*/
/*        firebaseAuth.createUserWithEmailAndPassword("analucia@gmail.com", "ana123")
                .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful())
                            Log.i("CreateUser", "Sucesso ao cadastrar usuario! ");
                        else
                            Log.i("CreateUser", "Erro ao cadastrar usuario! ");
                    }
                });*/

        addUsers();
        addProduct();
    }

    public void addUsers(){
        user = new Users();

        user.setFirstName("Ana");
        user.setSecondName("Gomes");
        user.setAge(21);

        DatabaseReference users = reference.child("Users");
        users.push().setValue(user);

/*        users.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Log.i("FIREBASEONDATA", "firebase" + snapshot.getValue());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });*/
    }

    public void addProduct(){
        product = new Product();

       /* product.setDescription("Nexus");
        product.setBrand("Samsung");
        product.setPrice(999.0);*/

        DatabaseReference products = reference.child("Product");
        //products.child("003").setValue(product);

/*        products.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Log.i("FirebaseProduct", "PRODUCT: " + snapshot.getValue());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });*/
    }
}