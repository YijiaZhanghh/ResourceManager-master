package model.PR;

public class ScienceMailingList extends PRMailingList {

    public ScienceMailingList(String name, String faculty, boolean status, boolean attendance){
        super(name, faculty, status, attendance);
    }

    @Override
    public String display() {
        return "Science Mailing List: " + "\n" + "Name: " + "\n" + this.name + "\n"  + "Received: " + this.status +  "\n" +"Attendance: "  + this.attendance;
    }


    @Override
    public boolean verified() {
        if(getFaculty().equals("Science")){
            return true;
        }
        return false;
    }

}
