package racingcar.domain;

import racingcar.constant.ErrorMessage;

public class Car implements Forwardable{
    public static final int FORWARD_CONDITION_NUMBER = 4;
    public static final int VALID_CAR_NAME_MAX_LENGTH = 5;
    public static final int INITIAL_POSITION = 0;
    private final String name;
    private int position;

    public Car(String name) {
        validate(name);

        this.name = name;
        this.position = INITIAL_POSITION;
    }

    @Override
    public void forwardIfConditionMet() {
        if (Race.pickRandomNumber() >= FORWARD_CONDITION_NUMBER) {
            this.position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void validate(String name) {
        checkCarNameLengthValid(name);
    }

    public void checkCarNameLengthValid(String carName) {
        if (carName.length() > Car.VALID_CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NAME_LENGTH_MESSAGE);
        }
    }
}
