package com.phonepe.logoquiz;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.phonepe.Utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class LogoInfoActivity extends AppCompatActivity {

    private RecyclerView rvLogoName, rvLogoNameHint;
    private ImageView ivLogo;
    private JSONObject jsonObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo_info);

        loadData();
        ivLogo = findViewById(R.id.ivLogo);
        rvLogoName = findViewById(R.id.rvLogoName);
        rvLogoNameHint = findViewById(R.id.rvLogoNameHint);

        loadImage();

        rvLogoName.setLayoutManager(new GridLayoutManager(this, 8));
        try {
            rvLogoName.setAdapter(new LogoNameAdapter(jsonObject.getString("name")));
        } catch (JSONException jsonException) {
            jsonException.printStackTrace();
        }

        rvLogoNameHint.setLayoutManager(new GridLayoutManager(this, 8));
        try {
            rvLogoNameHint.setAdapter(new LogoHintAdapter(generateRandomString()));
        } catch (JSONException jsonException) {
            jsonException.printStackTrace();
        }
    }

    private void loadImage() {
        try {
            Glide.with(this)
                    .load(jsonObject.getString("imgUrl"))
                    .into(ivLogo);
        } catch (JSONException jsonException) {
            jsonException.printStackTrace();
        }
    }

    private void loadData() {
        Intent intent = getIntent();
        int pos = intent.getExtras().getInt("pos");

        String data = Utils.loadJSONFile(this);
        try {
            JSONArray jsonArray = new JSONArray(data);
            jsonObject = jsonArray.getJSONObject(pos);
        } catch (JSONException jsonException) {
            jsonException.printStackTrace();
        }
    }

    private StringBuilder generateRandomString() throws JSONException {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        // specify length of random string
        int length = 18 - jsonObject.getString("name").length();

        for (int i = 0; i < length; i++) {

            // generate random index number
            int index = random.nextInt(alphabet.length());

            // get character specified by index
            // from the string
            char randomChar = alphabet.charAt(index);

            // append the character to string builder
            sb.append(randomChar);
        }

        String randomString = sb.toString() + jsonObject.getString("name");
        List<Character> characterList = randomString.chars().mapToObj(c -> new Character((char) c))
                .collect(Collectors.toList());
        Collections.shuffle(characterList);
        StringBuilder stringBuilder = new StringBuilder();
        characterList.forEach(c -> stringBuilder.append(c));

        return stringBuilder;
    }
}