package pser.com.pappawssmallenginerepair;
/*

Use for driver class to see images

"@../../../../../../../../Users/Brand/Downloads/1.png"

 */
public class ActiveJobs
{
    int jobID;
    String make;
    String model;
    int year;
    String type;
    String issue;
    String startDate;
    int clientID;


    public int getJobID()
    {
        return jobID;
    }

    public void setJobID(int jobID)
    {
        this.jobID = jobID;
    }

    public String getMake()
    {
        return make;
    }

    public void setMake(String make)
    {
        this.make = make;
    }

    public String getModel()
    {
        return model;
    }

    public void setModel(String model)
    {
        this.model = model;
    }

    public int getYear()
    {
        return year;
    }

    public void setYear(int year)
    {
        this.year = year;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getIssue()
    {
        return issue;
    }

    public void setIssue(String issue)
    {
        this.issue = issue;
    }

    public String getStartDate()
    {
        return startDate;
    }

    public void setStartDate(String startDate)
    {
        this.startDate = startDate;
    }

    public int getClientID()
    {
        return clientID;
    }

    public void setClientID(int clientID)
    {
        this.clientID = clientID;
    }

    public ActiveJobs(int jobID, String make, String model, int year, String type, String issue, String startDate, int clientID)
    {
        this.jobID = jobID;
        this.make = make;
        this.model = model;
        this.year = year;
        this.type = type;
        this.issue = issue;
        this.startDate = startDate;
        this.clientID = clientID;


    }
}
