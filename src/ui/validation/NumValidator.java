package ui.validation;

public class NumValidator {
    private final String checkString;
    private final int lowerValue;
    private final int upperValue;
    private int num;

    public NumValidator(final String checkString, final int lowerValue, final int upperValue) {
        this.checkString = checkString;
        this.lowerValue = lowerValue;
        this.upperValue = upperValue;
    }

    private boolean isNum() {
        try {
            num = Integer.parseInt(checkString);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    private boolean isInRange() {
        return (num >= lowerValue && num <= upperValue);
    }

    public boolean checkValidNum() {
        if (!isNum()) {
            return false;
        }
        return isInRange();
    }

    public int getNum() {
        return num;
    }
}
