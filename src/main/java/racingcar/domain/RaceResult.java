package racingcar.domain;

import java.util.HashMap;
import java.util.Map;

public class RaceResult {
    private Map<String, Integer> raceResult;

    public RaceResult(Cars cars) {
        this.raceResult = new HashMap<>();
        setResult(cars);
    }

    private void setResult(Cars cars) {
        for (Car car : cars.getCars()) {
            raceResult.put(car.getName(), car.getPosition());
        }
    }

    public Map<String, Integer> getRaceResult() {
        return raceResult;
    }
}
