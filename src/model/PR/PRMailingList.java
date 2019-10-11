package model.PR;

//Component
public abstract class PRMailingList {
    protected String faculty;
    protected String name;
    protected boolean status;
    protected boolean attendance;

    public PRMailingList(String name, String faculty, boolean status, boolean attendance) {
        this.name = name;
        this.faculty = faculty;
        this.status = status;
        this.attendance = attendance;
    }

    public abstract String display();



    public boolean didReceive() {
        if(getStatus()){
            return true;
        }
        return false;
    }

    public boolean willAttend(){
        if(getAttendance()){
            return true;
        }
        return false;
    };

    public abstract boolean verified();

    public String getName() {
        return name;
    }

    public String getFaculty(){
        return faculty;
    }

    public boolean getStatus(){ return status; }

    public boolean getAttendance(){ return attendance; }
}

