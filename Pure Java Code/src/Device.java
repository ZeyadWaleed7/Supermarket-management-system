public interface Device {
    String deviceID ="";
    String maintainanceDate ="";
    String status ="";


    abstract String getId();
    abstract void checkMaintained();
    abstract void checked();
    abstract void setStatus();
    abstract void setMaintained();
    abstract void displayInfo();

}
