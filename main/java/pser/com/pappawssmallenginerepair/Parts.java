package pser.com.pappawssmallenginerepair;

public class Parts
{
    protected String partName;
    protected double cost;
    protected int quantity;
    protected String date;
    protected int partID;
    protected int jobID;

    public Parts(int partID, int jobID, String partName, double cost, int quantity, String date)
    {
        this.partName = partName;
        this.cost = cost;
        this.quantity = quantity;
        this.date = date;
        this.partID = partID;
        this.jobID = jobID;
    }

    public String getPartName()
    {
        return partName;
    }

    public void setPartName(String partName)
    {
        this.partName = partName;
    }

    public double getCost()
    {
        return cost;
    }

    public void setCost(double cost)
    {
        this.cost = cost;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }

    public String getDate()
    {
        return date;
    }

    public void setDate(String date)
    {
        this.date = date;
    }

    public int getPartID()
    {
        return partID;
    }

    public void setPartID(int partID)
    {
        this.partID = partID;
    }

    public int getJobID()
    {
        return jobID;
    }

    public void setJobID(int jobID)
    {
        this.jobID = jobID;
    }
}
