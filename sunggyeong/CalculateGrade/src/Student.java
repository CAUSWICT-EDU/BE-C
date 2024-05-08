import java.util.ArrayList;

class Student {
    private String name;
    private String id;
    private String major;
    private ArrayList<Subject> takingClass = new ArrayList<>(GoodSchool.getSubjectNumber());

    public Student() {
        for(int i=0; i<GoodSchool.getSubjectNumber(); i++){
            Subject subject=new Subject();
            subject.setSubjectName(GoodSchool.getSubjectName(i));
            takingClass.add(i,subject);
        }


    }
    public Subject getSubject(int i){
        return takingClass.get(i);
    }
    public String getMajor(){
        return major;
    }
    public String getName(){
        return name;
    }
    public String getId(){
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setMajor(String major) {
        this.major = major;
    }

}
