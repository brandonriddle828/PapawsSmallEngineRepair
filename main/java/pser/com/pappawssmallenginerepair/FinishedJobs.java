package pser.com.pappawssmallenginerepair;

public class FinishedJobs
{
    int jobID;
    int clientID;
    String startDate;
    String endDate;
    int partsOrdered;
    double  partsCost;
    double markupCost;
    double pickupCost;
    double laborCost;
    double totalAmountOwed;

    public FinishedJobs(int jobID, int clientID, String startDate, String endDate, int partsOrdered, double partsCost, double markupCost, double pickupCost, double laborCost, double totalAmountOwed)
    {
        this.jobID = jobID;
        this.clientID = clientID;
        this.startDate = startDate;
        this.endDate = endDate;
        this.partsOrdered = partsOrdered;
        this.partsCost = partsCost;
        this.markupCost = markupCost;
        this.pickupCost = pickupCost;
        this.laborCost = laborCost;
        this.totalAmountOwed = totalAmountOwed;
    }

    public int getJobID()
    {
        return jobID;
    }

    public void setJobID(int jobID)
    {
        this.jobID = jobID;
    }

    public int getClientID()
    {
        return clientID;
    }

    public void setClientID(int clientID)
    {
        this.clientID = clientID;
    }

    public String getStartDate()
    {
        return startDate;
    }

    public void setStartDate(String startDate)
    {
        this.startDate = startDate;
    }

    public String getEndDate()
    {
        return endDate;
    }

    public void setEndDate(String endDate)
    {
        this.endDate = endDate;
    }

    public int getPartsOrdered()
    {
        return partsOrdered;
    }

    public void setPartsOrdered(int partsOrdered)
    {
        this.partsOrdered = partsOrdered;
    }

    public double getPartsCost()
    {
        return partsCost;
    }

    public void setPartsCost(double partsCost)
    {
        this.partsCost = partsCost;
    }

    public double getMarkupCost()
    {
        return markupCost;
    }

    public void setMarkupCost(double markupCost)
    {
        this.markupCost = markupCost;
    }

    public double getPickupCost()
    {
        return pickupCost;
    }

    public void setPickupCost(double pickupCost)
    {
        this.pickupCost = pickupCost;
    }

    public double getLaborCost()
    {
        return laborCost;
    }

    public void setLaborCost(double laborCost)
    {
        this.laborCost = laborCost;
    }

    public double getTotalAmountOwed()
    {
        return totalAmountOwed;
    }

    public void setTotalAmountOwed(double totalAmountOwed)
    {
        this.totalAmountOwed = totalAmountOwed;
    }
}
