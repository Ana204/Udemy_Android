package br.com.firebaseresouces;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    private DatabaseReference reference;
    private Users user;
    private Product product;
    private FirebaseAuth firebaseAuth;
    private Button uploadButton;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        reference = FirebaseDatabase.getInstance().getReference();
        firebaseAuth = FirebaseAuth.getInstance();
        uploadButton = findViewById(R.id.UploadImage);
        imageView = findViewById(R.id.imageView);


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

          //checking if the user is logged out
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
        uploadImage();
        addUsers();
        addProduct();
    }

    public void uploadImage(){
        uploadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //configurando image para ser salva em  memoria
                imageView.setDrawingCacheEnabled(true);
                imageView.buildDrawingCache();

                //recuperar image em bitmap(image a ser carregada)
                Bitmap bitmap = imageView.getDrawingCache();

                //comprimento bitmap para formato png/jpg
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 75,baos );

                //converter o boas para pixel brutos em uma matriz de bytes
                byte[] dadosImage = baos.toByteArray();

                StorageReference storageReference = FirebaseStorage.getInstance().getReference();
                StorageReference imagens = storageReference.child("imagens");
                //StorageReference imageRef = imagens.child("a7ea01ea-b9a0-4c2a-95ae-73abeb9c9cfd.jpeg");

                //String nomeArquivo = UUID.randomUUID().toString();
                StorageReference imageRef = imagens.child("celular.jpeg");

                //deletar image
                /*imageRef.delete().addOnFailureListener(MainActivity.this, new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivity.this, "Erro ao deletar", Toast.LENGTH_LONG).show();
                    }
                }).addOnSuccessListener(MainActivity.this, new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(MainActivity.this, "Sucesso ao deletar imagem", Toast.LENGTH_LONG).show();
                    }
                });*/

                //obj controla o upload
               /* UploadTask uploadTask = imageRef.putBytes(dadosImage);

                uploadTask.addOnFailureListener(MainActivity.this, new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivity.this, "Upload da imagem falhou: " + e.getMessage().toString(), Toast.LENGTH_LONG).show();
                    }
                }).addOnSuccessListener(MainActivity.this, new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        imageRef.getDownloadUrl().addOnCompleteListener(new OnCompleteListener<Uri>() {
                            @Override
                            public void onComplete(@NonNull Task<Uri> task) {
                                Uri url = task.getResult();
                                Toast.makeText(MainActivity.this, "Sucesso ao fazer upload", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });*/

                //download image
                /*Glide.with(MainActivity.this)
                        .load(imageRef)
                        .into(imageView);*/
            }
        });
    }

    public void addUsers(){
        user = new Users();

        /*user.setFirstName("Maria");
        user.setSecondName("Silva");
        user.setAge(41)*/;

        DatabaseReference users = reference.child("Users");
        //users.push().setValue(user);

        //filter event
        //DatabaseReference filterUser = users.child("");
        //Query filterUser = users.orderByChild("firstName").equalTo("Ana");
        //Query filterUser = users.orderByKey().limitToFirst(2);
        //Query filterUser = users.orderByKey().limitToLast(2);

        //>= startAt, >= endAt and in between
        //Query filterUser = users.orderByChild("age").startAt(30);
        //Query filterUser = users.orderByChild("age").endAt(21);
        //Query filterUser = users.orderByChild("age").startAt(21).endAt(30);
          Query filterUser = users.orderByChild("firstName").startAt("J").endAt("J" + "\uf8ff");


        filterUser.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                //Users dadosUser = snapshot.getValue(Users.class);
                //Log.i("DADOS USERS", "NOME: " + dadosUser.getFirstName());

               Log.i("DADOS USERS", snapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

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