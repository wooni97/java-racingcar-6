package racingcar.Processor;

public class Validator {
    private Validator() {} // 인스턴스화 방지

    public static boolean isEmptyOrWhiteSpaceOnly(String target) {
        return target == null || target.isEmpty() || target.replace(" ", "").isEmpty();
    }

    public static boolean IsNumber(String target) {
        try {
            Integer.parseInt(target);
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }
}
