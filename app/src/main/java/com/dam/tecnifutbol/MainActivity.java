package com.dam.tecnifutbol;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.dam.tecnifutbol.Modelo.Jugador;
import com.dam.tecnifutbol.R;
import com.dam.tecnifutbol.Entrenador.Entrenamientos.InsertarEntrenamientos;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static SQLiteDatabase database;
    public static String nombreEntrenamiento;
    public static String descripcionEntrenamiento;
    public static String tipoEntrenamiento;
    public static String edadesEntrenamiento;
    public static String dificultadEntrenamiento;
    public static String duracionEntrenamiento;
    public static String materialesEntrenamiento;
    public static String videoEntrenamiento;
    public static String equipoSeleccionadoAEditar = "";
    public static int jugadorSeleccionadoAEditarOEliminar;
    public static String fechaNacJugadorInsertado;
    public static Jugador jugadorSeleccionadoAEditar = null;

    SignInButton signInButton;
    TextView signOutButton;
    TextView tv_iniciarSesion;
    private static final int SIGN_IN = 123;
    public static FirebaseAuth mAuth;
    private GoogleSignInClient mGoogleSignInClient;
    private ImageButton menuHaburguesa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signInButton = findViewById(R.id.signInButton);
        signOutButton = findViewById(R.id.signoutButton);
        tv_iniciarSesion = findViewById(R.id.tv_iniciarSesion);

        mAuth = FirebaseAuth.getInstance();

        signInButton.setVisibility(View.VISIBLE);
        signOutButton.setVisibility(View.GONE);
        signInButton.setOnClickListener(this);
        signOutButton.setOnClickListener(this);

        signOutButton.setBackground(getResources().getDrawable(R.drawable.boton));


        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken("376380296561-plah95lhd3lvurjf49kpp4vjbbishvcp.apps.googleusercontent.com")
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        // Creación de la base de datos y la tabla entrenamientos
        database = openOrCreateDatabase("TecniFutbol", MODE_PRIVATE, null);

        // Esta linea se descomenta en caso de que cambieis los campos de la tabla entrenamientos
        database.execSQL("DROP TABLE IF EXISTS entrenamientos");
        database.execSQL("CREATE TABLE IF NOT EXISTS entrenamientos " +
                "(id INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT, descripcion TEXT, tipoEjercicio TEXT, categoriaEdad TEXT, dificultad TEXT, " +
                "duracion TEXT, material TEXT, imagen BLOB, video TEXT)");
        insertarEntrenamientos();

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        database.execSQL("CREATE TABLE IF NOT EXISTS equipos " +
                "(id INTEGER PRIMARY KEY AUTOINCREMENT, propietario TEXT, nombre TEXT, categoriaPartido TEXT, jugadores INTEGER)");

        database.execSQL("CREATE TABLE IF NOT EXISTS jugadores " +
                "(id INTEGER PRIMARY KEY AUTOINCREMENT, equipo TEXT, nombre TEXT, dorsal TEXT, posicion TEXT, peso TEXT, altura TEXT, fechaNacimiento DATE, " +
                "piernaHabil TEXT, notas TEXT, disponible BOOLEAN)");

        menuHaburguesa = findViewById(R.id.burguer_menu);
        menuHaburguesa.setOnClickListener(v -> {
            DialogMenuHamburguesa dialogMenuHamburguesa = new DialogMenuHamburguesa();
            dialogMenuHamburguesa.show(getSupportFragmentManager(), "Menu");
        });
        menuHaburguesa.setVisibility(View.GONE);
    }

    /**
     * Inserta en la BD los entrenamientos de las diferentes categorías de edad.
     */
    private void insertarEntrenamientos() {
        Cursor cursor = database.rawQuery("SELECT * FROM entrenamientos", null);

        if (cursor.getCount() == 0) {
            InsertarEntrenamientos.insertarEntrenamientosDeMenos8Años();
            InsertarEntrenamientos.insertarEntrenamientosDe8A11Años();
            InsertarEntrenamientos.insertarEntrenamientosDe11A14Años();
            InsertarEntrenamientos.insertarEntrenamientosDe14A18Años();
            InsertarEntrenamientos.insertarEntrenamientosDeMas18Años();
        }
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.signInButton) {
            signIn();
        } else if (i == R.id.signoutButton) {
            signOut();
        }
    }

    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, SIGN_IN);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == SIGN_IN) {
            Task<
                    GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = task.getResult(ApiException.class);
                Log.d(TAG, "firebaseAuthWithGoogle:" + account.getId());
                firebaseAuthWithGoogle(account.getIdToken());
                lanzarActividad();
            } catch (ApiException e) {
                // Google Sign In failed, update UI appropriately
                Log.w(TAG, "Google sign in failed", e);
                // [START_EXCLUDE]
                updateUI(null);
                // [END_EXCLUDE]
            }
        }
    }

    private void firebaseAuthWithGoogle(String idToken) {

        AuthCredential credential = GoogleAuthProvider.getCredential(idToken, null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithCredential:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithCredential:failure", task.getException());
                            updateUI(null);
                        }
                    }
                });
    }

    public void updateUI(FirebaseUser user) {
        if (user != null) {
            Toast.makeText(this, "Bienvenido " + user.getDisplayName()
                    + "[" + user.getEmail() + "]", Toast.LENGTH_LONG).show();
            signInButton.setVisibility(View.GONE);
            signOutButton.setVisibility(View.VISIBLE);
            menuHaburguesa.setVisibility(View.VISIBLE);
        } else {
            signInButton.setVisibility(View.VISIBLE);
            signOutButton.setVisibility(View.GONE);
            menuHaburguesa.setVisibility(View.GONE);
            tv_iniciarSesion.setText("Inicia Sesion");
        }
    }

    private void signOut() {
        // Firebase sign out
        mAuth.signOut();
        // Google sign out
        mGoogleSignInClient.signOut().addOnCompleteListener(this,
                new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        updateUI(null);
                    }
                });
    }

    private void lanzarActividad() {
        Intent intent = new Intent(this, PantallaInicial.class);
        startActivity(intent);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }

    @Override
    public void onBackPressed() {
    }
}