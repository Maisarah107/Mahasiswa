package id.ac.poliban.mi.maisarah.mahasiswa;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private String str;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==1 && resultCode==RESULT_OK && data.getExtras()!=null){
            str = data.getStringExtra("nim") + "\n";
            str += data.getStringExtra("nama") + "\n";
            str += data.getStringExtra("alamat") + "\n";
            str += data.getStringExtra("telp") + "\n";
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btShowInput = findViewById(R.id.btShowInput);
        Button btShowData = findViewById(R.id.btShowData);


        btShowInput.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, DataMahasiswa.class);
            startActivityForResult(intent,1);
        });

        btShowData.setOnClickListener(v -> {
            new AlertDialog.Builder(this)
                    .setTitle("Info")
                    .setMessage(str)
                    .setPositiveButton("OK", null).show();
        });



    }
}