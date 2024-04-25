package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.Race;
import racingcar.Processor.InputProcessor;
import racingcar.Processor.OutputView;

import java.util.List;

public class GameController {
    private final InputProcessor inputProcessor;
    private final OutputView outputView;
    private Cars cars;
    private Race race;

    public GameController(InputProcessor inputProcessor, OutputView outputView) {
        this.inputProcessor = inputProcessor;
        this.outputView = outputView;
    }

    public void run() {
        setGames();
        race.run();
        showResults();
        showWinnerCars();
    }

    public void setGames() {
        outputView.displayCarNamesInputMessage();
        List<String> carNames = inputProcessor.readCarNames();
        this.cars = new Cars(carNames);

        outputView.displayNumberOfTrialsQuestion();
        this.race = new Race(inputProcessor.readTrialNumber(), cars);
    }


    public void showResults() {
        outputView.displayRoundResultMessage();
        outputView.displayRaceResults(race.getRaceResults());
    }

    public void showWinnerCars() {
        outputView.displayWinners(race.getWinnerCarsName());
    }

    public List<String> getCarNames() {

        String inputCarNames = inputView.readCarNames();
        return StringParser.splitString(inputCarNames);
    }


}
