package fr.esilv.gsonexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import fr.esilv.gsonexample.models.Course;
import fr.esilv.gsonexample.models.Teacher;

public class MainActivity extends AppCompatActivity {

    private TextView moduleNameTextView;
    private TextView teacherTextView;
    private TextView semesterNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        moduleNameTextView = (TextView) findViewById(R.id.moduleNameTextView);
        teacherTextView = (TextView) findViewById(R.id.teacherTextView);
        semesterNameTextView = (TextView) findViewById(R.id.semesterNameTextView);

        initializeData();
    }

    private void initializeData() {
        //get the raw Json as A Stream
        InputStream courseAsInputStream = getResources().openRawResource(R.raw.course);

        //get a String from the Stream
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i;
        try {
            i = courseAsInputStream.read();
            while (i != -1) {
                byteArrayOutputStream.write(i);
                i = courseAsInputStream.read();
            }
            courseAsInputStream.close();
        } catch (IOException e) {

            e.printStackTrace();
        }

        String courseAsString = byteArrayOutputStream.toString();

        //parse the String as an Object using Gson
        Gson gson = new Gson();
        Course course = gson.fromJson(courseAsString, Course.class);

        //populate the View
        if (course != null) {
            moduleNameTextView.setText(course.getModuleName());
            Teacher teacher = course.getTeacher();
            teacherTextView.setText(getString(R.string.teacher, teacher.getFirstName(), teacher.getLastName()));
            semesterNameTextView.setText(getString(R.string.semester, course.getSemester()));
        }
    }
}
