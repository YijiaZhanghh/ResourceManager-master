package model.PR;

public class ArtsMailingList extends PRMailingList {

    public ArtsMailingList(String name, String faculty, boolean status, boolean attendance){
        super(name, faculty, status, attendance);
    }

    @Override
    public String display() {
        return "Arts Mailing List: " + "\n" + "Name: " + "\n" + this.name + "\n"  + "Received: " + this.status +  "\n" +"Attendance: "  + this.attendance;
    }


    @Override
    public boolean verified() {
        if(getFaculty().equals("Arts")){
            return true;
        }
        return false;
    }

}
