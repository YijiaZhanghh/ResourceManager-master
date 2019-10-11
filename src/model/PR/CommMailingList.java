package model.PR;


public class CommMailingList extends PRMailingList {

    public CommMailingList(String name, String faculty, boolean status, boolean attendance){
        super(name, faculty, status, attendance);
    }

    @Override
    public String display() {
        return "Commerce Mailing List: " + "\n" + "Name: " + "\n" + this.name + "\n"  + "Received: " + this.status +  "\n" +"Attendance: "  + this.attendance;
    }


    @Override
    public boolean verified() {
        if(getFaculty().equals("Commerce")){
            return true;
        }
        return false;
    }
}
