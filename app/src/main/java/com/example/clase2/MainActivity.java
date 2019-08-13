package com.example.clase2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText txtnombre, txthoras;
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtnombre = (EditText) findViewById(R.id.edtNombre);
        txthoras = (EditText) findViewById(R.id.edtHoras);
        btn = (Button) findViewById(R.id.btnAceptar);




        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int sueldo_x_hora = 40;
                int horas = 0;
                int horalaboral = 0;
                int horaextra;
                int sueldo = 0;
                int sueldoextra = 0;
                int sueldototal = 0;
                String nombre;


                nombre = txtnombre.getText().toString();

                if (nombre.isEmpty() ){
                    Toast.makeText(getApplicationContext(),"Ingresar el nombre", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (txthoras.getText().toString().isEmpty() ){
                    Toast.makeText(getApplicationContext(),"Ingresar las horas trabajadas", Toast.LENGTH_SHORT).show();
                    return;
                }
                horas = Integer.parseInt(txthoras.getText().toString());
                if(horas > 60){
                    Toast.makeText(getApplicationContext(),"No puede ingresar mas de 60 horas trabajadas", Toast.LENGTH_SHORT).show();
                    return;
                }

                horaextra = horas - 40;

                horalaboral = horas;


                if(horaextra <= 10 && horaextra > 0){
                    sueldoextra = (sueldo_x_hora * 2 )* horaextra;
                    horalaboral = horas - horaextra;
                }else if(horaextra > 10){
                    sueldoextra = (sueldo_x_hora * 3 )* horaextra;
                    horalaboral = horas - horaextra;
                }
                sueldo = sueldo_x_hora * horalaboral;
                sueldototal = sueldo + sueldoextra;
                Toast.makeText(getApplicationContext(),txtnombre.getText().toString()+" su sueldo es: "+ sueldototal, Toast.LENGTH_SHORT).show();


            }
        });
    }
}
