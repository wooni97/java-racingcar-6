package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constant.ErrorMessage;

import java.util.ArrayList;
import java.util.List;

public class Race {
    public static final int RANDOM_MIN_NUMBER = 0;
    public static final int RANDOM_MAX_NUMBER = 9;
    public static final int INITIAL_TRIAL_NUMBER = 0;
    private final Cars cars;
    private final int totalTrials;
    private int currentTrials;
    private List<RaceResult> raceResults;
    private Winners winners;

    public Race(int trialNumber, Cars cars) {
        validate(trialNumber);
        this.totalTrials = trialNumber;
        this.currentTrials = INITIAL_TRIAL_NUMBER;
        this.cars = cars;
        this.raceResults = new ArrayList<>(trialNumber);
    }

    public static int pickRandomNumber() {
        return Randoms.pickNumberInRange(RANDOM_MIN_NUMBER, RANDOM_MAX_NUMBER);
    }

    public void run() {
        while(!currentTrialReachedTotal()) {
            cars.forwardIfConditionMet();
            increaseCurrentTrial();
            raceResults.add(new RaceResult(cars));
        }

        winners = new Winners(cars);
    }

    private void increaseCurrentTrial() {
        this.currentTrials++;
    }

    private boolean currentTrialReachedTotal() {
        return this.totalTrials == this.currentTrials;
    }

    public List<String> getWinnerCarsName() {
        return winners.getWinnerCarsName();
    }

    public List<RaceResult> getRaceResults() {
        return raceResults;
    }

    private void validate(int trialNumber) {
        checkTrialNumberIsNonNegative(trialNumber);
    }

    private void checkTrialNumberIsNonNegative(int trialNumber) {
        if (trialNumber < 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_TRIALNUMBER_IS_NOT_NUMBER_MESSAGE);
        }
    }
}
