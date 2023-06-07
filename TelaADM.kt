package com.example.sustentacao
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class TelaADM : AppCompatActivity() {
    private lateinit var binding : ActivityCadastroVagaBinding
    private lateinit var dbRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCadastroVagaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var edEmpresa = binding.edEmpresa
        var edCargo = binding.edCargo
        var edSalario = binding.edSalario
        var btCadatrar = binding.button

        dbRef = FirebaseDatabase.getInstance().getReference("Empregador")

        btCadatrar.setOnClickListener{
            val empName = edEmpresa.text.toString()
            val empCargo = edCargo.text.toString()
            val empSalario = edSalario.text.toString()

            if(empName.isEmpty()){
                edEmpresa.error = "Seu nome e telefone"
            }
            if(empCargo.isEmpty()){
                edCargo.error = "Descreva o local da coleta"
            }
            if(empSalario.isEmpty()){
                edSalario.error = "Descreva o material a ser coletado"
            }

            val empId = dbRef.push().key!!

            val empregador = CoisasModelo(empId, empName, empCargo, empSalario)

            dbRef.child(empId).setValue(empregador)
                .addOnCompleteListener{
                    Toast.makeText(this, "Cadastro realizado", Toast.LENGTH_SHORT).show()

                    edEmpresa.text.clear()
                    edCargo.text.clear()
                    edSalario.text.clear()

                }.addOnFailureListener{err ->
                    Toast.makeText(this, "Error ${err.message}", Toast.LENGTH_SHORT).show()
                }
        }

    }


}