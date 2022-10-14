package hu.petrik.kopapirollo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView imageViewEmber, imageViewGep;
    private TextView textViewEmber, textViewGep, textViewResultEmber, textViewResultGep;
    private Button buttonKo, buttonPapir, buttonOllo;
    private int emberGyozelem, gepGyozelem;
    private AlertDialog.Builder builderJatekVege;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        buttonKo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageViewEmber.setImageResource(R.drawable.rock);
                Random rnd = new Random();
                int x = rnd.nextInt(3);
                switch (x){
                    case 0 : imageViewGep.setImageResource(R.drawable.rock);
                        Toast.makeText(MainActivity.this, "Döntetlen kör!", Toast.LENGTH_SHORT).show();
                        break;
                    case 1 : imageViewGep.setImageResource(R.drawable.paper);
                    gepGyozelem++;
                        Toast.makeText(MainActivity.this, "A gép nyerte a kört!", Toast.LENGTH_SHORT).show();
                        textViewResultGep.setText("Computer: " +gepGyozelem);
                        break;
                    case 2 : imageViewGep.setImageResource(R.drawable.scissors);
                    emberGyozelem++;
                        Toast.makeText(MainActivity.this, "A játékos nyerte a kört!", Toast.LENGTH_SHORT).show();
                        textViewResultEmber.setText("Ember: " +emberGyozelem);
                        break;
                    default: break;
                }

                if (emberGyozelem == 3){
                    builderJatekVege.setTitle("Győzelem");
                    builderJatekVege.show();
                }
                else if(gepGyozelem == 3){
                    builderJatekVege.setTitle("Vereség");
                    builderJatekVege.show();
                }


            }
        });

        buttonPapir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageViewEmber.setImageResource(R.drawable.paper);
                Random rnd = new Random();
                int x = rnd.nextInt(3);
                switch (x){
                    case 0 : imageViewGep.setImageResource(R.drawable.rock);
                        emberGyozelem++;
                        Toast.makeText(MainActivity.this, "A játékos nyerte a kört!", Toast.LENGTH_SHORT).show();
                        textViewResultEmber.setText("Ember: " +emberGyozelem);
                    break;
                    case 1 : imageViewGep.setImageResource(R.drawable.paper);
                        Toast.makeText(MainActivity.this, "Döntetlen kör!", Toast.LENGTH_SHORT).show();
                    break;
                    case 2 : imageViewGep.setImageResource(R.drawable.scissors);
                        gepGyozelem++;
                        Toast.makeText(MainActivity.this, "A gép nyerte a kört!", Toast.LENGTH_SHORT).show();
                        textViewResultGep.setText("Computer: " +gepGyozelem);
                    break;
                    default: break;
                }
                if (emberGyozelem == 3){
                    builderJatekVege.setTitle("Győzelem");
                    builderJatekVege.show();
                }
                else if(gepGyozelem == 3){
                    builderJatekVege.setTitle("Vereség");
                    builderJatekVege.show();
                }

            }

        });

        buttonOllo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageViewEmber.setImageResource(R.drawable.scissors);
                Random rnd = new Random();
                int x = rnd.nextInt(3);
                switch (x){
                    case 0 : imageViewGep.setImageResource(R.drawable.rock);
                        gepGyozelem++;
                        Toast.makeText(MainActivity.this, "A gépnyerte a kört!", Toast.LENGTH_SHORT).show();
                        textViewResultGep.setText("Computer: " +gepGyozelem);
                        break;
                    case 1 : imageViewGep.setImageResource(R.drawable.paper);
                        emberGyozelem++;
                        Toast.makeText(MainActivity.this, "A játékos nyerte a kört!", Toast.LENGTH_SHORT).show();
                        textViewResultEmber.setText("Ember: " +emberGyozelem);
                        break;
                    case 2 : imageViewGep.setImageResource(R.drawable.scissors);
                        Toast.makeText(MainActivity.this, "Döntetlen kör!", Toast.LENGTH_SHORT).show();
                        break;
                    default: break;
                }
                if (emberGyozelem == 3){
                    builderJatekVege.setTitle("Győzelem");
                    builderJatekVege.show();
                }
                else if(gepGyozelem == 3){
                    builderJatekVege.setTitle("Vereség");
                    builderJatekVege.show();
                }
            }
        });
    }


    public void init(){
        imageViewEmber = findViewById(R.id.imageViewEmber);
        imageViewGep = findViewById(R.id.imageViewGep);
        textViewEmber = findViewById(R.id.textViewEmber);
        textViewGep = findViewById(R.id.textViewGep);
        textViewResultEmber = findViewById(R.id.textViewResultEmber);
        textViewResultGep = findViewById(R.id.textViewResultGep);
        buttonKo = findViewById(R.id.buttonKo);
        buttonPapir = findViewById(R.id.buttonPapir);
        buttonOllo = findViewById(R.id.buttonOllo);
        emberGyozelem = 0;
        gepGyozelem = 0;

        builderJatekVege = new AlertDialog.Builder(MainActivity.this);
        builderJatekVege.setCancelable(false)
                .setMessage("Szeretne új játékot játszani?")
                .setNegativeButton("Nem", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                })
                .setPositiveButton("Igen", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ujJatek();
                    }
                })
                .create();

    }

    public void ujJatek(){
        emberGyozelem = 0;
        gepGyozelem = 0;
        imageViewGep.setImageResource(R.drawable.rock);
        imageViewEmber.setImageResource(R.drawable.rock);
        textViewResultGep.setText("Computer: " +gepGyozelem);
        textViewResultEmber.setText("Ember: " +emberGyozelem);
    }
}