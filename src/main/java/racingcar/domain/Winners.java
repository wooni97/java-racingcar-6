package racingcar.domain;

import java.util.List;

public class Winners {
    private final int maxPosition;
    private final List<Car> winnerCars;

    public Winners(Cars cars) {
        this.maxPosition = getMaxPosition(cars);
        this.winnerCars = getWinnerCars(cars);
    }

    private int getMaxPosition(Cars cars) {
        return cars.getCars().stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(Integer.MIN_VALUE);
    }

    private List<Car> getWinnerCars(Cars cars) {
        return cars.getCars().stream()
                .filter(car -> car.getPosition() == this.maxPosition)
                .toList();
    }

    public List<String> getWinnerCarsName() {
        return winnerCars.stream()
                .map(Car::getName)
                .toList();
    }

}
