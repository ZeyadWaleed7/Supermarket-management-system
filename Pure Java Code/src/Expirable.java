public abstract class Expirable {
    protected String expDate;

    public Expirable(String expDate) {
        this.expDate = expDate;
    }

    public abstract boolean isExpired();
}
