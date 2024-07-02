package com.example.petshopmobileapp.activity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.petshopmobileapp.R;
import com.example.petshopmobileapp.adapter.AnimalAdapter;
import com.example.petshopmobileapp.database.MySQLDatabaseHelper;
import com.example.petshopmobileapp.models.Animals;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private AnimalAdapter animalAdapter;
    private List<Animals> animalList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);

        recyclerView = findViewById(R.id.pet_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Load dữ liệu từ MySQL
        new LoadAnimalsTask().execute();
    }
    private class LoadAnimalsTask extends AsyncTask<Void, Void, List<Animals>> {

        @Override
        protected List<Animals> doInBackground(Void... voids) {
            List<Animals> animals = new ArrayList<>();
            try {
                Connection connection = MySQLDatabaseHelper.getConnection();
                Statement statement = connection.createStatement();
                String query = "SELECT * FROM animals";
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()) {
                    Animals animal = new Animals();
                    animal.setId(resultSet.getInt("id"));
                    animal.setPetTypeId(resultSet.getInt("pet_type_id"));
                    animal.setBreed(resultSet.getString("breed"));
                    animal.setName(resultSet.getString("name"));
                    animal.setAge(resultSet.getInt("age"));
                    animal.setGender(resultSet.getString("gender"));
                    animal.setColor(resultSet.getString("color"));
                    animal.setPrice(resultSet.getBigDecimal("price"));
                    animal.setAvailable(resultSet.getBoolean("is_available"));
                    animals.add(animal);
                }
                resultSet.close();
                statement.close();
                connection.close();
            } catch (Exception e) {
                Log.e("HomeActivity", "Error loading animals", e);
            }
            return animals;
        }

        @Override
        protected void onPostExecute(List<Animals> animals) {
            animalList = animals;
            animalAdapter = new AnimalAdapter(animalList);
            recyclerView.setAdapter(animalAdapter);
        }
    }
}