package simpleapps.kafkapoc.model;

public class CustomerEmployeeComposition {

    String customerId;
    String customerName;
    String employeeId;
    String employeeName;

    public CustomerEmployeeComposition() {
    }

    public CustomerEmployeeComposition(String customerId, String customerName, String employeeId, String employeeName) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.employeeId = employeeId;
        this.employeeName = employeeName;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    @Override
    public String toString() {
        return "CustomerEmployeeComposition{" +
                "customerId='" + customerId + '\'' +
                ", customerName='" + customerName + '\'' +
                ", employeeId='" + employeeId + '\'' +
                ", employeeName='" + employeeName + '\'' +
                '}';
    }
}
