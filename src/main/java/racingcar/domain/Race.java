package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
public class Race {
    private final int totalTrials;
    private int currentTrials = 0;
    public static final int RANDOM_MIN_NUMBER = 0;
    public static final int RANDOM_MAX_NUMBER = 9;
    public static final int ASCII_ONE = 49;
    public static final int ASCII_NINE = 57;

    public Race(String trialNumber) {
        checkTrialNumberIsEmpty(trialNumber);
        checkTrialNumberIsNaturalNumber(trialNumber);
        this.totalTrials = Integer.parseInt(trialNumber);
    }

    public int pickRandomNumber() {
        return Randoms.pickNumberInRange(RANDOM_MIN_NUMBER, RANDOM_MAX_NUMBER);
    }

    public void increaseCurrentTrial() {
        this.currentTrials++;
    }

    public boolean currentTrialReachedTotal() {
        return this.totalTrials == this.currentTrials;
    }

    public void checkTrialNumberIsNaturalNumber(String trialNumber) {
        for (int i = 0; i < trialNumber.length(); i++) {
            if (!(trialNumber.charAt(i) >= ASCII_ONE && trialNumber.charAt(i) <= ASCII_NINE)) {
                throw new IllegalArgumentException();
            }
        }
    }

    public void checkTrialNumberIsEmpty(String trialNumber) {
        if (trialNumber == null || trialNumber.replace(" ","").isEmpty()) {
            throw new IllegalArgumentException();
        }
    }
}
