package racingcar.domain;

import racingcar.constant.ErrorMessage;
import java.util.ArrayList;
import java.util.List;

public class Cars implements Forwardable{
    private final List<Car> cars;

    public Cars(List<String> carNames) {
        checkDuplicateCarName(carNames);

        this.cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    @Override
    public void forwardIfConditionMet() {
        cars.forEach(Forwardable::forwardIfConditionMet);
    }

    public static void checkDuplicateCarName(List<String> carNames) {
        if (carNames.size() != carNames.stream().distinct().count()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NAMES_DUPLICATED_MESSAGE);
        }
    }
}
