package fr.esilv.gsonexample.models;

import com.google.gson.annotations.SerializedName;

public class Course {
    @SerializedName("module_name")
    private String moduleName;
    private Teacher teacher;
    private int semester;

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }
}
