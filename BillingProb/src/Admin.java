

public class Admin {
	//fields
    Department[] depts;

    //methods
    public Admin(Department[] depts){
        this.depts = depts;
    }

    public String hourlyCompanyMessage(){

        StringBuffer sb = new StringBuffer();

        for(Department d : depts){

            sb.append(format(d.getName(),d.nextMessage()));
        }

        return sb.toString();
    }

    public String format(String name, String message){

        return name + ":" + message + "\n";
    }
	
}

