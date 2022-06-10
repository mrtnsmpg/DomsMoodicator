package com.example.domy_mood_indicator;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CRUDFunctions {

    private DatabaseReference databaseReference;
    public CRUDFunctions(){
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        databaseReference =db.getReference(UserData.class.getSimpleName());
    }

    public Task<Void> add(UserData userData){
        return databaseReference.push().setValue(userData);

    }
}
