package Entities;

public class Kid {
    private int id;
    private int groupId;
    private String firstName;
    private String secondName;
    private String middleName;
    private String mothersName;
    private int boxId;
    private int age;

    public Kid(int id, int groupId, String firstName, String secondName, String middleName, String mothersName, int boxId, int age) {
        this.id = id;
        this.groupId = groupId;
        this.firstName = firstName;
        this.secondName = secondName;
        this.middleName = middleName;
        this.mothersName = mothersName;
        this.boxId = boxId;
        this.age = age;
    }

    public Kid() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getMothersName() {
        return mothersName;
    }

    public void setMothersName(String mothersName) {
        this.mothersName = mothersName;
    }

    public int getBoxId() {
        return boxId;
    }

    public void setBoxId(int boxId) {
        this.boxId = boxId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public void print(){
        System.out.println("id ребёнка:"+getId());
        System.out.println("id группы:"+getGroupId());
        System.out.println("имя ребёнка:"+getFirstName());
        System.out.println("фамилия ребёнка:"+getSecondName());
        System.out.println("отчество ребенка:"+getMiddleName());
        System.out.println("имя матери:"+getMothersName());
        System.out.println("id шкафчика:"+getBoxId());
        System.out.println("возраст:"+getAge());
    }
}
